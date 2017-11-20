package templatemethoddesign;

public class WoodenHouse extends House {
	protected void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}
	protected void buildWalls() {
		System.out.println("Building Wooden Walls");
	}
}
