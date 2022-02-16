package com.caro.mycash.aplicacion.servicio;

import com.caro.mycash.aplicacion.dto.DtoPersona;
import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.dominio.modelo.Persona;
import com.caro.mycash.dominio.servicio.ServicioGuardarPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarPersona {

    private final ServicioGuardarPersona servicioGuardarPersona;

    public ServicioAplicacionGuardarPersona(ServicioGuardarPersona servicioGuardarPersona) {
        this.servicioGuardarPersona = servicioGuardarPersona;
    }

    public DtoRespuesta<Long> ejecutar(DtoPersona dto) {

        Persona persona = Persona.of(dto.getNombre(), dto.getApellido());

        return new DtoRespuesta<>(this.servicioGuardarPersona.ejecutar(persona));
    }
}
