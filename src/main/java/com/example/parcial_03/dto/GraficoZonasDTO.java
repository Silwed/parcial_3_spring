package com.example.parcial_03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


public interface GraficoZonasDTO {

    Integer getTipoVehiculo();
    Integer getCantidadDistribucion();

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime getFecha_distribucion();

    Integer getTipo_producto();
    Double getTotalVenta();
    String getZona();



}
