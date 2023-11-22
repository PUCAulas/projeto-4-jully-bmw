package com.lib.item;

import static org.junit.Assert.*;
import org.junit.Test;

import com.lib.estante.Livro;
import com.lib.usuario.Usuario;
import com.lib.biblioteca.Biblioteca;

public class ItemTest {

    @Test
    public void testIsEmprestavel() {
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008);
        assertTrue(livro.podeSerEmprestado());
    }

    @Test
    public void testPodeSerEmprestado() {
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008);
        assertTrue(livro.podeSerEmprestado());
    }

    @Test
    public void testEmprestarItem() {
        Biblioteca biblioteca = new Biblioteca();
        Usuario user = new Usuario("belle", 0, false);
        biblioteca.getUsuarios().add(new Usuario("belle", 0, false));
        
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008);
        biblioteca.getAcervo().add(new Livro("Clean Code", "Robert C. Martin", 2008));
        int initialQntdDeVezesEmprestado = livro.getQntdDeVezesEmprestado();

        biblioteca.emprestarItem(user, livro, biblioteca);

        assertEquals(initialQntdDeVezesEmprestado + 1, livro.getQntdDeVezesEmprestado());
    }

    @Test
    public void testGetTipo() {
        Item livro = new Livro("Clean Code", "Robert C. Martin", 2008);

        assertEquals(Item.ETipoItem.LIVRO, livro.getTipo());
    }

}
