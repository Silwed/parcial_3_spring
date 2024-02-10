package com.example.parcial_03.controller;

import com.example.parcial_03.service.VentaService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
/*
@RestController
@RequestMapping("/reporte")
public class GraficoPDF {

    final private VentaService ventaService;

@Autowired
    public  GraficoPDF(VentaService ventaService){
    this.ventaService = ventaService;
}


    @GetMapping(value = "/pdf")
    public void totalPorZona(ModelAndView model, HttpServletResponse response
    ) throws IOException {
        this.ventaService.totalPorZona(response);
    }

}
*/