package com.perfulandia.cl.perfulandia.service;

import com.perfulandia.cl.perfulandia.model.Producto;
import com.perfulandia.cl.perfulandia.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(int id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con id: " + id));
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void delete(int id){
        productoRepository.deleteById(id);
    }


    public List<Producto> findByName(String name){
        return productoRepository.findByNombreContainingIgnoreCase(name);
    }

    public List<Producto> findByCategory(String categoria){
        return productoRepository.findByCategoriaNombre(categoria);
    }

}
