package com.caro.mycash.dominio.testdatabuilder;

import com.caro.mycash.aplicacion.dto.DtoRegistro;
import com.caro.mycash.dominio.modelo.Registro;

import java.time.LocalDateTime;

public class RegistroTestDataBuilder {
    private String tipo;
    private String concepto;
    private String descripcion;
    private Double cuanto;
    private String icono;
    private LocalDateTime cuando;

    public RegistroTestDataBuilder() {
        this.tipo = "EG";
        this.concepto = "OB";
        this.descripcion = "Pagos";
        this.cuanto = 10000D;
        this.icono = "payments";
        this.cuando = LocalDateTime.of(2022, 3, 2, 5, 0,0);
    }

    public RegistroTestDataBuilder conTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public RegistroTestDataBuilder conConcepto(String concepto) {
        this.concepto = concepto;
        return this;
    }

    public RegistroTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public RegistroTestDataBuilder conCuanto(Double cuanto) {
        this.cuanto = cuanto;
        return this;
    }

    public Registro build() {
        return Registro.of(tipo, concepto, descripcion, cuanto, cuando, icono);
    }
}
