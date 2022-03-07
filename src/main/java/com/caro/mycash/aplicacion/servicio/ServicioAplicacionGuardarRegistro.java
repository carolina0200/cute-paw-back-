package com.caro.mycash.aplicacion.servicio;

import com.caro.mycash.aplicacion.dto.DtoRegistro;
import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.dominio.modelo.Registro;
import com.caro.mycash.dominio.servicio.ServicioGuardarRegistro;
import org.springframework.stereotype.Service;

@Service
public class ServicioAplicacionGuardarRegistro {
    private final ServicioGuardarRegistro servicio;

    public ServicioAplicacionGuardarRegistro(ServicioGuardarRegistro servicioGuardarRegistro) {
        this.servicio = servicioGuardarRegistro;
    }

    public DtoRespuesta<Long> ejecutar(DtoRegistro dto) {
        Registro registro = Registro.of(dto.getTipo(), dto.getConcepto(), dto.getDescripcion(), dto.getCuanto(), dto.getCuando(), dto.getIcono());
        return new DtoRespuesta<>(servicio.ejecutar(registro));
    }
}
