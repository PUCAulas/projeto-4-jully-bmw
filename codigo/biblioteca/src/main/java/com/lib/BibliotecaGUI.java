package com.lib;

import com.lib.biblioteca.Biblioteca;
import com.lib.estante.Livro;
import com.lib.usuario.UsuarioAdapter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BibliotecaGUI extends Application {

    private Biblioteca biblioteca;

    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        biblioteca = Biblioteca.getInstance();

        primaryStage.setTitle("Biblioteca App");

        VBox layout = new VBox(10);

        // Cadastro de Usuários
        Label labelUsuario = new Label("Cadastro de Usuário");
        TextField nomeUsuarioField = new TextField();
        Button cadastrarUsuarioButton = new Button("Cadastrar Usuário");

        cadastrarUsuarioButton.setOnAction(e -> {
            cadastrarUsuario(nomeUsuarioField.getText());
            nomeUsuarioField.clear();
        });

        // Cadastro de Itens
        Label labelItem = new Label("Cadastro de Item");
        TextField tituloItemField = new TextField();
        TextField autorItemField = new TextField();
        TextField anoItemField = new TextField();
        Button cadastrarItemButton = new Button("Cadastrar Item");

        cadastrarItemButton.setOnAction(e -> {
            cadastrarItem(tituloItemField.getText(), autorItemField.getText(), Integer.parseInt(anoItemField.getText()));
            tituloItemField.clear();
            autorItemField.clear();
            anoItemField.clear();
        });

        layout.getChildren().addAll(labelUsuario, nomeUsuarioField, cadastrarUsuarioButton,
                labelItem, tituloItemField, autorItemField, anoItemField, cadastrarItemButton);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cadastrarUsuario(String nome) {
        UsuarioAdapter novoUsuario = new UsuarioAdapter(nome, 0, false);
        biblioteca.adicionarUsuario(novoUsuario);
        System.out.println("Novo usuário cadastrado: " + nome);
    }

    private void cadastrarItem(String titulo, String autor, int ano) {
        // Você pode adicionar a lógica para escolher o tipo de item aqui
        // e criar o item correspondente usando a fábrica apropriada.

        // Exemplo para adicionar um livro:
        Livro novoLivro = new Livro(titulo, autor, ano);
        biblioteca.adicionarItem(novoLivro);

        System.out.println("Novo item cadastrado: " + titulo);
    }
}
