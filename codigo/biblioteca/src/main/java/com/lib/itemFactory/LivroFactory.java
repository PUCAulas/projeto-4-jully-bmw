package com.lib.itemFactory;

import com.lib.estante.Livro;
import com.lib.item.Item;

public class LivroFactory implements IItemFactory {
    @Override
    public Item criarItem(String titulo, String autor, int anoPublicacao) {
        return new Livro(titulo, autor, anoPublicacao);
    }
}