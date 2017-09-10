import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import cliente.BDCliente;
import cliente.Cliente;
import cliente.VerificadorCPF;
import produto.BDProduto;
import produto.Item;
import produto.ItensDeVenda;
import produto.Produto;
import produto.Servico;

public class testeNF {
	@Mock private Cliente clienteMock;
	@Mock private VerificadorCPF verificadorCPFMock;
	@Mock private BDProduto bdProdutoMock;
	@Mock private Item itemMockA;
	@Mock private Item itemMockB;
	@Mock private ItensDeVenda itensMockA;
	@Mock private ItensDeVenda itensMockB;
	@Mock private Produto produtoMock;
	@Mock private Servico servicoMock;
	private int cpf;
	private String nome;
	private BDCliente bdCliente;
	private NotaFiscal notafiscal;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ArrayList<ItensDeVenda> lista = new ArrayList<ItensDeVenda>();
		
		Mockito.when(itensMockA.getPreco()).thenReturn((float) 10.0);
		Mockito.when(itensMockB.getPreco()).thenReturn((float) 15.0);
		Mockito.when(itensMockA.getQuantidade()).thenReturn((int) 3);
		Mockito.when(itensMockB.getQuantidade()).thenReturn((int) 2);
		Mockito.when(itensMockA.getDesconto()).thenReturn((float) 0);
		Mockito.when(itensMockB.getDesconto()).thenReturn((float) 0);
		
		lista.add(itensMockA);
		try {
			notafiscal = new NotaFiscal(lista, clienteMock);
		}
		catch(excecao e) {
			e.printStackTrace();
		}

	}
	
	
	
	@Test
	public void testAdicionarItensDeVenda() throws excecao {
		Mockito.when(bdProdutoMock.existeProduto(Mockito.any())).thenReturn(true);

		notafiscal.adicionaItem(itensMockB, bdProdutoMock);
		
		assertTrue(notafiscal.contem(itensMockA));
		assertTrue(notafiscal.contem(itensMockB));
	}
	
	@Test
	public void testDeletarItensDeVenda() throws excecao {
		Mockito.when(bdProdutoMock.existeProduto(Mockito.any())).thenReturn(true);

		
		notafiscal.adicionaItem(itensMockB, bdProdutoMock);
		notafiscal.deletaItem(itensMockA);
		
		assertFalse(notafiscal.contem(itensMockA));
		assertTrue(notafiscal.contem(itensMockB));
	}
	
	@Test
	public void testValorDaNotaFiscal( ) throws excecao {
		Mockito.when(bdProdutoMock.existeProduto(Mockito.any())).thenReturn(true);

		
		assertEquals(notafiscal.getValor(), 30.00, 0.01);
		notafiscal.adicionaItem(itensMockB, bdProdutoMock);
		assertEquals(notafiscal.getValor(), 60.00, 0.01);
	}
	
	@Test
	public void testTrocaItem() throws excecao {
		Mockito.when(bdProdutoMock.existeProduto(Mockito.any())).thenReturn(true);

		
		assertTrue(notafiscal.contem(itensMockA));
		assertEquals(notafiscal.getValor(), 30, 0.01);
		notafiscal.adicionaItem(itensMockB, bdProdutoMock);
		notafiscal.deletaItem(itensMockA);
		assertTrue(notafiscal.contem(itensMockB));
		assertEquals(notafiscal.getValor(), 30, 0.01);
	}
	
	@Test(expected=excecao.class)
	public void testAdicionarProdutoSemBancoDeDados() throws excecao {
		Mockito.when(itensMockB.getItem()).thenReturn(itemMockB);
		Mockito.when(bdProdutoMock.existeProduto(itemMockB)).thenReturn(false);
	
		notafiscal.adicionaItem(itensMockB, bdProdutoMock);
	}
	
	@Test(expected=excecao.class)
	public void testListaVazia() throws excecao {
		ArrayList<ItensDeVenda> lista = new ArrayList<ItensDeVenda>();
		notafiscal = new NotaFiscal(lista, clienteMock);
	}
	
	@Test(expected=excecao.class)
	public void testRemoverUltimoItem() throws excecao {
		notafiscal.deletaItem(itensMockA);
	}
	
	
	
}
