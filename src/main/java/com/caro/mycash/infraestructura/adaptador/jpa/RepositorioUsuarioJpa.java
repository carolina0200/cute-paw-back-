package com.caro.mycash.infraestructura.adaptador.jpa;

import com.caro.mycash.infraestructura.adaptador.entidad.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarioJpa extends JpaRepository<EntidadUsuario, Long> {

    EntidadUsuario findByUsuario(String usuario);
    EntidadUsuario findByUsuarioAndClave(String usuario,String clave);
}
