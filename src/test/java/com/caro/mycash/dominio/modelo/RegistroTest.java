package com.caro.mycash.dominio.modelo;

import com.caro.mycash.dominio.testdatabuilder.RegistroTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    @Test
    @DisplayName("Validar creación exitosa de un registro")
    void validarCreacionExitosa() {
        Registro registro = new RegistroTestDataBuilder().build();

        assertEquals("OB", registro.getConcepto());
        assertEquals("EG", registro.getTipo());
    }

    @Test
    @DisplayName("Validar creación con campos faltantes")
    void validarCamposFaltantes() {
        RegistroTestDataBuilder registro = new RegistroTestDataBuilder().conTipo("");
        Assertions.assertEquals("El tipo de registro es obligatorio",
                Assertions.assertThrows(IllegalArgumentException.class, () -> registro.build())
                        .getMessage());
    }

    @Test
    @DisplayName("Validar creación con concepto erroneo")
    void validarConceptoErroneo() {
        RegistroTestDataBuilder registro = new RegistroTestDataBuilder().conConcepto("Obligatorio");
        Assertions.assertEquals("El concepto debe ser OT (Otro) OB (Obligatorio)",
                Assertions.assertThrows(IllegalArgumentException.class, () -> registro.build())
                        .getMessage());
    }

    @Test
    @DisplayName("Validar creación con tipo erroneo")
    void validarTipoErroneo() {
        RegistroTestDataBuilder registro = new RegistroTestDataBuilder().conTipo("Ingreso");
        Assertions.assertEquals("El tipo debe ser IN (Ingreso) EG (Egreso)",
                Assertions.assertThrows(IllegalArgumentException.class, () -> registro.build())
                        .getMessage());
    }

    @Test
    @DisplayName("Validar creación con descripcion erronea")
    void validarDescripcionErroneo() {
        RegistroTestDataBuilder registro = new RegistroTestDataBuilder().conDescripcion(".");
        Assertions.assertEquals("La descripcion debe tener como maximo 100 caracteres y como minimo 4",
                Assertions.assertThrows(IllegalArgumentException.class, () -> registro.build())
                        .getMessage());
    }

    @Test
    @DisplayName("Validar creación con valor erronea")
    void validarCuantoErroneo() {
        RegistroTestDataBuilder registro = new RegistroTestDataBuilder().conCuanto(0D);
        Assertions.assertEquals("El valor debe ser mayor a cero(0)",
                Assertions.assertThrows(IllegalArgumentException.class, () -> registro.build())
                        .getMessage());
    }
}