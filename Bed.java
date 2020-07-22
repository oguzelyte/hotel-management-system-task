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

public class Bed {

	private String sizeOfBed = new String(); // Initial size of bed is undefined.

	public Bed(String sizeOfBed) { // Constructor to set size of bed.
		this.setSizeOfBed(sizeOfBed);
	}

	public String getSizeOfBed() { // Returns the size of the bed.
		return sizeOfBed;
	}

	public void setSizeOfBed(String sizeOfBed) { // Sets the size of the bed.
		this.sizeOfBed = sizeOfBed;
	}

}
