package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpretadorExpressoesAritmeticas implements InterpretadorExpressao {
    private InterpretadorExpressao interpretadorInicial;

    public InterpretadorExpressoesAritmeticas(String contexto) {
        Stack<InterpretadorExpressao> pilha = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.matches("\\d+(\\.\\d*)?")) {
                pilha.push(new Numero(Double.parseDouble(elemento)));
            } else if (elemento.equals("+") || elemento.equals("-") || elemento.equals("*") || elemento.equals("/")) {
                if (!iterator.hasNext()) throw new IllegalArgumentException("Expressão inválida");

                Numero elementoEsquerda = (Numero) pilha.pop();
                Numero elementoDireita = new Numero(Double.parseDouble(iterator.next()));

                switch (elemento) {
                    case "+": pilha.push(new Numero(new Adicao(elementoEsquerda, elementoDireita).interpretar())); break;
                    case "-": pilha.push(new Numero(new Subtracao(elementoEsquerda, elementoDireita).interpretar())); break;
                    case "*": pilha.push(new Numero(new Multiplicacao(elementoEsquerda, elementoDireita).interpretar())); break;
                    case "/": pilha.push(new Numero(new Divisao(elementoEsquerda, elementoDireita).interpretar())); break;
                }
            } else {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }
        interpretadorInicial = pilha.pop();
    }

    public double interpretar() { return interpretadorInicial.interpretar(); }
}