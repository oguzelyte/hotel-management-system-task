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

public class HotelTest {

	public static void main(String[] args) {

		final int ROOMS = 3; // The amount of rooms in a hotel.
		final int[] BEDS_IN_ROOM = { 2, 1, 3 }; // The number of beds in each room.
		final String[] SIZE_OF_BED = { "double", "SiNGle", "Single", "Double", "Single", "Double" }; // The sizes of each bed.
		int size = 0; // Created to iterate through SIZE_OF_BED array.
		final boolean[] VACANCIES = { false, false, false }; //The vacancies of each room.		

		Hotel hotel = new Hotel("Turkish Delight"); // Create a new hotel object with a name assigned to it.

		for (int i = 0; i < ROOMS; i++) { // Iterate through all the rooms.

			hotel.addRoom(new Room("Room " + (i + 1))); // Add a new room to the hotel object each loop iteration.

			/*
			 * If any room is found vacant, automatically
			 * set that the hotel has vacancies.
			 */
			
			if (VACANCIES[i] == true)
				hotel.setHasVacancies(VACANCIES[i]);

			/*
			 * Iterate through all the beds of each 
			 * room and add a bed object to the 
			 * specific room at each cycle.
			 */
			
			for (int j = 0; j < BEDS_IN_ROOM[i]; j++) {
				hotel.getRooms().get(i).addBed(new Bed(SIZE_OF_BED[size]));
				size++; // Increment the size of size to iterate well through the SIZE_OF_BED array.
			}
		}

		HotelReport.report(hotel); // Print it out to the screen.

	}

}
