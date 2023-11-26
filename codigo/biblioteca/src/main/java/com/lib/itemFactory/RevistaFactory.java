package com.lib.itemFactory;

import com.lib.estante.Revista;
import com.lib.item.Item;

public class RevistaFactory implements IItemFactory {
    @Override
    public Item criarItem(String titulo, String autor, int anoPublicacao) {
        return new Revista(titulo, autor, anoPublicacao);
    }
}