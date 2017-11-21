package imposto;

public class IDataCidade extends IData {
	private static IDataCidade idata = null;
	
	public IDataCidade() {
		
	}

	public static IDataCidade getInstance() {
		if(idata == null) {
			idata = new IDataCidade();
		}
		return idata;
	}
}
