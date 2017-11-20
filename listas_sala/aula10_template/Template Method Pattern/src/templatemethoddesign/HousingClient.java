package templatemethoddesign;

public class HousingClient {
	public static void main(String[] args) {
		WoodenHouse woodenhouse = new WoodenHouse();
		woodenhouse.buildHouse();
		System.out.println("************");
		
		GlassHouse glasshouse = new GlassHouse();
		glasshouse.buildHouse();
		System.out.println("************");
	}
}
