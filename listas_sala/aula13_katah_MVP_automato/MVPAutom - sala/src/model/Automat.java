package model;

import java.util.Iterator;
import java.util.Random;

//import static com.google.common.base.Preconditions.*;

import model.Automat;
import model.Automat.Cell;

public class Automat implements Iterable<Cell> {

	public class Cell {
		public int x;
		public int y;
		public int state;
	}

	private int[][] cells;
	private int width;
	private int height;
	private Random r = new Random();
	
	public Automat(int width,int height) {
		this.width = width;
		this.height = height;
		cells = new int[width][height];
	}

	public Automat nextState() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				cells[x][y] = r.nextInt(2);
			}
		}
		return this;
	}

	@Override
	public Iterator<Cell> iterator() {
		return new Iterator<Automat.Cell>() {
			
			private int x = 0;
			private int y = 0;
			
			@Override
			public void remove() {
				;
			}
			
			@Override
			public Cell next() {
				//checkState(x < width && y < height,"Interator is after state: (%s,%s)",x,y);
				
				Cell c = new Cell();
				c.x = x;
				c.y = y;
				c.state = cells[x][y];
				
				x++;
				if (x >= width) {
					x = 0;
					y++;
				}
				
				return c;
			}
			
			@Override
			public boolean hasNext() {
				return (y < height && x < width-1) || (y < height-1 && x < width);
			}
		};
	}

	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}

	public void changeCellState(int xCell, int yCell, int state) {
		//checkElementIndex(xCell, width);
		//checkElementIndex(yCell, height);
		cells[xCell][yCell] = state;
	}

}
