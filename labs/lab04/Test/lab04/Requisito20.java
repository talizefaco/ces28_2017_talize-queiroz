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

public class Requisito20 {
	
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
	private ProdutoServico racao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		/*facadeimp = FacadeBDImposto.getInstance(bdimp);
		facadenf = FacadeBDNotaFiscal.getInstance(bdnf);
		facadeps = FacadeBDProdutoServico.getInstance(bdps);*/
		
		//ProdutoServico
		bulldog = new Produto("Bulldog", 500.0f, CategoriaTributaria.COMIDA, "É muito fofo!");
		Mockito.when(bdps.createPS("Bulldog")).thenReturn(bulldog);
		
		racao = new Produto("Racao", 100.0f, CategoriaTributaria.COMIDA, "Comida!");
		Mockito.when(bdps.createPS("Racao")).thenReturn(racao);
		bulldog.adicionar("Racao");
		
		camisapreta = new Produto("Camisa Preta", 50.0f, CategoriaTributaria.ROUPA, "Roupa boa!");
		Mockito.when(bdps.createPS("Camisa Preta")).thenReturn(camisapreta);
		
		impCidade = new ImpostoCidade();
		impEstado = new ImpostoEstado();
		impostos = new ArrayList<Imposto>();
		impostos.add(impCidade);
		impostos.add(impEstado);
		Mockito.when(bdimp.getImposto(CategoriaTributaria.COMIDA)).thenReturn(impostos);
		Mockito.when(bdimp.getImposto(CategoriaTributaria.ROUPA)).thenReturn(impostos);
		
		Mockito.when(bdimp.getAliquota(Mockito.any())).thenReturn(0.1f);
}
	
	@Test // Requisito 20
	public void addParametroOutros() {
		NFNaoFinalizada nf = new NFBuilder().adicionarItem(3, "Bulldog").addOutros(new String("Outros")).build();
		
		assertEquals("Outros", nf.getOutros());
		
		Mockito.when(bdnf.validar(nf)).thenReturn(true);
		Mockito.when(bdnf.gerarProxID()).thenReturn(1);
		
		ValidadorNotaFiscal validador = ValidadorNotaFiscal.getInstance();
		
		NFFinal nfvalidada = validador.validarNotaFiscal(nf);
		assertEquals("Outros", nfvalidada.getOutros());
	}
}
