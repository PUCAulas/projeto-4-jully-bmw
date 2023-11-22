package com.lib.item;

public abstract class Item {

    protected ETipoItem tipo;
    protected String titulo;
    protected String autor;
    protected int anoPublicacao;
    protected int quantidade;
    protected int qntdDeVezesEmprestado;
    protected boolean emprestavel;

    public abstract boolean isEmprestavel();

    public boolean podeSerEmprestado() {
        return emprestavel && quantidade > 1;
    }

    public enum ETipoItem {
        LIVRO,
        TESE,
        REVISTA,
        CD,
        DVD
    }

    public ETipoItem getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQntdDeVezesEmprestado() {
        return qntdDeVezesEmprestado;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEmprestavel(boolean emprestavel) {
        this.emprestavel = emprestavel;
    }

    public void setQntdDeVezesEmprestado(int qntdDeVezesEmprestado) {
        this.qntdDeVezesEmprestado = qntdDeVezesEmprestado;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setTipo(ETipoItem tipo) {
        this.tipo = tipo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void atualizarQntdDeVezesEmprestado(int qntd) {
        this.qntdDeVezesEmprestado += qntd;
    }
}
