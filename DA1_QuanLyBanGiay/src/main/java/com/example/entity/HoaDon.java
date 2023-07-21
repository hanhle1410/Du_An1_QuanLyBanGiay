package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Getter
@Setter
@Entity
@Table(name = "HoaDon", schema = "dbo")
public class HoaDon {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKH")
    private KhachHang idKH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNV")
    private NhanVien idNV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdVoucher")
    private Voucher idVoucher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP")
    private SanPham idSP;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Column(name = "TongTien", precision = 20)
    private BigDecimal tongTien;

    @Column(name = "TrangThai")
    private Integer trangThai;


    public HoaDon(UUID id, KhachHang idKH, NhanVien idNV, Voucher idVoucher, SanPham idSP, String ma, LocalDate ngayTao, LocalDate ngayThanhToan, BigDecimal tongTien, Integer trangThai) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idVoucher = idVoucher;
        this.idSP = idSP;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }


    public HoaDon() {

    }
}