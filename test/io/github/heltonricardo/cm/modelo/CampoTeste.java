package io.github.heltonricardo.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {

	private Campo campo;
	
	// O @BeforeEach é executado antes de cada função a ser testada
	@BeforeEach
	void inicializar() {
		 campo = new Campo(5, 5);
	}
	
	// O @Test deve ser informado para que essa função seja testada
	@Test
	void testeVizinhoReal() {
		// O assertAll exibe informações detalhadas de cada teste dentro dele
		assertAll(
				() -> assertTrue(campo.adicionarVizinho(new Campo(4, 4))),
				() -> assertTrue(campo.adicionarVizinho(new Campo(4, 5))),
				() -> assertTrue(campo.adicionarVizinho(new Campo(4, 6))),
				() -> assertTrue(campo.adicionarVizinho(new Campo(5, 4))),
				() -> assertTrue(campo.adicionarVizinho(new Campo(5, 6))),
				() -> assertTrue(campo.adicionarVizinho(new Campo(6, 4))),
				() -> assertTrue(campo.adicionarVizinho(new Campo(6, 5))),
				() -> assertTrue(campo.adicionarVizinho(new Campo(6, 6)))
		);
	}
	
	
}
