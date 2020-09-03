package io.github.heltonricardo.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.heltonricardo.cm.excecao.ExplosaoException;

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
			() -> assertTrue(campo.adicionarVizinho(new Campo(5, 4)))
		);
	}
	
	@Test
	void testeNaoVizinhos() {
		assertAll(
			() -> assertFalse(campo.adicionarVizinho(new Campo(3, 3))),
			() -> assertFalse(campo.adicionarVizinho(new Campo(3, 4))),
			() -> assertFalse(campo.adicionarVizinho(new Campo(3, 5))),
			() -> assertFalse(campo.adicionarVizinho(new Campo(4, 3))),
			() -> assertFalse(campo.adicionarVizinho(new Campo(5, 3)))
		);
	}
	
	@Test
	void testeMarcacao() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDual() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> campo.abrir());
	}
	
	@Test
	void testeAbrirComVizinhos() {
		Campo campo44 = new Campo(4, 4);
		Campo campo33 = new Campo(3, 3);
		Campo campo22 = new Campo(2, 2);
		
		campo22.minar();
		
		campo.adicionarVizinho(campo44);
		campo44.adicionarVizinho(campo33);
		campo33.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertAll(
			() -> assertTrue(campo.isAberto()),
			() -> assertTrue(campo44.isAberto()),
			() -> assertTrue(campo33.isAberto()),
			() -> assertFalse(campo22.isAberto())
		);
	}
}
