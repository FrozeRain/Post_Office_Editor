package com.frozerain.postoffice;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PostOfficeDAO {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/db/PostOffices";
    static final String USER = "sa";
    static final String PASS = "";

    private List<PostOfficeEntity> postOffices;
    private Connection conn;

    public PostOfficeDAO() {
        this.postOffices = new LinkedList<>();
    }

    public void getInstance() {
        ResultSet resultSet;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();

            String sql = "select * from POST_OFFICES";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                PostOfficeEntity entity = new PostOfficeEntity();
                entity.setPostOfficeCode(resultSet.getInt("POST_CODE"));
                entity.setPostOfficeAddress(resultSet.getString("OFFICE_ADDRESS"));
                entity.setPostOfficeWorkTime(resultSet.getString("OFFICE_WORKTIME"));
                entity.setPostOfficeRating(resultSet.getInt("OFFICE_RAITING"));
                this.postOffices.add(entity);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToDB(PostOfficeEntity entity) {
        String statement = "insert into POST_OFFICES values (?, ?, ?, ?)";

        if (conn != null) {
            try {
                PreparedStatement st = conn.prepareStatement(statement);
                st.setInt(1, entity.getPostOfficeCode());
                st.setString(2, entity.getPostOfficeAddress());
                st.setString(3, entity.getPostOfficeWorkTime());
                st.setInt(4, entity.getPostOfficeRating());

                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            postOffices.add(entity);
        }
    }

    public void updateToDB(PostOfficeEntity entity) {
        String statement = "update POST_OFFICES set OFFICE_ADDRESS=?, OFFICE_WORKTIME=?, OFFICE_RAITING=? where POST_CODE=?";

        if (conn != null) {
            try {
                PreparedStatement st = conn.prepareStatement(statement);
                st.setString(1, entity.getPostOfficeAddress());
                st.setString(2, entity.getPostOfficeWorkTime());
                st.setInt(3, entity.getPostOfficeRating());
                st.setInt(4, entity.getPostOfficeCode());

                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            postOffices.add(entity);
        }
    }

    public void deleteFromDB(int post_code) {
        String statement = "delete from POST_OFFICES where POST_CODE=?";

        if (conn != null) {
            try {
                PreparedStatement st = conn.prepareStatement(statement);
                st.setInt(1, post_code);

                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "PostOfficeDAO{" +
                "postOffices=" + postOffices.get(0) +
                '}';
    }

    public List<PostOfficeEntity> getPostOffices() {
        return postOffices;
    }
}
