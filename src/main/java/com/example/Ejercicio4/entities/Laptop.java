package com.example.Ejercicio4.entities;

import javax.persistence.*;


@Entity
@Table(name = "laptops")
public class Laptop {


    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Integer pulgadas;
    private Double price;
    private Boolean gamer;


    //constructores

    public Laptop() {

    }

    public Laptop(Long id, String marca, String modelo, Integer pulgadas, Double price, Boolean gamer) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.pulgadas = pulgadas;
        this.price = price;
        this.gamer = gamer;
    }
    //getter and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(Integer pulgadas) {
        this.pulgadas = pulgadas;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getGamer() {
        return gamer;
    }

    public void setGamer(Boolean gamer) {
        this.gamer = gamer;
    }
}
