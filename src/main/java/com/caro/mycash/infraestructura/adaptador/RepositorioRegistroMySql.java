package com.caro.mycash.infraestructura.adaptador;

import com.caro.mycash.dominio.modelo.Registro;
import com.caro.mycash.dominio.puerto.RepositorioRegistro;
import com.caro.mycash.infraestructura.adaptador.entidad.EntidadRegistro;
import com.caro.mycash.infraestructura.adaptador.jpa.RepositorioRegistroJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioRegistroMySql implements RepositorioRegistro {

    private final RepositorioRegistroJpa repositorio;

    public RepositorioRegistroMySql(RepositorioRegistroJpa repositorioRegistroJpa) {
        this.repositorio = repositorioRegistroJpa;
    }

    @Override
    public Long guardar(Registro registro) {
        return repositorio.save(new EntidadRegistro(registro.getTipo(), registro.getConcepto(), registro.getDescripcion(), registro.getCuanto(), registro.getIcono(), registro.getCuando())).getId();
    }

    @Override
    public List<Registro> listar() {
        List<EntidadRegistro> registros = repositorio.findAll();
        return registros.stream().map(Registro::fromEntity).toList();
    }

    @Override
    public List<Registro> obtenerPorTipo(String tipo) {
        List<EntidadRegistro> registros = repositorio.findAllByTipoOrderByCuandoAsc(tipo);
        return registros.stream().map(Registro::fromEntity).toList();
    }

    @Override
    public List<Registro> obtenerPorConcepto(String concepto) {
        List<EntidadRegistro> registros = repositorio.findAllByConceptoOrderByCuandoAsc(concepto);
        return registros.stream().map(Registro::fromEntity).toList();
    }

    @Override
    public void eliminar(List<Registro> registros) {
        Iterable<Long> ids = registros.stream().map(Registro::getId).toList();
        repositorio.deleteAllById(ids);
    }
}
