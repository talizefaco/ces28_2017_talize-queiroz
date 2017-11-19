package facade;

public class Facade {
	MercadoVirtual mercado;
	public Facade() {
		mercado = mercado.getMercado();
	}
	
	public void addProduto(int idproduto) {
		mercado.addProduto(idproduto);
	}
	
	public void fecharCompra() {
		mercado.fecharCompra();
	}
	
	public void registrarCliente(String nome, int id) {
		mercado.registrarCliente(nome, id);
	}

}
