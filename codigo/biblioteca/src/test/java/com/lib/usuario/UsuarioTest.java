package com.lib.usuario;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
    private Usuario usuario;

    @Before
    public void setUp() {
        usuario = new Usuario("Belle", 2, false);
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
}
