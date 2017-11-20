package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import exercicio17.*;

public class TestsEx17_18 {

	private PublishSubscriber pb;
	private Subject sub1;
	private Observers obs1;
	private Subject sub2;
	private Observers obs2;
	
	@Before
	public void setUp() {
		pb = new PublishSubscriber();
		
		sub1 = new Subject("sub1");
		sub2 = new Subject("sub2");
		
		obs1 = new Observers("obs1", pb);
		obs2 = new Observers("obs2", pb);
	}

	@Test
	public void test() {
		sub1.addObserver(pb);
		sub2.addObserver(pb);
		pb.addObserver(obs1);
		pb.addObserver(obs2);
		
		sub1.setMsg("msg do sub1");
		sub2.setMsg("msg do sub2");
	}

}
