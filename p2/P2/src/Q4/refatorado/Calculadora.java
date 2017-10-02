package Q4.refatorado;

public class Calculadora {
	private String _conteudo;
	public Calculadora(RelatorioDespesas relaDesp) {
		String conteudo = "Relatório de Despesas";
		conteudo+=("\n Total das despesas:" + relaDesp.getTotalDespesa());
		this._conteudo = conteudo;
	}
	public String getConteudo() {
		return this._conteudo;
	}
	
}
