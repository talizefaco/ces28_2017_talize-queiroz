package imposto;

public abstract class IData {
	protected float valorTotal;
	
	protected IData() {
		this.valorTotal = 0;
	}
	
	protected void update(float valor) {
		this.valorTotal += valor;
	}
	
	protected float getValor() {
		return this.valorTotal;
	}
}
