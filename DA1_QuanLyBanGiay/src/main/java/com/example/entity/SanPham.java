package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP")
    private DongSP idDongSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDeGiay")
    private DeGiay idDeGiay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNSX")
    private NhaSX idNhaSX;

    @Column(name = "NgayNhapHang")
    private LocalDate ngayNhapHang;

    @Column(name = "GiaNhap", precision = 20)
    private BigDecimal giaNhap;

    @Column(name = "GiaBan", precision = 20)
    private BigDecimal giaBan;

    @Size(max = 50)
    @Nationalized
    @Column(name = "XuatXu", length = 50)
    private String xuatXu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @OneToMany(mappedBy = "idSP", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietSP> chiTietSPList;



}