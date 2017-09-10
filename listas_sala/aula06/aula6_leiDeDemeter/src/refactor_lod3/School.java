package refactor_lod3;

public class School {
	private ApplicationDao _admissionApplicationDao;
	
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
		
		boolean result = applicationValidation.validate(student);
		if (result) {
			result = _admissionApplicationDao.persist(student);
			if (result) { // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				this.register(student);
			} else {
				retResult.setSuccess(false);
				retResult.setMessage("Admission application failed");
			}
		} else {
			retResult.setSuccess(false);
			retResult.setMessage("Admission application failed");
		}
		return retResult;
	}
	
	
}
