package produtoservico;

import java.util.ArrayList;

import bd.FacadeBDProdutoServico;
import imposto.CategoriaTributaria;
import imposto.Imposto;
import net.bytebuddy.asm.Advice.This;
import nota_fiscal.ItemDeVenda;
import nota_fiscal.NFFinal;
import nota_fiscal.ValidadorNotaFiscal;

public abstract class ProdutoServico {
	private final String _nome;
	private final float _preco;
	private final CategoriaTributaria _categTribut;
	private final ArrayList<ProdutoServico> child;
	
	public ProdutoServico(String nome, float preco, CategoriaTributaria categTrib) {
		this._nome = nome;
		this._preco = preco;
		this._categTribut = categTrib;
		child = new ArrayList<ProdutoServico>();
	}
	
	public boolean equals(Object anObject) {
		if (!(anObject instanceof ProdutoServico))
			return false;
		ProdutoServico outroItem = (ProdutoServico) anObject;
		
		return _nome.equals(outroItem.getNome());
	}
	
	public String getNome() {
		return this._nome;
	}
	
	public float getPreco() {
		return this._preco;
	}
	
	public void adicionar(String nomePS) {
		this.child.add(FacadeBDProdutoServico.getInstance().getPS(nomePS));
	}
	
	public CategoriaTributaria getCategoriaTributaria() {
		return this._categTribut;
	}
	
	public void accept(Imposto v) {
		
		v.visit(this);
		
		if(child != null) {
			for(ProdutoServico ps : child) {
				ps.accept(v);
			}
		}
	}

	public void accept(ValidadorNotaFiscal v) {
		v.visit(this);
		if(this.child != null) {
			for(ProdutoServico ps : child) {
				ps.accept(v);
			}
		}
	}
	
	public void accept(NFFinal v) {
		v.visit(this);
		
		if(child != null) {
			for(ProdutoServico ps : child) {
				ps.accept(v);
			}
		}
	}
}
