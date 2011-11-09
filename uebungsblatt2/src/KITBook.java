/**
 * Management controller for the KITBook social network
 * @author Forever Alone Guy
 *
 */
public class KITBook {

	/**
	 * the first profile managed by this instance
	 */
	private Profile profile1;
	
	/**
	 * the second profile managed by this instance
	 */
	private Profile profile2;
	
	/**
	 * the third profile managed by this instance
	 */
	private Profile profile3;
	
	/**
	 * the status of the friend relationship between the first and the second profile
	 */
	private boolean firstFriendSecond;
	
	/**
	 * the status of the friend relationship between the first and the third profile
	 */
	private boolean firstFriendThird;
	
	/**
	 * the status of the friend relationship between the third and the second profile
	 */
	private boolean secondFriendThird;
	
	/**
	 * the current time on the social network
	 */
	private Timestamp currentTime;
	
	/**
	 * Constructs a new instance with the given persons and current timestamp
	 * @param person1 the first person to manage
	 * @param person2 the second person to manage
	 * @param person3 the third person to manage
	 * @param currentTime the current time in the KITBook universe
	 */
	public KITBook(Person person1, Person person2, Person person3, Timestamp currentTime) {
		this.profile1 = new Profile(person1);
		this.profile2 = new Profile(person2);
		this.profile3 = new Profile(person3);
		this.currentTime = currentTime;
	}
	
	/**
	 * @return true if the given person is managed by this KITBook instance, else false
	 * @param p
	 * @return
	 */
	public boolean containsPerson(Person p) {
		return (this.profile1.getOwner() == p || this.profile2.getOwner() == p || this.profile3.getOwner() == p);
	}
	
	/**
	 * @param p the person to get the profile for
	 * @return the profile belonging to the given Person p
	 */
	public Profile getProfile(Person p) {
		if (this.profile1.getOwner() == p) {
			return this.profile1;
		}
		if (this.profile2.getOwner() == p) {
			return this.profile2;
		}
		if (this.profile3.getOwner() == p) {
			return this.profile3;
		}
		// if no valid person is given, return null
		return null;
	}

	/**
	 * @param p1 the first person in the relation to check
	 * @param p2 the second person in the relation to check
	 * @return true if first and second are friends in this KITBook instance, else false
	 */
	public boolean areFriends(Person p1, Person p2) {
		if (this.profile1.getOwner() == p1) {
			if (this.profile2.getOwner() == p2) {
				return this.firstFriendSecond;
			}
			if (this.profile3.getOwner() == p2) {
				return this.firstFriendThird;
			}
		}
		if (this.profile2.getOwner() == p1) {
			if (this.profile1.getOwner() == p2) {
				return this.firstFriendSecond;
			}
			if (this.profile3.getOwner() == p2) {
				return this.secondFriendThird;
			}
		}
		if (this.profile3.getOwner() == p1) {
			if (this.profile2.getOwner() == p2) {
				return this.secondFriendThird;
			}
			if (this.profile1.getOwner() == p2) {
				return this.firstFriendThird;
			}
		}
		// if either p1 or p2 are not managed by this KITBook, return false
		return false;
	}
	
	/**
	 * sets a friend relationship between the two given persons
	 * @param p1 the first person in the relationship
	 * @param p2 the second person in the relationship
	 */
	public void addFriendship(Person p1, Person p2) {
		if (this.profile1.getOwner() == p1) {
			if (this.profile2.getOwner() == p2) {
				this.firstFriendSecond = true;
			}
			if (this.profile3.getOwner() == p2) {
				this.firstFriendThird = true;
			}
		}
		if (this.profile2.getOwner() == p1) {
			if (this.profile1.getOwner() == p2) {
				this.firstFriendSecond = true;
			}
			if (this.profile3.getOwner() == p2) {
				this.secondFriendThird = true;
			}
		}
		if (this.profile3.getOwner() == p1) {
			if (this.profile2.getOwner() == p2) {
				this.secondFriendThird = true;
			}
			if (this.profile1.getOwner() == p2) {
				this.firstFriendThird = true;
			}
		}
	}

	/**
	 * Send a message to a profile
	 * @param from the sender of the message
	 * @param to the receipient of the message
	 * @param message the message body
	 */
	public void sendMessage(Person from, Person to, String message) {
		// create the message
		Message m = new Message(message, this.currentTime, from);
		// deliver it
		this.getProfile(to).receiveMessage(m);
	}


	
}
