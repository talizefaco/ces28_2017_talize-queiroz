package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import presenter.Presenter;
import view.GCSConcrete;;

public class TestePresenter {
	
	Presenter p;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		p = new Presenter();
	}
	
	@Test
	public void testaConstrucaoPresenter() {
		assertNotNull(p);
	}

	@Test
	public void testaConstrucaodeIARPeUTMCTRapartirdePresenter() {
		assertNotNull(p.getARP());
		assertNotNull(p.getUTMCTR());
	}
	
	@Test
	public void testaSeMetodoGetMapEhChamado() {
		p.getMapa();
		assertEquals(p.getFlag(),true);
	}
	

}
