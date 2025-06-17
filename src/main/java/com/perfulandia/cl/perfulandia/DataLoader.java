package com.perfulandia.cl.perfulandia;

import com.perfulandia.cl.perfulandia.model.Categoria;
import com.perfulandia.cl.perfulandia.model.Producto;
import com.perfulandia.cl.perfulandia.repository.CategoriaRepository;
import com.perfulandia.cl.perfulandia.repository.ProductoRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;

@Profile("default")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker();
        Categoria c1 = new Categoria("Bebestibles");
        Categoria c2 = new Categoria("Congelados");
        categoriaRepository.save(c1);
        categoriaRepository.save(c2);

        System.out.println("HI: "+faker.commerce().department());
        Random random = new Random();


        for(int i = 0; i< 10; i++){
            Producto producto = new Producto();
            producto.setNombre(faker.commerce().productName());
            producto.setPrecio(faker.number().numberBetween(100, 1000));
            producto.setCategoria(c1);
            producto.setStock(faker.number().numberBetween(1, 100));
            productoRepository.save(producto);
        }

    }
}
