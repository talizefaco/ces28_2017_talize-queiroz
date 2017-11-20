package templatemethoddesign;

public class House {
	public final void buildHouse(){
		buildFoundation();
	  	buildPillars();
	  	buildWalls();
	  	buildWindows();
	  	System.out.println("House is built.");
	}
	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rodsand sand");
	}
	protected void buildPillars() {
		System.out.println("Building Pillars");
	}
	protected void buildWalls() {
		System.out.println("Building Walls");
	}
	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}
}
