import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class MoneyBagTests {
	
	private Money money1;
	private Money money2;
	private Money money3;
	private Money money4;
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
		money3 = new Money(20,currencyUSD);
		money4 = new Money(30,currencyEUR);
		mnybg = new MoneyBag();
		mnybg.add(money1);
		
	}

	@Test //Testa se há a inserção correta na MoneyBag 
	public void testAssertIsInMoneyBag() {
		assertTrue(mnybg.getmBag().containsValue(money1));
		assertEquals(money1, mnybg.getmBag().get(money1.getCurrency()));
 
	}
	@Test //Testa se a soma de moneys de mesma currency funciona na MoneyBag
	public void testAssertTrueAddMoneyBagSameCurrency() {
		mnybg.add(money2);
		assertTrue(mnybg.getmBag().get(money1.getCurrency()).getAmount() == 30);
		mnybg.add(money2);
		assertTrue(mnybg.getmBag().get(money1.getCurrency()).getAmount() == 50);
	}
	@Test //Testa se a adição de moneys de currencies distintas funciona na MoneyBag
	public void testAssertTrueAddMoneyBagDifferentCurrency() {
		mnybg.add(money2);
		assertTrue(mnybg.getmBag().get(money1.getCurrency()).getAmount() == 30);
		mnybg.add(money2);
		assertTrue(mnybg.getmBag().get(money2.getCurrency()).getAmount() == 50);
		mnybg.add(money3);
		assertTrue(mnybg.getmBag().get(money3.getCurrency()).getAmount() == 20);
		mnybg.add(money4);
		assertTrue(mnybg.getmBag().get(money4.getCurrency()).getAmount() == 30);
		assertTrue(mnybg.getmBag().size() == 3);
	}
	@Test //Testa se a aplicação que apresenta as moedas na Money Bag funciona
	public void testAssertEqualsShowMoney() {
		mnybg.add(money2);
		assertEquals("BRL 30\n", mnybg.showMoney());
		mnybg.add(money2);
		assertEquals("BRL 50\n", mnybg.showMoney());
		mnybg.add(money3);
		assertEquals("BRL 50\nUSD 20\n", mnybg.showMoney());
		mnybg.add(money4);
		assertEquals("BRL 50\nUSD 20\nEUR 30\n", mnybg.showMoney());
	}
	@Test //Testa se a conversão para BRL funciona
	public void testAssertEqualsConvertToBRL() {
		mnybg.add(money2);
		assertEquals(30, mnybg.convertToBRL());
		mnybg.add(money2);
		assertEquals(50, mnybg.convertToBRL());
		mnybg.add(money3);
		assertEquals(110, mnybg.convertToBRL());
		mnybg.add(money4);
		assertEquals(230, mnybg.convertToBRL());
	}
		
}