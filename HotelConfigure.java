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
import java.util.Scanner;

public class HotelConfigure {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in); // Implements a new scanner.
		boolean invalidVacancies = true; // Will be used later to check if a valid vacancy "yes" or "no" is entered.
		int foundVacancies = 0; // If a vacancy is found, the value becomes 1, hotel automatically has vacancies.
		int nrOfRooms = 0; // Number of rooms in hotel, nullified in the beginning, in case of no rooms.
		String hotelName = new String(); // Hotel name string.

		HotelErrorHandling handleException = new HotelErrorHandling(); // Implements a hotel error handling object, used to handle user errors.

		System.out.println("Enter the name of the hotel:");
		hotelName = userInput.nextLine(); // User inputs hotel name.
		Hotel hotel = new Hotel(hotelName); // Hotel name is passed to Hotel class's constructor.

		System.out.println("Enter the number of rooms:");

		nrOfRooms = handleException.checkIfValidRoomNumberEntered(); // Check if user entered a valid positive integer value and assign it to total hotel rooms.

		for (int i = 0; i < nrOfRooms; i++) { // Iterate between hotel rooms.
			
		    int nrOfBeds = 0; // Number of beds in a room is each time nullified.
			hotel.addRoom(new Room("Room " + (i + 1))); // Adds an extra room to the Room list.

			/*
			 * If a vacancy is found, foundVacancies takes
			 * the value of 1 and, therefore, the hotel
			 * automatically has vacancies and no further
			 * search is needed.
			 */
			
			if (foundVacancies == 0) {
				
				/*
				 * Handles bad user input regarding adding
				 * a vacancy.
				 */
				
				handleException.checkIfValidVacancyEntered(invalidVacancies, foundVacancies, hotel, i+1);
			}
			
			/*
			 * If no vacancies are found, but the cycle
			 * is still stopped, invalidVacancies must
			 * re-take the 'true' value in order to
			 * continue searching for vacancies in other
			 * rooms.
			 */
			
			invalidVacancies = true;

			System.out.println("Enter the number of beds for room " + (i + 1) + ":");
			nrOfBeds = handleException.checkIfValidBedAmountEntered(); // Handles bad user input regarding bed amount in a room.
			
			for (int j = 0; j < nrOfBeds; j++) { // Loop iterates through beds in room.

				System.out.print("Enter the size of bed " + (j + 1) + ":");
				Room room = hotel.getRooms().get(i); // Takes the Hotel's Room object of place 'i'.
				
				if(j==0) userInput.nextLine(); // Passes the token one line down, to correctly do error checking.
				
				/*
				 * Passes the Room object to check bad user input
				 * regarding the entered room bed size.
				 */
				
				handleException.checkIfValidBedSizeEntered(room); 
				
			}

		}
		System.out.println();
		HotelReport.report(hotel); // Prints the hotel report.
		userInput.close();

	}

}
