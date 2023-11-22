package com.lib;

import java.util.Scanner;

import com.lib.biblioteca.Biblioteca;
import com.lib.estante.Cd;
import com.lib.estante.Dvd;
import com.lib.estante.Livro;
import com.lib.estante.Revista;
import com.lib.estante.Tese;
import com.lib.item.Item;
import com.lib.usuario.Usuario;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.getUsuarios().add(new Usuario("belle", 0, false));
        biblioteca.getUsuarios().add(new Usuario("jully", 0, false));
        biblioteca.getUsuarios().add(new Usuario("leo", 0, false));
        biblioteca.getUsuarios().add(new Usuario("maria", 0, false));

        for (int i = 1; i <= 3; i++) {
            biblioteca.getAcervo().add(new Livro("Livro " + i, "Autor " + i, 2000 + i *
                    5));
            biblioteca.getAcervo().add(new Revista("Revista " + i, "Editora " + i, 2010 +
                    i * 3));
            biblioteca.getAcervo().add(new Tese("Tese " + i, "Pesquisador " + i, 2015 +
                    i));
            biblioteca.getAcervo().add(new Cd("CD " + i, "Artista " + i, 2008 + i));
            biblioteca.getAcervo().add(new Dvd("DVD " + i, "Diretor " + i, 2012 + i));
        }

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerenciar usuários");
            System.out.println("2. Gerenciar itens");
            System.out.println("3. Pesquisar itens da biblioteca");
            System.out.println("4. Fazer empréstimo");
            System.out.println("5. Devolver empréstimo");
            System.out.println("6. Emitir relatórios");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    subMenuUser(biblioteca, scanner);
                    break;
                case 2:
                    subMenuItem(biblioteca, scanner);
                    break;
                case 3:
                    biblioteca.pesquisarItens();
                    break;
                case 4:
                    Scanner scannerEmprestimo = new Scanner(System.in);

                    System.out.print("Digite o nome do usuário: ");
                    String nomeUser = scannerEmprestimo.nextLine();

                    biblioteca.relatorioPorItem();

                    Usuario usuarioEmprestimo = biblioteca.buscarUsuario(nomeUser);

                    System.out.print("Digite o nome do item que deseja emprestar: ");
                    String nomeItem = scannerEmprestimo.nextLine();

                    Item itemParaEmprestar = biblioteca.buscarItemPorNome(nomeItem);

                    if (itemParaEmprestar != null) {
                        biblioteca.emprestarItem(usuarioEmprestimo, itemParaEmprestar, biblioteca);
                    } else {
                        System.out.println("Item não encontrado na biblioteca.");
                    }
                    break;
                case 5:
                    Scanner scannerDevolucao = new Scanner(System.in);

                    System.out.print("Digite o nome do usuário: ");
                    String scUser = scannerDevolucao.nextLine();

                    Usuario usuarioDevolucao = biblioteca.buscarUsuario(scUser);

                    System.out.print("Digite o nome do item que deseja emprestar: ");
                    String scItem = scannerDevolucao.nextLine();

                    Item itemParaDevolucao = biblioteca.buscarItemPorNome(scItem);

                    if (itemParaDevolucao != null) {
                        biblioteca.devolverItem(usuarioDevolucao, itemParaDevolucao);
                    } else {
                        System.out.println("Item não encontrado na biblioteca.");
                    }
                    break;

                case 6:
                    subMenuRelatorio(biblioteca, scanner);
                    break;

                case 0:
                    System.out.println("Finalizando atendimento... Até mais!");
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void subMenuRelatorio(Biblioteca biblioteca, Scanner scanner) {
        while (true) {
            System.out.println("Escolha uma opção de relatório:");
            System.out.println("1. Por item");
            System.out.println("2. Por usuário");
            System.out.println("0. Voltar ao menu principal");

            int opcaoSubMenuRelatorio = scanner.nextInt();

            switch (opcaoSubMenuRelatorio) {
                case 1:
                    biblioteca.relatorioPorItem();
                    break;
                case 2:
                    System.out.println("Digite o nome do Aluno");
                    String nomeAluno = scanner.nextLine();

                    biblioteca.relatorioPorUsuario(nomeAluno);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            if (opcaoSubMenuRelatorio == 0) {
                break;
            }
        }
    };

    public static void subMenuUser(Biblioteca biblioteca, Scanner scanner) {
        while (true) {
            System.out.println("Escolha uma opção de gerenciamento de usuários:");
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Editar usuário");
            System.out.println("3. Deletar usuário");
            System.out.println("0. Voltar ao menu principal");

            if (scanner.hasNextInt()) {
                int opcaoSubMenuUsuario = scanner.nextInt();

                switch (opcaoSubMenuUsuario) {
                    case 1:
                        System.out.print("Digite o nome do novo usuário: ");
                        String nome = scanner.next(); // Use next() em vez de nextLine() aqui

                        Usuario novoUsuario = new Usuario(nome, 0, false);
                        biblioteca.adicionarUsuario(novoUsuario);

                        System.out.println("Novo usuário adicionado com sucesso!");
                        biblioteca.listarUsuarios();
                        break;
                    case 2:
                        biblioteca.editarNomeDeUsuario();
                        biblioteca.listarUsuarios();
                        break;
                    case 3:
                        System.out.print("Digite o nome do usuário que deseja deletar: ");
                        String nomeUsuario = scanner.next();
                        biblioteca.removeUsuario(nomeUsuario);
                        biblioteca.listarUsuarios();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        scanner.next();
                }
            }
        }
    }

    public static void subMenuItem(Biblioteca biblioteca, Scanner scanner) {

        while (true) {
            System.out.println("Escolha uma opção de gerenciamento de itens:");
            System.out.println("1. Adicionar iten");
            System.out.println("2. Editar iten");
            System.out.println("3. Deletar iten");
            System.out.println("0. Voltar ao menu principal");

            if (scanner.hasNextInt()) {
                int opcaoSubMenuItem = scanner.nextInt();

                switch (opcaoSubMenuItem) {
                    case 1:
                        biblioteca.criarItemComEntradaDoUsuario(biblioteca);
                        System.out.println("Novo item adicionado com sucesso!");

                        break;
                    case 2:
                        biblioteca.editarItem(biblioteca, scanner);
                        break;
                    case 3:
                        System.out.print("Digite o nome do item que deseja remover: ");
                        String nomeItem = scanner.next();
                        biblioteca.removerItemPorNome(nomeItem);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        scanner.next();
                }
            }

        }
    };
};
