import cliente.*;
import produto.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class testeCadastro {
	
	@Mock private Cliente clienteMock;
	@Mock private VerificadorCPF verificadorCPFMock;
	@Mock private BDProduto bdProdutoMock;
	@Mock private Item itemMock;
	@Mock private ItensDeVenda itensMock;
	@Mock private Produto produtoMock;
	@Mock private Servico servicoMock;
	private int cpf;
	private String nome;
	private BDCliente bdCliente;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		cpf = 123456789;
		nome = "Dicklindobulldogs";
		bdCliente = new BDCliente(verificadorCPFMock);
		
	}
	
	
	@Test
	public void testeCadastroClienteTrue() {
		Mockito.when(verificadorCPFMock.verificaCPF(cpf)).thenReturn(true);
	
		bdCliente.cadastroCliente(cpf, nome);
		
		Mockito.verify(verificadorCPFMock, Mockito.times(1)).verificaCPF(cpf);
	}
	
	@Test
	public void testeCadastroClienteFalse() {
		Mockito.when(verificadorCPFMock.verificaCPF(cpf)).thenReturn(false);
	
		bdCliente.cadastroCliente(cpf, nome);
		
		Mockito.verify(verificadorCPFMock, Mockito.times(1)).verificaCPF(cpf);
	}
}
