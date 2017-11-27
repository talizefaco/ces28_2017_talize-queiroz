package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.IARP;
import presenter.Presenter;
import view.GCSConcrete;;

public class TesteGCS {
	
	private GCSConcrete gcs;
	@Mock private IARP arpMock;
	Presenter p;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		gcs = new GCSConcrete();
		p = new Presenter();
	}
	
	@Test
	public void testaConstrucaoGCS() {
		assertNotNull(gcs);
	}

	@Test
	public void testaSeUpdateChamaPrintMapa() {
		gcs.update(p, "dummy");
		//Mockito.verify(gcs, Mockito.times(1)).printMapa();
	}
	
	

}
