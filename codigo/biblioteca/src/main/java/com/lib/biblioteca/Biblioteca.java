package com.lib.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.lib.estante.Cd;
import com.lib.estante.Dvd;
import com.lib.estante.Livro;
import com.lib.estante.Revista;
import com.lib.estante.Tese;
import com.lib.item.Item;
import com.lib.item.Item.ETipoItem;
import com.lib.usuario.Usuario;

public class Biblioteca {
    private List<Item> acervo;
    private List<Usuario> usuarios;

    public Biblioteca() {
        acervo = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void pesquisarItens() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção de pesquisa:");
            System.out.println("1. Por título");
            System.out.println("2. Por autor");
            System.out.println("3. Por ano de publicação");
            System.out.println("4. Por tipo de item");
            System.out.println("0. Voltar ao menu principal");

            int opcaoPesquisa = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoPesquisa) {
                case 1:
                    pesquisarPorTitulo();
                    break;
                case 2:
                    pesquisarPorAutor();
                    break;
                case 3:
                    pesquisarPorAno();
                    break;
                case 4:
                    pesquisarPorTipo();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            scanner.close();
        }
    }

    private void pesquisarPorTitulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o título a ser pesquisado:");
        String titulo = scanner.nextLine();
        List<Item> resultados = new ArrayList<>();

        for (Item item : acervo) {
            if (item.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(item);
            }
        }

        exibirResultadosPesquisa(resultados);
        scanner.close();
    }

    private void pesquisarPorAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o autor a ser pesquisado:");
        String autor = scanner.nextLine();
        List<Item> resultados = new ArrayList<>();

        for (Item item : acervo) {
            if (item.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(item);
            }
        }

        exibirResultadosPesquisa(resultados);
        scanner.close();
    }

    private void pesquisarPorAno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ano de publicação a ser pesquisado:");
        int ano = scanner.nextInt();
        List<Item> resultados = new ArrayList<>();

        for (Item item : acervo) {
            if (item.getAnoPublicacao() == ano) {
                resultados.add(item);
            }
        }

        exibirResultadosPesquisa(resultados);
        scanner.close();
    }

    private void pesquisarPorTipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de item a ser pesquisado (livro, revista, etc.):");
        String tipo = scanner.nextLine();
        List<Item> resultados = new ArrayList<>();

        for (Item item : acervo) {
            if (item.getTipo().toString().equalsIgnoreCase(tipo)) {
                resultados.add(item);
            }
        }

        exibirResultadosPesquisa(resultados);
        scanner.close();
    }

    private void exibirResultadosPesquisa(List<Item> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
        } else {
            Collections.sort(resultados, (item1, item2) -> item1.getTitulo().compareTo(item2.getTitulo()));
            System.out.println("\nResultados da pesquisa:");
            for (Item item : resultados) {
                System.out.println(" - Título: " + item.getTitulo() +
                        ", Autor: " + item.getAutor() +
                        ", Ano de Publicação: " + item.getAnoPublicacao() +
                        ", Tipo: " + item.getTipo());
            }
        }
    }

    public void relatorioPorItem() {
        System.out.println("Relatório por Item:");

        for (ETipoItem tipo : ETipoItem.values()) {
            relatorioPorTipoDeItem(tipo);
        }
    }

    private void relatorioPorTipoDeItem(ETipoItem tipo) {
        List<Item> itensDoTipo = filtrarItensPorTipo(tipo);

        if (!itensDoTipo.isEmpty()) {
            Collections.sort(itensDoTipo,
                    (item1, item2) -> Integer.compare(item1.getAnoPublicacao(), item2.getAnoPublicacao()));

            System.out.println("\nTipo de Item: " + tipo);
            for (Item item : itensDoTipo) {
                System.out.println(" - Título: " + item.getTitulo() +
                        ", Ano de Publicação: " + item.getAnoPublicacao() +
                        ", Quantidade de vezes emprestado: " + item.getQntdDeVezesEmprestado());
            }
        }
    }

    private List<Item> filtrarItensPorTipo(ETipoItem tipo) {
        List<Item> itensDoTipo = new ArrayList<>();
        for (Item item : acervo) {
            if (item.getTipo() == tipo) {
                itensDoTipo.add(item);
            }
        }
        return itensDoTipo;
    }

    public void relatorioPorUsuario(String nomeUsuario) {
        Usuario usuario = buscarUsuario(nomeUsuario);

        if (usuario != null) {
            List<Item> historicoItens = usuario.getHistoricoDeItens();
            Collections.sort(historicoItens, (item1, item2) -> item1.getTitulo().compareTo(item2.getTitulo()));

            System.out.println("Relatório para o usuário " + nomeUsuario + ":");
            for (Item item : historicoItens) {
                System.out.println(" - " + item.getTitulo());
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public Usuario buscarUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public Item buscarItemPorNome(String nomeItem) {
        for (Item item : acervo) {
            if (item.getTitulo().equalsIgnoreCase(nomeItem)) {
                return item;
            }
        }
        return null; // Retorna null se o item não for encontrado.
    }

    public List<Item> getAcervo() {
        return acervo;
    }

    // Usuarios
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionarUsuario(Usuario novoUsuario) {
        usuarios.add(novoUsuario);
    }

    public void listarUsuarios() {
        System.out.println("\nLista de Usuários na Biblioteca:");
        for (Usuario usuario : usuarios) {
            System.out.println("Nome do Usuário: " + usuario.getNome());
        }
        System.out.println("\n");
    }

    public void editarNomeDeUsuario() {
        try (Scanner scannerEdicaoUser = new Scanner(System.in)) {
            System.out.print("Digite o nome do usuário que deseja editar: ");
            String nomeUsuario = scannerEdicaoUser.nextLine();
            boolean usuarioEncontrado = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equals(nomeUsuario)) {
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scannerEdicaoUser.nextLine();

                    usuario.setNome(novoNome);
                    System.out.println("Nome do usuário editado com sucesso.");
                    usuarioEncontrado = true;
                    break; // Saia do loop após encontrar o usuário
                }
            }
            if (!usuarioEncontrado) {
                System.out.println("Usuário não encontrado. Tente novamente.");
            }
        }
    }

    public void removeUsuario(String nomeUsuario) {
        Usuario usuarioParaRemover = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                if (usuario.getQntItensEmprestados() != 0
                        || usuario.isEmprestimoAtraso()
                        || (usuario.getItensEmEmprestismo() instanceof ArrayList
                                && !usuario.getItensEmEmprestismo().isEmpty())) {
                    System.out.println("Não é possível deletar este usuário devido a restrições.");
                    return;
                }

                usuarioParaRemover = usuario;
                break;
            }
        }

        if (usuarioParaRemover != null) {
            usuarios.remove(usuarioParaRemover);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    // Itens
    public void adicionarItem(Item item) {
        acervo.add(item);
    }

    public Item criarItemComEntradaDoUsuario(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título do item: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor/editora/pesquisador/artista/diretor do item: ");
        String autor = scanner.nextLine();

        System.out.print("Digite o ano de publicação do item: ");
        int anoPublicacao = scanner.nextInt();

        System.out.println("Escolha o tipo de item:");
        System.out.println("1. Livro");
        System.out.println("2. Revista");
        System.out.println("3. Tese");
        System.out.println("4. CD");
        System.out.println("5. DVD");

        int escolhaTipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha após a leitura do número.

        Item novoItem = null;

        switch (escolhaTipo) {
            case 1:
                novoItem = new Livro(titulo, autor, anoPublicacao);
                biblioteca.getAcervo().add(novoItem);
                break;
            case 2:
                novoItem = new Revista(titulo, autor, anoPublicacao);
                biblioteca.getAcervo().add(novoItem);
                break;
            case 3:
                novoItem = new Tese(titulo, autor, anoPublicacao);
                biblioteca.getAcervo().add(novoItem);
                break;
            case 4:
                novoItem = new Cd(titulo, autor, anoPublicacao);
                biblioteca.getAcervo().add(novoItem);
                break;
            case 5:
                novoItem = new Dvd(titulo, autor, anoPublicacao);
                biblioteca.getAcervo().add(novoItem);
                break;
            default:
                System.out.println("Tipo de item inválido. Nenhum item foi criado.");
        }

        if (novoItem != null) {
            System.out.println("Item criado com sucesso.");
        }

        return novoItem;
    }

    public void editarItem(Biblioteca biblioteca, Scanner scanner) {

        System.out.print("Digite o nome do item que deseja editar: ");
        String nomeItem = scanner.next();

        Item itemParaEditar = biblioteca.buscarItemPorNome(nomeItem);

        if (itemParaEditar != null) {

            System.out.print("Digite o novo título (atual: " + itemParaEditar.getTitulo() + "): ");
            String novoTitulo = scanner.next();

            System.out.print("Digite o novo autor (atual: " + itemParaEditar.getAutor() + "): ");
            String novoAutor = scanner.next();

            System.out
                    .print("Digite o novo ano de publicação (atual: " + itemParaEditar.getAnoPublicacao() + "): ");
            int novoAnoPublicacao = scanner.nextInt();

            // Atualize os atributos do item existente com os novos valores.
            itemParaEditar.setTitulo(novoTitulo);
            itemParaEditar.setAutor(novoAutor);
            itemParaEditar.setAnoPublicacao(novoAnoPublicacao);
            System.out.println("Item editado com sucesso.");

        } else {
            System.out.println("Item não encontrado.");
        }

    }

    public void removerItemPorNome(String nomeItem) {
        Item itemParaRemover = null;

        for (Item item : acervo) {
            if (item.getTitulo().equalsIgnoreCase(nomeItem)) {
                itemParaRemover = item;
                break;
            }
        }

        if (itemParaRemover != null) {
            acervo.remove(itemParaRemover);
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    public void emprestarItem(Usuario usuario, Item itemParaEmprestar, Biblioteca biblioteca) {

        if (itemParaEmprestar == null) {
            System.out.println("Item não encontrado na biblioteca.");
            return;
        }

        // Verifica se o usuário tem empréstimos em atraso
        if (usuario.isEmprestimoAtraso()) {
            System.out.println("Usuário com empréstimo em atraso. Não é possível pegar mais itens.");
            return;
        }

        // Verifica se o usuário já atingiu o limite de itens emprestados (limite de 3)
        if (usuario.getItensEmEmprestismo().size() >= 3) {
            System.out.println("Usuário atingiu o limite de itens emprestados.");
            return;
        }

        // Verifica se o item é emprestável
        if (!itemParaEmprestar.podeSerEmprestado()) {
            System.out.println("Este item não é emprestável.");
            return;
        }

        // Verifica a quantidade disponível do item na biblioteca
        if (itemParaEmprestar.getQuantidade() <= 0) {
            System.out.println("Não há exemplares disponíveis para empréstimo deste item.");
            return;
        }

        // Realiza o empréstimo
        itemParaEmprestar.setQuantidade(itemParaEmprestar.getQuantidade() - 1); // Reduz a quantidade do item na
                                                                                // biblioteca
        itemParaEmprestar.atualizarQntdDeVezesEmprestado(1); // Incrementa o contador de empréstimos do item

        // Atualiza a lista de itens emprestados pelo usuário
        usuario.getItensEmEmprestismo().add(itemParaEmprestar);

        System.out.println("Item emprestado com sucesso.");
    }

    public void devolverItem(Usuario usuario, Item itemDevolvido) {
        if (itemDevolvido != null) {
            // Remove o item da lista de itens emprestados pelo usuário
            usuario.getItensEmEmprestismo().remove(itemDevolvido);

            // Incrementa a quantidade do item na biblioteca
            itemDevolvido.setQuantidade(itemDevolvido.getQuantidade() + 1);

            System.out.println("Item devolvido com sucesso.");
        } else {
            System.out.println("Item não encontrado na lista de itens emprestados pelo usuário.");
        }
    }

}
