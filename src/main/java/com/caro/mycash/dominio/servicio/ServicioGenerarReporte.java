package com.caro.mycash.dominio.servicio;

import com.caro.mycash.dominio.modelo.Registro;
import com.caro.mycash.dominio.modelo.Reporte;
import com.caro.mycash.dominio.puerto.RepositorioReporte;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ServicioGenerarReporte {

    public static final String NO_HAY_REGISTROS = "No hay registros para realizar el reporte";

    private final ServicioObtenerRegistros servicioObtenerRegistros;
    private final ServicioEliminarRegistros servicioEliminarRegistros;
    private final RepositorioReporte repositorioReporte;

    public ServicioGenerarReporte(ServicioObtenerRegistros servicioObtenerRegistros, ServicioEliminarRegistros servicioEliminarRegistros, RepositorioReporte repositorioReporte) {
        this.servicioObtenerRegistros = servicioObtenerRegistros;
        this.servicioEliminarRegistros = servicioEliminarRegistros;
        this.repositorioReporte = repositorioReporte;
    }

    @Transactional
    public Reporte ejecutar() {
        List<Registro> ingresos = servicioObtenerRegistros.obtenerPorTipo("IN");
        List<Registro> egresos = servicioObtenerRegistros.obtenerPorTipo("EG");
        List<Registro> todas = Stream.of(ingresos, egresos).flatMap(Collection::stream).toList();
        if(todas.isEmpty()) {
            throw new IllegalStateException(NO_HAY_REGISTROS);
        }
        Reporte reporte = construirReport(ingresos.stream().mapToDouble(Registro::getCuanto).sum(), egresos.stream().mapToDouble(Registro::getCuanto).sum());
        reporte.setDesde(todas.get(0).getCuando().toLocalDate());
        servicioEliminarRegistros.ejecutar(todas);
        repositorioReporte.guardar(reporte);
        return reporte;
    }

    private Reporte construirReport(Double ingresos, Double egresos) {
        Reporte reporte = new Reporte();
        reporte.setIngresos(ingresos);
        reporte.setEgresos(egresos);
        reporte.setObligatorios(servicioObtenerRegistros.obtenerPorConcepto("OB").stream().mapToDouble(Registro::getCuanto).sum());
        reporte.setOtros(servicioObtenerRegistros.obtenerPorConcepto("OT").stream().mapToDouble(Registro::getCuanto).sum());
        reporte.setHasta(LocalDate.now());
        return  reporte;
    }
}
