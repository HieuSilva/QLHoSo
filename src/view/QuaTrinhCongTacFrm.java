/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Controller;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import model.HoSo;
import model.QuaTrinhCongTac;

/**
 *
 * @author Dell
 */
public class QuaTrinhCongTacFrm extends javax.swing.JFrame {

    private Controller controller;
    private HoSoNhanVienFrm hoSoNhanVienFrm;
    private HoSo hoSo;
    private QuaTrinhCongTac selectedQTCT;
    private ArrayList<ChucVu> listChucVu;
    private ArrayList<QuaTrinhCongTac> listQTCongTac;

    /**
     * Creates new form QuaTrinhCongTacFrm
     */
    public QuaTrinhCongTacFrm(HoSoNhanVienFrm hoSoNhanVienFrm, HoSo hoSo, ArrayList<ChucVu> listChucVu) {
        initComponents();

        controller = new Controller();
        setHoSo(hoSo);
        setListChucVu(listChucVu);
        setHoSoNhanVienFrm(hoSoNhanVienFrm);
        listQTCongTac = controller.getListQTCongTac(hoSo, listChucVu);

        if (listQTCongTac == null) {
            JOptionPane.showMessageDialog(null, "Không có quá trình công tác");
            hoSoNhanVienFrm.getBtnDeXuatThem().setEnabled(true);
        }

        displayTable();
        setCbbListChucVu();

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosed(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                hoSoNhanVienFrm.getBtnDeXuatThem().setEnabled(true);
                hoSoNhanVienFrm.setListQTCT(listQTCongTac);
            }

            @Override
            public void windowIconified(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public HoSo getHoSo() {
        return hoSo;
    }

    public void setHoSo(HoSo hoSo) {
        this.hoSo = hoSo;
    }

    public HoSoNhanVienFrm getHoSoNhanVienFrm() {
        return hoSoNhanVienFrm;
    }

    public void setHoSoNhanVienFrm(HoSoNhanVienFrm hoSoNhanVienFrm) {
        this.hoSoNhanVienFrm = hoSoNhanVienFrm;
    }

    public ArrayList<ChucVu> getListChucVu() {
        return listChucVu;
    }

    public void setListChucVu(ArrayList<ChucVu> listChucVu) {
        this.listChucVu = listChucVu;
    }

    public ArrayList<QuaTrinhCongTac> getListQTCongTac() {
        return listQTCongTac;
    }

    public void setListQTCongTac(ArrayList<QuaTrinhCongTac> listQTCongTac) {
        this.listQTCongTac = listQTCongTac;
    }

    private void displayTable() {
        DefaultTableModel dm = (DefaultTableModel) tblQTCT.getModel();
        dm.setRowCount(0);

        if (listQTCongTac != null) {
            for (QuaTrinhCongTac qtct : listQTCongTac) {
                Object[] obj = new Object[]{qtct.getChucVu().getTen(), qtct.getNhiemVu(), qtct.getNgayBatDau(), qtct.getNgayKetThuc()};
                dm.addRow(obj);
            }
        }
    }

    private void setContent(QuaTrinhCongTac qtct) {
        txtMaQTCT.setText(qtct.getId() + "");
        txtNhiemVu.setText(qtct.getNhiemVu());

        cbbChucVu.setSelectedItem(qtct.getChucVu().getTen());

        if (txtTuNgay.getText().trim().equals("")) {
            txtTuNgay.setText("");
        }
        else {
            txtTuNgay.setText(qtct.getNgayBatDau().toString());
        }

        if (txtDenNgay.getText().trim().equals("")) {
            txtDenNgay.setText("");
        }
        else {
            txtDenNgay.setText(qtct.getNgayKetThuc().toString());
        }
    }

    private void clearContent() {
        txtMaQTCT.setText("");
        txtNhiemVu.setText("");
        cbbChucVu.setSelectedIndex(0);
        txtTuNgay.setText("");
        txtDenNgay.setText("");
    }

    private void setCbbListChucVu() {
        cbbChucVu.removeAllItems();

        for (ChucVu cv : listChucVu) {
            cbbChucVu.addItem(cv.getTen());
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

        jLabel1 = new javax.swing.JLabel();
        txtMaQTCT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNhiemVu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTuNgay = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDenNgay = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQTCT = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quá trình công tác");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jLabel1.setText("Mã QTCT");

        txtMaQTCT.setEditable(false);

        jLabel2.setText("Nhiệm vụ");

        jLabel3.setText("Từ ngày");

        jLabel4.setText("Đến ngày");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblQTCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chức vụ", "Nhiệm vụ", "Từ ngày", "Đến ngày"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQTCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQTCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQTCT);

        jLabel5.setText("(*)");

        jLabel6.setText("Chức vụ");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaQTCT, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaQTCT)
                    .addComponent(btnThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(jLabel2)
                    .addComponent(txtNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!txtNhiemVu.getText().trim().equals("")) {
            QuaTrinhCongTac qtct = new QuaTrinhCongTac();
            qtct.setChucVu(listChucVu.get(cbbChucVu.getSelectedIndex()));
            qtct.setNhiemVu(txtNhiemVu.getText());
            try {
                if (txtTuNgay.getText().trim().equals("")) {
                    qtct.setNgayBatDau(null);
                }
                else {
                    qtct.setNgayBatDau(new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd").parse(txtTuNgay.getText()).getTime()));
                }

                if (txtDenNgay.getText().trim().equals("")) {
                    qtct.setNgayKetThuc(null);
                }
                else {
                    qtct.setNgayKetThuc(new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd").parse(txtDenNgay.getText()).getTime()));
                }

            }
            catch (ParseException ex) {
                //            Logger.getLogger(QuaTrinhCongTacFrm.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                qtct.setNgayBatDau(null);
                qtct.setNgayKetThuc(null);
            }

            if (listQTCongTac == null) {
                listQTCongTac = new ArrayList<>();
                listQTCongTac.add(qtct);

                displayTable();
                clearContent();
            }
            else {
                if (!listQTCongTac.contains(qtct)) {
                    listQTCongTac.add(qtct);

                    displayTable();
                    clearContent();
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Không được bỏ trống dữ liệu bắt buộc!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (selectedQTCT != null) {
            try {
                selectedQTCT.setChucVu(listChucVu.get(cbbChucVu.getSelectedIndex()));
                selectedQTCT.setNhiemVu(txtNhiemVu.getText());
                selectedQTCT.setNgayBatDau(new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd").parse(txtTuNgay.getText()).getTime()));
                selectedQTCT.setNgayKetThuc(new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd").parse(txtDenNgay.getText()).getTime()));
            }
            catch (ParseException ex) {
                Logger.getLogger(QuaTrinhCongTacFrm.class.getName()).log(Level.SEVERE, null, ex);
                selectedQTCT.setNgayBatDau(null);
                selectedQTCT.setNgayKetThuc(null);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        listQTCongTac.remove(selectedQTCT);
        selectedQTCT = null;

        displayTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblQTCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQTCTMouseClicked
        // TODO add your handling code here:
        int row = tblQTCT.getSelectedRow();
        selectedQTCT = listQTCongTac.get(row);

        setContent(selectedQTCT);
    }//GEN-LAST:event_tblQTCTMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuaTrinhCongTacFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuaTrinhCongTacFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuaTrinhCongTacFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuaTrinhCongTacFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuaTrinhCongTacFrm().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQTCT;
    private javax.swing.JTextField txtDenNgay;
    private javax.swing.JTextField txtMaQTCT;
    private javax.swing.JTextField txtNhiemVu;
    private javax.swing.JTextField txtTuNgay;
    // End of variables declaration//GEN-END:variables
}
