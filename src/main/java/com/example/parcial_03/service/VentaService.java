package com.example.parcial_03.service;

import com.example.parcial_03.entities.Venta;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface VentaService extends ICRUD<Venta> {

    void totalPorZona(HttpServletResponse response) throws IOException;

}
