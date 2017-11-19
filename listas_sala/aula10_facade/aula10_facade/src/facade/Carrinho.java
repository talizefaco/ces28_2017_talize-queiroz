package facade;	

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Carrinho {
	List<Produto> listaDeCompras;
	private Carrinho() {
		listaDeCompras = new ArrayList<>();
	}
	public static Carrinho create() {
		return new Carrinho();
	}
	public void adicionar(Produto p) {
		listaDeCompras.add(p);
	}
	public double getTotal() {
		double total = 0;
		for (Iterator<Produto> p = listaDeCompras.iterator(); p.hasNext();) {
			Produto produto = (Produto) p.next();
			System.out.println("Valor do item: " + produto.getPreco());
			total += produto.getPreco();
		}
		return total;
	}
}
