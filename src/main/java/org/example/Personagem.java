package org.example;

public class Personagem {
    private double pontosAtaque;
    private double bonusArma;

    public double getPontosAtaque() { return pontosAtaque; }
    public void setPontosAtaque(double pontosAtaque) { this.pontosAtaque = pontosAtaque; }

    public double getBonusArma() { return bonusArma; }
    public void setBonusArma(double bonusArma) { this.bonusArma = bonusArma; }

    public double causarDano() {
        return RegrasCombate.calcularDanoFinal(this.pontosAtaque, this.bonusArma);
    }
}