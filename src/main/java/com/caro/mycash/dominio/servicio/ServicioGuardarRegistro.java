package com.caro.mycash.dominio.servicio;

import com.caro.mycash.dominio.modelo.Registro;
import com.caro.mycash.dominio.puerto.RepositorioRegistro;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarRegistro {

    private final RepositorioRegistro repositorio;

    public ServicioGuardarRegistro(RepositorioRegistro repositorioRegistro) {
        this.repositorio = repositorioRegistro;
    }

    public Long ejecutar(Registro registro) {
        return repositorio.guardar(registro);
    }
}
