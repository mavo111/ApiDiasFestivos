package com.example.festivoapi.springboot.service;

import com.example.festivoapi.springboot.dto.RespuestaFestivoDTO;
import com.example.festivoapi.springboot.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FestivoService {

    private final FestivoRepository repository;

    @Autowired
    public FestivoService(FestivoRepository repository) {
        this.repository = repository;
    }

    public RespuestaFestivoDTO verificarFestivo(LocalDate fecha) {
        boolean esFestivo = repository.existsByFecha(fecha);
        return new RespuestaFestivoDTO(
                fecha.toString(),
                esFestivo,
                esFestivo ? "Es festivo" : "No es festivo"
        );
    }
}