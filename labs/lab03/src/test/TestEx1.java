package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import lab3.*;
import lab3.Person.PersonBuilder;

public class TestEx1 {

	private Person dicksiano;
	private Person italo;
	private Address dickAddress;
	private Address italoAddress;
	private Date data;
	
	@Before
	public void setUp() throws Exception {
		dicksiano = new PersonBuilder("Dicksiano", "Melo").email("dicksiano@ita.br").phone("86-99662 5478").build();
		italo = new PersonBuilder("Italo", "Tabatinga").email("italo@ita.br").phone("85-95621 2455").build();
		dickAddress = new Address("Rua dos Câncer, 123",  "12345", "Teresina", "PI", "Brasil");
		italoAddress = new Address("Rua dos Games, 456",  "67890", "Fortaleza", "CE", "Brasil");
		data = new Date(31, 2, 2017);
	}

	@Test // First letter type test
	public void testComercialLetter() {
		CommercialLetter letter1 = new CommercialLetter(dicksiano, italo, dickAddress, italoAddress, data);
		assertEquals(letter1.model(), "31/2/2017\n" + 
				"\n" + 
				"Dicksiano Melo\n" + 
				"Rua dos Câncer, 123, 12345, Teresina, PI, Brasil\n" + 
				"Italo Tabatinga\n" + 
				"Rua dos Games, 456, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"Dear Italo\n" + 
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
		PersonalLetter letter = new PersonalLetter(dicksiano, italo, dickAddress, italoAddress, data);
		assertEquals(letter.model(), "31/2/2017\n" + 
				"\n" + 
				"Dicksiano Melo\n" + 
				"Rua dos Câncer, 123, 12345, Teresina, PI, Brasil\n" + 
				"Italo Tabatinga\n" + 
				"Rua dos Games, 456, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"How you doing? \n" + 
				"\n" + 
				"XOXO,\n" + 
				"\n" + 
				"\n" + 
				"                    ---------\n" + 
				"Dicksiano");
	}
	
	@Test // Third letter type test
	public void testInterviewInvitation() {
		Date interviewDate = new Date(31, 12, 2017);
		InterviewInvitation letter = new InterviewInvitation(dicksiano, italo, dickAddress, italoAddress, data,
				"Astronaut", interviewDate);
		System.out.println(letter.model());
		assertEquals(letter.model(), "31/2/2017\n" + 
				"\n" + 
				"Dicksiano Melo\n" + 
				"Rua dos Câncer, 123, 12345, Teresina, PI, Brasil\n" + 
				"Italo Tabatinga\n" + 
				"Rua dos Games, 456, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"Dear, Italo Tabatinga,\n" + 
				"\n" + 
				"As result of your application for the position of Astronaut, I would like to invite you to attend on 31/12/2017 at our office.\n" + 
				"\n" + 
				"Best regards,\n" + 
				"\n" + 
				"Dicksiano Melo\n" + 
				"Rua dos Câncer, 123, 12345, Teresina, PI, Brasil\n" + 
				"86-99662 5478\n" + 
				"dicksiano@ita.br");
	}

}
