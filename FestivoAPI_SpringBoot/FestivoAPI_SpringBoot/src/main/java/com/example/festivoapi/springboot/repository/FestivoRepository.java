package com.example.festivoapi.springboot.repository;

import com.example.festivoapi.springboot.model.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

public interface FestivoRepository extends JpaRepository<Festivo, Long> {
    
    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END " +
           "FROM Festivo f WHERE " +
           "(f.tipo IN (1, 2) AND f.mes = MONTH(:fecha) AND f.dia = DAY(:fecha)) OR " +
           "(f.tipo IN (3, 4) AND :fecha = FUNCTION('calcular_fecha_movil', f.diasDesdePascua))")
    boolean existsByFecha(@Param("fecha") LocalDate fecha);
}