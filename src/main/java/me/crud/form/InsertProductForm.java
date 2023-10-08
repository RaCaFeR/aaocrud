/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package me.crud.form;

import me.crud.database.DatabaseManager;
import me.crud.database.ProductManager;
import me.crud.model.Product;

/**
 *
 * @author helio
 */
public class InsertProductForm extends javax.swing.JFrame {

    /**
     * Creates new form InsertProductForm
     */
    public InsertProductForm() {
        initComponents();
        
        errorLabel.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        formTitle = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Product");
        setAlwaysOnTop(true);
        setResizable(false);

        okButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nameLabel.setText("Product Name");

        nameField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        priceLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        priceLabel.setText("Product Price");

        priceField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        quantityLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        quantityLabel.setText("Quantity");

        quantityField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        formTitle.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        formTitle.setText("Insert Product");

        errorLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("ERROR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceLabel)
                            .addComponent(quantityLabel)
                            .addComponent(nameLabel))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                            .addComponent(priceField)
                            .addComponent(quantityField)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(formTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(okButton)
                        .addGap(37, 37, 37)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLabel)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errorLabel)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        ProductManager productManager = ProductManager.getInstance();
        DatabaseManager databaseManager = DatabaseManager.getInstance();

        if (databaseManager.isClosed()) {
            errorLabel.setText("ERROR: Database connection is closed");
            return;
        }

        if (!productManager.isLoaded()) {
            errorLabel.setText("ERROR: Products have not been loaded yet");
            return;
        }

        String name = nameField.getText();
        if (name.isEmpty()) {
            errorLabel.setText("ERROR: You must give a name to the product");
            return;
        }

        String priceText = priceField.getText();
        if (priceText.isEmpty()) {
            errorLabel.setText("ERROR: You must give a price to the product");
            return;
        }

        float price = 0;
        try {
            price = Float.parseFloat(priceText);
        }
        catch (Exception e) {
            errorLabel.setText("ERROR: Invalid price");
            return;
        }

        if (price < 0) {
            errorLabel.setText("ERROR: Invalid price (must be >= 0)");
            return;
        }

        String quantityText = quantityField.getText();
        if (quantityText.isEmpty()) {
            errorLabel.setText("ERROR: You must give a quantity to this product");
            return;
        }

        int quantity = -1;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            errorLabel.setText("ERROR: Invalid quantity");
            return;
        }

        if (quantity < 0) {
            errorLabel.setText("ERROR: Invalid quantity (must be >= 0)");
            return;
        }

        if (productManager.getProductByName(name) != null) {
            errorLabel.setText("ERROR: Name is already in use");
            return;
        }

        Product product = productManager.createProduct(name, price, quantity);
        if (product == null) {
            errorLabel.setText("ERROR: Error creating product");
            return;
        }

        MainForm.getInstance().updateProductsTable();
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel formTitle;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel quantityLabel;
    // End of variables declaration//GEN-END:variables
}
