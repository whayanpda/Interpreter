package org.example;

public class Adicao implements InterpretadorExpressao {
    private double x; private double y;
    public Adicao (Numero esq, Numero dir) { x = esq.getNumero(); y = dir.getNumero(); }
    public double interpretar() { return x + y; }
}
