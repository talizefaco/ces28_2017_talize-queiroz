package refactor_lod2;

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
		
		ApplicationResult result = applicationValidation.validate(student);
		if (result.isSuccess()) {
			result = _admissionApplicationDao.persist(student);
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
