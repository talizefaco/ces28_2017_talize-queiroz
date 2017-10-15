package lab02;

import org.apache.commons.lang3.StringUtils;

public class CalculadoraString {
	
	/*
	 * Observe que eu montei vários método: add1, add2, ... add8.
	 * Se fosse um projeto, cada método destes seria uma função com nome indicando sua função.
	 * 
	 * Eu deixei esses nomes para que seja fácil visualizar a evolução do lab.
	 * 
	 */
	
	private static int calculateSum(String numbers) {
		String plots[] = numbers.split(","); // Split input
		int result = 0;
		for(String plot : plots) {
			if(Integer.parseInt(plot) <= 1000) {
				result = result + Integer.parseInt(plot);
			}
		}
		return result;
	}
	
	private static String parseInput1(String input) {			
		// Check if there are only spaces between numbers
		if(input.matches(".*[\\d+]\\s+[\\d+].*")) { 
			throw new IllegalArgumentException();
		}
		
		input = input.replaceAll(" ","");
		return input;
	}
	
	public static int add1(String numbers) {
		if(numbers.length() == 0) { // Empty string
			return 0;
		}
		numbers = parseInput1(numbers); // Parse input		
		return calculateSum(numbers);		
	}
	
	private static String parseInput2(String input) {
		if(!input.matches(".*\\d.*")) { // Check if there is at least one number.
			throw new IllegalArgumentException();
		}
		input = parseInput1(input);
		input = input.replaceAll(",{2,}", ",");
		
		return input;
	}
	
	public static int add2(String numbers) {
		if(numbers.length() == 0 || numbers.matches("\\s+")) { // Empty string
			return 0;
		}
		numbers = parseInput2(numbers); // Parse input	
		return calculateSum(numbers);
	}
	
	private static String parseInput3(String input) {
		input = input.replaceAll("\n", ",");
		input = parseInput2(input);	
		return input;
	}
	
	public static int add3(String numbers) {
		if(numbers.length() == 0 || numbers.matches("\\s+")) { // Empty string
			return 0;
		}		
		numbers = parseInput3(numbers); // Parse input
		return calculateSum(numbers);
	}
	
	private static String parseInput4(String input) {
		if(input.matches(".*\\[.*]\n.*")) { 
			String[] delimiters = StringUtils.substringsBetween(input, "//[", "]\n");
			for(String delimiter : delimiters) {
				input = input.replace("//[" + delimiter + "]\n", "");
				input = input.replaceAll(delimiter, ",");
			}
		}
		input = input.replaceAll("\n", ",");
		input = parseInput3(input);	
		return input;
	}
	
	public static int add4(String numbers) {
		if(numbers.length() == 0 || numbers.matches("\\s+")) { // Empty string
			return 0;
		}		
		numbers = parseInput4(numbers); // Parse input
		return calculateSum(numbers);
	}
	
	private static void checkNegativeNumbers(String input) {
		String negativeNumbers = "";
		
		for(String plot : input.split(",")) {
			if(!plot.matches("^-?\\d+$")) { // Empty string
				throw new IllegalArgumentException();
			}
			if(Integer.parseInt(plot) < 0) { // If the number is negative
				if(negativeNumbers.isEmpty()) {
					negativeNumbers = plot;
				} else {
				negativeNumbers = negativeNumbers + " " + plot;
				}
			}
		}
		if(!negativeNumbers.isEmpty()) { 
			throw new IllegalArgumentException("negativos proibidos [" + negativeNumbers + "]");
		}
	}
	private static String parseInput5(String input) {
		input = parseInput4(input);	
		checkNegativeNumbers(input);
		return input;
	}
	
	public static int add5(String numbers) {
		if(numbers.length() == 0 || numbers.matches("\\s+")) { // Empty string
			return 0;
		}		
		numbers = parseInput5(numbers); // Parse input
		return calculateSum(numbers);
	}
	
	public static int add6(String numbers) {
		if(numbers.length() == 0 || numbers.matches("\\s+")) { // Empty string
			return 0;
		}		
		numbers = parseInput5(numbers); // Parse input
		return calculateSum(numbers);
	}
	
	public static int add7(String numbers) {
		if(numbers.length() == 0 || numbers.matches("\\s+")) { // Empty string
			return 0;
		}		
		numbers = parseInput5(numbers); // Parse input
		return calculateSum(numbers);
	}
	
	private static String parseInput8(String input) {
		if(input.matches(".*\\[.*]\n.*")) {  // Check if there are delimiter
			input = input.replaceAll(".*\\\\[.*]\\n.*", ",");
			input = input.replaceAll("//", "");
			String[] delimiters = StringUtils.substringsBetween(input, "[", "]"); // Catch all delimiters
			for(String delimiter : delimiters) {
				input = input.replace("[" + delimiter + "]\n", "");
				input = input.replace("[" + delimiter + "]", "");
			}
			String regex;
			for(String delimiter : delimiters) {
				if(delimiter.isEmpty()) {
					throw new IllegalArgumentException();
				}
				regex = "\\Q" + delimiter + "\\E"; // Avoid problems with Regex reserved characters
				input = input.replaceAll(regex, ","); // Replace delimiter
			}
		}
		input = input.replaceAll("\n", ",");
		input = parseInput3(input);	
		checkNegativeNumbers(input); // Check if there is negative numbers
		return input;
	}
	public static int add8(String numbers) {
		if(numbers.length() == 0 || numbers.matches("\\s+")) { // Empty string
			return 0;
		}		
		numbers = parseInput8(numbers); // Parse input
		return calculateSum(numbers);
	}
	
	public static int add(String numbers) {
		return add8(numbers);
	}
} 
