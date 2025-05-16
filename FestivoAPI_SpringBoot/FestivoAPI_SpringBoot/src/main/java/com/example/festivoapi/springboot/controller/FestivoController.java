package com.example.festivoapi.springboot.controller;

import com.example.festivoapi.springboot.dto.RespuestaFestivoDTO;
import com.example.festivoapi.springboot.service.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/festivos")
public class FestivoController {

    @Autowired
    private FestivoService service;

    @GetMapping("/verificar/{anio}/{mes}/{dia}")
    public ResponseEntity<RespuestaFestivoDTO> verificar(@PathVariable int anio, @PathVariable int mes, @PathVariable int dia) {
        try {
            LocalDate date = LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE);
            return ResponseEntity.ok(service.verificarFestivo(date));

        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body(
                    new RespuestaFestivoDTO(
                            fecha,
                            false,
                            "Fecha no válida"
                    )
            );
        }
    }
}
