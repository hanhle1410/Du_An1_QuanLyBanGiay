package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Getter
@Setter
@Entity
@Table(name = "HoaDonCT", schema = "dbo")
public class HoaDonCT {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon idHoaDon;

    @Size(max = 20)
    @Column(name = "SoLuong", length = 20)
    private String soLuong;

    @Column(name = "DonGia", precision = 20)
    private BigDecimal donGia;

    public HoaDonCT(UUID id, HoaDon idHoaDon, String soLuong, BigDecimal donGia) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDonCT() {
    }
}