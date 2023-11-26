package com.lib.itemFactory;

import com.lib.estante.Cd;
import com.lib.item.Item;

public class CdFactory implements IItemFactory {
    @Override
    public Item criarItem(String titulo, String autor, int anoPublicacao) {
        return new Cd(titulo, autor, anoPublicacao);
    }
}