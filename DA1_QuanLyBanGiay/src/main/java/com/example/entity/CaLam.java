package com.example.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "CaLam", schema = "dbo")
public class CaLam {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenCa", length = 50)
    private String tenCa;
}
