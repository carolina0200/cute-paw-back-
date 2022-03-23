package com.caro.mycash.infraestructura.adaptador.entidad;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "reporte")
public class EntidadReporte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double ingresos;
    private Double egresos;
    private Double obligatorios;
    private Double otros;
    private LocalDate desde;
    private LocalDate hasta;

    public EntidadReporte() { }

    public EntidadReporte(Double ingresos, Double egresos, Double obligatorios, Double otros, LocalDate desde, LocalDate hasta) {
        this.ingresos = ingresos;
        this.egresos = egresos;
        this.obligatorios = obligatorios;
        this.otros = otros;
        this.desde = desde;
        this.hasta = hasta;
    }
}
