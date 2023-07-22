package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Data
@Setter
@Entity
@Table(name = "KichCo", schema = "dbo")
public class KichCo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(max = 20)
    @Column(name = "CoGiay", length = 20)
    private String coGiay;

}