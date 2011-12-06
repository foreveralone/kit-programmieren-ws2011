/**
 * This class represents the KITBook itself. It stores and administers 
 * the profiles of the KITBook's members and their relationships.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class KITBook {

	/** Maximum amount of profiles that can be stored */
	private static final int MAX_PROFILES = 50;
	
	/** first profile */
	private Profile profiles[];

	/** current time in KITbook */
	private Timestamp currentTime;

	/**
	 * Constructs a new KITBook out of the given persons and timestamp.
	 * @param person1 first person of new KITBook
	 * @param person2 second person of new KITBook
	 * @param person3 third person of new KITBook
	 * @param currentTime initial current time of new KITBook
	 */
	public KITBook(Timestamp currentTime) {
		this.currentTime = currentTime;
		this.profiles = new Profile[MAX_PROFILES];
	}

	/**
	 * Lets the inner clock of this KITBook tick one minute forward.
	 * @return old timestamp
	 */
	public Timestamp tickTime() {
		Timestamp time = currentTime;
		currentTime = currentTime.tick();
		return time;
	}

	/**
	 * Sends a message with a certain content from the given sender to the given
	 * recipient.
	 * @param from sender of message to be sent
	 * @param to recipient of message to be sent
	 * @param message text of message to be sent
	 */
	public void sendMessage(Person from, Person to, String message) {
		Message msg = new Message(message, tickTime(), from);
		Profile pTo = getProfile(to);
		pTo.receiveMessage(msg);
	}

	/**
	 * Returns whether this KITBook contains the profile of the given person.
	 * @param p owner of the profile to be checked
	 * @return whether this KITBook contains the profile of the given person.
	 */
	public boolean containsPerson(Person p) {
		for (int i = 0; i < this.profiles.length; i++) {
			if (this.profiles[i] == null)
				continue;
			// if the owner is p
			if (this.profiles[i].getOwner().equals(p)) {
				return true;
			}
		}
		// if no such person was found, return false
		return false;
	}

	/**
	 * Returns the profile of the given person. It is assumed that the given person
	 * is a member of this KITBook, i.e. that the profile of the given person
	 * is one of this KITBook's profiles.
	 * @param p person to return the profile of
	 * @return the profile of the given person
	 */
	public Profile getProfile(Person p) {
		for (int i = 0; i < this.profiles.length; i++) {
			if (this.profiles[i] == null)
				continue;
			// if the owner is p
			if (this.profiles[i].getOwner().equals(p)) {
				// return the sought-after Profile
				return this.profiles[i];
			}
		}
		return null;
	}
	
	/**
	 * Returns the profile of the person with the given name. It is assumed that the given person
	 * is a member of this KITBook, i.e. that the profile of the given person
	 * is one of this KITBook's profiles.
	 * @param name name of the person to return the profile of
	 * @return the profile of the given person
	 */
	public Profile getProfile(String personName) {
		for (int i = 0; i < this.profiles.length; i++) {
			if (this.profiles[i] == null)
				continue;
			// if the owner is p
			if (this.profiles[i].getOwner().getName().equals(personName)) {
				// return the sought-after Profile
				return this.profiles[i];
			}
		}
		return null;
	}

	/**
	 * Returns, whether the two given persons are friends in this KITBook. If
	 * one of the given persons is not a member of the KITBook, then {@code false}
	 * is returned.
	 * @param p1 first person
	 * @param p2 second person
	 * @return whether first person and second person are friends in this KITBook.
	 */
	public boolean areFriends(Person p1, Person p2) {
		return this.getProfile(p1).isBefriendedWith(this.getProfile(p2));
	}

	/**
	 * Stores the friendship between the two given persons, if they are both members
	 * of this KITBook. If one of them is not, nothing happens.
	 * @param p1 first person
	 * @param p2 second person
	 * @return true if the operation was successful, else false
	 */
	public boolean addFriendship(Person p1, Person p2) {
		// make sure a person never befriends itself!
		// make sure both persons are member of this KITBook
		if (!p1.equals(p2)
				&& this.containsPerson(p1)
				&& this.containsPerson(p2)) {
			// establish a symmetric friend relationship
			this.getProfile(p1).addFriendship(this.getProfile(p2));
			this.getProfile(p2).addFriendship(this.getProfile(p1));
			return true;
		}
		return false;
	}
	
	/**
	 * Remove the friend relationship between the two given persons, if there is any
	 * @param p1 first Person
	 * @param p2 second Person
	 * @return true if the operation was successful, else false
	 */
	public boolean removeFriendship(Person p1, Person p2) {
		// make sure that they are both in KITBook
		if (this.containsPerson(p1) && this.containsPerson(p2)) {
			// return if both removal operations were successful
			return this.getProfile(p1).removeFriendship(this.getProfile(p2))
					&& this.getProfile(p2).removeFriendship(this.getProfile(p1));
		}
		return false;
	}
	
	/**
	 * Add a Profile belonging to the given Person p to this instace
	 * @param p the Person the new profile shall belong to
	 * @return true if the operation succeeded, else false
	 */
	public boolean addPerson(Person p) {
		if (this.containsPerson(p))  {
			// return false if a profile belonging to this person is already managed by this instance
			return false;
		}
		if (p == null) {
			// can't add null Persons!
			return false;
		}
		// insert a new Profile at the next free position
		for (int i = 0; i < this.profiles.length; i++) {
			if (this.profiles[i] == null) {
				this.profiles[i] = new Profile(p);
				return true;
			}
		}
		// no free slot was found
		return false;
	}
	
	/**
	 * Remove the profile belonging to the Person p from this KITBook
	 * @param p the person whose Profile shall be removed
	 * @return true if the operation succeeded, else false
	 */
	public boolean removePerson(Person p) {
		for (int i = 0; i < this.profiles.length; i++) {
			// if the owner is p
			if (this.profiles[i].getOwner().equals(p)) {
				// remove the profile from the array
				this.profiles[i] = null;
				return true;
			}
		}
		// if no such person was found, return false
		return false;
	}
	/**
	 * Returns the number of profiles managed by this instance
	 * @return
	 */
	public int getSize() {
		// count the number of non-null slots in the array - no big deal
		int count = 0;
		for (int i = 0; i < this.profiles.length; i++) {
			if (this.profiles[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * @return an Array of all Persons whose Profiles are managed by this KITBook instance
	 */
	public Person[] getPersons() {
		// compact array of Persons to be returned
		Person[] compactPersons = new Person[this.getSize()];
		// index variable for next free in compactPersons
		int j = 0;
		
		for (int i = 0; i < this.profiles.length; i++) {
			if (this.profiles[i] != null) {
				// stuff the owner of the profile into the result array
				compactPersons[j++] = this.profiles[i].getOwner();
			}
		}
		return compactPersons;
	}
	
	/**
	 * Return a person other than p with the most similar interests in this KITBook
	 * @param p the Person to find somebody similar to
	 * @return the most similar Person to p
	 */
	public Person findMostSimilarTo(Person p) {
		int bestCount = 0;
		Person bestPerson = null;
		
		Profile ownProfile = this.getProfile(p);
		
		for (int i = 0; i < this.getPersons().length; i++) {
			// check if we are not comparing to ourselves
			if (this.getPersons()[i].equals(p)) {
				continue;
			}
			// get the other profile
			Profile otherProfile = this.getProfile(this.getPersons()[i]);
			// count the similarities and compare it to the best we've got
			if (ownProfile.countSimilarities(otherProfile) > bestCount) {
				bestCount = ownProfile.countSimilarities(otherProfile);
				bestPerson = otherProfile.getOwner();
			}
		}
		return bestPerson;
	}

}
