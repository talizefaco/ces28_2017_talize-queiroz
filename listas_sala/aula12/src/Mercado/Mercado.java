package Mercado;

import Infraestrutura.FakeNameService;
import Infraestrutura.IBancoDados;

public class Mercado {

		private IBancoDados banco_; 
		public Mercado(String nomebanco) {
			this.setIBanco(nomebanco);
		}

		public Mercado() {
			banco_ = this.setIBanco("Banco");
		}
		
		public int registraNovoCliente(String nome, int id) {
			Cliente cliente = Cliente.create(nome, id);
			Carrinho car = Carrinho.create();
			cliente.adicionarCarrinho(car);
			banco_.registrarCliente(cliente);
			return id;
		}

		public void adicionaProduto(int idCliente, int idProduto) {
			Cliente cliente = banco_.selectCliente(idCliente);
			Produto produto = banco_.selectProduto(idProduto);
			cliente.getCarrinho().adicionar(produto);
		}

		public void processarPagamento(int idCliente) {
			Cliente cliente = banco_.selectCliente(idCliente);
			double valor = cliente.getCarrinho().getTotal();
			banco_.processarPagamento(cliente, valor);
		}

		public IBancoDados setIBanco(String nomebanco) {
			FakeNameService NS = FakeNameService.getInstance();
			this.banco_ = (IBancoDados) NS.get(nomebanco);
			return banco_;
		}
		
	}//Mercado


