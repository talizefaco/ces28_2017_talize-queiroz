package facade;

public class MercadoVirtual {
	private Cliente cliente;
	private Carrinho carrinho;
	private BancoDeDados bd;
	private static MercadoVirtual mercado = new MercadoVirtual();
	
	private MercadoVirtual() {
		bd = new BancoDeDados();
	}
	
	public void addProduto(int idproduto) {
		Produto produto = bd.selectProduto(idproduto);
		carrinho.adicionar(produto);
	}
	
	public void fecharCompra() {
		double valor = carrinho.getTotal();
		bd.processarPagamento(cliente, valor);
	}
	
	public void registrarCliente(String nome, int id) {
		cliente = Cliente.create(nome, id);
		carrinho = Carrinho.create();
		cliente.adicionarCarrinho(carrinho);
		bd.registrarCliente(cliente);
	}
	
	static public MercadoVirtual getMercado() {
		return mercado;
	}
}
