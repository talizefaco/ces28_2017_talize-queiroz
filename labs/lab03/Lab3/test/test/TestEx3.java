package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab3.*;
import lab3.Address.AddressBuilder;
import lab3.Date.DateBuilder;
import lab3.Person.PersonBuilder;

public class TestEx3 {

	private PersonBuilder dicksiano;
	private PersonBuilder italo;
	private AddressBuilder dickAddress;
	private AddressBuilder italoAddress;
	private DateBuilder date;
	
	@Before
	public void setUp() throws Exception {
		dicksiano = new PersonBuilder("Dicksiano", "Melo").email("dicksiano@ita.br").phone("86-99662 5478");
		italo = new PersonBuilder("Italo", "Tabatinga").email("italo@ita.br").phone("85-95621 2455");
		dickAddress = new AddressBuilder("Câncer", "123",  "12345").city("Teresina").state("PI").country("Brasil");
		italoAddress = new AddressBuilder("Games","456",  "67890").city("Fortaleza").state("CE").country("Brasil");
		date = new DateBuilder(31, 2, 2017);
	}

	@Test // First letter type in ENUS test 
	public void testComercialLetterENUS() {
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
				"            86-99662 5478\n" + 
				"            email:dicksiano@ita.br");
	}
	
	@Test // First letter type in PTBR test 
	public void testComercialLetterPTBR() {
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
				"            86-99662 5478\n" + 
				"            email:dicksiano@ita.br");
	}
	
	@Test // Second letter type in ENUS test 
	public void testPersonalLetterENUS() {
		PersonalLetter letter = PersonalLetter.getLetter(Languages.ENUS, dicksiano, italo, dickAddress, italoAddress, date);
		
		assertEquals(letter.model(), "2/31/2017\n" + 
				"\n" + 
				"Mr(s) Dicksiano Melo\n" + 
				"123 St Câncer, 12345, Teresina, PI, Brasil\n" + 
				"Mr(s) Italo Tabatinga\n" + 
				"456 St Games, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"How you are you, dude?\n" + 
				"See ya,\n" + 
				"\n" + 
				"\n" + 
				"                    ---------\n" + 
				"Dicksiano");
	}
	
	@Test // Second letter type in PTBR test 
	public void testPersonalLetterPTBR() {
		PersonalLetter letter = PersonalLetter.getLetter(Languages.PTBR, dicksiano, italo, dickAddress, italoAddress, date);
		
		assertEquals(letter.model(), "31/2/2017\n" + 
				"\n" + 
				"Sr(a) Dicksiano Melo\n" + 
				"Rua Câncer 123, 12345, Teresina, PI, Brasil\n" + 
				"Sr(a) Italo Tabatinga\n" + 
				"Rua Games 456, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"Como vai, mano?\n" + 
				"Falous broder\n" + 
				"\n" + 
				"\n" + 
				"                    ---------\n" + 
				"Dicksiano");
	}
	
	@Test // Third letter type in ENUS test 
	public void testInterviewInvitationENUS() {
		DateBuilder interviewDate = new DateBuilder(31, 12, 2017);
		InterviewInvitation letter = InterviewInvitation.getLetter(Languages.ENUS, dicksiano, italo, dickAddress, italoAddress, date,
				"Astronaut", interviewDate);
		
		assertEquals(letter.model(), "2/31/2017\n" + 
				"\n" + 
				"Mr(s) Dicksiano Melo\n" + 
				"123 St Câncer, 12345, Teresina, PI, Brasil\n" + 
				"Mr(s) Italo Tabatinga\n" + 
				"456 St Games, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"Dear, Mr(s) Italo Tabatinga,\n" + 
				"\n" + 
				"As result of your application for the position of Astronaut, I would like to invite you to attend on 12/31/2017 at our office.\n" + 
				"\n" + 
				"Best regards,\n" + 
				"Dicksiano\n" + 
				"123 St Câncer, 12345, Teresina, PI, Brasil\n" + 
				"86-99662 5478\n" + 
				"dicksiano@ita.br");
	}

	@Test // Third letter type in PTBR test 
	public void testInterviewInvitationPTBR() {
		DateBuilder interviewDate = new DateBuilder(31, 12, 2017);
		InterviewInvitation letter = InterviewInvitation.getLetter(Languages.PTBR, dicksiano, italo, dickAddress, italoAddress, date,
				"Astronaut", interviewDate);
		
		assertEquals(letter.model(), "31/2/2017\n" + 
				"\n" + 
				"Sr(a) Dicksiano Melo\n" + 
				"Rua Câncer 123, 12345, Teresina, PI, Brasil\n" + 
				"Sr(a) Italo Tabatinga\n" + 
				"Rua Games 456, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"Caro, Sr(a) Italo Tabatinga,\n" + 
				"\n" + 
				"Ficamos felizes em dizer que você avançou no nosso processo paraAstronaut, gostaríamos de lhe convidar para vir no dia 31/12/2017 no nosso escritório.\n" + 
				"\n" + 
				"Boa sorte,\n" + 
				"Dicksiano\n" + 
				"Rua Câncer 123, 12345, Teresina, PI, Brasil\n" + 
				"86-99662 5478\n" + 
				"dicksiano@ita.br");
	}

}
