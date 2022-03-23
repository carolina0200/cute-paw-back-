package com.caro.mycash.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Reporte {
    private Double ingresos;
    private Double egresos;
    private Double obligatorios;
    private Double otros;
    private LocalDate desde;
    private LocalDate hasta;
}
