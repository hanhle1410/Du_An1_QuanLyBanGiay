package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "idHoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDonCT> hoaDonCTList = new ArrayList<>();

}