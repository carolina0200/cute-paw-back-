package com.caro.mycash.aplicacion.servicio;

import com.caro.mycash.dominio.modelo.Persona;
import com.caro.mycash.dominio.puerto.RepositorioPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarPersonas {

    private final RepositorioPersona repositorioPersona;

    public ServicioAplicacionListarPersonas(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public List<Persona> ejecutar() {
        return this.repositorioPersona.listar();
    }
}
