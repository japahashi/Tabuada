package br.senai.sp.jandira.tabuada.model;

import java.util.Scanner;

public class TabuadaApp {

    public int multiplicando;
    public int multiplicadorInicial;
    public int multiplicadorFinal;
    public String[] tabuada;

    public  void coletarDados(){
        Scanner leitor = new Scanner(System.in);

        System.out.print("Qual é o valor do multiplicando: ");
        multiplicando = leitor.nextInt();

        System.out.print("Qual é o valor do multiplicador inicial: ");
        multiplicadorInicial = leitor.nextInt();

        System.out.print("Qual é o valor do multiplicador final: ");
        multiplicadorFinal = leitor.nextInt();

        calcularTabuada();
    }
    public String[] calcularTabuada(){
        int apoio = 0;
        if(multiplicadorFinal < multiplicadorInicial){
            apoio = multiplicadorFinal;
            multiplicadorFinal = multiplicadorInicial;
            multiplicadorInicial = apoio;
        }
        int tamanho = multiplicadorFinal - multiplicadorInicial + 1;
        tabuada = new String[tamanho];

        int i = 0;
        while (i < tamanho){
            int produto = multiplicando * multiplicadorInicial;
            tabuada[i] = multiplicando + " x " + multiplicadorInicial + " = " + produto;
            multiplicadorInicial = multiplicadorInicial + 1;
            i = i + 1;
        }
        return tabuada;
        //exibirTabuada();
    }
    public void exibirTabuada(){
        System.out.println("Resultado da sua tabuada:");

        int i = 0;
        while (i < tabuada.length){
            System.out.println(tabuada[i]);
            i++;
        }
    }
}







