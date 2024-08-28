/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.AuthorController;
import controller.ValidationController;
import model.Author;

public class AuthorsManager extends javax.swing.JPanel {

    /**
     * Creates new form AuthorsManager
     */
    public AuthorsManager() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAuthors = new javax.swing.JTable();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JButton BtnAdd = new javax.swing.JButton();
        javax.swing.JButton BtnView = new javax.swing.JButton();
        BtnMain = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        tfAuthorID = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        tfAuthorName = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        tfAuthorLastName = new javax.swing.JTextField();
        javax.swing.JButton BtnReset = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1080, 540));
        setLayout(null);

        TableAuthors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAuthors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAuthorsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableAuthors);

        add(jScrollPane1);
        jScrollPane1.setBounds(6, 306, 1006, 226);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Authors");
        add(jLabel1);
        jLabel1.setBounds(431, 10, 220, 50);

        BtnAdd.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnAdd.setText("Add");
        BtnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });
        add(BtnAdd);
        BtnAdd.setBounds(840, 110, 175, 30);

        BtnView.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnView.setText("View");
        BtnView.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnViewActionPerformed(evt);
            }
        });
        add(BtnView);
        BtnView.setBounds(840, 160, 175, 30);

        BtnMain.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnMain.setText("Main Menu");
        BtnMain.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnMain.setMaximumSize(new java.awt.Dimension(28, 22));
        BtnMain.setMinimumSize(new java.awt.Dimension(28, 22));
        BtnMain.setPreferredSize(new java.awt.Dimension(28, 22));
        BtnMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMainActionPerformed(evt);
            }
        });
        add(BtnMain);
        BtnMain.setBounds(840, 60, 175, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ID:");
        add(jLabel2);
        jLabel2.setBounds(40, 80, 16, 16);

        tfAuthorID.setText("Enter ID");
        tfAuthorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAuthorIDActionPerformed(evt);
            }
        });
        add(tfAuthorID);
        tfAuthorID.setBounds(30, 100, 270, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Name:");
        add(jLabel4);
        jLabel4.setBounds(40, 140, 110, 16);

        tfAuthorName.setText("Enter your Name");
        add(tfAuthorName);
        tfAuthorName.setBounds(30, 160, 270, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Last Name:");
        add(jLabel6);
        jLabel6.setBounds(40, 200, 130, 16);

        tfAuthorLastName.setText("Enter your Last Name");
        add(tfAuthorLastName);
        tfAuthorLastName.setBounds(30, 220, 270, 22);

        BtnReset.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnReset.setText("Reset");
        BtnReset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnReset.setName(""); // NOI18N
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });
        add(BtnReset);
        BtnReset.setBounds(40, 260, 110, 30);

        BtnUpdate.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnUpdate.setText("Update");
        BtnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnUpdate.setEnabled(false);
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });
        add(BtnUpdate);
        BtnUpdate.setBounds(840, 210, 175, 30);

        BtnDelete.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnDelete.setText("Delete");
        BtnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnDelete.setEnabled(false);
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });
        add(BtnDelete);
        BtnDelete.setBounds(840, 260, 175, 30);
    }// </editor-fold>//GEN-END:initComponents

    private AuthorController ac;
    ValidationController vc = new ValidationController();
    Author author;
    
    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        try {
            ac = new AuthorController();
            
            int id = Integer.parseInt(tfAuthorID.getText());
            String name = tfAuthorName.getText();
            String lastName = tfAuthorLastName.getText();
            author = new Author(id, name, lastName);

            // Validate Author
            ValidationController.ValidationResult result = vc.validateAuthor(author);

            if (result.isValid()) {
                // Add author to the database
                ac.addAuthor(author);
                //Pull and Update the table from DB
                // TO HERE
                JOptionPane.showMessageDialog(null, "Author " + Integer.toString(author.getId()) + " successfully added!");
            } else {
                // Display error dialog with the identifier result
                JOptionPane.showMessageDialog(null, "Error: " + result.getIdentifier(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex){
            //JOptionPane.showMessageDialog(null, "Error: Invalid ID", "Validation Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }  
    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnViewActionPerformed

    private void BtnMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMainActionPerformed
        // TODO add your handling code here:
        JFrame parentFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (parentFrame != null) {
            parentFrame.dispose();
        } else {
            System.out.println("No parent frame found.");
        }

        MainDashboard md = new MainDashboard();
        md.setVisible(true);
    }//GEN-LAST:event_BtnMainActionPerformed

    private void tfAuthorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAuthorIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAuthorIDActionPerformed

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // Clear text fields
        tfAuthorID.setText("");
        tfAuthorName.setText("");
        tfAuthorLastName.setText("");

        // Re-enable the ID text field
        tfAuthorID.setEnabled(true);
        
        // Disable Buttons
        BtnUpdate.disable();
        BtnDelete.disable();

        // Deselect any selected row in the table
        TableAuthors.clearSelection();
    }//GEN-LAST:event_BtnResetActionPerformed

    private void TableAuthorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAuthorsMouseClicked
        // Check if a row is selected
        int selectedRow = TableAuthors.getSelectedRow();
    
        if (selectedRow != -1) {
            // Get values from the selected row
            Object idValue = TableAuthors.getValueAt(selectedRow, 0);
            Object firstNameValue = TableAuthors.getValueAt(selectedRow, 1);
            Object lastNameValue = TableAuthors.getValueAt(selectedRow, 2);

            // Convert to String, defaulting to empty string if null
            String id = idValue != null ? idValue.toString() : "";
            String firstName = firstNameValue != null ? firstNameValue.toString() : "";
            String lastName = lastNameValue != null ? lastNameValue.toString() : "";

            // Set the values in text fields
            tfAuthorID.setText(id);
            tfAuthorName.setText(firstName);
            tfAuthorLastName.setText(lastName);

            // Disable the ID field and enable buttons
            tfAuthorID.setEnabled(false);
            BtnUpdate.enable();
            BtnDelete.enable();
        }
    }//GEN-LAST:event_TableAuthorsMouseClicked

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        try {
            ac = new AuthorController();
            
            int id = Integer.parseInt(tfAuthorID.getText());
            String name = tfAuthorName.getText();
            String lastName = tfAuthorLastName.getText();
            author = new Author(id, name, lastName);

            // Validate Author
            ValidationController.ValidationResult result = vc.validateAuthor(author);

            if (result.isValid()) {
                // Add author to the database
                ac.updateAuthor(author);
                //Pull and Update the table from DB
                // TO HERE
                JOptionPane.showMessageDialog(null, "Author " + Integer.toString(author.getId()) + " successfully updated!");
            } else {
                // Display error dialog with the identifier result
                JOptionPane.showMessageDialog(null, "Error: " + result.getIdentifier(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex){
            //JOptionPane.showMessageDialog(null, "Error: Invalid ID", "Validation Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        try {
            ac = new AuthorController();
            
            int id = Integer.parseInt(tfAuthorID.getText());
            String name = tfAuthorName.getText();
            String lastName = tfAuthorLastName.getText();
            author = new Author(id, name, lastName);

            // Validate Author
            ValidationController.ValidationResult result = vc.validateAuthor(author);

            if (result.isValid()) {
                // Add author to the database
                ac.deleteAuthor(author);
                //Pull and Update the table from DB
                // TO HERE
                JOptionPane.showMessageDialog(null, "Author " + Integer.toString(author.getId()) + " successfully deleted!");
            } else {
                // Display error dialog with the identifier result
                JOptionPane.showMessageDialog(null, "Error: " + result.getIdentifier(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex){
            //JOptionPane.showMessageDialog(null, "Error: Invalid ID", "Validation Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnMain;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JTable TableAuthors;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfAuthorID;
    private javax.swing.JTextField tfAuthorLastName;
    private javax.swing.JTextField tfAuthorName;
    // End of variables declaration//GEN-END:variables
}
