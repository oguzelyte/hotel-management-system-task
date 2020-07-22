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
import java.util.Collections;
import java.util.List;

public class Hotel {

	private String name = new String(); // Tells the name of the hotel.
	private List<Room> rooms = new ArrayList<Room>(); // Tells how many rooms there are in the hotel.
	private boolean hasVacancies = false; // Tells if a hotel has vacancies or not.

	public Hotel(String name) { // Constructor to set a hotel's name.
		this.setName(name);
	}

	public void addRoom(Room room) { // Helps to add a room easier.
		rooms.add(room);
	}

	public List<Room> getRooms() { // Gets the list of all the rooms.
		return Collections.unmodifiableList(rooms);
	}

	public void setRooms(List<Room> rooms) { // Sets the list of all the rooms.
		this.rooms = rooms;
	}

	public String getName() { // Gets the hotel name.
		return name;
	}

	public void setName(String name) { // Sets the hotel name.
		this.name = name;
	}

	public boolean isHasVacancies() { // Returns if a hotel has vacancies or not.
		return hasVacancies;
	}

	/*
	 * Sets the value of vacancies to either false or true.
	 * False - there aren't any available rooms.
	 * True - there are available rooms.
	 */
	
	public void setHasVacancies(boolean hasVacancies) {
		this.hasVacancies = hasVacancies;
	}
	
	/*
	 * If there are vacancies in the hotel (hasVacancies = true) returns 'yes', otherwise returns 'no'.
	 */
	
	public String vacanciesReturnValue() {
		if (isHasVacancies()) {
			return "Yes.";
		} else
			return "No.";
	}
}
