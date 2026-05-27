package org.example;

public class Divisao implements InterpretadorExpressao {
    private double x; private double y;
    public Divisao (Numero esq, Numero dir) { x = esq.getNumero(); y = dir.getNumero(); }
    public double interpretar() { return x / y; }
}
