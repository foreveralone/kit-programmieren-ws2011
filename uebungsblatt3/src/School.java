/**
 * This class models a school. A school is represented by its name and address.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class School {

	/** name of the school */
	private String name;
	
	/** address of the school */
	private String address;

	/** 
	 * Constructs a new school with the given values.
	 * @param name name of the new school
	 * @param address address of the new school
	 */
	public School(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * Returns this school's name.
	 * @return this school's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns this school's address.
	 * @return this school's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns a string representation of this school.
	 * @return a string representation of this school
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * @return true if this School is equal to the School other, else false
	 */
	public boolean equals(School other) {
		return (this.getName().equals(other.getName())
				&& this.getAddress().equals(other.getAddress()));
	}
 }
