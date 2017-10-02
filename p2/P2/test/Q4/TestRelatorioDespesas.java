package Q4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Q4.refatorado.*;



public class TestRelatorioDespesas {
	
	
	@InjectMocks private RelatorioDespesas relaDesp;
	@Mock private Iterator<Despesa> despesas;
	@Mock private Despesa despMock1;
	@Mock private Despesa despMock2;
	private ArrayList<Despesa> listadespesas =  new ArrayList<Despesa>();
	

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		listadespesas.add(despMock1);
		listadespesas.add(despMock2);
		RelatorioDespesas relaDesp = new RelatorioDespesas(listadespesas.iterator());
		
	}
	

	
	@Test
	public void testInicializationRelatorioDespesas() {
		RelatorioDespesas relaDespInit = new RelatorioDespesas(listadespesas.iterator());
		assertNotNull(relaDespInit);
		
	}
	
	@Test
	public void testIfRelatorioDespesasTotalDespesaIsCorrect() {
		Mockito.when(despMock1.getDespesa()).thenReturn((float)10);
		Mockito.when(despMock2.getDespesa()).thenReturn((float)20);
		RelatorioDespesas relaDesp = new RelatorioDespesas(listadespesas.iterator());
		assertEquals(30,relaDesp.getTotalDespesa(),0);
		
		
	}
}
