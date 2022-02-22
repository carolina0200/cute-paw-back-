package com.caro.mycash.infraestructura.adaptador;

import com.caro.mycash.dominio.modelo.Persona;
import com.caro.mycash.dominio.puerto.RepositorioPersona;
import com.caro.mycash.infraestructura.adaptador.entidad.EntidadPersona;
import com.caro.mycash.infraestructura.adaptador.jpa.RepositorioPersonaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPersonaMySql implements RepositorioPersona {

    private final RepositorioPersonaJpa repositorioPersonaJpa;

    public RepositorioPersonaMySql(RepositorioPersonaJpa repositorioPersonaJpa) {
        this.repositorioPersonaJpa = repositorioPersonaJpa;
    }

    @Override
    public List<Persona> listar() {
        List<EntidadPersona> entidades = this.repositorioPersonaJpa.findAll();
        return entidades.stream().map(entidad -> Persona.of(entidad.getNombre(), entidad.getApellido())).toList();
    }

    @Override
    public Persona consultarPorId(Long id) {

        return this.repositorioPersonaJpa
                .findById(id)
                .map(entidad -> Persona.of(entidad.getNombre(), entidad.getApellido()))
                .orElse(null);
    }

    @Override
    public Long guardar(Persona persona) {

        EntidadPersona entidadPersona = new EntidadPersona(persona.getNombre(), persona.getApellido());

        return this.repositorioPersonaJpa.save(entidadPersona).getId();
    }

    @Override
    public boolean existe(Persona persona) {
        return this.repositorioPersonaJpa.findByNombreAndApellido(persona.getNombre(), persona.getApellido()) != null;
    }

    @Override
    public boolean existe(Long id) {
        return false;
    }

    @Override
    public void modificar(Long id, Persona persona) {
        EntidadPersona entidadPersona = new EntidadPersona(persona.getNombre(), persona.getApellido());
        repositorioPersonaJpa.save(entidadPersona);
    }

    @Override
    public void eliminar(Long id) {
        repositorioPersonaJpa.deleteById(id);
    }
}
