package com.caro.mycash.dominio.puerto;

import com.caro.mycash.dominio.modelo.Usuario;

public interface RepositorioUsuario {

    Long guardar(Usuario usuario);
    boolean existe(Usuario usuario);
    Usuario consultar(String usuario, String clave);
}
