package com.caro.mycash.infraestructura.controlador;

import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.aplicacion.dto.DtoUsuario;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionRegistrarUsuario;
import com.caro.mycash.dominio.dto.DtoUsuarioActual;
import com.caro.mycash.dominio.servicio.ServicioObtenerUsuarioActual;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuario {

    private final ServicioAplicacionRegistrarUsuario servicioAplicacionRegistrarUsuario;
    private final ServicioObtenerUsuarioActual servicioObtenerUsuarioActual;

    public ControladorUsuario(ServicioAplicacionRegistrarUsuario servicioAplicacionRegistrarUsuario,ServicioObtenerUsuarioActual servicioObtenerUsuarioActual) {
        this.servicioAplicacionRegistrarUsuario = servicioAplicacionRegistrarUsuario;
        this.servicioObtenerUsuarioActual = servicioObtenerUsuarioActual;
    }

    @GetMapping("/actual")
    public DtoUsuarioActual obtenerActual() {
        return this.servicioObtenerUsuarioActual.ejecutar();
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoUsuario dto) {
        return this.servicioAplicacionRegistrarUsuario.ejecutar(dto);
    }
}
