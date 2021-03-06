/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.presentation;

import canteen.common.utility.Session;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BillPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderPanel
     *
     */
    public BillPanel() {
        initComponents();

        tblAllBillModel = (DefaultTableModel) tblAllBill.getModel();
        tblBillDetailModel = (DefaultTableModel) tblBillDetail.getModel();

        setButtonStatus(Session.employee.getRole() == 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        pnlBillDetail = new javax.swing.JPanel();
        jlblFullName = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        jlblDepartment = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        jlblCreateDate = new javax.swing.JLabel();
        lblCreateDate = new javax.swing.JLabel();
        jlblTotalPrice = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        jlblPaymentStatus = new javax.swing.JLabel();
        lblPaymentStatus = new javax.swing.JLabel();
        scpBillDetail = new javax.swing.JScrollPane();
        tblBillDetail = new javax.swing.JTable();
        jlblComment = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaComment = new javax.swing.JTextArea();
        btnUpdateComment = new javax.swing.JButton();
        jlblStatus = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        btnExportBill = new javax.swing.JButton();
        btnDeleteBill = new javax.swing.JButton();
        dateCreateDate = new com.toedter.calendar.JDateChooser();
        pnlAllBill = new javax.swing.JPanel();
        scpAllBill = new javax.swing.JScrollPane();
        tblAllBill = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(920, 659));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 102, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Bill Management");

        pnlBillDetail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bill Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 153, 255))); // NOI18N
        pnlBillDetail.setPreferredSize(new java.awt.Dimension(900, 293));

        jlblFullName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblFullName.setText("Full Name:");

        lblFullName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFullName.setForeground(new java.awt.Color(51, 51, 255));
        lblFullName.setText("Dao Thao");

        jlblDepartment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblDepartment.setText("Department:");

        lblDepartment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDepartment.setText("...");

        jlblCreateDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblCreateDate.setText("Create Date:");

        lblCreateDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCreateDate.setText("...");

        jlblTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblTotalPrice.setText("Total Price:");
        jlblTotalPrice.setPreferredSize(new java.awt.Dimension(100, 14));

        lblTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotalPrice.setText("...");

        jlblPaymentStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblPaymentStatus.setText("Payment Status:");
        jlblPaymentStatus.setPreferredSize(new java.awt.Dimension(100, 14));

        lblPaymentStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPaymentStatus.setForeground(new java.awt.Color(255, 51, 0));
        lblPaymentStatus.setText("...");

        tblBillDetail.setAutoCreateRowSorter(true);
        tblBillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bill ID", "Item Name", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBillDetail.getTableHeader().setResizingAllowed(false);
        tblBillDetail.getTableHeader().setReorderingAllowed(false);
        tblBillDetail.setUpdateSelectionOnSort(false);
        scpBillDetail.setViewportView(tblBillDetail);

        jlblComment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblComment.setText("Comment:");
        jlblComment.setPreferredSize(new java.awt.Dimension(100, 14));

        txaComment.setColumns(20);
        txaComment.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txaComment.setRows(5);
        txaComment.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txaComment);

        btnUpdateComment.setText("Update Comment");
        btnUpdateComment.setPreferredSize(new java.awt.Dimension(115, 30));
        btnUpdateComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCommentActionPerformed(evt);
            }
        });

        jlblStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblStatus.setText("Search by payment status:");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Paid", "Unpaid" }));
        cboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatusActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSearch.setText("Search:");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnPayment.setText("Payment");
        btnPayment.setPreferredSize(new java.awt.Dimension(115, 30));
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        btnExportBill.setText("Export Bill");
        btnExportBill.setPreferredSize(new java.awt.Dimension(115, 30));
        btnExportBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportBillActionPerformed(evt);
            }
        });

        btnDeleteBill.setText("Delete Bill");
        btnDeleteBill.setPreferredSize(new java.awt.Dimension(115, 30));
        btnDeleteBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBillActionPerformed(evt);
            }
        });

        dateCreateDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateCreateDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout pnlBillDetailLayout = new javax.swing.GroupLayout(pnlBillDetail);
        pnlBillDetail.setLayout(pnlBillDetailLayout);
        pnlBillDetailLayout.setHorizontalGroup(
            pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBillDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlBillDetailLayout.createSequentialGroup()
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlblDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblPaymentStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblCreateDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblTotalPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblFullName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblComment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblFullName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCreateDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpBillDetail)
                    .addGroup(pnlBillDetailLayout.createSequentialGroup()
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblStatus)
                            .addComponent(btnUpdateComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBillDetailLayout.createSequentialGroup()
                                .addComponent(btnExportBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(btnDeleteBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBillDetailLayout.createSequentialGroup()
                                .addComponent(lblSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateCreateDate, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(txtSearch))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        pnlBillDetailLayout.setVerticalGroup(
            pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBillDetailLayout.createSequentialGroup()
                .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBillDetailLayout.createSequentialGroup()
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblCreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblComment, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpBillDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBillDetailLayout.createSequentialGroup()
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch)
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateCreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdateComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExportBill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDeleteBill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pnlAllBill.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 153, 255))); // NOI18N
        pnlAllBill.setPreferredSize(new java.awt.Dimension(816, 200));

        tblAllBill.setAutoCreateRowSorter(true);
        tblAllBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bill ID", "Employee Name", "Department", "Total Price", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAllBill.getTableHeader().setResizingAllowed(false);
        tblAllBill.getTableHeader().setReorderingAllowed(false);
        tblAllBill.setUpdateSelectionOnSort(false);
        scpAllBill.setViewportView(tblAllBill);

        javax.swing.GroupLayout pnlAllBillLayout = new javax.swing.GroupLayout(pnlAllBill);
        pnlAllBill.setLayout(pnlAllBillLayout);
        pnlAllBillLayout.setHorizontalGroup(
            pnlAllBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpAllBill)
        );
        pnlAllBillLayout.setVerticalGroup(
            pnlAllBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpAllBill, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBillDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
            .addComponent(pnlAllBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBillDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAllBill, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCommentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateCommentActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnExportBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportBillActionPerformed

    private void btnDeleteBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteBillActionPerformed

    private void cboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboStatusActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void dateCreateDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateCreateDatePropertyChange
        // TODO add your handling code here:
        if (evt.getPropertyName().equals("date")) {
            String createDate = new SimpleDateFormat("yyyy-MM-dd").format(dateCreateDate.getDate());
            System.out.println(createDate);
        }
    }//GEN-LAST:event_dateCreateDatePropertyChange

    private void setButtonStatus(boolean status) {
        btnPayment.setVisible(status);
        btnExportBill.setVisible(status);
        btnDeleteBill.setVisible(status);
    }

    // Get all bill by role
    private void getAllBill() {
        tblAllBillModel.setNumRows(0);

    }

    // Variables declaration
    private DefaultTableModel tblAllBillModel, tblBillDetailModel;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteBill;
    private javax.swing.JButton btnExportBill;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateComment;
    private javax.swing.JComboBox cboStatus;
    private com.toedter.calendar.JDateChooser dateCreateDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblComment;
    private javax.swing.JLabel jlblCreateDate;
    private javax.swing.JLabel jlblDepartment;
    private javax.swing.JLabel jlblFullName;
    private javax.swing.JLabel jlblPaymentStatus;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JLabel jlblTotalPrice;
    private javax.swing.JLabel lblCreateDate;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblPaymentStatus;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JPanel pnlAllBill;
    private javax.swing.JPanel pnlBillDetail;
    private javax.swing.JScrollPane scpAllBill;
    private javax.swing.JScrollPane scpBillDetail;
    private javax.swing.JTable tblAllBill;
    private javax.swing.JTable tblBillDetail;
    private javax.swing.JTextArea txaComment;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
