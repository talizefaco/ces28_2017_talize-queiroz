package v0;

import java.util.Arrays;
import java.util.Vector;

class Project {
	 private Person[] participants;

	 //create a vector identical to participants 
	
	
  
  public Person[] getParticipants() { return participants; }
  public int getNumberOfParticipants() { return participants.length; }
  public void setParticipants(Person[] p) { participants=p; }

  //method returns if an object belongs to a list 
  boolean participate(Person x) {
		Vector<Person> vector = new Vector<Person>(Arrays.asList(participants));			 
	    return (vector.contains(x)) ;
   }
 	
  
  public void printParticipants() {
	  for (int i=0; i < participants.length; i++)
		  System.out.println("project has person "+participants[i].id);
  }
  

}

