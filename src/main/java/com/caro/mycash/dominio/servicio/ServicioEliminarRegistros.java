package com.caro.mycash.dominio.servicio;

import com.caro.mycash.dominio.modelo.Registro;
import com.caro.mycash.dominio.puerto.RepositorioRegistro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEliminarRegistros {

    private final RepositorioRegistro repositorio;

    public ServicioEliminarRegistros(RepositorioRegistro repositorioRegistro) {
        this.repositorio = repositorioRegistro;
    }

    public void ejecutar(List<Registro> registros) {
        repositorio.eliminar(registros);
    }
}
