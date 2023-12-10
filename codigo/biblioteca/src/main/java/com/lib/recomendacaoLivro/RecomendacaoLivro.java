package com.lib.recomendacaoLivro;

import com.lib.biblioteca.Biblioteca;
import com.lib.usuario.Usuario;
import com.lib.item.Item;

import java.util.ArrayList;
import java.util.List;

public class RecomendacaoLivro {
    
    //TODO: passar a lib inteira e filtrar ou passar o array de livros já filtrado.
    // Passada lib e filtrado livros de cada user por titulo
    

    public void recomendar(Usuario usuario, Biblioteca biblioteca) {
        List<Item> acervo = biblioteca.getAcervo();
        List<Item> itensRecomendados = new ArrayList<>();

        // Obter títulos dos itens do usuário
        List<String> titulosUsuario = obterTitulosItensUsuario(usuario);

        // Iterar sobre os itens do acervo
        for (Item item : acervo) {
            // Verificar se o título do item contém palavras-chave do usuário
            if (contemTitulo(titulosUsuario, item.getTitulo())) {
                // Adicionar o item à lista de recomendações
                itensRecomendados.add(item);
            }
        }

        // Exibir os itens recomendados
        exibirRecomendacoes(itensRecomendados);
    }

    private List<String> obterTitulosItensUsuario(Usuario usuario) {
        List<String> titulosItens = new ArrayList<>();
    
        if (usuario != null && usuario.getItensEmEmprestismo() != null) {
            for (Item item : usuario.getItensEmEmprestismo()) {
                titulosItens.add(item.getTitulo());
            }
        } else {
            titulosItens.add("Usuário não possui livros emprestados");
        }
    
        return titulosItens;
    }
    

    // Método auxiliar para verificar se o título do item contém palavras-chave do usuário
    private boolean contemTitulo(List<String> titulosUsuario, String tituloItem) {
        for (String titulo : titulosUsuario) {
            if (tituloItem.toLowerCase().contains(titulo.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar para exibir os itens recomendados
    private void exibirRecomendacoes(List<Item> itensRecomendados) {
        if (itensRecomendados.isEmpty()) {
            System.out.println("Não há recomendações de livros para o usuário.");
        } else {
            System.out.println("Livros recomendados para o usuário:");
            for (Item item : itensRecomendados) {
                System.out.println(" - Título: " + item.getTitulo() +
                        ", Autor: " + item.getAutor() +
                        ", Ano de Publicação: " + item.getAnoPublicacao());
            }
        }
    }












    }

