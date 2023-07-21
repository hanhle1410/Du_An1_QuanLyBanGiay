package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ChiTietSP", schema = "dbo")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP")
    private SanPham idSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSP")
    private MauSP idMauSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKichCo")
    private KichCo idKichCo;

    @Column(name = "SoLuong")
    private Integer soLuong;


    public ChiTietSP(UUID id, SanPham idSP, MauSP idMauSP, KichCo idKichCo, Integer soLuong) {
        this.id = id;
        this.idSP = idSP;
        this.idMauSP = idMauSP;
        this.idKichCo = idKichCo;
        this.soLuong = soLuong;
    }

    public ChiTietSP() {

    }
}