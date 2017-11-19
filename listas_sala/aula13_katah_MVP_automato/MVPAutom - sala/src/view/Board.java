package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import static com.google.common.base.Preconditions.*;

import javax.swing.JPanel;

import presenter.Presenter;

public class Board extends JPanel {
	
	private static final int MAXIMAL_STATE = 2;
	private int[][] cells;
	private int xCells;
	private int yCells;
	
	private Color borderColor = Color.BLACK;
	private Color fillAliveColor = Color.GREEN;
	private Color fillDeadColor = Color.RED;
	
	public Board(int widthInCells,int heightInCells) {
		this.resizeBoardSizeInCellsTo(widthInCells, heightInCells);
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		System.out.println(Thread.currentThread().getStackTrace()[1]);
		Graphics2D canvas = (Graphics2D)g;
		
		for (int x = 0; x < xCells; x++) {
			for (int y = 0; y < yCells; y++) {
				Color fillColor = getColorOfCell(x,y);
				drawCell(canvas, x, y,fillColor);
			}
		}
		
	}

	private Color getColorOfCell(int x, int y) {
		int c = cells[x][y];
		if (c == 0) {
			return fillDeadColor;
		} else if (c == 1) {
			return fillAliveColor;
		} else {
			throw new IllegalStateException(String.format("state of the cell(%d,%d) is: %d",x,y,c));
		}
	}

	private void drawCell(Graphics2D canvas, int x, int y, Color fillColor) {		
		int physicalCellWidht = physicalCellWidth();
		int physicalCellHeight = physicalCellHeight();
		int physicalX = physicalCellWidht * x;
		int physicalY = physicalCellHeight * y;
		canvas.setColor(fillColor);
		canvas.fillRect(physicalX, physicalY, physicalCellWidht, physicalCellHeight);
		canvas.setColor(borderColor);
		canvas.drawRect(physicalX, physicalY, physicalCellWidht, physicalCellHeight);
	}
	
	public void resizeBoardSizeInCellsTo(int xCells,int yCells) {
		this.xCells = xCells;
		this.yCells = yCells;
		
		this.cells = new int[xCells][yCells];
	}
	
	public void setCellTo(int xCell,int yCell,int state) {
		this.cells[xCell][yCell] = state;
	}

	
	public MouseListener createMouseListner(final Presenter p) {
		return new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent event) {
				int logicalX = toLogicalXCell(event.getX());
				int logicalY = toLogicalYCell(event.getY());
				System.out.println(event.getX()+": is within "+logicalX);
				System.out.println(event.getY()+": is within "+logicalY);
				System.out.println(cells[logicalX][logicalY]);
				
				int newState = nextCellState(logicalX,logicalY);
				p.changeAutomatCellState(logicalX, logicalY, newState);
				repaint();
			}
		};
	}
	
	private int nextCellState(int logicalX, int logicalY) {
		//checkElementIndex(logicalX,xCells);
		//checkElementIndex(logicalY,yCells);
		cells[logicalX][logicalY]++;
		if (cells[logicalX][logicalY] >= MAXIMAL_STATE) {
			cells[logicalX][logicalY] = 0;
		}
		return cells[logicalX][logicalY];
	}
	
	private int toLogicalXCell(int x) {
		int physicalCellWidth = physicalCellWidth();
		return x/physicalCellWidth;
	}

	private int physicalCellWidth() {
		int physicalWidth = this.getWidth();
		int physicalCellWidth = physicalWidth/xCells;
		return physicalCellWidth;
	}
	
	private int toLogicalYCell(int y) {
		int physicalCellHeight = physicalCellHeight();
		return y/physicalCellHeight;
	}

	private int physicalCellHeight() {
		int physicalHeight = this.getHeight();
		int physicalCellHeight = physicalHeight/yCells;
		return physicalCellHeight;
	}
}
