package com.perfulandia.cl.perfulandia.service;


import com.perfulandia.cl.perfulandia.model.Categoria;
import com.perfulandia.cl.perfulandia.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoria(Integer id){
        return categoriaRepository.findById(id);
    }

    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }


}
