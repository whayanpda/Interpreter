package org.example;

public class RegrasCombate {
    public static String formulaDano = "ataque * 1.5 + bonus";

    public static double calcularDanoFinal(double ataque, double bonus) {
        String expressao = formulaDano.replace("ataque", Double.toString(ataque));
        expressao = expressao.replace("bonus", Double.toString(bonus));

        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }
}
