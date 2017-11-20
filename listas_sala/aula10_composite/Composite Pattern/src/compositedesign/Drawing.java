package compositedesign;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {
	private List<Shape> drawing = new ArrayList<Shape>();
	public Drawing() {
		
	}
	@Override
	public void draw(String fillColor) {
		for(int i = 0; i < drawing.size(); i ++) {
			drawing.get(i).draw(fillColor);
		}
	}
	
	public void add(Shape shape) {
		drawing.add(shape);
	}
	
	public void remove(Shape shape) {
		drawing.remove(shape);
	}
	
	public void clear() {
		System.out.println("Clearing all the shapes from the drawing");
		drawing.clear();
	}
}
