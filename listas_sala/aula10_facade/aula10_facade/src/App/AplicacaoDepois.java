package App;

import facade.Facade;

public class AplicacaoDepois {
	public static void main(String[] args) {
		Facade sistema = new Facade();
		sistema.registrarCliente("Didi Bulldogs", 666);
		sistema.addProduto(223);
		sistema.addProduto(342);
		sistema.fecharCompra();
	}	
}
