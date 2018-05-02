/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

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

    public LyLich(int id, String hoTen, String gioiTinh, String danToc, String tonGiao, Date ngaySinh, String nguyenQuan, String quocTich, String noiSinh, String diaChi, String sdt, String cmnd, String noiCap, Date ngayCap, String tdHocVan, String tdChinhTri, String chuyenMon, String ngoaiNgu, boolean dangVien, Date ngayVaoDang, String tpGiaDinh, String tpBanThan) {
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
        this.noiCap = noiCap;
        this.ngayCap = ngayCap;
        this.tdHocVan = tdHocVan;
        this.tdChinhTri = tdChinhTri;
        this.chuyenMon = chuyenMon;
        this.ngoaiNgu = ngoaiNgu;
        this.dangVien = dangVien;
        this.ngayVaoDang = ngayVaoDang;
        this.tpGiaDinh = tpGiaDinh;
        this.tpBanThan = tpBanThan;
    }

    public LyLich() {
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

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getTdHocVan() {
        return tdHocVan;
    }

    public void setTdHocVan(String tdHocVan) {
        this.tdHocVan = tdHocVan;
    }

    public String getTdChinhTri() {
        return tdChinhTri;
    }

    public void setTdChinhTri(String tdChinhTri) {
        this.tdChinhTri = tdChinhTri;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getNgoaiNgu() {
        return ngoaiNgu;
    }

    public void setNgoaiNgu(String ngoaiNgu) {
        this.ngoaiNgu = ngoaiNgu;
    }

    public boolean isDangVien() {
        return dangVien;
    }

    public void setDangVien(boolean dangVien) {
        this.dangVien = dangVien;
    }

    public Date getNgayVaoDang() {
        return ngayVaoDang;
    }

    public void setNgayVaoDang(Date ngayVaoDang) {
        this.ngayVaoDang = ngayVaoDang;
    }

    public String getTpGiaDinh() {
        return tpGiaDinh;
    }

    public void setTpGiaDinh(String tpGiaDinh) {
        this.tpGiaDinh = tpGiaDinh;
    }

    public String getTpBanThan() {
        return tpBanThan;
    }

    public void setTpBanThan(String tpBanThan) {
        this.tpBanThan = tpBanThan;
    }

}
