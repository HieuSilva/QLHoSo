/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Controller;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.ChucVu;
import model.DonVi;
import model.HoSo;
import model.HopDong;
import model.LoaiHopDong;
import model.LyLich;
import model.PhongBan;
import model.QuaTrinhCongTac;

/**
 *
 * @author Dell
 */
public class HoSoNhanVienFrm extends javax.swing.JFrame {

    private Controller controller;
    private DonVi donVi;
    private HoSo hoSo;
    private LyLich lyLich;
    private HopDong hopDong;
    private ArrayList<PhongBan> listPhongBan;
    private ArrayList<ChucVu> listChucVu;
    private ArrayList<LoaiHopDong> listLoaiHopDong;
    private ArrayList<QuaTrinhCongTac> listQTCT;

    /**
     * Creates new form HoSoNhanVienFrm
     */
    public HoSoNhanVienFrm() {
        initComponents();

        controller = new Controller();
        donVi = controller.getDonVi();
        hoSo = new HoSo();
        lyLich = new LyLich();
        hopDong = new HopDong();
        listPhongBan = controller.getListPhongBan(donVi);
        listChucVu = controller.getListChucVu();
        listLoaiHopDong = controller.getListLoaiHopDong();
        listQTCT = controller.getListQTCongTac(hoSo, listChucVu);

        displayPhongBan();
        displayChucVu();
        displayLoaiHopDong();

        addComboboxListener();
        addTextListener();
    }

    public HoSo getHoSo() {
        return hoSo;
    }

    public void setHoSo(HoSo hoSo) {
        this.hoSo = hoSo;
    }

    public LyLich getLyLich() {
        return lyLich;
    }

    public void setLyLich(LyLich lyLich) {
        this.lyLich = lyLich;
    }

    public HopDong getHopDong() {
        return hopDong;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }

    public ArrayList<QuaTrinhCongTac> getListQTCT() {
        return listQTCT;
    }

    public void setListQTCT(ArrayList<QuaTrinhCongTac> listQTCT) {
        this.listQTCT = listQTCT;
    }

    public ArrayList<ChucVu> getListChucVu() {
        return listChucVu;
    }

    public void setListChucVu(ArrayList<ChucVu> listChucVu) {
        this.listChucVu = listChucVu;
    }

    private void displayPhongBan() {
        cbbTenPB.removeAllItems();

        if (listPhongBan != null) {
            for (PhongBan pb : listPhongBan) {
                cbbTenPB.addItem(pb.getTen());
            }
        }
    }

    private void displayChucVu() {
        cbbTenCV.removeAllItems();

        if (listChucVu != null) {
            for (ChucVu cv : listChucVu) {
                cbbTenCV.addItem(cv.getTen());
            }
        }
    }

    private void displayLoaiHopDong() {
        cbbLoaiHD.removeAllItems();

        if (listLoaiHopDong != null) {
            for (LoaiHopDong lhd : listLoaiHopDong) {
                cbbLoaiHD.addItem(lhd.getTen());
            }
        }
    }

    private void addComboboxListener() {
        cbbGioiTinh.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                JComboBox cbb = (JComboBox) e.getSource();
                Object item = e.getItem();

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lyLich.setGioiTinh(item.toString());
                }
            }
        });

        cbbLoaiHD.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                JComboBox cbb = (JComboBox) e.getSource();
                Object item = e.getItem();

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    hopDong.setLoaiHopDong(listLoaiHopDong.get(cbb.getSelectedIndex()));
                }
            }
        });

        cbbTenCV.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                JComboBox cbb = (JComboBox) e.getSource();
                Object item = e.getItem();

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    hopDong.setLoaiHopDong(listLoaiHopDong.get(cbb.getSelectedIndex()));
                }
            }
        });

        cbbTenPB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                JComboBox cbb = (JComboBox) e.getSource();
                Object item = e.getItem();

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    hoSo.setPhongBan(listPhongBan.get(cbb.getSelectedIndex()));
                }
            }
        });
    }

    public void addTextListener() {
        txtHoso_TenNV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                txtHoso_TenNV.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        txtLylich_TenNV.setText(txtHoso_TenNV.getText());
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        txtLylich_TenNV.setText(txtHoso_TenNV.getText());
                    }
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                txtHoso_TenNV.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        txtLylich_TenNV.setText(txtHoso_TenNV.getText());
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        txtLylich_TenNV.setText(txtHoso_TenNV.getText());
                    }
                });
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        txtLylich_TenNV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                txtLylich_TenNV.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        txtHoso_TenNV.setText(txtLylich_TenNV.getText());
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        txtHoso_TenNV.setText(txtLylich_TenNV.getText());
                    }
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                txtLylich_TenNV.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        txtHoso_TenNV.setText(txtLylich_TenNV.getText());
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        txtHoso_TenNV.setText(txtLylich_TenNV.getText());
                    }
                });
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    private boolean requiredTextFilled() {
        if ("".equals(txtHoso_TenNV.getText().trim()) || "".equals(txtHeSoLuong.getText().trim()) || "".equals(txtMucLuong.getText().trim()) || "".equals(txtCongViecDamNhan.getText().trim())) {
            return false;
        }

        if ("".equals(txtSdt.getText().trim())
                || "".equals(txtSoCMND.getText().trim())
                || "".equals(txtTonGiao.getText().trim())
                || "".equals(txtQuocTich.getText().trim())
                || "".equals(txtNgaySinh.getText().trim())
                || "".equals(txtNoiSinh.getText().trim())
                || "".equals(txtNguyenQuan.getText().trim())
                || "".equals(txtDanToc.getText().trim())
                || "".equals(txtDiaChi.getText().trim())) {
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtHoso_MaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHoso_TenNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbTenPB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbTenCV = new javax.swing.JComboBox<>();
        btnTheoDoiCongTac = new javax.swing.JButton();
        btnQTTangGiamLuong = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSoHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbLoaiHD = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNgayHopDong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgayBatDau = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtBaoHiemXH = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtBaoHiemYT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPhuCap = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtHeSoCBCV = new javax.swing.JTextField();
        txtThoiGianGiuBac = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHeSoLuong = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtMucLuong = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSoSoBHXH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtSoSoBHYT = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        txtCongViecDamNhan = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtLylich_TenNV = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cbxDangVien = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtNgayVaoDang = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtNoiSinh = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtNguyenQuan = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtQuocTich = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtDanToc = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtTonGiao = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtThanhPhanGiaDinh = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtThanhPhanBanThan = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtSoCMND = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtNgayCapCMND = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtNoiCapCMND = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtVanHoa = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtChuyenMon = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtNgoaiNgu = new javax.swing.JTextField();
        txtHocVan = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        btnDeXuatThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hồ sơ nhân viên");

        jLabel1.setText("Mã nhân viên");

        txtHoso_MaNV.setEditable(false);

        jLabel2.setText("Họ tên");

        jLabel3.setText("Phòng ban");

        cbbTenPB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Chức vụ");

        cbbTenCV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTheoDoiCongTac.setText("Theo dõi quá trình công tác");
        btnTheoDoiCongTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheoDoiCongTacActionPerformed(evt);
            }
        });

        btnQTTangGiamLuong.setText("Quá trình tăng giảm mức lương");
        btnQTTangGiamLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQTTangGiamLuongActionPerformed(evt);
            }
        });

        jLabel5.setText("HĐLĐ số");

        txtSoHD.setEditable(false);

        jLabel6.setText("Loại HĐ");

        cbbLoaiHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Ngày hợp đồng");

        jLabel8.setText("Ngày bắt đầu");

        jLabel9.setText("Công việc đảm nhận");

        jLabel11.setText("Bảo hiểm XH");

        jLabel12.setText("%LCB");

        jLabel13.setText("Bảo hiểm YT");

        jLabel14.setText("%LCB");

        jLabel15.setText("Phụ cấp");

        jLabel16.setText("Hệ số CBCV");

        jLabel17.setText("Thời gian giữ bậc");

        jLabel18.setText("Hệ số lương");

        jLabel19.setText("Mức lương");

        jLabel20.setText("Số sổ BHXH");

        jLabel21.setText("Số sổ BHYT");

        jLabel22.setText("Ghi chú");

        jLabel24.setText("(*)");

        jLabel45.setText("(*)");

        jLabel46.setText("(*)");

        jLabel57.setText("(*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbbTenPB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbTenCV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(44, 44, 44)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(283, 283, 283)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMucLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(txtHeSoLuong))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel45))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnQTTangGiamLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                        .addComponent(btnTheoDoiCongTac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtHoso_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(165, 165, 165)
                                        .addComponent(jLabel46))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNgayHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbLoaiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel17))
                                                .addGap(18, 18, 18)
                                                .addComponent(txtThoiGianGiuBac, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtBaoHiemYT)
                                                            .addComponent(txtBaoHiemXH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel12)
                                                            .addComponent(jLabel14)))
                                                    .addComponent(txtPhuCap)
                                                    .addComponent(txtHeSoCBCV, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel19)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel20)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtSoSoBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtSoSoBHXH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtHoso_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel57)))
                                .addGap(0, 59, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(26, 26, 26)
                                .addComponent(txtCongViecDamNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel22))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtHoso_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtHoso_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbTenPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTheoDoiCongTac)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQTTangGiamLuong))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cbbLoaiHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtMucLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(txtNgayHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txtCongViecDamNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel46)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtSoSoBHXH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel21)
                                            .addComponent(txtSoSoBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtBaoHiemXH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtBaoHiemYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtHeSoCBCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtThoiGianGiuBac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );

        jTabbedPane1.addTab("Hồ sơ nhân viên", jPanel1);

        jLabel23.setText("Họ tên");

        jLabel25.setText("Giới tính");

        cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "KXD" }));

        jLabel26.setText("Đảng viên");

        jLabel27.setText("Ngày vào Đảng");

        jLabel28.setText("Ngày sinh");

        jLabel29.setText("Nơi sinh");

        jLabel30.setText("Nguyên quán");

        jLabel31.setText("Quốc tịch");

        jLabel32.setText("Dân tộc");

        jLabel33.setText("Tôn giáo");

        jLabel34.setText("Thành phần gia đình");

        jLabel35.setText("Thành phần bản thân");

        jLabel36.setText("Số CMND");

        jLabel37.setText("Ngày cấp");

        jLabel38.setText("Nơi cấp");

        jLabel39.setText("Địa chỉ");

        jLabel40.setText("Điện thoại");

        jLabel41.setText("Học vấn");

        jLabel42.setText("Văn hóa");

        jLabel43.setText("Chuyên môn");

        jLabel44.setText("Ngoại ngữ");

        jLabel47.setText("(*)");

        jLabel48.setText("(*)");

        jLabel49.setText("(*)");

        jLabel50.setText("(*)");

        jLabel51.setText("(*)");

        jLabel52.setText("(*)");

        jLabel53.setText("(*)");

        jLabel54.setText("(*)");

        jLabel55.setText("(*)");

        jLabel56.setText("(*)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSdt))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtThanhPhanBanThan))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(txtThanhPhanGiaDinh))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel32))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtNoiSinh, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNguyenQuan, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtQuocTich, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel51)
                                            .addComponent(jLabel52)
                                            .addComponent(jLabel53)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel49)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel33)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTonGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSoCMND)
                                            .addComponent(txtNoiCapCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel37)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNgayCapCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel54)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtDiaChi))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel44))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVanHoa, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                    .addComponent(txtChuyenMon)
                                    .addComponent(txtNgoaiNgu)
                                    .addComponent(txtHocVan)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel56))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxDangVien)))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNgayVaoDang, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel48))))
                            .addComponent(jLabel31)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(txtLylich_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel47)))
                        .addGap(0, 354, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtLylich_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(cbxDangVien))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(txtNgayVaoDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtNguyenQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(txtTonGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(txtHocVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtThanhPhanGiaDinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(txtVanHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtThanhPhanBanThan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(txtChuyenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtSoCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(txtNgoaiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtNoiCapCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(txtNgayCapCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lý lịch nhân viên", jPanel2);

        btnDeXuatThem.setText("Đề xuất thêm");
        btnDeXuatThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeXuatThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeXuatThem)
                .addGap(329, 329, 329))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeXuatThem)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeXuatThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeXuatThemActionPerformed
        // TODO add your handling code here:
        if (requiredTextFilled()) {
            hoSo.setPhongBan(listPhongBan.get(cbbTenPB.getSelectedIndex()));

            try {
                lyLich.setNgaySinh((Date) new SimpleDateFormat("yyyy/MM/dd").parse(txtNgaySinh.getText()));
            }
            catch (Exception ex) {
//                Logger.getLogger(HoSoNhanVienFrm.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            lyLich.setHoTen(txtLylich_TenNV.getText());
            lyLich.setGioiTinh(cbbGioiTinh.getSelectedItem().toString());
            lyLich.setNoiSinh(txtNoiSinh.getText());
            lyLich.setNguyenQuan(txtNguyenQuan.getText());
            lyLich.setQuocTich(txtQuocTich.getText());
            lyLich.setDanToc(txtDanToc.getText());
            lyLich.setTonGiao(txtTonGiao.getText());
            lyLich.setCmnd(txtSoCMND.getText());
            lyLich.setDiaChi(txtDiaChi.getText());
            lyLich.setSdt(txtSdt.getText());

            if (controller.addHoSo(hoSo) != 0) {
                int maxId = controller.getMaxIDHoSo();

                if (maxId != 0) {
                    hoSo.setId(maxId);
                    lyLich.setId(hoSo.getId());
                }

                if (controller.addLyLich(lyLich) != 0) {
                    hopDong.setHoso(hoSo);
                    hopDong.setHeSoLuong(Float.parseFloat(txtHeSoLuong.getText()));
                    hopDong.setLoaiHopDong(listLoaiHopDong.get(cbbLoaiHD.getSelectedIndex()));
                    hopDong.setMucLuong(Float.parseFloat(txtMucLuong.getText()));

                    if (txtPhuCap.getText().trim().equals("")) {
                        hopDong.setPhuCap(0);
                    }
                    else {
                        hopDong.setPhuCap(Float.parseFloat(txtPhuCap.getText()));
                    }

                    hopDong.setCongViec(txtCongViecDamNhan.getText());
                    try {
                        if (txtNgayHopDong.getText().trim().equals("")) {
                            hopDong.setNgayHopDong(null);
                        }
                        else {
                            hopDong.setNgayHopDong((Date) new SimpleDateFormat("yyyy/MM/dd").parse(txtNgayHopDong.getText()));
                        }

                        if (txtNgayBatDau.getText().trim().equals("")) {
                            hopDong.setNgayBatDau(null);
                        }
                        else {
                            hopDong.setNgayBatDau((Date) new SimpleDateFormat("yyyy/MM/dd").parse(txtNgayBatDau.getText()));
                        }
                    }
                    catch (Exception ex) {
//                        Logger.getLogger(HoSoNhanVienFrm.class.getName()).log(Level.SEVERE, null, ex);
                        hopDong.setNgayHopDong(null);
                        hopDong.setNgayBatDau(null);
                        ex.printStackTrace();
                    }

                    if (controller.addHopDong(hopDong) != 0) {
                        if (listQTCT != null) {
                            for (QuaTrinhCongTac qtct : listQTCT) {
                                qtct.setHoso(hoSo);
                                if (controller.addQuaTrinhCongTac(qtct) == 0) {
                                    JOptionPane.showMessageDialog(null, "Không thêm được Quá trình công tác");
                                }
                            }
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Không thêm được Hợp đồng");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Không thêm được Lý lịch");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Không thêm được Hồ sơ");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Không để trống dữ liệu bắt buộc!");
        }
    }//GEN-LAST:event_btnDeXuatThemActionPerformed

    private void btnTheoDoiCongTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheoDoiCongTacActionPerformed
        // TODO add your handling code here:
        QuaTrinhCongTacFrm quaTrinhCongTacFrm = new QuaTrinhCongTacFrm(this);
        quaTrinhCongTacFrm.setVisible(true);

        if (quaTrinhCongTacFrm.isVisible()) {
            btnDeXuatThem.setEnabled(false);
        }
    }//GEN-LAST:event_btnTheoDoiCongTacActionPerformed

    private void btnQTTangGiamLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQTTangGiamLuongActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Chức năng đang được xây dựng");
    }//GEN-LAST:event_btnQTTangGiamLuongActionPerformed

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
            java.util.logging.Logger.getLogger(HoSoNhanVienFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoSoNhanVienFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoSoNhanVienFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoSoNhanVienFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoSoNhanVienFrm().setVisible(true);
            }
        });
    }

    public JButton getBtnDeXuatThem() {
        return btnDeXuatThem;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeXuatThem;
    private javax.swing.JButton btnQTTangGiamLuong;
    private javax.swing.JButton btnTheoDoiCongTac;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JComboBox<String> cbbLoaiHD;
    private javax.swing.JComboBox<String> cbbTenCV;
    private javax.swing.JComboBox<String> cbbTenPB;
    private javax.swing.JCheckBox cbxDangVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBaoHiemXH;
    private javax.swing.JTextField txtBaoHiemYT;
    private javax.swing.JTextField txtChuyenMon;
    private javax.swing.JTextField txtCongViecDamNhan;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHeSoCBCV;
    private javax.swing.JTextField txtHeSoLuong;
    private javax.swing.JTextField txtHocVan;
    private javax.swing.JTextField txtHoso_MaNV;
    private javax.swing.JTextField txtHoso_TenNV;
    private javax.swing.JTextField txtLylich_TenNV;
    private javax.swing.JTextField txtMucLuong;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayCapCMND;
    private javax.swing.JTextField txtNgayHopDong;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgayVaoDang;
    private javax.swing.JTextField txtNgoaiNgu;
    private javax.swing.JTextField txtNguyenQuan;
    private javax.swing.JTextField txtNoiCapCMND;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JTextField txtPhuCap;
    private javax.swing.JTextField txtQuocTich;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSoCMND;
    private javax.swing.JTextField txtSoHD;
    private javax.swing.JTextField txtSoSoBHXH;
    private javax.swing.JTextField txtSoSoBHYT;
    private javax.swing.JTextField txtThanhPhanBanThan;
    private javax.swing.JTextField txtThanhPhanGiaDinh;
    private javax.swing.JTextField txtThoiGianGiuBac;
    private javax.swing.JTextField txtTonGiao;
    private javax.swing.JTextField txtVanHoa;
    // End of variables declaration//GEN-END:variables
}
