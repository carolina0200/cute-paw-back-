package com.caro.mycash.infraestructura.adaptador.entidad;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro")
public class EntidadRegistro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String tipo;
    private String concepto;
    private String descripcion;
    private Double cuanto;
    private String icono;
    private LocalDateTime cuando;

    public EntidadRegistro() { }

    public EntidadRegistro(String tipo, String concepto, String descripcion, Double cuanto, String icono, LocalDateTime cuando) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.cuanto = cuanto;
        this.icono = icono;
        this.cuando = cuando;
    }

    public Long getId() {
        return id;
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

    public Double getCuanto() {
        return cuanto;
    }

    public String getIcono() {
        return icono;
    }

    public LocalDateTime getCuando() {
        return cuando;
    }
}
