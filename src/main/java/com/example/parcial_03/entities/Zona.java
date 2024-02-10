package com.example.parcial_03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_zona")
public class Zona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer codigoZona;

    private String nombre;
}
