package model;

import java.time.Instant;

public class Student {
    private long maSinhVien;
    private String hoTen;
    private int age;
    private String gioiTinh;
    private String diaChi;
    private double diemTB;

    public Student() {
    }

    public Student(long maSinhVien, String hoTen, int age, String gioiTinh, String diaChi, double diemTB) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.age = age;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diemTB = diemTB;
    }

    public static Student parse(String record) {
        String[] fields = record.split(",");
        long maSinhVien = Long.parseLong(fields[0]);
        String hoTen = fields[1];
        int age = Integer.parseInt(fields[2]);
        String gioiTinh = fields[3];
        String diaChi = fields[4];
        double diemTB = Double.parseDouble(fields[5]);
        return new Student(maSinhVien, hoTen,age, gioiTinh, diaChi, diemTB);
    }
    public long getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(long maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return maSinhVien + "," + hoTen + "," + age + "," + gioiTinh + "," + diaChi + "," + diemTB;
    }
}
