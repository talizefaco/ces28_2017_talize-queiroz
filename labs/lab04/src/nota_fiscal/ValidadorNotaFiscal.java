package nota_fiscal;

import java.util.HashMap;
import java.util.List;

import bd.BDNotaFiscal;
import bd.FacadeBDImposto;
import bd.FacadeBDNotaFiscal;
import imposto.Imposto;
import nota_fiscal.NFFinal.NFFinalBuilder;
import produtoservico.ProdutoServico;

/*
 * Classe que valida uma nota fiscal e gera a nota fiscal finalizada.
 */
public class ValidadorNotaFiscal {
	private static FacadeBDNotaFiscal bdnf;
	private static FacadeBDImposto bdimposto;
	private float precoSemImpostoAux;
	private static ValidadorNotaFiscal validador;
	private HashMap<Imposto, Float> mapaImposto;

	private ValidadorNotaFiscal() {
		bdnf = FacadeBDNotaFiscal.getInstance();
		bdimposto = FacadeBDImposto.getInstance();
	}
	
	public static ValidadorNotaFiscal getInstance() {
		if(validador == null) {
			validador = new ValidadorNotaFiscal();
		}
		return validador;
	}
	
	private float calcularPreco(List<ItemDeVenda> itens) {
		float total = 0;
		for (ItemDeVenda item : itens) {
			precoSemImpostoAux = 0;
			ProdutoServico ps = item.getProdutoServico();
			ps.accept(this);
			item.setValor(this.precoSemImpostoAux);
			total += item.getQuantidade() * precoSemImpostoAux;
		}
		return total;
	}
	
	private float calcularImposto(List<ItemDeVenda> itens) {
		float total = 0;
		for(ItemDeVenda e : itens) {
			ProdutoServico ps = e.getProdutoServico();
			List<Imposto> impostos = bdimposto.getImposto(ps.getCategoriaTributaria());
			for(Imposto i : impostos) {
				float valorImposto = i.getImposto(itens, e);
				if(!this.mapaImposto.containsKey(i)) {			
					mapaImposto.put(i, valorImposto);
				} else {
					mapaImposto.put(i, mapaImposto.get(i) + valorImposto);
				}
				total += valorImposto;
			}
		}
		return total;
	}
	
	public void visit(ProdutoServico ps) {
		precoSemImpostoAux += ps.getPreco();
	}
	
	public NFFinal validarNotaFiscal(NFNaoFinalizada notafiscal) {
		/*if() { // Checar no BD Produtos a partir do Facade de BD Produtos
			// gerar ID a partir do Facade de BD NF
			
			// calcula impostos e adiciona na nota final
			
			return new NFFinal(nFNaoFinalizada, ID); // Adiciona no BD NF a partir do Facade de BD NF
		} else {
			// Exception
		}
		*/
		int ID = 0;
		float valor = 0;
		this.mapaImposto = new HashMap<Imposto, Float>();
		List<ItemDeVenda> itens = notafiscal.getListaItemDeVenda();
		NFFinal nf = null;
		try {
			if (bdnf.validar(notafiscal)) {
				valor += this.calcularPreco(itens);
				valor += this.calcularImposto(itens);
				
				ID = bdnf.gerarProxID();
				nf = new NFFinalBuilder(itens, ID).setValor(valor).setMapaImposto(mapaImposto).setOutros(notafiscal.getOutros()).build();
			}
			else {
				throw new Exception ("NF não válida pelo bancodedados.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nf;
	}
	
}
