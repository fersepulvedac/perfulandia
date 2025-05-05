package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Producto;
import com.perfulandia.cl.perfulandia.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos(){
        List<Producto> productos = productoService.findAll();
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @GetMapping("{id}")
    public Producto getProducto(@PathVariable int id){
        return productoService.findById(id);
    }

}
