package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Producto;
import com.perfulandia.cl.perfulandia.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("buscar")
    public ResponseEntity<List<Producto>> findByName(@RequestParam String nombre){
        List<Producto>productos = productoService.findByName(nombre);
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @GetMapping("categoria/{categoria}")
    public ResponseEntity<List<Producto>> findByCategory(@PathVariable String categoria){
        List<Producto> productos = productoService.findByCategory(categoria);
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        Producto nuevo = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }



}
