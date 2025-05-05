package com.perfulandia.cl.perfulandia.repository;

import com.perfulandia.cl.perfulandia.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
