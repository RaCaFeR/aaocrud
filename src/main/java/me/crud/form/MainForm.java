/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package me.crud.form;

import me.crud.database.DatabaseManager;
import me.crud.database.ProductManager;
import me.crud.model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author helio
 */
public class MainForm extends javax.swing.JFrame {

    private static MainForm instance;
    private boolean loaded;

    public static MainForm getInstance() {
        return MainForm.instance;
    }

    public static void setInstance(MainForm instance) {
        MainForm.instance = instance;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        loadingPanel.setVisible(false);
        mainPanel.setVisible(false);
    }
    
    public void initLoading() {
        if (isLoaded()) return;
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        ProductManager productManager = ProductManager.getInstance();
        
        loadingPanel.setVisible(true);

        try {
            loadingLabel.setText("Connecting to database...");

            databaseManager.connect();
            if (databaseManager.isClosed()) {
                loadingLabel.setText("Could not connect to the database");
                return;
            }

            databaseManager.setupDatabase();
        }
        catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            loadingLabel.setText("An error occurred when connecting to the database");
            return;
        }

        try {
            loadingLabel.setText("Loading products...");

            productManager.loadAllProducts();

            loadingLabel.setText("Successfully loaded all the products");
        }
        catch (Exception e) {
            System.out.println("Error loading products: " + e.getMessage());
            loadingLabel.setText("An error occurred when loading the products");
            return;
        }

        loadingPanel.setVisible(false);
        mainPanel.setVisible(true);
    }

    public void clearProductsTable() {
        DefaultTableModel model = (DefaultTableModel)productsTable.getModel();
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i);
        }
    }

    public void updateProductsTable() {
        DefaultTableModel model = (DefaultTableModel)productsTable.getModel();
        clearProductsTable();

        String filter = searchField.getText();

        ProductManager productManager = ProductManager.getInstance();
        ArrayList<Product> searchResult = productManager.getProductsByName(filter);
        for (Product product : searchResult) {
            model.addRow(product.toRow());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingPanel = new javax.swing.JPanel();
        loadingLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        formTitle = new javax.swing.JLabel();
        productsTitle = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();

        loadingLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        loadingLabel.setText("...");

        javax.swing.GroupLayout loadingPanelLayout = new javax.swing.GroupLayout(loadingPanel);
        loadingPanel.setLayout(loadingPanelLayout);
        loadingPanelLayout.setHorizontalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
            .addGroup(loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loadingPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(loadingLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        loadingPanelLayout.setVerticalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loadingPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(loadingLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD - Product Manager");
        setResizable(false);

        formTitle.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        formTitle.setText("Product Manager");

        productsTitle.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        productsTitle.setText("Products");

        removeButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        removeButton.setText("Remove Product");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        insertButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        insertButton.setText("Insert Product");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        editButton.setText("Edit Product");

        searchField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        searchField.setToolTipText("");
        searchField.setName("Search"); // NOI18N

        searchButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        productsTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productsTable.setRowHeight(24);
        scrollPane.setViewportView(productsTable);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(productsTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(insertButton)
                                .addGap(41, 41, 41)
                                .addComponent(editButton)
                                .addGap(35, 35, 35)
                                .addComponent(removeButton))
                            .addComponent(formTitle)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(searchButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(formTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(productsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchField))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(insertButton)
                    .addComponent(editButton))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        new InsertProductForm().setVisible(true);
    }//GEN-LAST:event_insertButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        updateProductsTable();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (productsTable.getSelectedRow() != -1) {
            new RemoveProductForm().setVisible(true);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    public JTable getProductsTable() {
        return this.productsTable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editButton;
    private javax.swing.JLabel formTitle;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JPanel loadingPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable productsTable;
    private javax.swing.JLabel productsTitle;
    private javax.swing.JButton removeButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
