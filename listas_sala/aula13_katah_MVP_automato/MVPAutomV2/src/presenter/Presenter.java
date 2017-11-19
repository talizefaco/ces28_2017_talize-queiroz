package presenter;

import java.util.Observable;
import java.util.Observer;

import model.Automat;
import model.Automat.Cell;

public class Presenter extends Observable {
	
	Automat currentAutomat;
	
	public Presenter(Observer view, Automat automat) {
		currentAutomat = automat;
		addObserver(view);
	}

	public void nextClicked() {
		currentAutomat = currentAutomat.nextState();
		setChanged();
		notifyObservers(this);
	}
	
	public void changeAutomatCellState(int xCell,int yCell,int state) {
		currentAutomat.changeCellState(xCell,yCell,state);
	}

	public void updateView(IBoardView view) {
		view.resizeBoardSizeInCellsTo(currentAutomat.width(), currentAutomat.height());
		for(Cell c : currentAutomat) {
			view.changeCell(c.x,c.y,c.state);
		}
	}

}
