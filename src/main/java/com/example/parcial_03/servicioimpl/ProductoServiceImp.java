package com.example.parcial_03.servicioimpl;


import com.example.parcial_03.entities.Producto;
import com.example.parcial_03.repositories.IProductoRepo;
import com.example.parcial_03.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements IProductoService {

    private final IProductoRepo productoService;

    @Autowired
    public ProductoServiceImp(IProductoRepo productoService){
        this.productoService = productoService;
    }

    @Override
    public List<Producto> listar(){
        List<Producto> listProductos = this.productoService.findAll();
        return listProductos;
    }

    @Override
    public Producto registrar(Producto obj){ return  this.productoService.save(obj); }

    @Override
    public Producto modificar(Producto obj){ return  this.productoService.save(obj); }

    @Override
    public boolean eliminar(Producto obj) {
        try{
            this.productoService.delete(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Producto leerPorId(Integer id) {
        return this.productoService.findById(id).orElse(new Producto());
    }




}
