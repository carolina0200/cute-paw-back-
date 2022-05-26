package com.caro.mycash.infraestructura.controlador;

import com.caro.mycash.aplicacion.dto.DtoLogin;
import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionLogin;
import com.caro.mycash.infraestructura.aspecto.LogExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@Tag(name = "Controlador login")
public class ControladorLogin {

    private final ServicioAplicacionLogin servicioAplicacionLogin;

    public ControladorLogin(ServicioAplicacionLogin servicioAplicacionLogin) {
        this.servicioAplicacionLogin = servicioAplicacionLogin;
    }

    @PostMapping
    @LogExecutionTime
    @Operation(summary = "Login", description = "Usado para hacer login")
    public DtoRespuesta<String> login(@RequestBody DtoLogin dto) {
        return this.servicioAplicacionLogin.ejecutar(dto);
    }
}
