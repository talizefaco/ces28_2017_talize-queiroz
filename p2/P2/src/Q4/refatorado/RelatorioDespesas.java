package Q4.refatorado;

import java.util.Iterator;

public class RelatorioDespesas {

	private float _totalDespesa;
	public RelatorioDespesas(Iterator<Despesa> despesas) {
		float totalDespesa = 0.0f;
		while (despesas.hasNext()) {
			Despesa desp = despesas.next();
			float despesa = desp.getDespesa();
			totalDespesa+= despesa;
			
		}
		this._totalDespesa = totalDespesa;
	}
	
	public float getTotalDespesa() {
		return this._totalDespesa;
	}

}