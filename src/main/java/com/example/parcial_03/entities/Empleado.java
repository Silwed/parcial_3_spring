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
@Table(name="tb_empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer codigoEmpleado;
    private String nombre;
    private int tipo ;
    private Double salario;
    @ManyToOne
    @JoinColumn(name="codigo_vehiculo",nullable=false,
            foreignKey=@ForeignKey(name="FK_empleado_vehiculo"))
    @JsonBackReference
    private Vehiculo codigoVehiculo;
}
