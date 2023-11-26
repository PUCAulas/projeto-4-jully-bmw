package com.lib.usuario;

import java.util.List;

public interface IUsuarioAdapter {
    String getCurso();

    void setCurso(String curso);

    List<String> getCategoriasDeInteresse();

    void setCategoriasDeInteresse(List<String> categoriasDeInteresse);
}