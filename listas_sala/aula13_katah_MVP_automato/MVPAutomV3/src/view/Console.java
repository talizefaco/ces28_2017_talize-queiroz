package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import presenter.IBoardView;
import presenter.Presenter;

public class Console implements IBoardView, Observer  {
	
	private int[][] _tabela;
	private int _sizex = 0;
	private int _sizey = 0;
	private Presenter _p;
	
	public void init() {
			_tabela = new int[100][100];
			System.out.println("Matriz de celulas:");
			printTabela();
			System.out.println("Digite qualquer tecla para ir para NEXT");
	}
	
	public void printTabela() {
		for(int i = 0; i < _tabela.length; i++){
            for(int j = 0; j < _tabela[0].length; j++){
            	System.out.println(_tabela[i][j]);
            	}
        System.out.println("\n");
		}
	}
	
	@Override
	public void update(Observable observable, Object o) {
		Presenter _p = (Presenter) o;
		_p.updateView(this);
		printTabela();
	}



	@Override
	public void resizeBoardSizeInCellsTo(int xCells, int yCells) {
		// TODO Auto-generated method stub
		_sizex = xCells;
		_sizey = yCells;
	}

	@Override
	public void changeCell(int x, int y, int state) {
		_tabela[x][y] = state;
		
	}



	@Override
	public void bindTo(Presenter p) {
		_p=p;
		
	}
	
	public void nextText() {
		_p.nextClicked();
		
	}
	

}
