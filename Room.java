/**
* This is the second project of Programming (CSC1021) to create
* a hotel management system, with rooms and bed storage, in order
* to test what we have learned in Programming 1 course part 2.
*  
* @author Olivija Guzelyte
* @studentId 160421859
* @version final
* @since   08/12/2016
*/

import java.util.ArrayList;
import java.util.List;

public class Room {

	private List<Bed> beds = new ArrayList<Bed>(); // Creates a list of all the beds in the room.
	private String name = new String(); // Creates the name of the room (for printing on screen purposes).

	public Room(String name) { // Constructor to set the name of the room.
		this.setName(name);
	}

	public List<Bed> getBeds() { // Gets the bed list.
		return beds;
	}

	public void addBed(Bed bed) { // Adds a bed to the list.
		beds.add(bed);
	}

	public void setBeds(List<Bed> beds) { // Sets the bed list.
		this.beds = beds;
	}

	public String getName() { // Returns the name of the room.
		return name;
	}

	public void setName(String name) { // Sets the name of the room.
		this.name = name;
	}

}
