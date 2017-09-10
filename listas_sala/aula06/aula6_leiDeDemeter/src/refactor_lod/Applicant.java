package refactor_lod;

public class Applicant {
	int id;
	String nome;
	double averageGrade = 0.0;

	public ApplicationResult recordNewApplication(School school) {
		ApplicationResult retResult = school.applicate(this);
		
		return retResult;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

}
