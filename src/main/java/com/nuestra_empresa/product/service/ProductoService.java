package com.nuestra_empresa.product.service;

import com.nuestra_empresa.product.entity.Categoria;
import com.nuestra_empresa.product.entity.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> listAllProduct();
    public Producto getProduct(Long id);

    public Producto createProduct(Producto product);
    public Producto updateProduct(Producto product);
    public  Producto deleteProduct(Long id);
    public List<Producto> findByCategory(Categoria category);
    public Producto updateStock(Long id, Double quantity);
}
