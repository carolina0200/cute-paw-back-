package com.caro.mycash.dominio.puerto;

import com.caro.mycash.dominio.modelo.Registro;

import java.util.List;

public interface RepositorioRegistro {

    Long guardar(Registro registro);
    List<Registro> listar();
    List<Registro> obtenerPorTipo(String tipo);
    List<Registro> obtenerPorConcepto(String concepto);
    void eliminar(List<Registro> registros);
}
