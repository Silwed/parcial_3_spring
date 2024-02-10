package com.example.parcial_03.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="tb_venta")
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer codigoVenta;

    @ManyToOne
    @JoinColumn(name="codigo_producto",nullable=false,
            foreignKey=@ForeignKey(name="FK_venta_producto"))

    private Producto codigoProducto;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name="codigo_distribucion",nullable=false)
    private Distribucion codigoDistribucion;

    @ManyToOne
    @JoinColumn(name="codigo_municipio",nullable=false,
            foreignKey=@ForeignKey(name="FK_venta_municipio"))
    @JsonBackReference
    private Municipio codigoMunicipio;
}
