package enus;

import lab3.Address;
import lab3.Date;
import lab3.InterviewInvitation;
import lab3.Languages;
import lab3.Person;

public class InterviewInvitationENUS extends InterviewInvitation {	
	public InterviewInvitationENUS(Person sender, Person destinatary, Address senderAddress, Address destinataryAddress,
			Date date, String position, Date interviewDate) {
		super(Languages.ENUS, sender, destinatary, senderAddress, destinataryAddress, date, position, interviewDate);
	}

	@Override
	protected String getInvitationMSG() {
		return "Dear, " + _destinatary.getName() + ",\n\nAs result of your application"
				+ " for the position of " + _position + ", I would "
				+ "like to invite you to attend on " + _interviewDate.toPrint() + " at our office.\n\n";
	}

	@Override
	protected String getGoodLuck() {
		return "Best regards,\n";
	}

	
	
}
