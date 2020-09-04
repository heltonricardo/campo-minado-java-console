package io.github.heltonricardo.cm;

import io.github.heltonricardo.cm.modelo.Tabuleiro;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		tabuleiro.abrir(3, 3);
		tabuleiro.AlterarMarcacao(4, 4);
		tabuleiro.AlterarMarcacao(4, 5);
		
		System.out.println(tabuleiro);
	}
}
