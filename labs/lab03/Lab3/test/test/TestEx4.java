package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab3.CommercialLetter;
import lab3.Languages;
import lab3.PhoneFormat;
import lab3.Address.AddressBuilder;
import lab3.Date.DateBuilder;
import lab3.Person.PersonBuilder;

public class TestEx4 {

	private PersonBuilder dicksiano;
	private PersonBuilder italo;
	private AddressBuilder dickAddress;
	private AddressBuilder italoAddress;
	private DateBuilder date;
	
	@Before
	public void setUp() throws Exception {
		dicksiano = new PersonBuilder("Dicksiano", "Melo").email("dicksiano@ita.br").phone("86-996625478")
				.phoneFormat(PhoneFormat.A);
		italo = new PersonBuilder("Italo", "Tabatinga").email("italo@ita.br").phone("85-956212455");
		dickAddress = new AddressBuilder("Câncer", "123",  "12345").city("Teresina").state("PI").country("Brasil");
		italoAddress = new AddressBuilder("Games","456",  "67890").city("Fortaleza").state("CE").country("Brasil");
		date = new DateBuilder(31, 2, 2017);
	}

	@Test // First letter type in ENUS with sender in PhoneFormat A test 
	public void testComercialLetterENUS() {
		//dicksiano = dicksianoA.phoneFormat(PhoneFormat.A);
		CommercialLetter letter = CommercialLetter.getLetter(Languages.ENUS, dicksiano, italo, dickAddress, italoAddress, date);
		
		assertEquals(letter.model(), "2/31/2017\n" + 
				"\n" + 
				"Mr(s) Dicksiano Melo\n" + 
				"123 St Câncer, 12345, Teresina, PI, Brasil\n" + 
				"Mr(s) Italo Tabatinga\n" + 
				"456 St Games, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"DearItalo\n" + 
				"\n" + 
				"Sincerely,\n" + 
				"\n" + 
				"                    ---------\n" + 
				"Dicksiano\n" + 
				"            86-996625478\n" + 
				"            email:dicksiano@ita.br");
	}
	
	@Test // First letter type in ENUS with sender in PhoneFormat B test 
	public void testComercialLetterPTBR() {
		dicksiano = dicksiano.phoneFormat(PhoneFormat.B);
		CommercialLetter letter = CommercialLetter.getLetter(Languages.PTBR, dicksiano, italo, dickAddress, italoAddress, date);

		assertEquals(letter.model(), "31/2/2017\n" + 
				"\n" + 
				"Sr(a) Dicksiano Melo\n" + 
				"Rua Câncer 123, 12345, Teresina, PI, Brasil\n" + 
				"Sr(a) Italo Tabatinga\n" + 
				"Rua Games 456, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"Querido Italo\n" + 
				"\n" + 
				"Atenciosamente,\n" + 
				"\n" + 
				"                    ---------\n" + 
				"Dicksiano\n" + 
				"            86 996625478\n" + 
				"            email:dicksiano@ita.br");
	}

}
