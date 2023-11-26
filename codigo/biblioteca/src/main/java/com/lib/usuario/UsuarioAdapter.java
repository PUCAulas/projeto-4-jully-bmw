package com.lib.usuario;

import java.util.List;

public class UsuarioAdapter extends Usuario {
    public UsuarioAdapter(String nome, int qntItensEmprestados, boolean isEmprestimoAtraso) {
        super(nome, qntItensEmprestados, isEmprestimoAtraso);
    }

    @Override
    public String getCurso() {
        return curso;
    }

    @Override
    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public List<String> getCategoriasDeInteresse() {

        return categoriasDeInteresse;
    }

    @Override
    public void setCategoriasDeInteresse(List<String> categoriasDeInteresse) {

        this.categoriasDeInteresse = categoriasDeInteresse;
    }
}
