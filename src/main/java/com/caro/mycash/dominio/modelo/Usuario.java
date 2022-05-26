package com.caro.mycash.dominio.modelo;

import java.util.List;

public class Usuario {

    private final String usuario;
    private String clave;

    private List<RolUsuario> roles;

    public static Usuario of(String usuario, String clave,List<RolUsuario> roles) {

        validarObligatorio(usuario, "El usuario no puede ser vacio");
        validarObligatorio(clave, "La clave no puede ser vacio");
        //validarLongitud(clave, 6L, "La clave debe tener una longitud mínima de %s");
        //validarNoVacia(roles, "Debe tener por lo menos un rol");

        return new Usuario(usuario, clave, roles);
    }

    private Usuario(String usuario, String clave, List<RolUsuario> roles) {
        this.usuario = usuario;
        this.clave = clave;
        this.roles = roles;
    }

    public List<RolUsuario> getRoles() {
        return roles;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public void asignarClaveCifrada(String clave) {
        this.clave = clave;
    }

    private static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null || valor.equals("")) {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
