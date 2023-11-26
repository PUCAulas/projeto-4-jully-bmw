package com.lib.usuario;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.lib.estante.Livro;
import com.lib.item.Item;

public class UsuarioTest {
    private Usuario usuario;
    private Item itemExistente;
    private Item itemNaoExistente;

    @Before
    public void setUp() {
        usuario = new Usuario("Belle", 2, false);
        itemExistente = new Livro("A cabana", "Coiso", 2022);
        itemNaoExistente = new Livro("Bacana", "Ana", 2023);
    }

    @Test
    public void testPegarMaisUmItemComEmprestimoAtraso() {
        usuario.setEmprestimoAtraso(true);
        assertFalse(usuario.pegarMaisUmItem());
    }

    @Test
    public void testPegarMaisUmItemComLimiteAlcancado() {
        usuario.setEmprestimoAtraso(false);
        usuario.setQntItensEmprestados(3);
        assertFalse(usuario.pegarMaisUmItem());
    }

    @Test
    public void testPegarMaisUmItemComEmprestimoDentroDoLimite() {
        usuario.setEmprestimoAtraso(false);
        usuario.setQntItensEmprestados(2);
        assertTrue(usuario.pegarMaisUmItem());
    }

    @Test
    public void testJaPossuiExemplar() {
        usuario.getItensEmEmprestismo().add(itemExistente);
        assertTrue(usuario.jaPossuiExemplar(itemExistente));
        assertFalse(usuario.jaPossuiExemplar(itemNaoExistente));
    }
}
