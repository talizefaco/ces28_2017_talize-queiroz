package aula10;

import java.util.ArrayList;
import java.util.List;

public class Fiveton {
	private final static int max_instancias = 3;
	private static int currentIndex = 1;
	private static List<Singleton> available = new ArrayList<Singleton>();
	private static List<Singleton> inUse = new ArrayList<Singleton>();
	
	static public class Singleton {
		private int index;
		private Singleton(int num) {
			index = num;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void printIndex() {
			System.out.println(index);
		}
	}
	
	public Fiveton() {
		Singleton a = new Singleton(currentIndex);
		available.add(a);
		currentIndex += 1;
		Singleton b = new Singleton(currentIndex);
		currentIndex += 1;
		available.add(b);
	}
	
	public static Singleton getInstancia() {
		if (inUse.size() > max_instancias) throw new RuntimeException("Tamanho limite excedido.");
		if(available.size() > 0) {
			Singleton instancia = available.get(0);
			available.remove(instancia);
			inUse.add(instancia);
			return instancia;
		}
		Singleton instancia = new Singleton(currentIndex);
		currentIndex += 1;
		inUse.add(instancia);
		return instancia;
	}
	
	public static void destroy(Singleton instancia) {
		inUse.remove(instancia);
		available.add(instancia);
	}
	
	public static void main(String[] args) {
		Fiveton fiveton = new Fiveton();
		Singleton elem1 = fiveton.getInstancia();
		Singleton elem2 = fiveton.getInstancia();
		Singleton elem3 = fiveton.getInstancia();
		Singleton elem4 = fiveton.getInstancia();
		fiveton.destroy(elem3);
		elem4 = fiveton.getInstancia();
		elem4.printIndex();
	}
}