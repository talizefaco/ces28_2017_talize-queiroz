package presenter;


public interface IBoardView {

	// binds the view to the Presenter p
	public abstract void bindTo(Presenter p);

	// the view must change its board size
	public abstract void resizeBoardSizeInCellsTo(int xCells, int yCells);

	// the view must change the state of a cell
	public abstract void changeCell(int x, int y, int state);

}