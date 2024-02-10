package com.example.parcial_03.repositories;

import com.example.parcial_03.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IProductoRepo extends JpaRepository<Producto,Integer> {

}
