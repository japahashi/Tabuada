package br.senai.sp.jandira.tabuada.gui;

import br.senai.sp.jandira.tabuada.model.TabuadaApp;
import javafx.application.Application;
import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TelaTabuada extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    //Definir o tamanho da tela
        //stage.setWidth(500);
        //stage.setHeight(500);
        stage.setTitle("Tabuada");
        stage.setResizable(false);

        //Criar root - componente de leitura principal
        VBox root = new VBox();
        root.setStyle("-fx-background-color: pink;");

        //Criamos a cena e root nela
        Scene scene = new Scene(root);

        //Criar o header da tela
        VBox header = new VBox();
        //header.setPrefHeight(100);
        header.setStyle("-fx-background-color: orange;");

        //Colocar o conteudo do header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setPadding(new Insets(15, 0, 0,15));
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 30;fx-font-weight: bold;");

        Label labelSubtitulo = new Label("Crie a tabuada que a sua imaginação mandar!!!");
        labelSubtitulo.setPadding(new Insets(0, 0, 15,10));
        labelSubtitulo.setStyle("-fx-text-fill: white;-fx-font-weight: bold;");


        //Colocar os labels do header
        header.getChildren().addAll(labelTitulo, labelSubtitulo);

        //Criar grid de formulario
        GridPane gridFormulario = new GridPane();
        gridFormulario.setVgap(10);
        gridFormulario.setHgap(10);
        gridFormulario.setPadding(new Insets(10, 0, 10, 3));
        //gridFormulario.setPrefHeight(100);
        //gridFormulario.setStyle("-fx-background-color: white;");


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
        boxBotoes.setSpacing(10);
        boxBotoes.setPadding(new Insets(0, 0, 10, 10));
        Pane paneButtons = new Pane();
        paneButtons.setPadding(new Insets(0, 0, 0, 10));
        //boxBotoes.setPrefHeight(100);
        //boxBotoes.setStyle("-fx-background-color: black;");
        paneButtons.getChildren().add(boxBotoes);

        //Criar os botões
        Button botaoCalcular = new Button("Calcular");
        Button botaoLimpar = new Button("Limpar");
        Button botaoSair = new Button("Sair");

        //Adcionar os botões na boxBotoes
        boxBotoes.getChildren().addAll(botaoCalcular, botaoLimpar, botaoSair);

        //Criar a caixa de resultado
        VBox boxResultados = new VBox();
        boxResultados.setPrefHeight(300);
        //boxResultados.setStyle("-fx-background-color: purple;");

        //Criar os componentes da boxResultados
        Label labelResultados = new Label("Resultados");
        labelResultados.setPadding(new Insets(15, 0, 0, 15));
        labelResultados.setStyle("-fx-text-fill-color: orange;-fx-font-size: 20;");
        ListView listaTabuada = new ListView();
        listaTabuada.setPadding(new Insets(8));

        //Adcionar os componentes na boxResultados
        boxResultados.getChildren().addAll(labelResultados, listaTabuada);

        //Adcionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(paneButtons);
        root.getChildren().add(boxResultados);


        //Colocamos a cena no palco
        stage.setScene(scene);

        stage.show();

        botaoCalcular.setOnAction(event -> {
            TabuadaApp tabuada = new TabuadaApp();

            tabuada.multiplicando =
                    //Convertendo String em int
                    Integer.parseInt(textFieldMultiplicando.getText());

            tabuada.multiplicadorInicial =
                    Integer.parseInt(textFieldMenormultiplicador.getText());

            tabuada.multiplicadorFinal =
                    Integer.parseInt(textFieldMaiormultiplicador.getText());

            String[] resultados = tabuada.calcularTabuada();
            listaTabuada.getItems().addAll(resultados);

            //Gravar os dados de tabuada em arquivo
            Path arquivo = Path.of("c:\\Users\\25203688\\DS1T\\tabuada\\dados_tabuada.csv");
            String dados = textFieldMultiplicando.getText() + ";" + textFieldMenormultiplicador.getText() + ";" + textFieldMaiormultiplicador.getText() + ";" + LocalDateTime.now() + "\n";
            try{
                //Testar o codigo pra ver se da erro
                Files.writeString(arquivo, dados, StandardOpenOption.APPEND);
            } catch (IOException erro) {
                System.out.println(erro.getMessage());
            }


        });

        botaoLimpar.setOnAction(event1 -> {
            listaTabuada.getItems().clear();
            textFieldMaiormultiplicador.clear();
            textFieldMultiplicando.clear();
            textFieldMenormultiplicador.clear();
            textFieldMultiplicando.requestFocus();

        });

        botaoSair.setOnAction(event1 -> {
            System.exit(0);
        });
    }

}
