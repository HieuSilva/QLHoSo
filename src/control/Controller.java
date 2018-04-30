/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
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
public class Controller {

    private DAO dao;

    public Controller() {
        dao = new DAO();
    }

    public boolean checkLogin(String username, String password) {
        return dao.checkLogin(username, password);
    }
    
    public int addHoSo(HoSo hoSo) {
        return dao.addHoSo(hoSo);
    }
    
    public int getMaxIDHoSo() {
        return dao.getMaxIDHoSo();
    }
    
    public int addLyLich(LyLich lyLich) {
        return dao.addLyLich(lyLich);
    }
    
    public int addHopDong(HopDong hopDong) {
        return dao.addHopDong(hopDong);
    }
    
    public int addQuaTrinhCongTac(QuaTrinhCongTac qtct) {
        return dao.addQuaTrinhCongTac(qtct);
    }
    
    public DonVi getDonVi() {
        return dao.getDonVi();
    }

    public ArrayList<ChucVu> getListChucVu() {
        return dao.getListChucVu();
    }

    public ArrayList<PhongBan> getListPhongBan(DonVi donVi) {
        return dao.getListPhongBan(donVi);
    }
//
    public ArrayList<LoaiHopDong> getListLoaiHopDong() {
        return dao.getListLoaiHopDong();
    }
    
    public ArrayList<QuaTrinhCongTac> getListQTCongTac(HoSo hoSo, ArrayList<ChucVu> listChucVu) {
        return dao.getListQTCongTac(hoSo, listChucVu);
    }
}
