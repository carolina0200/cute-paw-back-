package com.caro.mycash.infraestructura.adaptador.jpa;

import com.caro.mycash.infraestructura.adaptador.entidad.EntidadRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRegistroJpa extends JpaRepository<EntidadRegistro, Long> {
}
