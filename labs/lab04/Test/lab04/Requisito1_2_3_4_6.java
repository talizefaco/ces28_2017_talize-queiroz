package lab04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import bd.BDImposto;
import bd.BDNotaFiscal;
import bd.BDProdutoServico;
import bd.FacadeBDImposto;
import bd.FacadeBDNotaFiscal;
import bd.FacadeBDProdutoServico;
import imposto.CategoriaTributaria;
import imposto.Imposto;
import imposto.ImpostoCidade;
import imposto.ImpostoEstado;
import nota_fiscal.NotaFiscal;
import nota_fiscal.ValidadorNotaFiscal;
import produtoservico.Produto;
import produtoservico.ProdutoServico;
import nota_fiscal.ItemDeVenda;
import nota_fiscal.NFFinal;
import nota_fiscal.NFNaoFinalizada;
import nota_fiscal.NFNaoFinalizada.NFBuilder;

public class Requisito1_2_3_4_6 {
	
	public ExpectedException excecao = ExpectedException.none();
	
	private BDImposto bdimp = Mockito.mock(BDImposto.class);
	private BDNotaFiscal bdnf = Mockito.mock(BDNotaFiscal.class);
	private BDProdutoServico bdps = Mockito.mock(BDProdutoServico.class);
	
	private FacadeBDImposto facadeimp= FacadeBDImposto.getInstance(bdimp);
	private FacadeBDNotaFiscal facadenf= FacadeBDNotaFiscal.getInstance(bdnf);;
	private FacadeBDProdutoServico facadep= FacadeBDProdutoServico.getInstance(bdps);
	
	private ImpostoCidade impCidade;
	private ImpostoEstado impEstado;
	private List<Imposto> impostos;
	
	private ProdutoServico bulldog;
	private ProdutoServico camisapreta;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		/*facadeimp = FacadeBDImposto.getInstance(bdimp);
		facadenf = FacadeBDNotaFiscal.getInstance(bdnf);
		facadeps = FacadeBDProdutoServico.getInstance(bdps);*/
		
		//ProdutoServico
		bulldog = new Produto("Bulldog", 500.0f, CategoriaTributaria.COMIDA, "� muito fofo!");
		Mockito.when(bdps.createPS("Bulldog")).thenReturn(bulldog);
		
		camisapreta = new Produto("Camisa Preta", 50.0f, CategoriaTributaria.ROUPA, "Roupa boa!");
		Mockito.when(bdps.createPS("Camisa Preta")).thenReturn(camisapreta);
		
		impCidade = new ImpostoCidade();
		impEstado = new ImpostoEstado();
		impostos = new ArrayList<Imposto>();
		impostos.add(impCidade);
		impostos.add(impEstado);
		Mockito.when(bdimp.getImposto(CategoriaTributaria.COMIDA)).thenReturn(impostos);
}

	@Test // Requisito 1
	public void testCriarNotaFiscalVazia() {
		excecao.expect(Exception.class);
		NotaFiscal nf = new NFBuilder().build();
	}
	
	@Test // Requisito 2, Requisito 3 e Requisito 4
	public void testCriarIVnaNF() {
		// Os IVs s� s�o criados por uma NF.
			// Criados na constru��o da NF:
		NFNaoFinalizada nf = new NFBuilder().adicionarItem(3, "Bulldog").build();
			// Adicionados ap�s a cria��o de uma NF:
		nf.addItemDeVenda(2, "Camisa Preta");
		// S� � requisitado ao BD:PS a cria��o de um PS quando este � relacionado
		// a um IV ou quando este � adicionado como "filho" de um PS
		// Al�m disso, cada IV s� possui 1 PS e n�o existem m�todos para adicionar ou substituir este
	}
	
	@Test // Requisito 6
	public void validacaoDeUmaNF() {
		NFNaoFinalizada nf = new NFBuilder().adicionarItem(3, "Bulldog").build();
		ValidadorNotaFiscal validador = ValidadorNotaFiscal.getInstance();
		
		//NFNaoFinalizada ainda n�o armazenada no BDNF, ent�o validar => true
		Mockito.when(bdnf.validar(nf)).thenReturn(true);
		
		NFFinal nfvalidada = validador.validarNotaFiscal(nf);
		// � imut�vel pois os atributos s�o final e a lista recebida com o getListaItemDeVenda() � um clone de 
		// Collections.Immutable(), logo n�o � poss�vel nem modificar a lista apontada e nem modificar os itens
		// da lista.
		assertNotNull(nfvalidada);
		//Caso fosse passado a mesma NFNaoFinalizada para o BDNF, ele retornaria false
		Mockito.when(bdnf.validar(nf)).thenReturn(false);
		
		excecao.expect(Exception.class);
		NFFinal nfvalidada2 = validador.validarNotaFiscal(nf);
		assertNull(nfvalidada2);
	}
}
