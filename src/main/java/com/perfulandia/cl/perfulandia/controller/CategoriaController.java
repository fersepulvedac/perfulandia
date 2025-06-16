package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Categoria;
import com.perfulandia.cl.perfulandia.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getALlCategorias(){
        List<Categoria> categorias = categoriaService.getAllCategorias();
        if(categorias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable Integer id){
        Categoria categoria = categoriaService.getCategoria(id).get();
        return ResponseEntity.ok(categoria);
    }

    @PostMapping()
    public ResponseEntity<Categoria> newCategoria(@RequestBody Categoria categoria){
        Categoria nueva = categoriaService.saveCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }




}
