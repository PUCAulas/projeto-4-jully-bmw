package com.lib.itemFactory;

import com.lib.item.Item;

public interface IItemFactory {
    Item criarItem(String titulo, String autor, int anoPublicacao);
}
