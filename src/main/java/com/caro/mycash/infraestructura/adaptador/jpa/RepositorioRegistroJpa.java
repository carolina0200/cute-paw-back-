package com.caro.mycash.infraestructura.adaptador.jpa;

import com.caro.mycash.infraestructura.adaptador.entidad.EntidadRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioRegistroJpa extends JpaRepository<EntidadRegistro, Long> {
    List<EntidadRegistro> findAllByTipoOrderByCuandoAsc(String tipo);
    List<EntidadRegistro> findAllByConceptoOrderByCuandoAsc(String tipo);
}
