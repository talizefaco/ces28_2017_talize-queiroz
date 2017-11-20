package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercicio11.*;

public class TestsEx11 {
	
	private TelaConversa obs1;
	private SistemaCliente obs2;
	private Usuario sub;
	
	@Before
	public void setUp() {
		sub = new Usuario();
		obs1 = new TelaConversa("Obs1", sub);
		obs2 = new SistemaCliente("Obs2", sub);
	}

	@Test
	public void testItem11() {
		System.out.println("Gerar primeiro evento\n" + 
				"---------------------");
		sub.add(obs1);
		sub.add(obs2);
		sub.setMsg("Olá, como vai, Dicksiano?");
		
		System.out.println("Gerar segundo evento\n" + 
				"---------------------");
		sub.remove(obs1);
		sub.setMsg("Por aqui vai feliz Bullgods!1!");
	}
}
