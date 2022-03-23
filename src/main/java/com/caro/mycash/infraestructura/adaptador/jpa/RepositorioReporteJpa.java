package com.caro.mycash.infraestructura.adaptador.jpa;

import com.caro.mycash.infraestructura.adaptador.entidad.EntidadReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReporteJpa extends JpaRepository<EntidadReporte, Long> {
}
