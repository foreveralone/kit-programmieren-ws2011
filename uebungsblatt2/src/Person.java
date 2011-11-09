/**
 * The class {@code Person} models a person.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 * @author Forever Alone Guy
 */
public class Person {

	/** name of the person */
	private String name;
	
	/** birthday of the person */
	private Timestamp birthday;
	
	/** last school of the person */
	private School school;

	/**
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the birthday of the person
	 */
	public Timestamp getBirthday() {
		return birthday;
	}

	/**
	 * @return the last school of the person
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school the last school to set for the person
	 */
	protected void setSchool(School school) {
		this.school = school;
	}
	
	/**
	 * Constructs a new person instance with the given properties
	 * @param name the name to set for the new person instance
	 * @param birthday the birthday to set for the new person instance
	 */
	public Person(String name, Timestamp birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	/**
	 * @return a short description of this person
	 */
	public String toString() {
		// do not include the school because it is not essential to the identification of the person
		return this.getName() + " born on " + this.getBirthday().toString();
	}

}
