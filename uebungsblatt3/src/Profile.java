/**
 * The class {@code Profile} represents a profile of a {@link Person} in KITBook.
 * A profile stores the current status, the inbox and information about the
 * interests of its owner.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 * @author Forever Alone Guy
 */
public class Profile {

	/** the person to which this profile belongs */
	private Person owner;
	
	/** current status of this profile's owner */
	private Message status;
	
	/** last school of this profile's owner */
	private School school;
	
	/** maximum number of friendship relations managed by a Profile */
	private static final int MAX_FRIENDS = 20;
	
	/** other profiles that this Profile has a friend relationship with */
	private Profile[] friends;
	
	/** inbox of this profile's owner */
	private Message lastIncomingMessage;
	
	/** links posted by this profile's owner */
	private Link[] postedLinks = new Link[30];
	
	/**
	 * List containing all the interests of the owner
	 */
	private InterestList interests = new InterestList();

	/**
	 * Constructs a new profile for the given person.
	 * @param owner the owner of the new profile
	 */
	public Profile(Person owner) {
		this.friends = new Profile[MAX_FRIENDS];
		this.owner = owner;
	}
	
	/**
	 * returns this profile's owner.
	 * @return this profile's owner
	 */
	public Person getOwner() {
		return owner;
	}
	
	/**
	 * returns this profile's status.
	 * @return this profile's status
	 */
	public Message getStatus() {
		return status;
	}
	
	/**
	 * Returns this profile's owner's last school.
	 * @return this profile's owner's last school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * Sets this profile's owner's last school.
	 * @param school the new school
	 */
	public void setSchool(School school) {
		this.school = school;
	}
	
	/**
	 * Sets the status of this profile.
	 * @param message text representing the new status of this profile
	 * @param time time at which the status update occurred
	 */
	public void setStatus(String message, Timestamp time) {
		this.status = new Message(message, time, owner);
	}
	
	/**
	 * Stores the given message in this profile's inbox.
	 * @param msg message to recieve
	 */
	public void receiveMessage(Message msg) {
		this.lastIncomingMessage = msg;
	}

	/**
	 * Returns the last incoming message of this profile.
	 * @return the last incoming message of this profile
	 */
	public Message getLastIncomingMessage() {
		return lastIncomingMessage;
	}
	
	/**
	 * Returns whether this profile's owner is interested in the given topic.
	 * @param topic topic to check interest for
	 * @return true if this profile's owner is interested in the given topic,
	 * false otherwise
	 */
	public boolean hasInterestFor(Topic topic) {
		return this.interests.contains(topic);
	}
	
	/**
	 * Stores the information that this profile's owner is interested in the 
	 * given topic.
	 * @param topic topic to store interest for
	 */
	public boolean addInterestFor(Topic topic) {
		return this.interests.add(topic);
	}
	
	/**
	 * Stores the information that this profile's owner is not interested in the 
	 * given topic.
	 * @param topic topic to store interest for
	 */
	public boolean removeInterestFor(Topic topic) {
		return this.interests.remove(topic);
	}
	
	/**
	 * Get an array of Topics of interest of this profile's owner
	 * @return the array of Topics the owner is interested in
	 */
	public Topic[] getInterests() {
		return this.interests.getTopics();
	}

	
	/**
	 * Returns a string representation of this profile.
	 * @return a string representation of this profile
	 */
	public String toString() {
		return "Profile of " + getOwner();
	}
	
	/**
	 * Add a friend relationship with the given profile p
	 * @param p the Profile to befriend
	 * @return true if the operation succeeded, else false
	 */
	public boolean addFriendship(Profile p) {
		if (this.isBefriendedWith(p))  {
			// return false if a profile belonging to this person is already managed by this instance
			return false;
		}
		if (p == null) {
			// can't add null Friendships!
			return false;
		}
		// insert a new Friendship at the next free position
		for (int i = 0; i < this.friends.length; i++) {
			if (this.friends[i] == null) {
				this.friends[i] = p;
				return true;
			}
		}
		// no free slot was found
		return false;
	}
	
	/**
	 * Remove the friend relationship with the Profile p
	 * @param p the Profile to un-befriend
	 * @return true if the operation succeeded, else false
	 */
	public boolean removeFriendship(Profile p) {
		for (int i = 0; i < this.friends.length; i++) {
			if (this.friends[i] == null)
				continue;
			// if the friendship is the one we want to remove
			if (this.friends[i].equals(p)) {
				// remove the friendship from the array
				this.friends[i] = null;
				return true;
			}
		}
		// if no such Friendship was found, return false
		return false;
	}
	/**
	 * Returns the number of friendships this profile has
	 * @return
	 */
	public int getNumberOfFriends() {
		// count the number of non-null slots in the array - no big deal
		int count = 0;
		for (int i = 0; i < this.friends.length; i++) {
			if (this.friends[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	public Profile[] getFriends() {
		// compact array of Friends to be returned
		Profile[] compactFriends = new Profile[this.getNumberOfFriends()];
		// index variable for next free in compactFriends
		int j = 0;
		
		for (int i = 0; i < this.friends.length; i++) {
			if (this.friends[i] != null) {
				// stuff the owner of the profile into the result array
				compactFriends[j++] = this.friends[i];
			}
		}
		return compactFriends;
	}
	
	/**
	 * Check if a friend relationship with the Profile p exists
	 * @param p the Profile to check the friend relationship with
	 * @return if a friend relationship exists with the Profile p
	 */
	public boolean isBefriendedWith(Profile p) {
		for (int i = 0; i < this.friends.length; i++) {
			if (this.friends[i] == null)
				continue;
			// if the friend is p
			if (this.friends[i].equals(p)) {
				return true;
			}
		}
		// if no such friend was found, return false
		return false;
	}
	
	/**
	 * Post a new link to the list of recently posted links
	 * @param l the Link to post
	 */
	public void postLink(Link l) {
		// search for the next free slot
		for (int i = 0; i < this.postedLinks.length; i++) {
			if (this.postedLinks[i] == null) {
				// a new slot was found - store our given link there!
				this.postedLinks[i] = l;
				// our deed is done here
				return;
			}
		}
		// if no free slot is found, nothing happens
	}
	
	/**
	 * Return the number of Topics of interests shared with the given profile
	 * @param other the Profile to compare with
	 * @return
	 */
	public int countSimilarities(Profile other) {
		int count = 0;
		
		// loop through all our own interests
		for (int i = 0; i < this.getInterests().length; i++) {
			Topic t = this.getInterests()[i];
			// check if t exists in the other profile
			for (int j = 0; j < other.getInterests().length; j++) {
				if (other.getInterests()[i].equals(t)) {
					// it was found! increase count and continue at the next of our interests
					count++;
					break;
				}
			}
		}
		
		return count;
	}

}
