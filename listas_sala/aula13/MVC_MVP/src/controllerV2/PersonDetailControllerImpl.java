package controllerV2;

import model.Person;
import view.PersonDetailView;
import view.PersonDetailViewListener;

public class PersonDetailControllerImpl implements PersonDetailViewListener {

	public PersonDetailControllerImpl(Person person)
	{
		this.setModel(person);
		this.setView(person); 
	}

	@Override
	public void changedButtonPressed() {
		final String newName = _view.getNameFromTextField();
		if (isNotEmpty(newName))
		{	
			this.getModel().setName(getSizedName(getValidName(newName)));
		}
	}
	
	@Override
	public void windowClosed() {
		System.exit(0);
	}
	
	protected PersonDetailView getView() {
		return _view;
	}
	
	protected void setView(Person person){
		_view = new PersonDetailView(person, this);
		this.getView().display();
	}
	
	protected Person getModel() {
		return _model;
	}

	protected void setModel(Person model) {
		_model = model;
	}
	
	private Boolean isNotEmpty(String s){
		return !s.trim().isEmpty();
	}
	
	private String getValidName(String name) {
		name = name.replaceAll("[^a-zA-Z]+","");
		name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		return name;
	}
	
	private String getSizedName(String name) {
		if(name.length() <= 6) {
			return "VERMELHO" + name;
		} else if(name.length() <= 10) {
			return "VERDE" + name;			
		} else {
			return "AMARELO" + name;
		}
	}

	private Person _model;
	private PersonDetailView _view;
}
