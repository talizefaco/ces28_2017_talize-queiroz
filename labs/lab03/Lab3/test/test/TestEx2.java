package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enus.CommercialLetterENUS;
import enus.InterviewInvitationENUS;
import enus.PersonalLetterENUS;
import lab3.*;
import lab3.Address.AddressBuilder;
import lab3.Date.DateBuilder;
import lab3.Person.PersonBuilder;

public class TestEx2 {

	private Person dicksiano;
	private Person italo;
	private Address dickAddress;
	private Address italoAddress;
	private Date date;
	
	@Before
	public void setUp() throws Exception {
		dicksiano = new PersonBuilder("Dicksiano", "Melo").email("dicksiano@ita.br").phone("86-99662 5478")
				.language(Languages.PTBR).build();
		italo = new PersonBuilder("Italo", "Tabatinga").email("italo@ita.br").phone("85-95621 2455")
				.language(Languages.ENUS).build();
		dickAddress = new AddressBuilder("Câncer", "123",  "12345").city("Teresina").state("PI").country("Brasil")
				.language(Languages.PTBR).build();
		italoAddress = new AddressBuilder("Games","456",  "67890").city("Fortaleza").state("CE").country("Brasil")
				.language(Languages.ENUS).build();
		date = new DateBuilder(31, 2, 2017)
				.language(Languages.ENUS).build();
	}

	@Test // First letter type test with sender in PTBR and destinatary/date in ENUS
	public void testComercialLetterPTBR() {
		CommercialLetterENUS letter = new CommercialLetterENUS(dicksiano, italo, dickAddress, italoAddress, date);
		
		assertEquals(letter.model(), "2/31/2017\n" + 
				"\n" + 
				"Sr(a) Dicksiano Melo\n" + 
				"Rua Câncer 123, 12345, Teresina, PI, Brasil\n" + 
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
	
	@Test // Second letter type test with sender in PTBR and destinatary/date in ENUS
	public void testCommercialLetterENUS() {
		PersonalLetterENUS letter = new PersonalLetterENUS(dicksiano, italo, dickAddress, italoAddress, date);
		assertEquals(letter.model(), "2/31/2017\n" + 
				"\n" + 
				"Sr(a) Dicksiano Melo\n" + 
				"Rua Câncer 123, 12345, Teresina, PI, Brasil\n" + 
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
	
	@Test // Third letter type test with sender/interviewDate in PTBR and destinatary/date in ENUS
	public void testInterviewInvitation() {
		Date interviewDate = new DateBuilder(31, 12, 2017).language(Languages.PTBR).build();
		InterviewInvitation letter = new InterviewInvitationENUS(dicksiano, italo, dickAddress, italoAddress, date,
				"Astronaut", interviewDate);
		assertEquals(letter.model(), "2/31/2017\n" + 
				"\n" + 
				"Sr(a) Dicksiano Melo\n" + 
				"Rua Câncer 123, 12345, Teresina, PI, Brasil\n" + 
				"Mr(s) Italo Tabatinga\n" + 
				"456 St Games, 67890, Fortaleza, CE, Brasil\n" + 
				"\n" + 
				"Dear, Mr(s) Italo Tabatinga,\n" + 
				"\n" + 
				"As result of your application for the position of Astronaut, I would like to invite you to attend on 31/12/2017 at our office.\n" + 
				"\n" + 
				"Best regards,\n" + 
				"Dicksiano\n" + 
				"Rua Câncer 123, 12345, Teresina, PI, Brasil\n" + 
				"86-99662 5478\n" + 
				"dicksiano@ita.br");
	}

}
