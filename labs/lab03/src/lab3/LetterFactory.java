package lab3;

import ptbr.*;
import enus.*;

public abstract class LetterFactory {
	private static LetterBuilderPTBR letter_ptbr;
	private static LetterBuilderENUS letter_enus;
	
	public static LetterFactory getLetter(String lang, String letterType,
			IPerson sender, IPerson destinatary, Address senderAddress,
			Address destinataryAddress, Date date) {
		LetterFactory factory = null;
		switch (lang) {
			case "ptbr":
				letter_ptbr = LetterBuilderPTBR.getBuilder(letterType,(PersonPTBR) sender,(PersonPTBR) destinatary,
						(AddressPTBR) senderAddress, (AddressPTBR) destinataryAddress,(DatePTBR) date);
				factory = letter_ptbr;
				break;
			case "enus":
				letter_enus = LetterBuilderENUS.getBuilder(letterType, (PersonENUS) sender, (PersonENUS) destinatary,
						(AddressPTBR) senderAddress, (AddressPTBR) destinataryAddress,(DateENUS) date);
				factory = letter_enus;
				break;
		}
		return factory;
	}
	
	public static LetterFactory getLetter(String lang, String letterType,
			IPerson sender, IPerson destinatary, Address senderAddress,
			Address destinataryAddress, Date date, String position, Date interviewDate) {
		LetterFactory factory = null;
		switch (lang) {
			case "ptbr":
				letter_ptbr = LetterBuilderPTBR.getBuilder(letterType, (PersonPTBR) sender, (PersonPTBR) destinatary,
						(AddressPTBR) senderAddress, (AddressPTBR) destinataryAddress, (DatePTBR) date, position,
						(DatePTBR) interviewDate);
				factory = letter_ptbr;
				break;
			case "enus":
				letter_enus = LetterBuilderENUS.getBuilder(letterType, (PersonENUS) sender, (PersonENUS) destinatary,
						(AddressPTBR) senderAddress, (AddressPTBR) destinataryAddress, (DateENUS) date, position, 
						(DateENUS) interviewDate);
				factory = letter_enus;
				break;
		}
		return factory;
	}
}
