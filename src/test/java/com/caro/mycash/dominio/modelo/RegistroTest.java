package com.caro.mycash.dominio.modelo;

import com.caro.mycash.dominio.testdatabuilder.RegistroTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    @Test
    @DisplayName("Validar creación exitosa de un registro")
    public void validarCreacionExitosa() {
        Registro registro = new RegistroTestDataBuilder().build();

        assertEquals("OB", registro.getConcepto());
        assertEquals("EG", registro.getTipo());
    }

    @Test
    @DisplayName("Validar creación con campos faltantes")
    public void validarCamposFaltantes() {
        try {
            new RegistroTestDataBuilder().conTipo("").build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("El tipo de registro es obligatorio", e.getMessage());
        }
    }

    @Test
    @DisplayName("Validar creación con concepto erroneo")
    public void validarConceptoErroneo() {
        try {
            new RegistroTestDataBuilder().conConcepto("Obligatorio").build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("El concepto debe ser OT (Otro) OB (Obligatorio)", e.getMessage());
        }
    }

    @Test
    @DisplayName("Validar creación con tipo erroneo")
    public void validarTipoErroneo() {
        try {
            new RegistroTestDataBuilder().conTipo("Ingreso").build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("El tipo debe ser IN (Ingreso) EG (Egreso)", e.getMessage());
        }
    }

    @Test
    @DisplayName("Validar creación con descripcion erronea")
    public void validarDescripcionErroneo() {
        try {
            new RegistroTestDataBuilder().conDescripcion(".").build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("La descripcion debe tener como maximo 100 caracteres y como minimo 4", e.getMessage());
        }
    }

    @Test
    @DisplayName("Validar creación con valor erronea")
    public void validarCuantoErroneo() {
        try {
            new RegistroTestDataBuilder().conCuanto(0D).build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("El valor debe ser mayor a cero(0)", e.getMessage());
        }
    }
}