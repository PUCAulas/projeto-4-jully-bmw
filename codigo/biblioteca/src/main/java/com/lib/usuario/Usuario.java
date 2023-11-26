package com.lib.usuario;

import java.util.ArrayList;
import java.util.List;

import com.lib.item.Item;

public class Usuario implements IUsuarioAdapter {
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

    public boolean jaPossuiExemplar(Item item) {
        for (Item itemEmprestado : itensEmEmprestismo) {

            if (itemEmprestado.getTitulo().equalsIgnoreCase(item.getTitulo())
                    && itemEmprestado.getAutor().equalsIgnoreCase(item.getAutor())
                    && itemEmprestado.getAnoPublicacao() == item.getAnoPublicacao()) {
                return true;
            }
        }
        return false;
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

    @Override
    public String getCurso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurso'");
    }

    @Override
    public void setCurso(String curso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurso'");
    }

    @Override
    public List<String> getCategoriasDeInteresse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoriasDeInteresse'");
    }

    @Override
    public void setCategoriasDeInteresse(List<String> categoriasDeInteresse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCategoriasDeInteresse'");
    }

}