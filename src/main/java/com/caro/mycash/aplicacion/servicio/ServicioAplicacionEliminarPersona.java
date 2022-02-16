package com.caro.mycash.aplicacion.servicio;

import com.caro.mycash.dominio.puerto.RepositorioPersona;
import org.springframework.stereotype.Service;

@Service
public class ServicioAplicacionEliminarPersona {
    private final RepositorioPersona repositorioPersona;

    public ServicioAplicacionEliminarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Long id) {
        this.repositorioPersona.eliminar(id);
    }
}
