package com.example.festivoapi.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "festivos")
public class Festivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "El día es obligatorio")
    @Min(value = 1, message = "El día debe ser entre 1 y 31")
    @Max(value = 31, message = "El día debe ser entre 1 y 31")
    private int dia;
    
    @NotNull(message = "El mes es obligatorio")
    @Min(value = 1, message = "El mes debe ser entre 1 y 12")
    @Max(value = 12, message = "El mes debe ser entre 1 y 12")
    private int mes;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String nombre;
    
    @NotNull(message = "El tipo es obligatorio")
    @Min(value = 1, message = "Tipo inválido")
    @Max(value = 2, message = "Tipo inválido")
    private int tipo;
    
    private Integer diasDesdePascua;

    public Festivo() {}

    public Festivo(int dia, int mes, String nombre, int tipo, Integer diasDesdePascua) {
        this.dia = dia;
        this.mes = mes;
        this.nombre = nombre;
        this.tipo = tipo;
        this.diasDesdePascua = diasDesdePascua;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Integer getDiasDesdePascua() {
        return diasDesdePascua;
    }

    public void setDiasDesdePascua(Integer diasDesdePascua) {
        this.diasDesdePascua = diasDesdePascua;
    }
}