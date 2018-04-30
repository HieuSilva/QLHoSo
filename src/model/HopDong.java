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
public class HopDong {
    private int id;
    private HoSo hoso;
    private LoaiHopDong loaiHopDong;
    private Date ngayHopDong;
    private Date ngayBatDau;
    private float heSoLuong;
    private float mucLuong;
    private float phuCap;
    private float bhyt;
    private float bhxh;
    private String soBhyt;
    private String soBhxh;
    private float heSoCbvc;
    private Date tgGiuBac;
    private String ghiChu;
    private String congViec;

    public HopDong(HoSo hoso, float heSoLuong, float mucLuong, float phuCap) {
        this.hoso = hoso;
        this.heSoLuong = heSoLuong;
        this.mucLuong = mucLuong;
        this.phuCap = phuCap;
    }

    public HoSo getHoso() {
        return hoso;
    }

    public void setHoso(HoSo hoso) {
        this.hoso = hoso;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public float getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(float mucLuong) {
        this.mucLuong = mucLuong;
    }

    public float getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(float phuCap) {
        this.phuCap = phuCap;
    }
    
}
