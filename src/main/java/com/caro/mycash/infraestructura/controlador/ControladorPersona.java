package com.caro.mycash.infraestructura.controlador;

import com.caro.mycash.aplicacion.dto.DtoPersona;
import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionEliminarPersona;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionGuardarPersona;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionListarPersonas;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionModificarPersona;
import com.caro.mycash.dominio.modelo.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class ControladorPersona {

    private final ServicioAplicacionListarPersonas servicioListarPersonas;
    private final ServicioAplicacionGuardarPersona servicioGuardarPersona;
    private final ServicioAplicacionModificarPersona servicioModificarPersona;
    private final ServicioAplicacionEliminarPersona servicioEliminarPersona;

    public ControladorPersona(
            ServicioAplicacionListarPersonas servicioListarPersonas,
            ServicioAplicacionGuardarPersona servicioGuardarPersona,
            ServicioAplicacionModificarPersona servicioModificarPersona,
            ServicioAplicacionEliminarPersona servicioEliminarPersona) {
        this.servicioListarPersonas = servicioListarPersonas;
        this.servicioGuardarPersona = servicioGuardarPersona;
        this.servicioModificarPersona = servicioModificarPersona;
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    @GetMapping
    public List<Persona> listar() {
        return servicioListarPersonas.ejecutar();
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoPersona dto) {
        return this.servicioGuardarPersona.ejecutar(dto);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") long id, @RequestBody DtoPersona dto) {
        this.servicioModificarPersona.ejecutar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") long id) {
        this.servicioEliminarPersona.ejecutar(id);
    }
}
