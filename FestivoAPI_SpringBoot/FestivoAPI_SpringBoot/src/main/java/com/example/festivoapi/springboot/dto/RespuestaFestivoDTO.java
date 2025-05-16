package com.example.festivoapi.springboot.dto;

public class RespuestaFestivoDTO {
    private String fecha;
    private boolean esFestivo;
    private String mensaje;

    public RespuestaFestivoDTO(String fecha, boolean esFestivo, String nombreFestivo) {
        this.fecha = fecha;
        this.esFestivo = esFestivo;
        this.mensaje = esFestivo ? nombreFestivo : "No es festivo";
    }

    public RespuestaFestivoDTO error(String fecha, boolean esFestivo, String mensajeError) {
        this.fecha = fecha;
        this.esFestivo = esFestivo;
        this.mensaje = mensajeError;
        return null;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEsFestivo() {
        return esFestivo;
    }

    public void setEsFestivo(boolean esFestivo) {
        this.esFestivo = esFestivo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}