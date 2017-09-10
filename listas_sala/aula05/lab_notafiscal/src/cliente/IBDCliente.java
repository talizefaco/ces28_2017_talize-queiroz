package cliente;

public interface IBDCliente {
	public Cliente getCliente(int cpf);
	
	public void uploadCliente(int cpf, String nome);
	
	public boolean cadastroCliente(int cpf, String nome);
}
