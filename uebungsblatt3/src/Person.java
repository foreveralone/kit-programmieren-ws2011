public class Person {

	/** name of the person */
	private String name;
	
	/** birthday of the person */
	private Timestamp birthday;
	
	/**
	 * Constructs a new person with the given values.
	 * @param name name of the person
	 * @param birthday birthday of the person
	 */
	public Person(String name, Timestamp birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	/**
	 * Returns this person's birthday.
	 * @return this person's birthday
	 */
	public Timestamp getBirthday() {
		return birthday;
	}

	/**
	 * Returns this person's name.
	 * @return this person's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns this person's zodiac.
	 * @return this person's zodiac
	 */
	public String getZodiac() {
		return birthday.getZodiac();
	}
	
	/**
	 * Returns a string representation of this person.
	 * @return a string representation of this person
	 */
	public String toString() {
		return name + " (*" + birthday.getDay() + "." + birthday.getMonth() + "." + birthday.getYear() + ")";
	}
	
	/**
	 * @return true if this Person is the same as the Person other, else false
	 */
	public boolean equals(Person other) {
		return (this.getName().equals(other.getName())
				&& this.getBirthday().equals(other.getBirthday()));
	}
	

}
