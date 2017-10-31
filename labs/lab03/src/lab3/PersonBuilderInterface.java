package lab3;

public interface PersonBuilderInterface {
	public PersonBuilderInterface firstName(String firstName);
	
	public PersonBuilderInterface lastName(String lastName);
	
	public PersonBuilderInterface phone(String phone);
	
	public PersonBuilderInterface email(String email);
	
	public Person build();

	public String getFirstName();
	
	public String getLastName();
	
	public String getPhone();
	
	public String getEmail();
}
