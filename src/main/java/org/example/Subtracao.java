package org.example;

public class Subtracao implements InterpretadorExpressao {
    private double x; private double y;
    public Subtracao (Numero esq, Numero dir) { x = esq.getNumero(); y = dir.getNumero(); }
    public double interpretar() { return x - y; }
}
