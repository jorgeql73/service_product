package com.nuestra_empresa.product.repository;

import com.nuestra_empresa.product.entity.Categoria;
import com.nuestra_empresa.product.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

    public List<Producto> findByCategoria(Categoria categoria);
}
