package com.lib.itemFactory;

import com.lib.estante.Tese;
import com.lib.item.Item;

public class TeseFactory implements IItemFactory {
    @Override
    public Item criarItem(String titulo, String autor, int anoPublicacao) {
        return new Tese(titulo, autor, anoPublicacao);
    }
}