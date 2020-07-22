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

import java.util.List;

public class HotelReport {

	public static void report(Hotel currentHotel) { // Passes a Hotel object to a static method.

		int maxOccupancy = 0; // Variable used to count maximum occupancy of the hotel. Set to 0.
		System.out.println("HOTEL SPECIFICATIONS:\n\nHotel name: " + currentHotel.getName() + "."); // Get and print the Hotel name.
		List<Room> roomsInHotel = currentHotel.getRooms(); // List of all the rooms in hotel.
		System.out.println("The number of rooms is: " + roomsInHotel.size() + "."); // Get the amount of rooms in the Hotel object and print them.

		for (int i = 0; i < roomsInHotel.size(); i++) { // Iterate through all the rooms in hotel.

			int bedsInRoom = roomsInHotel.get(i).getBeds().size(); // Get the amount of beds in one room and assign it to a variable.

			System.out.printf("\n%s, number of beds: %d.\nBed sizes: ", roomsInHotel.get(i).getName(), bedsInRoom); // Get the name of the specific room and the amount of beds, print them out.

			for (int j = 0; j < bedsInRoom; j++) { // Iterate through all the beds in specific room.

				String currentBedSize = roomsInHotel.get(i).getBeds().get(j).getSizeOfBed(); // Get the size of the specific bed in the room, assign it to a variable.

				if (currentBedSize.toLowerCase().equals("double")) { // If lower cased bed size equals 'double', maximum hotel occupancy is enhanced by 2. 
					maxOccupancy += 2;
				} else if (currentBedSize.toLowerCase().equals("Single")) // If lower cased bed size equals 'single', maximum hotel occupancy is enhanced by 1. 
					maxOccupancy++;
				
                char capitalChar = Character.toUpperCase(currentBedSize.charAt(0)); // First character of room size is forcefully upper cased.
                currentBedSize = currentBedSize.toLowerCase(); // The bed size string is forcefully made lower cased.
                String finalBedSize = currentBedSize.replace(currentBedSize.charAt(0), capitalChar); // The first bed size character is replaced by the upper case one.
                  
				System.out.print(finalBedSize + " "); // Print out current bed size. 
			}

			System.out.print("\n");

		}

		System.out.printf("\nMaximum occupancy is: %d.\n", maxOccupancy); // Print out calculated maximum occupancy.
		System.out.printf("Has vacancies? %s", currentHotel.vacanciesReturnValue()); // Return the method from the Hotel class, telling if there are any vacancies in the hotel.
	}

}