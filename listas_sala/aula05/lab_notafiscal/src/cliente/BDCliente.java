package cliente;

public class BDCliente implements IBDCliente {
	VerificadorCPF verificaCPF;
	
	public BDCliente(VerificadorCPF verificaCPF) {
		super();
		this.verificaCPF = verificaCPF;
	}

	public Cliente getCliente(int cpf) {
		return null;
	}
	
	public void uploadCliente(int cpf, String nome) {
		
	}
	
	public boolean cadastroCliente(int cpf, String nome) {
		if (verificaCPF.verificaCPF(cpf)) {
			uploadCliente(cpf, nome);
			return true;
		}
		return false;
	}
}
