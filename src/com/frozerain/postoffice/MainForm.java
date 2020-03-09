package com.frozerain.postoffice;

import javax.swing.*;
import java.awt.*;

public class MainForm {
    private JPanel rootPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JList officeList;
    private JTextArea officeDetails;
    private JButton editOfficeButton;
    private JButton deleteOfficeButton;
    private JButton addNewOfficeButton;


    public MainForm(PostOfficeDAO postOfficeDAO) {
        DefaultListModel<PostOfficeEntity> model = new DefaultListModel<>();
        for (PostOfficeEntity e : postOfficeDAO.getPostOffices()) {
            model.addElement(e);
        }
        officeDetails.setEditable(false);

        officeList.setLayoutOrientation(JList.VERTICAL);
        officeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        officeList.setModel(model);

        officeList.addListSelectionListener(e -> {
            PostOfficeEntity entity = (PostOfficeEntity) officeList.getSelectedValue();
            if (entity != null) {
                officeDetails.setText(entity.getInfo());
            }
        });

        addNewOfficeButton.addActionListener(e -> new AddEditForm("Добавление нового почтового отделения", model, null, postOfficeDAO));

        editOfficeButton.addActionListener(e -> {
            PostOfficeEntity entity = (PostOfficeEntity) officeList.getSelectedValue();
            postOfficeDAO.getPostOffices().remove(entity);
            new AddEditForm("Изменение почтового отделения " + entity.getPostOfficeCode(), model, entity, postOfficeDAO);
        });

        deleteOfficeButton.addActionListener(e -> {
            Object object = officeList.getSelectedValue();
            if (object != null) {
                officeList.clearSelection();
                model.removeElement(object);
                officeDetails.setText("");
                postOfficeDAO.deleteFromDB(((PostOfficeEntity) object).getPostOfficeCode());
                postOfficeDAO.getPostOffices().remove(object);
            }
        });

        searchButton.addActionListener(e -> {
            try {
                int indx = -1;
                int postCode = Integer.decode(searchField.getText());
                for (PostOfficeEntity entity: postOfficeDAO.getPostOffices()){
                    if (entity.getPostOfficeCode() == postCode){
                        indx = model.indexOf(entity);
                        officeList.setSelectedIndex(indx);
                        break;
                    }
                }
                if (indx == -1) JOptionPane.showMessageDialog(null, "Почтовое отделение не найдено!");
            } catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Неправильный почтовый индекс!");
            }
        });
    }

    static void frameSettings(MainForm form) {
        JFrame frame = new JFrame("Post Office Editor");
        Dimension windowSize = new Dimension(600, 500);

        ImageIcon ico = new ImageIcon("D:/Post Office/resource/postImg.png");
        frame.setIconImage(ico.getImage());
        frame.setContentPane(form.rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(windowSize);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        PostOfficeDAO postOfficeDAO = new PostOfficeDAO();
        postOfficeDAO.getInstance();
        MainForm form = new MainForm(postOfficeDAO);
        frameSettings(form);

    }
}
