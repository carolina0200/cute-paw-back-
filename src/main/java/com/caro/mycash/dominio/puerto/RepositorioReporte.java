package com.caro.mycash.dominio.puerto;

import com.caro.mycash.dominio.modelo.Reporte;

public interface RepositorioReporte {
    Long guardar(Reporte reporte);
}
