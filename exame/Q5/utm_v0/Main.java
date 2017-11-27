import presenter.Presenter;
import view.GCSConcrete;
import view.IGCS;

public class Main {

	public static void main(String[] args) {
		Presenter p = new Presenter();
		IGCS v1 = new GCSConcrete();
		IGCS v2 = new GCSConcrete();
		IGCS v3 = new GCSConcrete();
		System.out.println("\nPrint relativo a v1:");
		v1.init(p);
		v1.recebeMapa();
		System.out.println("\nPrint relativo a v2:");
		v2.init(p);
		v2.recebeMapa();
		System.out.println("\nPrint relativo a v3:");
		v3.init(p);
		v3.recebeMapa();
	}

}
