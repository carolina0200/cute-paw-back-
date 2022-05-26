package com.caro.mycash.infraestructura.testdatabuilder;

import com.caro.mycash.aplicacion.dto.DtoLogin;

public class DtoLoginTestDataBuilder {
    private String usuario;
    private String clave;

    public DtoLoginTestDataBuilder() {
        this.usuario = "carolina";
        this.clave = "12345678";
    }

    public DtoLoginTestDataBuilder conUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public DtoLogin build() {
        return new DtoLogin(usuario, clave);
    }
}
