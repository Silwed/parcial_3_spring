package com.example.parcial_03.controller;

import com.example.parcial_03.entities.GenericResponse;
import com.example.parcial_03.entities.Producto;
import com.example.parcial_03.service.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService){
        this.productoService = productoService;
    }


    @GetMapping
    public ResponseEntity<List<Producto>> showProducto(){
        List<Producto> productos = this.productoService.listar();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto>consultaById(@PathVariable("id") Integer id){
        Producto obj = this.productoService.leerPorId(id);

        return new ResponseEntity<Producto>(obj , HttpStatus.OK);
    }

    @PostMapping
    public Producto savePatient( @RequestBody Producto patient){
        return this.productoService.registrar(patient);
    }


    @PutMapping
    public ResponseEntity<GenericResponse<Producto>> editPatient(@RequestBody Producto patient){
        System.out.println("producto http "+patient.toString());
        Optional<Producto> opt = Optional.ofNullable(this.productoService.leerPorId(patient.getCodigoProducto()));
        GenericResponse<Producto> response;
        Producto patientResponse;

        if (opt.isPresent()){
            patientResponse = savePatient(patient);
            System.out.println(patient.getNombre() + " ");
            response =  new GenericResponse<Producto>(1, "Producto guardado con exito", patientResponse);
            return new ResponseEntity<GenericResponse<Producto>>(response, HttpStatus.OK);
        } else {
            response = new GenericResponse<Producto>(0, "Producto no fue guardado", patient);
            return new ResponseEntity<GenericResponse<Producto>>(response, HttpStatus.BAD_REQUEST);
        }
    }





    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Producto>> deletePatient(@PathVariable("id") Integer id){
        Optional<Producto> opt = Optional.ofNullable(this.productoService.leerPorId(id));
        GenericResponse<Producto> response =  new GenericResponse<Producto>();
        HttpStatus http = HttpStatus.OK;

        if (opt.isPresent()){
            if(this.productoService.eliminar(opt.get())){
                response.setCode(1);
                response.setMessage("Exito - Se elimino al producto");
                response.setResponse(opt.get());
            } else {
                response.setCode(0);
                response.setMessage("Fallo - No se pudo eliminar al producto");
                response.setResponse(opt.get());
            }
        } else {
            response.setCode(0);
            response.setMessage("Fallo - No hay producto que eliminar");
        }
        return new ResponseEntity<GenericResponse<Producto>>(response, http);
    }



}
