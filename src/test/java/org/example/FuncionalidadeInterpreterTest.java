package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionalidadeInterpreterTest {
    private static final double MARGEM_ERRO = 0.0001;

    @AfterEach
    void restaurarFormulaPadrao() {
        RegrasCombate.formulaDano = "ataque * 1.5 + bonus";
    }

    @Test
    void deveInterpretarOperacoesAritmeticasEmSequencia() {
        InterpretadorExpressao interpretador =
                new InterpretadorExpressoesAritmeticas("10 + 5 - 3 * 2 / 4");

        assertEquals(6.0, interpretador.interpretar(), MARGEM_ERRO);
    }

    @Test
    void deveCalcularDanoFinalComFormulaPadrao() {
        double dano = RegrasCombate.calcularDanoFinal(10.0, 2.0);

        assertEquals(17.0, dano, MARGEM_ERRO);
    }

    @Test
    void personagemDeveCausarDanoComPontosDeAtaqueEBonusDaArma() {
        Personagem personagem = new Personagem();
        personagem.setPontosAtaque(8.0);
        personagem.setBonusArma(3.0);

        assertEquals(15.0, personagem.causarDano(), MARGEM_ERRO);
    }

    @Test
    void devePermitirAlterarFormulaDeDano() {
        RegrasCombate.formulaDano = "ataque * 2 + bonus";

        assertEquals(22.0, RegrasCombate.calcularDanoFinal(10.0, 2.0), MARGEM_ERRO);
    }
}
