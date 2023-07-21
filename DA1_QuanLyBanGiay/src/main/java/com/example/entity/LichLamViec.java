package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "LichLamViec", schema = "dbo")
public class LichLamViec {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNV")
    private SanPham idNV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCaLam")
    private MauSP idCaLam;

    public LichLamViec() {
    }

    public LichLamViec(UUID id, SanPham idNV, MauSP idCaLam) {
        this.id = id;
        this.idNV = idNV;
        this.idCaLam = idCaLam;
    }
}
