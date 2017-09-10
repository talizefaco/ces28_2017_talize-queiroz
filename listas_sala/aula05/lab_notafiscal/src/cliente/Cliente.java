package cliente;
public class Cliente {
	private int _CPF;
	private String _nome;
	
	Cliente(int cpf, String nome) {
		this._CPF = cpf;
		this._nome = nome;
	}
	
	public int getCPF() {
		return this._CPF;
	}
	
	public String getNome() {
		return this._nome;
	}
}