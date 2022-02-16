package com.caro.mycash.dominio.servicio;

import com.caro.mycash.dominio.modelo.Persona;
import com.caro.mycash.dominio.puerto.RepositorioPersona;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarPersona {
    private static final String MENSAJE_YA_EXISTE = "Ya existe la persona con los datos ingresados";

    private final RepositorioPersona repositorioPersona;

    public ServicioGuardarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public Long ejecutar(Persona persona) {

        if(this.repositorioPersona.existe(persona)) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }

        return this.repositorioPersona.guardar(persona);
    }
}
