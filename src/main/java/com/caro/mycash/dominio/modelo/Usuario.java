package com.caro.mycash.dominio.modelo;

import java.util.List;

public class Usuario {

    public static final String MENSAJE_LONGITUD_MINIMA_CLAVE = "La clave debe tener una longitud mínima de 6";
    public static final String MENSAJE_ROLES_VACIOS = "Debe tener por lo menos un rol";
    public static final String MENSAJE_NOMBRE_USUARIO_OBLIGATORIO = "El usuario no puede ser vacio";
    public static final String MENSAJE_CLAVE_OBLIGATORIA = "La clave no puede ser vacio";
    private final String nombre;
    private String clave;

    private List<RolUsuario> roles;

    public static Usuario of(String nombre, String clave,List<RolUsuario> roles) {

        validarObligatorio(nombre, MENSAJE_NOMBRE_USUARIO_OBLIGATORIO);
        validarObligatorio(clave, MENSAJE_CLAVE_OBLIGATORIA);
        validarLongitudClave(clave);
        validarRolesNoVacios(roles);

        return new Usuario(nombre, clave, roles);
    }

    private Usuario(String nombre, String clave, List<RolUsuario> roles) {
        this.nombre = nombre;
        this.clave = clave;
        this.roles = roles;
    }

    public List<RolUsuario> getRoles() {
        return roles;
    }

    public String getNombre() {
        return nombre;
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

    private static void validarLongitudClave(String valor) {
        if (valor.length() < 6) {
            throw new IllegalArgumentException(MENSAJE_LONGITUD_MINIMA_CLAVE);
        }
    }

    private static void validarRolesNoVacios(List<RolUsuario> roles) {
        if (roles.isEmpty()) {
            throw new IllegalArgumentException(MENSAJE_ROLES_VACIOS);
        }
    }
}
