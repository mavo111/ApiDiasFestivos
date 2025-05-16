package com.example.festivoapi.springboot.utils;

import java.time.LocalDate;

public class CalculadoraPascua {

    public static LocalDate obtenerDomingoPascua(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int dias = d + e;
        return LocalDate.of(year, 3, 15).plusDays(dias + 7);
    }
}