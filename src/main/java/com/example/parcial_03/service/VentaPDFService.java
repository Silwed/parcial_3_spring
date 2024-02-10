package com.example.parcial_03.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface VentaPDFService <T> {
    void totalPorZona(InputStream stream, HttpServletResponse response, List<T> data) throws IOException;
}
