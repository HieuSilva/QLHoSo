/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HIEU
 */
public class PhongBan {

    private int id;
    private String ten;
    private DonVi donVi;
    private String sdt;

    public PhongBan(int id, String ten, DonVi donVi, String sdt) {
        this.id = id;
        this.ten = ten;
        this.donVi = donVi;
        this.sdt = sdt;
    }

    public PhongBan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public DonVi getDonVi() {
        return donVi;
    }

    public void setDonVi(DonVi donVi) {
        this.donVi = donVi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

}
