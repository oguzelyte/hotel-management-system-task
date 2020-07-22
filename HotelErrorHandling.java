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

public class HotelErrorHandling { // Class generally used to handle user-made errors.

	private Scanner userInput = new Scanner(System.in); // New private scanner is implemented.
	
	public int checkIfValidRoomNumberEntered() { // Check if user entered a valid room amount.

		boolean invalidRooms = true; // Until user enters a valid room amount, the invalidRooms is true.
		int nrOfRooms = 0; // Number of rooms, in the beginning is zero.
	
		while (invalidRooms) { // Until invalid amount is entered.
			try {
				nrOfRooms = userInput.nextInt(); // User keeps inputting his values.
				if (nrOfRooms >= 0) { // If the entered value is integer and positive, the value is valid, cycle is exited.
					invalidRooms = false;
				} else // If the entered value is integer, but negative, an exception is thrown.
					throw new IllegalArgumentException();
			} catch (IllegalArgumentException k) { // Catches the negative integer exception, asks user to try to input a value again.
				System.out.println("Enter a positive integer value (or 0).");
				userInput.nextLine();
			} catch (Exception e) { // If user types in a char or a string, asks user to try to input a value again.
				System.out.println("Enter a positive integer value (or 0).");
				userInput.nextLine();

			}
		}
		return nrOfRooms; // The valid value of rooms in a hotel is returned back to the HotelConfigure class.
	}
	
	public int checkIfValidVacancyEntered(boolean invalidVacancies, int foundVacancies, Hotel hotel, int i){ // Checks if user enters a proper vacancy value ('yes' or 'no').
		
		String vacancy = new String(); // New vacancy string.
		System.out.print("Does room " + i + " have any vacancies? (yes/no)");

		while (invalidVacancies) { // Iterates until the user input is faulty.
			try {
				vacancy = userInput.next(); // User inputs a string.
				Integer.parseInt(vacancy); // Checks if user put in a string or an integer. If an string, throws an exception.
				System.out.println("Enter \"yes\" or \"no\".");
			} catch (Exception e) {
				if (vacancy.equals("yes")) { // If string equals 'yes', hotel has vacancies.
					hotel.setHasVacancies(true);
					foundVacancies = 1; // A vacancy is found, an if statement in HotelConfigure will stop any upcoming iterations.
					invalidVacancies = false; // Cycle is stopped then.
				} else if (vacancy.equals("no")) { // If string equals 'no', the cycle is stopped but the search for vacancies in HotelConfigure will continue.
					invalidVacancies = false;
				} else {
					System.out.println("Enter \"yes\" or \"no\"."); // Otherwise, a person has to continue typing in values.
				}
				userInput.nextLine();
			}

		}
		return foundVacancies; // Returns either 1 or 0, depending on if a vacancy was found or not.
	}
	
	public int checkIfValidBedAmountEntered(){ // Checks if bed amount value entered by user isn't faulty.
		
		boolean invalidBeds = true; // The invalidBeds is set to true, in order to be set to false when user inputs the correct value.
		int nrOfBeds = 0; // Number of beds is assigned to zero originally.
		
		while (invalidBeds) {
			try {
				nrOfBeds = userInput.nextInt(); // User is asked to input an integer value for the amount of beds.
				if (nrOfBeds >= 0) { // If the value is positive or zero, the cycle is stopped, correct value found.
					invalidBeds = false;
				} else
					throw new IllegalArgumentException(); // Otherwise, an exception is thrown.
			} catch (IllegalArgumentException e) { // Handles the negative value exception.
				System.out.println("Enter a positive integer value (or 0).");
				userInput.nextLine();
			} catch (Exception e) { // Handles type mismatch exception.
				System.out.println("Enter an integer value.");
				userInput.nextLine();
			}
		}
		return nrOfBeds;
		
	}
	
	public void checkIfValidBedSizeEntered(Room room){ // Check if the entered bed size value is appropriate.
		
		boolean invalidSize = true; // invalidSize is true until proven that it's not invalid.
		String sizeOfBed = new String(); // sizeOfBed is a new undefined string object.
		while (invalidSize) { // Iterations until invalidSize is true.
			try {
				sizeOfBed = userInput.nextLine(); // User inputs a string.

				Integer.parseInt(sizeOfBed); // If the string is an integer, asks for a text value, otherwise throws an exception.
				System.out.println("Enter a text value.");

			} catch (Exception e) { // Exception handles the proper text value, checks if it equals to double or single and adds those values to Bed objects, respectively.
				if (sizeOfBed.toLowerCase().equals("double")) {
					room.addBed(new Bed("Double"));
					invalidSize = false; // Stops the cycle.
				} else if (sizeOfBed.toLowerCase().equals("single")) {
					room.addBed(new Bed("Single"));
					invalidSize = false; // Stops the cycle.
				} else {
					 // If the text value is inappropriate, it asks the user to enter another value.
					System.out.println("Enter either \"Double\" or \"Single\".");
				}

			}

		}
	}

}
