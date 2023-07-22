package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDonCT")
public class HoaDonCT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon idHoaDon;

    @Size(max = 20)
    @Column(name = "SoLuong", length = 20)
    private String soLuong;

    @Column(name = "DonGia", precision = 20)
    private BigDecimal donGia;


}