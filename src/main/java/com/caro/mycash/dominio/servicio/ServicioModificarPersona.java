package com.caro.mycash.dominio.servicio;

import com.caro.mycash.dominio.modelo.Persona;
import com.caro.mycash.dominio.puerto.RepositorioPersona;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarPersona {

    private static final String MENSAJE_NO_EXISTE = "No existe la persona con los datos ingresados";

    private final RepositorioPersona repositorioPersona;

    public ServicioModificarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Long id, Persona persona) {
        if (this.repositorioPersona.existe(id)) {
            this.repositorioPersona.modificar(id, persona);
        } else {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
    }
}
