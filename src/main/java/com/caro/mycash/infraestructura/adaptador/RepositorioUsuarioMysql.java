package com.caro.mycash.infraestructura.adaptador;

import com.caro.mycash.dominio.modelo.RolUsuario;
import com.caro.mycash.dominio.modelo.Usuario;
import com.caro.mycash.dominio.puerto.RepositorioUsuario;
import com.caro.mycash.infraestructura.adaptador.entidad.EntidadRolUsuario;
import com.caro.mycash.infraestructura.adaptador.entidad.EntidadUsuario;
import com.caro.mycash.infraestructura.adaptador.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;

    public RepositorioUsuarioMysql(RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }

    @Override
    public Long guardar(Usuario usuario) {

        List<EntidadRolUsuario> roles = usuario.getRoles().stream().map(rol -> new EntidadRolUsuario(rol.getRol())).toList();
        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getClave(), roles);

        return this.repositorioUsuarioJpa.save(entidadUsuario).getId();
    }

    @Override
    public boolean existe(Usuario usuario) {
        return this.repositorioUsuarioJpa.findByUsuario(usuario.getNombre()) != null;
    }

    @Override
    public Usuario consultar(String usuario, String clave) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByUsuarioAndClave(usuario, clave);

        if(entidadUsuario == null) {
            return null;
        }

        List<RolUsuario> roles = entidadUsuario.getRoles().stream().map(rol -> RolUsuario.of(rol.getRol())).toList();
        return Usuario.of(entidadUsuario.getUsuario(), entidadUsuario.getClave(), roles);
    }
}
