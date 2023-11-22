package com.lib.biblioteca;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.lib.estante.Livro;
import com.lib.item.Item;
import com.lib.usuario.Usuario;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void testAdicionarUsuario() {
        Usuario novoUsuario = new Usuario("maria", 0, false);
        biblioteca.adicionarUsuario(novoUsuario);
        assertTrue(biblioteca.getUsuarios().contains(novoUsuario));
    }

    @Test
    public void testBuscarUsuario() {
        Usuario novoUsuario = new Usuario("Maria", 0, false);
        biblioteca.adicionarUsuario(novoUsuario);

        Usuario usuarioEncontrado = biblioteca.buscarUsuario("Maria");
        assertEquals(novoUsuario, usuarioEncontrado);
    }

    @Test
    public void testRemoverUsuario() {
        Usuario novoUsuario = new Usuario("Maria", 0, false);
        biblioteca.adicionarUsuario(novoUsuario);

        biblioteca.removeUsuario("Maria");
        assertFalse(biblioteca.getUsuarios().contains(novoUsuario));
    }

    @Test
    public void testAdicionarItem() {
        Item novoItem = new Livro("Olhai os Lírios do Campo", "Erico Verissimo", 2022);
        biblioteca.adicionarItem(novoItem);

        assertTrue(biblioteca.getAcervo().contains(novoItem));
    }

    @Test
    public void testBuscarItemPorNome() {
        Item novoItem = new Livro("Olhai os Lírios do Campo", "Erico Verissimo", 2022);
        biblioteca.adicionarItem(novoItem);

        Item itemEncontrado = biblioteca.buscarItemPorNome("Olhai os Lírios do Campo");
        assertEquals(novoItem, itemEncontrado);
    }

    @Test
    public void testRemoverItemPorNome() {
        Item novoItem = new Livro("Olhai os Lírios do Campo", "Erico Verissimo", 2022);
        biblioteca.adicionarItem(novoItem);

        biblioteca.removerItemPorNome("Olhai os Lírios do Campo");
        assertFalse(biblioteca.getAcervo().contains(novoItem));
    }

    @Test
    public void testEmprestarItem() {
        Usuario usuario = new Usuario("Maria", 0, false);
        biblioteca.adicionarUsuario(usuario);

        Item livro = new Livro("Olhai os Lírios do Campo", "Erico Verissimo", 2022);
        biblioteca.adicionarItem(livro);
        
        biblioteca.emprestarItem(usuario, livro, biblioteca);

        assertTrue(usuario.getItensEmEmprestismo().contains(livro));
        assertEquals(1, livro.getQntdDeVezesEmprestado());
    }

    @Test
    public void testDevolverItem() {
        Usuario usuario = new Usuario("Maria", 0, false);
        biblioteca.adicionarUsuario(usuario);

        Item livro = new Livro("Olhai os Lírios do Campo", "Erico Verissimo", 2022);
        biblioteca.adicionarItem(livro);

        biblioteca.emprestarItem(usuario, livro, biblioteca);
        biblioteca.devolverItem(usuario, livro);

        assertFalse(usuario.getItensEmEmprestismo().contains(livro));
    }

}
