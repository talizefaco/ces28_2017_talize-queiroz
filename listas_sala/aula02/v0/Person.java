package v0;


public class Person {
	int id;
	static int nextId=0;
	Person(){
		id = nextId++;
	}
	
	
	   
	public int getId() {
	  return id;
	}
	
	 public boolean equals(Object o){
	        return id == ((Person) o).getId();
	    }


}
