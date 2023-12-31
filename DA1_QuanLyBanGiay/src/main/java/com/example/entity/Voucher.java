package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Getter
@Setter
@Entity
@Table(name = "Vouncher", schema = "dbo")
public class Voucher {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Ten", length = 50)
    private String ten;

    @Column(name = "GiamGia")
    private Double giamGia;

    @Column(name = "NgayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "NgayHetHan")
    private LocalDate ngayHetHan;

    @Size(max = 50)
    @Nationalized
    @Column(name = "GhiChu", length = 50)
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

}