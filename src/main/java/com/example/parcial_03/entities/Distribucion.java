package com.example.parcial_03.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_distribucion")
public class Distribucion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer codigoDistribucion;

    @ManyToOne
    @JoinColumn(name="codigo_vehiculo",nullable=false,
            foreignKey=@ForeignKey(name="FK_distribucion_vehiculo"))
    @JsonBackReference
    private Vehiculo codigoVehiculo;



    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fecha_venta;

}
