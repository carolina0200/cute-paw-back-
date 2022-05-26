package com.caro.mycash.dominio.servicio;

import com.caro.mycash.dominio.modelo.Usuario;
import com.caro.mycash.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarUsuario {

    private static final String MENSAJE_YA_EXISTE = "Ya existe un usuario con los datos ingresados";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioGuardarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Usuario usuario) {

        if(this.repositorioUsuario.existe(usuario)) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }

        return this.repositorioUsuario.guardar(usuario);
    }
}
