package io.github.heltonricardo.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import io.github.heltonricardo.cm.excecao.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;
	
	private boolean aberto;
	private boolean minado;
	private boolean marcado;
	
	private List<Campo> vizinhos = new ArrayList<Campo>();
	
	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		int d = (int) (Math.sqrt(Math.pow(linha - vizinho.linha, 2) + 
				       Math.pow(coluna - vizinho.coluna, 2)));
		if (d == 1) {
			vizinhos.add(vizinho);
			return true;
		}
		return false;
	}
	
	void alternarMarcacao() {
		if (!aberto)
			marcado = !marcado;
	}
	
	boolean abrir() {
		if (aberto || marcado)
			return false;
		
		aberto = true;
		
		if (minado)
			throw new ExplosaoException();
		
		if (vizinhancaSegura())
			vizinhos.forEach(v -> v.abrir());
		
		return true;
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
}
