package com.nuestra_empresa.product.controller;
import com.nuestra_empresa.product.entity.Categoria;
import com.nuestra_empresa.product.entity.Producto;
import com.nuestra_empresa.product.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping (value = "/productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listaProductos(@RequestParam(name = "categoria", required = false) Long categoriaId) {
        List<Producto> productos = new ArrayList<>();
        if (null == categoriaId) {
            productos = productoService.listAllProduct();
            if (productos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            Categoria categoria = new Categoria();
            categoria.setId(categoriaId);
            productos = productoService.findByCategory(categoria);
            if (productos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }


        return ResponseEntity.ok(productos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Producto> getProduct(@PathVariable("id") Long id) {
        Producto producto =  productoService.getProduct(id);
        if (null==producto){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> createProduct( @RequestBody Producto producto){
        Producto productoCreado =  productoService.createProduct(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Producto> deleteProduct(@PathVariable("id") Long id){
        Producto productoDelete = productoService.deleteProduct(id);
        if (productoDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoDelete);
    }

    @PutMapping (value = "/{id}/stock")
    public ResponseEntity<Producto> updateStockProduct(@PathVariable  Long id ,@RequestParam(name = "cantidad", required = true) Double cantidad){
        Producto producto = productoService.updateStock(id, cantidad);
        if (producto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }






}
