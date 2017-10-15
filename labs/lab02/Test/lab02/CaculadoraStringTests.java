package lab02;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CaculadoraStringTests {
	private CalculadoraString calculadoraString = new CalculadoraString();
	
	/*
	 * Observe que addTest representa os testes do TDD relacionados aos requisitos de cada item. Ou seja,
	 * add1Test representa os testes levando em conta apenas o primeiro requisito.
	 * 
	 */
	
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();
	
	// Tests from Item 1!
	@SuppressWarnings("static-access")
	@Test
	public void add1TestValidInputs() {
		String inputA = "";
		String inputB = "1";
		String inputC = "1,2";
		String inputD = "1            ,      2";
		
		assertEquals(calculadoraString.add(inputA), 0);
		assertEquals(calculadoraString.add(inputB), 1);
		assertEquals(calculadoraString.add(inputC), 3);
		assertEquals(calculadoraString.add(inputD), 3);
	}
	@SuppressWarnings("static-access")
	@Test
	public void add1TestInvalidInputs() {		
		expectedEx2.expect(IllegalArgumentException.class);
		String inputA = "1,2       3";
		
		calculadoraString.add(inputA);
	}
	
	// Tests from Item 2!
	@SuppressWarnings("static-access")
	@Test
	public void add2TestValidInputs() {
		String inputA = "";
		String inputB = "1,,";
		String inputC = "1         ,           ,";
		String inputD = "1            ,      2";
		String inputE = "1 ,,,,,,,  2  ,,  ,    ,  , 3";
		String inputF = "    ";
		
		assertEquals(calculadoraString.add(inputA), 0);
		assertEquals(calculadoraString.add(inputB), 1);
		assertEquals(calculadoraString.add(inputC), 1);
		assertEquals(calculadoraString.add(inputD), 3);
		assertEquals(calculadoraString.add(inputE), 6);
		assertEquals(calculadoraString.add(inputF), 0);
	}
	@SuppressWarnings("static-access")
	@Test
	public void add2TestInvalidInputs() {		
		expectedEx2.expect(IllegalArgumentException.class);
		
		String inputA = ",";
		String inputB = ",   ,    ,";
		
		calculadoraString.add(inputA);
		calculadoraString.add(inputB);
	}
	
	// Tests from Item 3!
	@SuppressWarnings("static-access")
	@Test
	public void add3TestValidInputs() {
		String inputA = "";
		String inputB = "1,\n";
		String inputC = "1         \n           ,";
		String inputD = "1            \n      2";
		String inputE = "1 ,,\n\n,,,  2  ,\n  ,    \n  , 3\n\n";
		
		assertEquals(calculadoraString.add(inputA), 0);
		assertEquals(calculadoraString.add(inputB), 1);
		assertEquals(calculadoraString.add(inputC), 1);
		assertEquals(calculadoraString.add(inputD), 3);
		assertEquals(calculadoraString.add(inputE), 6);
	}
	@SuppressWarnings("static-access")
	@Test
	public void add3TestInvalidInputs() {		
		expectedEx2.expect(IllegalArgumentException.class);
		String inputA = "\n";
		String inputB = ",  \n   \n ,    ,";
		
		calculadoraString.add(inputA);
		calculadoraString.add(inputB);
	}
	
	// Tests from Item 5!
	@SuppressWarnings("static-access")
	@Test
	public void add5TestValidInputs() {
		String inputA = "";
		String inputB = "      ";
		String inputC = "1,\n";
		String inputD = "1 ,,\n\n,,,  2  ,\n  ,    \n  , 3\n\n";
		String inputE = "//[x]\n1   x     2    x x   3";
		String inputF = "//[x]\n1   x      x";
		
		assertEquals(calculadoraString.add(inputA), 0);
		assertEquals(calculadoraString.add(inputB), 0);
		assertEquals(calculadoraString.add(inputC), 1);
		assertEquals(calculadoraString.add(inputD), 6);
		assertEquals(calculadoraString.add(inputE), 6);
		assertEquals(calculadoraString.add(inputF), 1);
	}
	@SuppressWarnings("static-access")
	@Test
	public void add5TestInvalidInputs() {		
		expectedEx2.expect(IllegalArgumentException.class);
		expectedEx2.expectMessage("negativos proibidos [-1 -2 -3]");
		String inputA = "-1,-2,-3\n";
		
		calculadoraString.add(inputA);
	}
	
	// Tests from Item 6!
	@SuppressWarnings("static-access")
	@Test
	public void add6TestValidInputs() {
		String inputA = "";
		String inputB = "      ";
		String inputC = "1500,\n";
		String inputD = "1 ,,\n\n,,,  20000  ,\n  ,    \n  , 30000\n\n";
		String inputE = "//[x]\n1   x     2    x x   3";
		String inputF = "//[x]\n1   x      x1030";
		
		assertEquals(calculadoraString.add(inputA), 0);
		assertEquals(calculadoraString.add(inputB), 0);
		assertEquals(calculadoraString.add(inputC), 0);
		assertEquals(calculadoraString.add(inputD), 1);
		assertEquals(calculadoraString.add(inputE), 6);
		assertEquals(calculadoraString.add(inputF), 1);
	}
	
	// Tests from Item 7!
	@SuppressWarnings("static-access")
	@Test
	public void add7TestValidInputs() {
		String inputA = "";
		String inputB = "      ";
		String inputC = "1500,\n";
		String inputD = "1 ,,\n\n,,,  20000  ,\n  ,    \n  , 30000\n\n";
		String inputE = "//[xxx]\n1   xxx     2    xxx xxx   3";
		String inputF = "//[xxx]\n1   xxx      xxx1030";
		
		assertEquals(calculadoraString.add(inputA), 0);
		assertEquals(calculadoraString.add(inputB), 0);
		assertEquals(calculadoraString.add(inputC), 0);
		assertEquals(calculadoraString.add(inputD), 1);
		assertEquals(calculadoraString.add(inputE), 6);
		assertEquals(calculadoraString.add(inputF), 1);
	}
	
	// Tests from Item 8!
	@SuppressWarnings("static-access")
	@Test
	public void add8TestValidInputs() {
		String inputA = "";
		String inputB = "      ";
		String inputC = "1500,\n";
		String inputD = "1 ,,\n\n,,,  20000  ,\n  ,    \n  , 30000\n\n";
		String inputE = "//[xxx][aaa][bbb]\n1   xxx     2    aaa bbb   3";
		String inputF = "//[xxx][aaa][bbb]\n1   bbb      xxx1030";
		String inputG = "//[xxx][aaa][bbb]\n1   bbb      xxx103";
		String inputH = "//[xxx][aaa][bbb]\n1   bbb  aaa 200 aaa 5    xxx103";
		
		assertEquals(calculadoraString.add(inputA), 0);
		assertEquals(calculadoraString.add(inputB), 0);
		assertEquals(calculadoraString.add(inputC), 0);
		assertEquals(calculadoraString.add(inputD), 1);
		assertEquals(calculadoraString.add(inputE), 6);
		assertEquals(calculadoraString.add(inputF), 1);
		assertEquals(calculadoraString.add(inputG), 104);
		assertEquals(calculadoraString.add(inputH), 309);
	}
	
	/*
	 * Valid corner cases!
	 */
	@SuppressWarnings("static-access")
	@Test
	public void addUsingRegexReservedCharAsDelimiter() {
		String inputC = "//[**]\n1 ** 2 ** 3 **** ** 4";
		String inputF = "//[*]\n1 * 2 * 3 *** ** 4";
	
		assertEquals(calculadoraString.add(inputC), 10);
		assertEquals(calculadoraString.add(inputF), 10);
	}
	@SuppressWarnings("static-access")
	@Test
	public void addUsingSpaceAsDelimiter() {
		String inputD = "//[ ]\n1  2  3  40000";
	
		assertEquals(calculadoraString.add(inputD), 6);
	}
	@SuppressWarnings("static-access")
	@Test
	public void addUsingMinusSignAsDelimiter() {
		String inputE = "//[---][--]\n1 -----4";
	
		assertEquals(calculadoraString.add(inputE), 5);
	}
	
	/*
	 * Invalid Corner Cases!
	 */
	
	@SuppressWarnings("static-access")
	@Test
	public void addNegativeNumberWithDelimiterComposedByMinusSign() {		
		expectedEx2.expect(IllegalArgumentException.class);
		String inputE = "//[------]\n1-------4";
		
		calculadoraString.add(inputE);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void addFakeValidDelimitersA() {		
		expectedEx2.expect(IllegalArgumentException.class);
		String inputC = "//[aa][aaa]\n1 aaa  a  2    aa  3";		
		
		calculadoraString.add(inputC);
	}
	@SuppressWarnings("static-access")
	@Test
	public void addFakeValidDelimitersB() {		
		expectedEx2.expect(IllegalArgumentException.class);
		String inputA = "//[aa][aaa]\n1 aaa    2    aaaaa  3";
		
		calculadoraString.add(inputA);
	}
	@SuppressWarnings("static-access")
	@Test
	public void addFakeValidDelimitersC() {		
		expectedEx2.expect(IllegalArgumentException.class);
		String inputD = "//[bbb][aa][c]\n1 aacaa  ccbb  2 cbbbc bbbcc 3 aa c ccc bbbbbbaa 4";
		
		calculadoraString.add(inputD);
	}
	

}