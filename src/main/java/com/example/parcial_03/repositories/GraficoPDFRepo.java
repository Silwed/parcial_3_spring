package com.example.parcial_03.repositories;

import com.example.parcial_03.dto.GraficoZonasDTO;
import com.example.parcial_03.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraficoPDFRepo extends JpaRepository<Venta, Integer> {


    @Query(value = "SELECT tb_vehiculo.tipo as tipoVehiculo, COUNT(tb_venta.codigo_distribucion) as cantidadDistribucion,\n" +
            "tb_distribucion.fecha_venta as fecha_distribucion, tb_producto.tipo as tipo_producto, SUM(tb_venta.cantidad * tb_producto.precio) as totalVenta,\n" +
            "tb_zona.nombre as zona\n" +
            "FROM tb_venta\n" +
            "INNER JOIN tb_distribucion ON tb_venta.codigo_distribucion = tb_distribucion.codigo_distribucion\n" +
            "INNER JOIN tb_producto ON tb_venta.codigo_producto = tb_producto.codigo_producto\n" +
            "INNER JOIN tb_municipio ON tb_venta.codigo_municipio = tb_municipio.codigo_municipio\n" +
            "INNER JOIN tb_zona ON tb_municipio.codigo_zona = tb_zona.codigo_zona\n" +
            "INNER JOIN tb_vehiculo ON tb_distribucion.codigo_vehiculo = tb_vehiculo.codigo_vehiculo\n" +
            "GROUP BY tb_zona.codigo_zona",nativeQuery=true)
    List<GraficoZonasDTO> totalPorZona();


}
