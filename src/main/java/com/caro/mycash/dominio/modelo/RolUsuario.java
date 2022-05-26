package com.caro.mycash.dominio.modelo;

public class RolUsuario {

    private final String rol;

    public static RolUsuario of(String rol) {

        validarObligatorio(rol, "El rol no puede ser vacio");

        return new RolUsuario(rol);
    }

    private RolUsuario(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    private static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null || valor.equals("")) {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
