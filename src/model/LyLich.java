/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author HIEU
 */
public class LyLich {
    private int id;
    private String hoTen;
    private String gioiTinh;
    private String danToc;
    private String tonGiao;
    private Date ngaySinh;
    private String nguyenQuan;
    private String quocTich;
    private String noiSinh;
    private String diaChi;
    private String sdt;
    private String cmnd;
    private String noiCap;
    private Date ngayCap;
    private String tdHocVan;
    private String tdChinhTri;
    private String chuyenMon;
    private String ngoaiNgu;
    private boolean dangVien;
    private Date ngayVaoDang;
    private String tpGiaDinh;
    private String tpBanThan;

    public LyLich(int id, String hoTen, String gioiTinh, String danToc, String tonGiao, Date ngaySinh, String nguyenQuan, String quocTich, String noiSinh, String diaChi, String sdt, String cmnd) {
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.danToc = danToc;
        this.tonGiao = tonGiao;
        this.ngaySinh = ngaySinh;
        this.nguyenQuan = nguyenQuan;
        this.quocTich = quocTich;
        this.noiSinh = noiSinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.cmnd = cmnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public LyLich(String hoTen) {
        this.hoTen = hoTen;
    }
    
}
