package org.example;

public class Multiplicacao implements InterpretadorExpressao {
    private double x; private double y;
    public Multiplicacao (Numero esq, Numero dir) { x = esq.getNumero(); y = dir.getNumero(); }
    public double interpretar() { return x * y; }
}
