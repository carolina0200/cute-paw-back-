package com.caro.mycash.aplicacion.servicio;

import com.caro.mycash.aplicacion.dto.DtoPersona;
import com.caro.mycash.dominio.modelo.Persona;
import com.caro.mycash.dominio.servicio.ServicioModificarPersona;
import org.springframework.stereotype.Service;

@Service
public class ServicioAplicacionModificarPersona {
    private final ServicioModificarPersona servicioModificarPersona;

    public ServicioAplicacionModificarPersona(ServicioModificarPersona servicioModificarPersona) {
        this.servicioModificarPersona = servicioModificarPersona;
    }

    public void ejecutar(Long id, DtoPersona dto) {
        Persona persona = Persona.of(dto.getNombre(), dto.getApellido());
        this.servicioModificarPersona.ejecutar(id, persona);
    }
}
