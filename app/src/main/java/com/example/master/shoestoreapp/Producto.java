package com.example.master.shoestoreapp;

public class Producto {
    private String tipo;
    private String marca;
    private String descripcion;
    private String categoria;
    private String color;
    private String precio;
    private String talla;

    public  Producto (){}

    public Producto(String tipo, String marca, String descripcion, String categoria, String color, String precio, String talla) {
        this.tipo = tipo;
        this.marca = marca;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.color = color;
        this.precio = precio;
        this.talla = talla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCodigo() {
        String codigo = marca.toLowerCase() + descripcion.toLowerCase();
        return codigo;
    }
}
