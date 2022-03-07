package com.caro.mycash.aplicacion.dto;

import java.time.LocalDateTime;

public class DtoRegistro {
    private String tipo;
    private String concepto;
    private String descripcion;
    private Double cuanto;
    private String icono;
    private LocalDateTime cuando;

    public DtoRegistro() {}

    public DtoRegistro(String tipo, String concepto, String descripcion, Double cuanto, LocalDateTime cuando, String icono) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.cuanto = cuanto;
        this.cuando = cuando;
        this.icono = icono;
    }

    public String getTipo() {
        return tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getCuanto() { return cuanto; }

    public LocalDateTime getCuando() { return cuando; }

    public String getIcono() {
        return icono;
    }
}
