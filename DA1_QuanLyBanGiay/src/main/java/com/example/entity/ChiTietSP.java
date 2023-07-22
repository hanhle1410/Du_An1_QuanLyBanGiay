package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


}