package br.senai.sp.jandira.tabuada.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaTabuada extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    //Definir o tamanho da tela
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setTitle("Tabuada");

        //Criar root - componente de leitura principal
        VBox root = new VBox();
        root.setStyle("-fx-background-color: pink;");

        //Criamos a cena e root nela
        Scene scene = new Scene(root);

        //Criar o header da tela
        VBox header = new VBox();
        header.setPrefHeight(100);
        header.setStyle("-fx-background-color: orange;");

        //Colocar o conteudo do header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 20;fx-font-weight: bold;");

        Label labelSubtitulo = new Label("crie a tabuada que a sua imaginação mandar");


        //Colocar os labels do header
        header.getChildren().addAll(labelTitulo, labelSubtitulo);

        //Criar grid de formulario
        GridPane gridFormulario = new GridPane();
        gridFormulario.setPrefHeight(100);
        gridFormulario.setStyle("-fx-background-color: white;");

        //Criar conteudo do gridFormulario
        Label labelMultiplicando = new Label("Multiplicando");
        TextField textFieldMultiplicando = new TextField();
        Label labelMenormultiplicador = new Label("Menor multiplicador");
        TextField textFieldMenormultiplicador = new TextField();
        Label labelMaiormultiplicador = new Label("Maior multiplicador");
        TextField textFieldMaiormultiplicador = new TextField();

        //Colocar os componentes no grid
        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldMultiplicando, 1, 0);
        gridFormulario.add(labelMenormultiplicador, 0, 1);
        gridFormulario.add(textFieldMenormultiplicador, 1, 1);
        gridFormulario.add(labelMaiormultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiormultiplicador, 1, 2);

        //Criar a caixa de botões
        HBox boxBotoes = new HBox();
        boxBotoes.setPrefHeight(100);
        boxBotoes.setStyle("-fx-background-color: black;");

        //Criar os botões
        Button botaoCalcular = new Button("Calcular");
        Button botaoLimpar = new Button("Limpar");
        Button botaoSair = new Button("Sair");

        //Adcionar os botões na boxBotoes
        boxBotoes.getChildren().addAll(botaoCalcular, botaoLimpar, botaoSair);

        //Criar a caixa de resultado
        VBox boxResultados = new VBox();
        boxResultados.setPrefHeight(100);
        boxResultados.setStyle("-fx-background-color: purple;");

        //Criar os componentes da boxResultados
        Label labelResultados = new Label("Resultados");
        ListView listaTabuada = new ListView();

        //Adcionar os componentes na boxResultados
        boxResultados.getChildren().addAll(labelResultados, listaTabuada);

        //Adcionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultados);


        //Colocamos a cena no palco
        stage.setScene(scene);

        stage.show();
    }

}
