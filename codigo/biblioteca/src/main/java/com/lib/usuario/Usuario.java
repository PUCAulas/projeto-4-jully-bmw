package com.lib.usuario;

import java.util.ArrayList;
import java.util.List;

import com.lib.item.Item;

public class Usuario {
    private String nome;
    private int qntItensEmprestados;
    private boolean isEmprestimoAtraso;
    private List<Item> historicoDeItens;
    private List<Item> itensEmEmprestismo;

    public Usuario(String nome, int qntItensEmprestados, boolean isEmprestimoAtraso) {
        this.nome = nome;
        this.qntItensEmprestados = qntItensEmprestados;
        this.isEmprestimoAtraso = isEmprestimoAtraso;
        this.historicoDeItens = new ArrayList<>();
        this.itensEmEmprestismo = new ArrayList<>();
    }

    public boolean pegarMaisUmItem() {
        return !isEmprestimoAtraso && qntItensEmprestados < 3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQntItensEmprestados() {
        return qntItensEmprestados;
    }

    public List<Item> getHistoricoDeItens() {
        return historicoDeItens;
    }

    public void setQntItensEmprestados(int qntItensEmprestados) {
        this.qntItensEmprestados = qntItensEmprestados;
    }

    public boolean isEmprestimoAtraso() {
        return isEmprestimoAtraso;
    }

    public void setEmprestimoAtraso(boolean emprestimoAtraso) {
        this.isEmprestimoAtraso = emprestimoAtraso;
    }

    public List<Item> getItensEmEmprestismo() {
        return itensEmEmprestismo;
    }

    public void setHistoricoDeItens(List<Item> historicoDeItens) {
        this.historicoDeItens = historicoDeItens;
    }

    public void setItensEmEmprestismo(List<Item> itensEmEmprestismo) {
        this.itensEmEmprestismo = itensEmEmprestismo;
    }

}