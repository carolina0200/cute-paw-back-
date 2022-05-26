package com.caro.mycash.aplicacion.servicio;

import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.aplicacion.dto.DtoUsuario;
import com.caro.mycash.dominio.modelo.RolUsuario;
import com.caro.mycash.dominio.modelo.Usuario;
import com.caro.mycash.dominio.servicio.ServicioCifrarTexto;
import com.caro.mycash.dominio.servicio.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionRegistrarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioAplicacionRegistrarUsuario(ServicioGuardarUsuario servicioGuardarUsuario,ServicioCifrarTexto servicioCifrarTexto) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto) {

        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("USER"));

        Usuario usuario = Usuario.of(dto.getUsuario(), dto.getClave(), roles);

        String claveCifrada = this.servicioCifrarTexto.ejecutar(usuario.getClave());
        usuario.asignarClaveCifrada(claveCifrada);

        return new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutar(usuario));
    }
}
