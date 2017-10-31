package test;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;
import exercicio12.*;

public class TestsEx12 {
	
	private TelaConversa telaConversa;
	private SistemaCliente sistemaCliente;
	private Usuario usuario;
	
	@Before
	public void setUp() {
		usuario = new Usuario();
		telaConversa = new TelaConversa("Obs1", usuario);
		sistemaCliente = new SistemaCliente("Obs2", usuario);
	}

	@Test
	public void testItem12() {
		System.out.println("Gerar primeiro evento\n" + 
				"---------------------");
		usuario.addObserver(telaConversa);
		usuario.addObserver(sistemaCliente);
		usuario.setMsg("Olá, como vai, Dicksiano?");
		
		System.out.println("Gerar segundo evento\n" + 
				"---------------------");
		usuario.deleteObserver(telaConversa);
		usuario.setMsg("Por aqui vai feliz Bullgods!1!");
	}
}