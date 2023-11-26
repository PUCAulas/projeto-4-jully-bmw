package com.lib.itemFactory;

import com.lib.estante.Dvd;
import com.lib.item.Item;

public class DvdFactory implements IItemFactory {
    @Override
    public Item criarItem(String titulo, String autor, int anoPublicacao) {
        return new Dvd(titulo, autor, anoPublicacao);
    }
}