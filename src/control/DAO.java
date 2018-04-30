/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
 * @author HIEU
 */
public class DAO {

    private Connection conn;
    private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private String dbURL = "jdbc:sqlserver://localhost\\EVALUATION_2:1433; databasename=HTTTQL; username=sa; password=12345678";
    private String dbURL = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433; databasename=HTTTQL; username=sa; password=12345678";

    public DAO() {
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String username, String password) {
        int check = 0;
        try {
            CallableStatement call = conn.prepareCall("{call login(?,?,?)}");
            call.setString(1, username);
            call.setString(2, password);
            call.registerOutParameter(3, Types.INTEGER);
            call.executeUpdate();
            check = call.getInt(3);
            return (check == 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!");
            e.printStackTrace();
            return false;
        }
    }

    public int addHoSo(HoSo hoSo) {
        try {
            CallableStatement call = conn.prepareCall("{call addHoSo(?,?)}");
            call.setInt(1, hoSo.getPhongBan().getId());
            call.setInt(2, hoSo.getPhongBan().getDonVi().getId());

            return call.executeUpdate();
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        }
    }

    public int getMaxIDHoSo() {
        try {
            CallableStatement call = conn.prepareCall("{call getMaxIDHoSo()}");

            int id = 0;

            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

            return id;
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        }
    }
    
    public int addLyLich(LyLich lyLich) {
        try {
            CallableStatement call = conn.prepareCall("{call addLyLich(?,?,?,?,?,?,?,?,?,?)}");
            call.setString(1, lyLich.getHoTen());
            call.setString(2, lyLich.getGioiTinh());
            call.setString(3, lyLich.getDanToc());
            call.setString(4, lyLich.getTonGiao());
            call.setDate(5, new java.sql.Date(lyLich.getNgaySinh().getTime()));
            call.setString(6, lyLich.getNguyenQuan());
            call.setString(7, lyLich.getQuocTich());
            call.setString(8, lyLich.getNoiSinh());
            call.setString(9, lyLich.getDiaChi());
            call.setString(10, lyLich.getSdt());

            return call.executeUpdate();
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        }
    }
    
    public int addHopDong(HopDong hopDong) {
        try {
            CallableStatement call = conn.prepareCall("{call addHopDong(?,?,?,?,?,?,?,?)}");
            call.setInt(1, hopDong.getHoso().getId());
            call.setDate(2, new java.sql.Date(hopDong.getNgayHopDong().getTime()));
            call.setDate(3, new java.sql.Date(hopDong.getNgayBatDau().getTime()));
            call.setFloat(4, hopDong.getHeSoLuong());
            call.setInt(5, hopDong.getLoaiHopDong().getId());
            call.setFloat(6, hopDong.getMucLuong());
            call.setFloat(7, hopDong.getPhuCap());
            call.setString(8, hopDong.getCongViec());

            return call.executeUpdate();
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        }
    }
    
    public int addQuaTrinhCongTac(QuaTrinhCongTac qtct) {
        try {
            CallableStatement call = conn.prepareCall("{call addQuaTrinhCongTac(?,?,?,?,?)}");
            call.setInt(1, qtct.getHoso().getId());
            call.setInt(2, qtct.getChucVu().getId());
            call.setString(3, qtct.getNhiemVu());
            call.setDate(4, new java.sql.Date(qtct.getNgayBatDau().getTime()));
            call.setDate(5, new java.sql.Date(qtct.getNgayKetThuc().getTime()));

            return call.executeUpdate();
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        }
    }

    public ArrayList<ChucVu> getListChucVu() {
        ArrayList<ChucVu> list = new ArrayList<>();

        try {
            CallableStatement call = conn.prepareCall("{call dbo.getListChucVu()}");

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setId(rs.getInt("id_chuc_vu"));
                cv.setTen("ten");
                cv.setGhiChu("ghi_chu");

                list.add(cv);
            }

            if (list.size() != 0) {
                return list;
            } else {
                return null;
            }
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Chức vụ");
            ex.printStackTrace();
            return null;
        }
    }

    public DonVi getDonVi() {
        DonVi dv = null;

        try {
            CallableStatement call = conn.prepareCall("{call dbo.getDonVi()}");

            ResultSet rs = call.executeQuery();

            if (rs.last()) {
                dv = new DonVi();
                dv.setId(rs.getInt("id_chuc_vu"));
                dv.setTen("ten");
            }

            return dv;
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không lấy được Đơn vị");
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<PhongBan> getListPhongBan(DonVi donVi) {
        ArrayList<PhongBan> list = new ArrayList<>();

        try {
            CallableStatement call = conn.prepareCall("{call dbo.getListPhongBan(?)}");
            call.setInt(1, donVi.getId());

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                PhongBan pb = new PhongBan();
                pb.setId(rs.getInt("id_chuc_vu"));
                pb.setTen("ten");

                list.add(pb);
            }

            if (list.isEmpty()) {
                return list;
            } else {
                return null;
            }
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Phòng ban");
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<LoaiHopDong> getListLoaiHopDong() {
        ArrayList<LoaiHopDong> list = new ArrayList<>();

        try {
            CallableStatement call = conn.prepareCall("{call dbo.getListLoaiHopDong()}");

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                LoaiHopDong lhd = new LoaiHopDong();
                lhd.setId(rs.getInt("id_loai"));
                lhd.setTen("ten");

                list.add(lhd);
            }

            if (list.isEmpty()) {
                return list;
            } else {
                return null;
            }
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Loại hợp đồng");
            return null;
        }
    }

    public ArrayList<QuaTrinhCongTac> getListQTCongTac(HoSo hoSo, ArrayList<ChucVu> listChucVu) {
        ArrayList<QuaTrinhCongTac> list = new ArrayList<>();

        try {
            CallableStatement call = conn.prepareCall("{call dbo.getListQTCongTac(?)}");
            call.setInt(1, hoSo.getId());

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                QuaTrinhCongTac qtct = new QuaTrinhCongTac();
                qtct.setId(rs.getInt("id_qtct"));
                qtct.setHoso(hoSo);
                qtct.setNhiemVu(rs.getString("nhiem_vu"));
                qtct.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                qtct.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));

                for (ChucVu cv : listChucVu) {
                    if (cv.getId() == rs.getInt("id_chuc_vu")) {
                        qtct.setChucVu(cv);
                        break;
                    }
                }

                list.add(qtct);
            }

            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không có quá trình công tác");
                return list;
            } else {
                return null;
            }
        } catch (Exception ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Quá trình công tác");
            ex.printStackTrace();
            return null;
        }
    }

//    public LoaiHopDong getLoaiHopDong(int id_loai) {
//        LoaiHopDong loaiHopDong = null;
//        
//        try {
//            CallableStatement call = conn.prepareCall("{call dbo.getLoaiHopDong(?)}");
//            call.setInt(1, id_loai);
//            
//            ResultSet rs = call.executeQuery();
//            
//            if (rs.last()) {
//                loaiHopDong = new LoaiHopDong(rs.getInt("id_loai"), rs.getString("ten"));
//            }
//            
//            return loaiHopDong;
//        } catch (Exception ex) {
////            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Unable to get LoaiHopDong");
//            return null;
//        }
//    }
//    public HopDong getHopDong(HoSo hoSo) {
//        HopDong hopDong = null;
//        
//        try {
//            CallableStatement call = conn.prepareCall("{call dbo.getHopDong(?)}");
//            call.setInt(1, hoSo.getId());
//            
//            ResultSet rs = call.executeQuery();
//            
//            if (rs.last()) {
//                hopDong = new HopDong();
//                hopDong.setId(rs.getInt("id_hop_dong"));
//                hopDong.setHoso(hoSo);
//                hopDong.setNgayBatDau(rs.getDate("ngay_bat_dau"));
//                hopDong.setNgayHopDong(rs.getDate("ngay_hop_dong"));
//                hopDong.setHeSoLuong(rs.getFloat("he_so_luong"));
//                hopDong.setLoaiHopDong(getLoaiHopDong(rs.getInt("id_loai_hop_dong")));
//                hopDong.setMucLuong(rs.getFloat("muc_luong"));
//                hopDong.setPhuCap(rs.getFloat("phu_cap"));
//                hopDong.setBhyt(rs.getFloat("bhyt"));
//                hopDong.setBhxh(rs.getFloat("bhxh"));
//                hopDong.setSoBhyt(rs.getString("so_bhyt"));
//                hopDong.setSoBhxh(rs.getString("so_bhxh"));
//                hopDong.setHeSoCbvc(rs.getFloat("he_so_cbcv"));
//                hopDong.setTgGiuBac(rs.getDate("thoi_gian_giu_bac"));
//                hopDong.setGhiChu(rs.getString("ghi_chu"));
//                hopDong.setCongViec(rs.getString("cong_viec"));
//            }
//            
//            return hopDong;
//        } catch (Exception ex) {
////            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Unable to get HopDong");
//            return null;
//        }
//    }
}
