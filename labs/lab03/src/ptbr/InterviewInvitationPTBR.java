package ptbr;

import lab3.Address;
import lab3.Date;
import lab3.InterviewInvitation;
import lab3.Languages;
import lab3.Person;

public class InterviewInvitationPTBR extends InterviewInvitation {
	public InterviewInvitationPTBR(Person sender, Person destinatary, Address senderAddress, Address destinataryAddress,
			Date date, String position, Date interviewDate) {
		super(Languages.PTBR, sender, destinatary, senderAddress, destinataryAddress, date, position, interviewDate);
	}

	@Override
	protected String getInvitationMSG() {
		return "Caro, " + _destinatary.getName() + ",\n\n" +
				"Ficamos felizes em dizer que voc� avan�ou no nosso processo para" + _position + ", gostar�amos de "
				+ "lhe convidar para vir no dia " + _interviewDate.toPrint() + " no nosso escrit�rio.\n\n";
	}

	@Override
	protected String getGoodLuck() {
		return "Boa sorte,\n";
	}

}
