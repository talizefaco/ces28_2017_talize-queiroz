package model;

public class ARPConcrete implements IARP {
	private String _status = "posicao do drone respectivo:";
	
	@Override
	public String selfstatus() {
		return _status;
	}
	// Funcao para auxiliar na demonstracao da questao na main
	public void setstatus(String st) {
		_status = st;
	}

}
