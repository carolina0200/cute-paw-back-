package com.caro.mycash.dominio.servicio;

import com.caro.mycash.dominio.modelo.Registro;
import com.caro.mycash.dominio.puerto.RepositorioRegistro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioObtenerRegistros {

    private final RepositorioRegistro repositorio;

    public ServicioObtenerRegistros(RepositorioRegistro repositorioRegistro) {
        this.repositorio = repositorioRegistro;
    }

    public List<Registro> obtenerPorTipo(String tipo) {
        return repositorio.obtenerPorTipo(tipo);
    }

    public List<Registro> obtenerPorConcepto(String concepto) {
        return repositorio.obtenerPorConcepto(concepto);
    }
}
