package com.example.demo.entity;

import lombok.Data;

@Data
public class RemedioEntity {

    private Long id;
    private String nombreCientifico;
    private String marca;
    private Double gramos;
    private int anio;
    private char tipo;
    private boolean controlado;
}