package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter @Data
@Entity
@Table(name = "NhanVien", schema = "dbo")
public class NhanVien {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV")
    private ChucVu idCV;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Ten", length = 50)
    private String ten;

    @Size(max = 30)
    @Column(name = "SDT", length = 30)
    private String sdt;

    @Size(max = 100)
    @Column(name = "Email", length = 100)
    private String email;

    @Size(max = 10)
    @Nationalized
    @Column(name = "GioiTinh", length = 10)
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Size(max = 100)
    @Nationalized
    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    public NhanVien(UUID id, ChucVu idCV, String ma, String ten, String sdt, String email, String gioiTinh, LocalDate ngaySinh, String diaChi) {
        this.id = id;
        this.idCV = idCV;
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public NhanVien() {

    }
}