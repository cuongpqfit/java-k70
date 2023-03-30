package it.cuongpq.springmvc.dto;

import java.util.Date;

public class HocVienDto {

    private String ho;


    private String ten;


    private Date ngaysinh;


    private String gioitinh;


    private String noisinh;


    private String malop;


    public HocVienDto(String ho, String ten, Date ngaysinh, String gioitinh, String noisinh, String malop) {
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.noisinh = noisinh;
        this.malop = malop;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    @Override
    public String toString() {
        return "HocVien [ho=" + ho + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", gioitinh="
                + gioitinh + ", noisinh=" + noisinh + ", malop=" + malop + "]";
    }
}
