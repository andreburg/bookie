/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.BorrowerController;
import controller.ValidationController;
import controller.DataController;
import java.util.List;
import model.Borrower;

/**
 *
 * @author olwia
 */
public class BorrowerManager extends javax.swing.JPanel {

    /**
     * Creates new form BorrowerManager
     */
    public BorrowerManager() {
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

        tfBorrowerID = new javax.swing.JTextField();
        tfBorrowerName = new javax.swing.JTextField();
        tfBorrowerLastName = new javax.swing.JTextField();
        tfBorrowerPhoneNumber = new javax.swing.JTextField();
        tfBorrowerEmailAddress = new javax.swing.JTextField();
        tfBorrowerHomeAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBorrowers = new javax.swing.JTable();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JButton BtnAdd = new javax.swing.JButton();
        javax.swing.JButton BtnView = new javax.swing.JButton();
        BtnMain = new javax.swing.JButton();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        BtnSearch = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1040, 760));
        setLayout(null);

        tfBorrowerID.setText("Enter ID");
        add(tfBorrowerID);
        tfBorrowerID.setBounds(20, 80, 270, 26);

        tfBorrowerName.setText("Enter your Name");
        add(tfBorrowerName);
        tfBorrowerName.setBounds(20, 130, 270, 26);

        tfBorrowerLastName.setText("Enter your Last Name");
        add(tfBorrowerLastName);
        tfBorrowerLastName.setBounds(320, 130, 270, 26);

        tfBorrowerPhoneNumber.setText("Enter your Phone Number");
        add(tfBorrowerPhoneNumber);
        tfBorrowerPhoneNumber.setBounds(20, 180, 270, 26);

        tfBorrowerEmailAddress.setText("Enter Email Address");
        add(tfBorrowerEmailAddress);
        tfBorrowerEmailAddress.setBounds(320, 180, 270, 26);

        tfBorrowerHomeAddress.setText("Enter Home Address");
        add(tfBorrowerHomeAddress);
        tfBorrowerHomeAddress.setBounds(20, 230, 270, 26);

        TableBorrowers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Last Name", "Phone Number", "Email", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableBorrowers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBorrowersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableBorrowers);

        add(jScrollPane1);
        jScrollPane1.setBounds(22, 327, 990, 410);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Borrowers");
        add(jLabel1);
        jLabel1.setBounds(407, 10, 196, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ID:");
        add(jLabel2);
        jLabel2.setBounds(30, 60, 16, 16);

        BtnAdd.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnAdd.setText("Add");
        BtnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });
        add(BtnAdd);
        BtnAdd.setBounds(30, 290, 174, 30);

        BtnView.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnView.setText("View All");
        BtnView.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnViewActionPerformed(evt);
            }
        });
        add(BtnView);
        BtnView.setBounds(410, 230, 80, 30);

        BtnMain.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnMain.setText("Main Menu");
        BtnMain.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMainActionPerformed(evt);
            }
        });
        add(BtnMain);
        BtnMain.setBounds(840, 290, 174, 31);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(370, 80, 0, 0);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Name:");
        add(jLabel4);
        jLabel4.setBounds(30, 110, 110, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Phone Number:");
        add(jLabel5);
        jLabel5.setBounds(30, 160, 220, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Last Name:");
        add(jLabel6);
        jLabel6.setBounds(330, 110, 130, 16);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Home Address:");
        add(jLabel7);
        jLabel7.setBounds(30, 210, 150, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Email Address:");
        add(jLabel8);
        jLabel8.setBounds(330, 160, 230, 16);

        BtnSearch.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnSearch.setText("Search ID");
        BtnSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(BtnSearch);
        BtnSearch.setBounds(500, 230, 79, 30);

        BtnUpdate.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnUpdate.setText("Update");
        BtnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });
        add(BtnUpdate);
        BtnUpdate.setBounds(230, 290, 170, 30);

        BtnDelete.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnDelete.setText("Delete");
        BtnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });
        add(BtnDelete);
        BtnDelete.setBounds(430, 290, 170, 30);

        BtnReset.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        BtnReset.setText("Reset");
        BtnReset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });
        add(BtnReset);
        BtnReset.setBounds(320, 230, 79, 30);
    }// </editor-fold>//GEN-END:initComponents

    private BorrowerController bc;
    ValidationController vc = new ValidationController();
    Borrower borrower;

    private void populateTable(boolean search, boolean update) {
        try {
            bc = new BorrowerController();
            DefaultTableModel model = (DefaultTableModel) TableBorrowers.getModel();

            if (search) {
                // Perform search
                bc.viewAllBorrowers(tfBorrowerID.getText());
            } else {
                // Retrieve all authors
                bc.viewAllBorrowers("");
            }

            List<Borrower> borrowers = bc.getBorrowers();

            // Clear existing rows
            model.setRowCount(0);

            if (borrowers.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No borrowers found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                // Populate the table with new data
                for (Borrower borrower : borrowers) {
                    Object[] row = {borrower.getId(), borrower.getName(), borrower.getSurname(), borrower.getPhone(), borrower.getEmail(), borrower.getAddress()};
                    model.addRow(row);
                }
                if (!update) {
                    JOptionPane.showMessageDialog(null, "Borrower table successfully pulled!");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Borrower table not pulled!", "Read Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        // TODO add your handling code here:
        try {
            bc = new BorrowerController();

            int id = Integer.parseInt(tfBorrowerID.getText());
            String name = tfBorrowerName.getText();
            String lastName = tfBorrowerLastName.getText();
            String phoneNumber = tfBorrowerPhoneNumber.getText();
            String email = tfBorrowerEmailAddress.getText();
            String address = tfBorrowerHomeAddress.getText();

            borrower = new Borrower(id, name, lastName, phoneNumber, email, address);

            // Validate Borrower
            ValidationController.ValidationResult result = vc.validateBorrower(borrower);

            if (result.isValid()) {
                // Add author to the database
                bc.addBorrower(borrower);

                //Pull and Update the table from DB
                populateTable(false, true);
                JOptionPane.showMessageDialog(null, "Borrower " + Integer.toString(borrower.getId()) + " successfully added!");
                
                //Clear all fields:
                tfBorrowerID.setText("");
                tfBorrowerName.setText("");
                tfBorrowerLastName.setText("");
                tfBorrowerPhoneNumber.setText("");
                tfBorrowerEmailAddress.setText("");
                tfBorrowerHomeAddress.setText("");

            } else {
                // Display error dialog with the identifier result
                JOptionPane.showMessageDialog(null, "Error: " + result.getIdentifier(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "Error: Invalid ID", "Validation Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViewActionPerformed
        // TODO add your handling code here:
       populateTable(false,false);
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

    private void TableBorrowersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBorrowersMouseClicked
        // Check if a row is selected
        int selectedRow = TableBorrowers.getSelectedRow();

        if (selectedRow != -1) {
            // Get values from the selected row
            Object idValue = TableBorrowers.getValueAt(selectedRow, 0);
            Object nameValue = TableBorrowers.getValueAt(selectedRow, 1);
            Object surnameValue = TableBorrowers.getValueAt(selectedRow, 2);
            Object phoneValue = TableBorrowers.getValueAt(selectedRow, 3);
            Object emailValue = TableBorrowers.getValueAt(selectedRow, 4);
            Object addressValue = TableBorrowers.getValueAt(selectedRow, 5);

            // Convert to String, defaulting to empty string if null
            String id = idValue != null ? idValue.toString() : "";
            String name = nameValue != null ? nameValue.toString() : "";
            String surname = surnameValue != null ? surnameValue.toString() : "";
            String phone = phoneValue != null ? phoneValue.toString() : "";
            String email = emailValue != null ? emailValue.toString() : "";
            String address = addressValue != null ? addressValue.toString() : "";

            // Set the values in text fields
            tfBorrowerID.setText(id);
            tfBorrowerName.setText(name);
            tfBorrowerLastName.setText(surname);
            tfBorrowerPhoneNumber.setText(phone);
            tfBorrowerEmailAddress.setText(email);
            tfBorrowerHomeAddress.setText(address);

            // Disable the ID field and enable buttons
            tfBorrowerID.setEnabled(false);
            BtnUpdate.setEnabled(true);
            BtnDelete.setEnabled(true);
        }
    }//GEN-LAST:event_TableBorrowersMouseClicked

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        try {
            bc = new BorrowerController();

            int id = Integer.parseInt(tfBorrowerID.getText());
            String name = tfBorrowerName.getText();
            String lastName = tfBorrowerLastName.getText();
            String phoneNumber = tfBorrowerPhoneNumber.getText();
            String email = tfBorrowerEmailAddress.getText();
            String address = tfBorrowerHomeAddress.getText();

            borrower = new Borrower(id, name, lastName, phoneNumber, email, address);

            // Validate Borrower
            ValidationController.ValidationResult result = vc.validateBorrower(borrower);

            if (result.isValid()) {
                // Add borrower to the database
                bc.updateBorrower(borrower);
                //Pull and Update the table from DB
                populateTable(false,true);
                // TO HERE
                JOptionPane.showMessageDialog(null, "Borrower " + Integer.toString(borrower.getId()) + " successfully updated!");
            } else {
                // Display error dialog with the identifier result
                JOptionPane.showMessageDialog(null, "Error: " + result.getIdentifier(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "Error: Invalid ID", "Validation Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        try {
            bc = new BorrowerController();

            int id = Integer.parseInt(tfBorrowerID.getText());
            String name = tfBorrowerName.getText();
            String lastName = tfBorrowerLastName.getText();
            String phoneNumber = tfBorrowerPhoneNumber.getText();
            String email = tfBorrowerEmailAddress.getText();
            String address = tfBorrowerHomeAddress.getText();

            borrower = new Borrower(id, name, lastName, phoneNumber, email, address);

            // Validate Author
            ValidationController.ValidationResult result = vc.validateBorrower(borrower);

            if (result.isValid()) {
                // Add author to the database
                bc.deleteBorrower(borrower);
                //Pull and Update the table from DB
                populateTable(false,true);
                // TO HERE
                JOptionPane.showMessageDialog(null, "Borrower " + Integer.toString(borrower.getId()) + " successfully deleted!");
            } else {
                // Display error dialog with the identifier result
                JOptionPane.showMessageDialog(null, "Error: " + result.getIdentifier(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "Error: Invalid ID", "Validation Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // Clear all text fields
        tfBorrowerID.setText("");
        tfBorrowerName.setText("");
        tfBorrowerLastName.setText("");
        tfBorrowerPhoneNumber.setText("");
        tfBorrowerEmailAddress.setText("");
        tfBorrowerHomeAddress.setText("");

        // Re-enable the ID text field for new entries
        tfBorrowerID.setEnabled(true);

        // Disable the update and delete buttons
        BtnUpdate.setEnabled(false);
        BtnDelete.setEnabled(false);

        // Deselect any selected row in the table
        TableBorrowers.clearSelection();
    }//GEN-LAST:event_BtnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnMain;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JTable TableBorrowers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfBorrowerEmailAddress;
    private javax.swing.JTextField tfBorrowerHomeAddress;
    private javax.swing.JTextField tfBorrowerID;
    private javax.swing.JTextField tfBorrowerLastName;
    private javax.swing.JTextField tfBorrowerName;
    private javax.swing.JTextField tfBorrowerPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
