import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class MoneyTests {
	
	private Money money1;
	private Money money2;
	private Currency currencyBRL;
	private Currency currencyUSD;
	private Currency currencyEUR;
	private MoneyBag mnybg;
	
	@Before
	public void setUp() {
		currencyBRL = new Currency("BRL", 1);
		currencyUSD = new Currency("USD", 3);
		currencyEUR = new Currency("EUR", 4);
		money1 = new Money(10,currencyBRL);
		money2 = new Money(20,currencyBRL);
		mnybg = new MoneyBag();
		mnybg.add(money1);
		
	}
	
	@Test //Testa se a soma entre dois moneys está correta com AssertTrue 
	public void testAssertTrueAdd() {
		assertTrue(( (Money) money1.add(money2)).getAmount()==30);
 
	}
	
	@Test //Testa se a soma entre dois moneys está correta com AssertEquals
	public void testAssertEqualsAdd() {
		assertEquals(30,( (Money) money1.add(money2)).getAmount());
 
	}

}
