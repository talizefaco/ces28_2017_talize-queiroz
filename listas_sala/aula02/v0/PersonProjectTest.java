package v0;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonProjectTest {

	Project pj;
	Person x;
	Person p;
	
	@Before
	public void inicializar() {
		pj = new Project();	
		x = new Person();
		p = new Person();

		Person[] ps = new Person[3];
		for (int i = 0; i < ps.length; i++)
			ps[i] = new Person();
		ps[0]=p;
		pj.setParticipants(ps);
		pj.printParticipants();
	}

	@Test
	public void test() {
		
		assertTrue (pj.participate(p)); 
		assertFalse(pj.participate(x));
 
	}
	

}

