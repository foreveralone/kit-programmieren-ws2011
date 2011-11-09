/** 
 * This class models a school. A school is represented by its name and address.
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 * @author Forever Alone Guy
 *
 */
public class School {

	/** name of the school */
	private String name;
	
	/** address of the school */
	private String address;

	/**
	 * @return the name of the school
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address of the school
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Constructs a new school instance with the given properties
	 * @param name the name to set for the new school instance
	 * @param address the address to set for the new school instance
	 */
	public School(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * @return a short description of this school instance
	 */
	public String toString() {
		return "School " + this.getName() + " at " + this.getAddress();
	}

}
