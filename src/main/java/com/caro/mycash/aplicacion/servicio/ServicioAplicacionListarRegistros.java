package com.caro.mycash.aplicacion.servicio;

import com.caro.mycash.dominio.modelo.Registro;
import com.caro.mycash.dominio.puerto.RepositorioRegistro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAplicacionListarRegistros {

    private final RepositorioRegistro repositorio;

    public ServicioAplicacionListarRegistros(RepositorioRegistro repositorioRegistro) {
        this.repositorio = repositorioRegistro;
    }

    public List<Registro> ejecutar() {
        return repositorio.listar();
    }
}
