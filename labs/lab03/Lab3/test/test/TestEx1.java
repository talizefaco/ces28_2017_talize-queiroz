package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enus.CommercialLetterENUS;
import enus.InterviewInvitationENUS;
import enus.PersonalLetterENUS;
import lab3.*;
import lab3.Person.PersonBuilder;
import lab3.Address.AddressBuilder;
import lab3.Date.DateBuilder;

public class TestEx1 {

	private Person dicksiano;
	private Person italo;
	private Address dickAddress;
	private Address italoAddress;
	private Date date;
	
	@Before
	public void setUp() throws Exception {
		dicksiano = new PersonBuilder("Dicksiano", "Melo").email("dicksiano@ita.br").phone("86-99662 5478").build();
		italo = new PersonBuilder("Italo", "Tabatinga").email("italo@ita.br").phone("85-95621 2455").build();
		dickAddress = new AddressBuilder("Câncer", "123",  "12345").city("Teresina").state("PI").country("Brasil").build();
		italoAddress = new AddressBuilder("Games","456",  "67890").city("Fortaleza").state("CE").country("Brasil").build();
		date = new DateBuilder(31, 2, 2017).build();
	}

	@Test // First letter type test
	public void testComercialLetter() {
		CommercialLetterENUS letter = new CommercialLetterENUS(dicksiano, italo, dickAddress, italoAddress, date);
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
	
	@Test // Second letter type test
	public void testPersonalLetter() {
		PersonalLetterENUS letter = new PersonalLetterENUS(dicksiano, italo, dickAddress, italoAddress, date);
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
	
	@Test // Third letter type test
	public void testInterviewInvitation() {
		Date interviewDate = new DateBuilder(12, 5, 2049).build();
		String position = new String("Astronaut");
		InterviewInvitationENUS letter = new InterviewInvitationENUS(dicksiano, italo, dickAddress, italoAddress, date,
				position, interviewDate);
		System.out.println(letter.model());

		assertEquals(letter.model(), "2/31/2017\n" + 
				"\n" + 
				"Mr(s) Dicksiano Melo\n" + 
				"123 St Câncer, 12345, Teresina, PI, Brasil\n" + 
				"Mr(s) Italo Tabatinga\n" + 
				"456 St Games, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"Dear, Mr(s) Italo Tabatinga,\n" + 
				"\n" + 
				"As result of your application for the position of Astronaut, I would like to invite you to attend on 5/12/2049 at our office.\n" + 
				"\n" + 
				"Best regards,\n" + 
				"Dicksiano\n" + 
				"123 St Câncer, 12345, Teresina, PI, Brasil\n" + 
				"86-99662 5478\n" + 
				"dicksiano@ita.br");
	}

}
