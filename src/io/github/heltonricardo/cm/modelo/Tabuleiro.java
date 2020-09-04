package io.github.heltonricardo.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<Campo>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}

	private void gerarCampos() {
		for (int i = 0; i < linhas; ++i)
			for (int j = 0; j < colunas; ++j)
				campos.add(new Campo(i, j));
		
	}

	private void associarVizinhos() {
		for (Campo c1: campos)
			for (Campo c2: campos)
				c1.adicionarVizinho(c2);
	}

	private void sortearMinas() {
		Random rnd = new Random();
		int minadas = 0;
		int max = linhas * colunas;
		int num;
		
		while (minadas < minas) {
			num = rnd.nextInt(max);
			if (!campos.get(num).isMinado()) {
				campos.get(num).minar();
				++minadas;
			}
		}
	}
	
	public boolean objetivoAlcancado() {
		return campos.parallelStream().allMatch(c -> c.objetivoAlcancado());
	}
	
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}
	
	public void abrir(int linha, int coluna) {
		if (0 <= linha && linha < linhas && 0 <= coluna && coluna < colunas)
			campos.get(linha * colunas + coluna).abrir();
	}
	
	public void AlterarMarcacao(int linha, int coluna) {
		if (0 <= linha && linha < linhas && 0 <= coluna && coluna < colunas)
			campos.get(linha * colunas + coluna).alternarMarcacao();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < linhas; ++i) {
			for (int j = 0; j < colunas; ++j) {
				sb.append(" ");
				sb.append(campos.get(i * colunas + j));
				sb.append(" ");
			}
			sb.append("\n");
		}
				
		return sb.toString();
	}
	
	
}