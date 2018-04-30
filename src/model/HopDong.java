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

    public HopDong(int id, HoSo hoso, LoaiHopDong loaiHopDong, Date ngayHopDong, Date ngayBatDau, float heSoLuong, float mucLuong, float phuCap, float bhyt, float bhxh, String soBhyt, String soBhxh, float heSoCbvc, Date tgGiuBac, String ghiChu, String congViec) {
        this.id = id;
        this.hoso = hoso;
        this.loaiHopDong = loaiHopDong;
        this.ngayHopDong = ngayHopDong;
        this.ngayBatDau = ngayBatDau;
        this.heSoLuong = heSoLuong;
        this.mucLuong = mucLuong;
        this.phuCap = phuCap;
        this.bhyt = bhyt;
        this.bhxh = bhxh;
        this.soBhyt = soBhyt;
        this.soBhxh = soBhxh;
        this.heSoCbvc = heSoCbvc;
        this.tgGiuBac = tgGiuBac;
        this.ghiChu = ghiChu;
        this.congViec = congViec;
    }

    public HopDong() {
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

    public LoaiHopDong getLoaiHopDong() {
        return loaiHopDong;
    }

    public void setLoaiHopDong(LoaiHopDong loaiHopDong) {
        this.loaiHopDong = loaiHopDong;
    }

    public Date getNgayHopDong() {
        return ngayHopDong;
    }

    public void setNgayHopDong(Date ngayHopDong) {
        this.ngayHopDong = ngayHopDong;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
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

    public float getBhyt() {
        return bhyt;
    }

    public void setBhyt(float bhyt) {
        this.bhyt = bhyt;
    }

    public float getBhxh() {
        return bhxh;
    }

    public void setBhxh(float bhxh) {
        this.bhxh = bhxh;
    }

    public String getSoBhyt() {
        return soBhyt;
    }

    public void setSoBhyt(String soBhyt) {
        this.soBhyt = soBhyt;
    }

    public String getSoBhxh() {
        return soBhxh;
    }

    public void setSoBhxh(String soBhxh) {
        this.soBhxh = soBhxh;
    }

    public float getHeSoCbvc() {
        return heSoCbvc;
    }

    public void setHeSoCbvc(float heSoCbvc) {
        this.heSoCbvc = heSoCbvc;
    }

    public Date getTgGiuBac() {
        return tgGiuBac;
    }

    public void setTgGiuBac(Date tgGiuBac) {
        this.tgGiuBac = tgGiuBac;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

}
