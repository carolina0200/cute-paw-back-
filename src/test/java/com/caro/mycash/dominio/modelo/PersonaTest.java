package com.caro.mycash.dominio.modelo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    @DisplayName("Validar creación exitosa de persona")
    public void validarCreacionExitosa() {
        // Pattern AAA
        // Arrange
        String nombre = "Carolina";
        String apellido = "Giraldo";

        // Act
        Persona persona = Persona.of(nombre, apellido);

        // Assert
        assertEquals(persona.getNombre(), nombre);
        assertEquals(persona.getApellido(), apellido);
    }

    @Test
    @DisplayName("Validar creación con campos faltantes")
    public void validarCamposFaltantes() {
        // Pattern AAA
        // Arrange
        String nombre = "";
        String apellido = "Giraldo";

        try {
            // Act

            Persona.of(nombre, apellido);
            fail();
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals(e.getMessage(), "El nombre no puede ser vacio");
        }

    }
}