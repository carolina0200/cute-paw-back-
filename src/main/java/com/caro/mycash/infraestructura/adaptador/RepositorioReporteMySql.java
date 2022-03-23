package com.caro.mycash.infraestructura.adaptador;

import com.caro.mycash.dominio.modelo.Reporte;
import com.caro.mycash.dominio.puerto.RepositorioReporte;
import com.caro.mycash.infraestructura.adaptador.entidad.EntidadReporte;
import com.caro.mycash.infraestructura.adaptador.jpa.RepositorioReporteJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReporteMySql implements RepositorioReporte {

    private final RepositorioReporteJpa repositorioReporteJpa;

    public RepositorioReporteMySql(RepositorioReporteJpa repositorioReporteJpa) {
        this.repositorioReporteJpa = repositorioReporteJpa;
    }

    @Override
    public Long guardar(Reporte reporte) {
        return repositorioReporteJpa.save(new EntidadReporte(reporte.getIngresos(), reporte.getEgresos(), reporte.getObligatorios(), reporte.getOtros(), reporte.getDesde(), reporte.getHasta())).getId();
    }
}
