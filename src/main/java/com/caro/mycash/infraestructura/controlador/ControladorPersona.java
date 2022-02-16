package com.caro.mycash.infraestructura.controlador;

import com.caro.mycash.aplicacion.dto.DtoPersona;
import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionGuardarPersona;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionListarPersonas;
import com.caro.mycash.dominio.modelo.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class ControladorPersona {

    private final ServicioAplicacionListarPersonas servicioListarPersonas;
    private final ServicioAplicacionGuardarPersona servicioGuardarPersona;

    public ControladorPersona(ServicioAplicacionListarPersonas servicioListarPersonas, ServicioAplicacionGuardarPersona servicioGuardarPersona) {
        this.servicioListarPersonas = servicioListarPersonas;
        this.servicioGuardarPersona = servicioGuardarPersona;
    }

    @GetMapping
    public List<Persona> listar() {
        return servicioListarPersonas.ejecutar();
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoPersona dto) {
        return this.servicioGuardarPersona.ejecutar(dto);
    }
}
