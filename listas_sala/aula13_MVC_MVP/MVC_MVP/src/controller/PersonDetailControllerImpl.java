package controller;
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
			this.getModel().setName(newName);
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

	private Person _model;
	private PersonDetailView _view;
}
