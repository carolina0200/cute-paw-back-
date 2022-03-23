package com.caro.mycash.aplicacion.servicio;

import com.caro.mycash.dominio.modelo.Reporte;
import com.caro.mycash.dominio.servicio.ServicioGenerarReporte;
import org.springframework.stereotype.Service;

@Service
public class ServicioAplicacionGenerarReporte {

    private final ServicioGenerarReporte servicio;

    public ServicioAplicacionGenerarReporte(ServicioGenerarReporte servicioGuardarRegistro) {
        this.servicio = servicioGuardarRegistro;
    }

    public Reporte ejecutar() {
        return servicio.ejecutar();
    }
}
