package com.caro.mycash.infraestructura.adaptador;

import com.caro.mycash.dominio.modelo.Persona;
import com.caro.mycash.dominio.puerto.RepositorioPersona;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class RepositorioPersonaImpl implements RepositorioPersona {

    private long secuencia;
    private final HashMap<Long, Persona> personas = new HashMap<>();

    @Override
    public List<Persona> listar() {
        return personas.values().stream().toList();
    }

    @Override
    public Persona consultarPorId(Long id) {
        return personas.get(id);
    }

    @Override
    public Long guardar(Persona persona) {
        personas.put(++secuencia, persona);
        return secuencia;
    }

    @Override
    public boolean existe(Persona persona) {
        return listar().stream().anyMatch(row -> row.toString().equals(persona.toString()));
    }

    @Override
    public boolean existe(Long id) {
        return personas.containsKey(id);
    }

    @Override
    public void modificar(Long id, Persona persona) {
        personas.put(id, persona);
    }

    @Override
    public void eliminar(Long id) {
        personas.remove(id);
    }

}
