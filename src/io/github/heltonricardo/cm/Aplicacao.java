package io.github.heltonricardo.cm;

import io.github.heltonricardo.cm.modelo.Tabuleiro;
import io.github.heltonricardo.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);
	}
}
