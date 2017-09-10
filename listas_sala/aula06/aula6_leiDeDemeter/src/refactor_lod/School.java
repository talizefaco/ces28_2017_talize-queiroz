package refactor_lod;

public class School {

	public void register(Applicant applicant) {
		// TODO Auto-generated method stub
		
	}

	public ApplicationValidation getApplicationValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationResult applicate(Applicant student) {
		ApplicationResult retResult = new ApplicationResult();
		
		ApplicationValidation applicationValidation = this.getApplicationValidation();
		ApplicationDao admissionApplicationDao = this.getApplicationValidation().getApplicationDao();
		
		ApplicationResult result = applicationValidation.validate(student);
		if (result.isSuccess()) {
			result = admissionApplicationDao.persist(student);
			if (result.isSuccess()) { // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				this.register(student);
			} else {
				retResult.setMessage(result.getMessage());
			}
		} else {
			retResult.setMessage(result.getMessage());
		}
		return retResult;
	}

	
}
