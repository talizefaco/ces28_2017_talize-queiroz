package imposto;

public class IDataEstado extends IData {
	private static IDataEstado idata = null;
	
	public IDataEstado() {
		
	}

	public static IDataEstado getInstance() {
		if(idata == null) {
			idata = new IDataEstado();
		}
		return idata;
	}
}
