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
public class QuaTrinhCongTac {

    private int id;
    private HoSo hoso;
    private ChucVu chucVu;
    private String nhiemVu;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public QuaTrinhCongTac() {
    }

    public QuaTrinhCongTac(int id, HoSo hoso, ChucVu chucVu, String nhiemVu, Date ngayBatDau, Date ngayKetThuc) {
        this.id = id;
        this.hoso = hoso;
        this.chucVu = chucVu;
        this.nhiemVu = nhiemVu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HoSo getHoso() {
        return hoso;
    }

    public void setHoso(HoSo hoso) {
        this.hoso = hoso;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getNhiemVu() {
        return nhiemVu;
    }

    public void setNhiemVu(String nhiemVu) {
        this.nhiemVu = nhiemVu;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

}
