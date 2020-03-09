package com.frozerain.postoffice;

import javax.swing.*;

public class AddEditForm {
    private JTextField txtCod;
    private JTextField txtAddress;
    private JTextField txtWorkTime;
    private JTextField txtRating;
    private JButton btnSubmit;
    private JPanel addEditPanel;
    private JFrame frame;

    public AddEditForm(String tittle, DefaultListModel<PostOfficeEntity> listModel, PostOfficeEntity officeEntity, PostOfficeDAO dao) {
        frame = new JFrame(tittle);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(this.addEditPanel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        if (officeEntity != null){
            txtCod.setText(String.valueOf(officeEntity.getPostOfficeCode()));
            txtCod.setEditable(false);
            txtAddress.setText(officeEntity.getPostOfficeAddress());
            txtWorkTime.setText(officeEntity.getPostOfficeWorkTime());
            txtRating.setText(String.valueOf(officeEntity.getPostOfficeRating()));
        }

        btnSubmit.addActionListener(e -> {
            if (officeEntity == null) {
                PostOfficeEntity entity = new PostOfficeEntity();
                entity.setPostOfficeCode(Integer.decode(txtCod.getText()));
                entity.setPostOfficeAddress(txtAddress.getText());
                entity.setPostOfficeWorkTime(txtWorkTime.getText());
                entity.setPostOfficeRating(Integer.decode(txtRating.getText()));

                listModel.addElement(entity);
                dao.addToDB(entity);
                frame.dispose();
            } else {
                officeEntity.setPostOfficeAddress(txtAddress.getText());
                officeEntity.setPostOfficeWorkTime(txtWorkTime.getText());
                officeEntity.setPostOfficeRating(Integer.decode(txtRating.getText()));
                dao.updateToDB(officeEntity);
                frame.dispose();
            }
        });
    }
}
