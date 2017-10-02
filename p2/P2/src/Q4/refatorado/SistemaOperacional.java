package Q4.refatorado;

public class SistemaOperacional {
	
	public Impressora getDriverImpressao() {
		return new Impressora();
	}
	
	public void SolicitaImpressao(Calculadora calculadora) {
		Impressora impressora = this.getDriverImpressao();
		impressora.Imprimir(calculadora.getConteudo());
		
	}
}
