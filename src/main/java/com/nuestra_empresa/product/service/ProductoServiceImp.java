package com.nuestra_empresa.product.service;

import com.nuestra_empresa.product.entity.Categoria;
import com.nuestra_empresa.product.entity.Producto;
import com.nuestra_empresa.product.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listAllProduct() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProduct(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto createProduct(Producto product) {
        product.setEstado("CREADO");
        product.setFechaCreacion(new Date());

        return productoRepository.save(product);
    }

    @Override
    public Producto updateProduct(Producto producto) {
        Producto productoDB = getProduct(producto.getId());
        if (null == productoDB){
            return null;
        }
        productoDB.setNombre(producto.getNombre());
        productoDB.setDescripcion(producto.getDescripcion());

        productoDB.setCategoria(producto.getCategoria());
        productoDB.setPrecio(producto.getPrecio());
        return productoRepository.save(productoDB);
    }

    @Override
    public Producto deleteProduct(Long id) {
        Producto productoDB = getProduct(id);
        if (null == productoDB){
            return null;
        }
        productoDB.setEstado("Borrado");
        return productoRepository.save(productoDB);
    }

    @Override
    public List<Producto> findByCategory(Categoria category) {
        return productoRepository.findByCategoria(category);
    }

    @Override
    public Producto updateStock(Long id, Double cantidad) {
        Producto productDB = getProduct(id);
        if (null == productDB){
            return null;
        }
        int stock = (int) (productDB.getStock() + cantidad);
        productDB.setStock(stock);
        return productoRepository.save(productDB);
    }
}
