/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.JOptionPane;
import model.DonVi;
import model.HoSo;
import model.HopDong;
import model.LyLich;
import model.PhongBan;

/**
 *
 * @author HIEU
 */
public class DAO {
    private Connection conn;
    private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    private String dbURL = "jdbc:sqlserver://localhost\\EVALUATION_2014:1433; databasename=HTTTQL; username=sa; password=12345678";
    
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
    public LyLich[] searchLyLich(String key){
        LyLich[] listll = null;
        
        try {
            CallableStatement call = conn.prepareCall("{call searchLLByName(?)}",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            call.setString(1, "%"+key+"%");
            ResultSet rs = call.executeQuery();
            if(rs.last()){
                listll = new LyLich[rs.getRow()];
                rs.beforeFirst();
            }
            int i=0;
            while(rs.next()){
                listll[i++] = new LyLich(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listll;
    }
    
    public LyLich getLyLichByID(int idhs){
        
        String sql = "SELCET * FROM ly_lich WHERE id_ho_so = ?";
        try {
            PreparedStatement ps = conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, idhs);
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                rs.beforeFirst();
                while(rs.next()) {
                    
                    LyLich ll = new LyLich(rs.getString(2));
                    return ll;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public HoSo getHoSoByID(int idhs){
        
        String sql=  "SELECT * FROM ho_so WHERE id_ho_so = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, idhs);
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                rs.beforeFirst();
                while(rs.next()) {
                    int idpb = rs.getInt(2);
                    PhongBan pb = getPhongBanByID(idpb);
                    HoSo hs = new HoSo(rs.getInt(1), pb);
                    return hs;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public PhongBan getPhongBanByID(int idpb){
        
        String sql=  "SELECT * FROM phong_ban WHERE id_phong_ban = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, idpb);
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                rs.beforeFirst();
                while(rs.next()) {
                    int iddv = rs.getInt(3);
                    DonVi dv = getDonViByID(iddv);
                    PhongBan pb = new PhongBan(rs.getInt(1), rs.getString(2), dv);
                    return pb;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public DonVi getDonViByID(int iddv){
        
        String sql=  "SELECT * FROM don_vi WHERE id_don_vi = ?";
        
        try {
            PreparedStatement ps = conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, iddv);
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                rs.beforeFirst();
                while(rs.next()) {
                    DonVi dv = new DonVi(rs.getInt(1), rs.getString(2));
                    return dv;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HopDong[] searchHopDong(float luong){
        HopDong[] listhd = null;
        
        try {
            CallableStatement call = conn.prepareCall("{call searchHDByLuong(?)}",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            call.setFloat(1, luong);
            ResultSet rs = call.executeQuery();
            if(rs.last()){
                listhd = new HopDong[rs.getRow()];
                rs.beforeFirst();
            }
            int i=0;
            while(rs.next()){
                int idhs = rs.getInt(2);
                float hsl = rs.getFloat("he_so_luong");
                float mucluong =rs.getFloat("muc_luong");
                float phucap = rs.getFloat("phu_cap");
                HoSo hs = getHoSoByID(idhs);
                listhd[i++] = new HopDong(hs, hsl, mucluong, phucap);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listhd;
    }
}
