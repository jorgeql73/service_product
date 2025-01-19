package com.nuestra_empresa.product.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "tbl_producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
    private String estado;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)//fecha y hora
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)//solo se carga en el momento que se requiera
    @JoinColumn(name = "categoria_id")//Dato con el que se mapea en la tabla categoria
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Categoria categoria;

    public Producto(String nombre, String descripcion, int stock, double precio, String estado, Date fechaCreacion, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.categoria = categoria;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", estado='" + estado + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", categoria=" + categoria +
                '}';
    }
}
