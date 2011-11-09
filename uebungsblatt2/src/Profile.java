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
	
	/** inbox of this profile's owner */
	private Message lastIncomingMessage;

	/** whether this profile's owner likes soccer */
	private boolean likesSoccer;
	
	/** whether this profile's owner likes racing */
	private boolean likesRacing;
	
	/** whether this profile's owner likes volleyball */
	private boolean likesVolleyball;
	
	/** whether this profile's owner likes swimming */
	private boolean likesSwimming;
	
	/** whether this profile's owner likes rock music */
	private boolean likesRock;
	
	/** whether this profile's owner likes jazz music */
	private boolean likesJazz;
	
	/** whether this profile's owner likes classic music */
	private boolean likesClassic;
	
	/** whether this profile's owner likes dubstep music */
	private boolean likesDubstep;
	
	/** whether this profile's owner likes party */
	private boolean likesParty;
	
	/**
	 * @return the person to which this profile belongs
	 */
	public Person getOwner() {
		return owner;
	}

	/**
	 * @return the current status of this profile's owner
	 */
	public Message getStatus() {
		return status;
	}

	/**
	 * @param school the last school to set for the owner of this profile
	 */
	public void setSchool(School school) {
		this.getOwner().setSchool(school);
	}
	
	/**
	 * @param text the text to set as a status
	 * @param time the time at which this status is set
	 */
	public void setStatus(String text, Timestamp time) {
		// construct a new message object and set it as the new status
		this.status = new Message(text, time, this.getOwner());
	}
	
	/**
	 * Constructs a new profile instance with the given owner
	 * @param owner
	 */
	public Profile(Person owner) {
		this.owner = owner;
	}
	
	/**
	 * @return a short description of this profile
	 */
	public String toString() {
		return "Profile owned by " + this.getOwner().toString() + " with status " + this.getStatus().toString();
	}
	
	/**
	 * Add an interest for the given topic to this profile
	 * @param topic the topic to be interested in
	 */
	public void addInterestFor(Topic topic) {
		this.setInterestFor(topic, true);
	}
	
	/**
	 * Remove an interest for the given topic to this profile
	 * @param topic the topic to not be interested in
	 */
	public void removeInterestFor(Topic topic) {
		this.setInterestFor(topic, false);
	}
	
	/**
	 * Set interest status for the given topic to this profile
	 * @param topic the topic to set the interest status for
	 */
	private void setInterestFor(Topic topic, boolean status) {
		// Bitch please!
		if (topic == Topic.JAZZ_TOPIC) {
			this.likesJazz = true;
		}
		if (topic == Topic.SOCCER_TOPIC) {
			this.likesSoccer = true;
		}
		if (topic == Topic.VOLLEYBALL_TOPIC) {
			this.likesVolleyball = true;
		}
		if (topic == Topic.RACING_TOPIC) {
			this.likesRacing = true;
		}
		if (topic == Topic.ROCK_TOPIC) {
			this.likesRock = true;
		}
		if (topic == Topic.CLASSIC_TOPIC) {
			this.likesClassic = true;
		}
		if (topic == Topic.DUBSTEP_TOPIC) {
			this.likesDubstep = true;
		}
		if (topic == Topic.SWIMMING_TOPIC) {
			this.likesSwimming = true;
		}
		if (topic == Topic.PARTY_TOPIC) {
			this.likesParty = true;
		}		
	}
	
	/**
	 * @param topic the topic to check interest in
	 * @return true if the profile indicates interest, else false
	 */
	public boolean hasInterestFor(Topic topic) {
		// Me gusta!
		if (topic == Topic.JAZZ_TOPIC) {
			return this.likesJazz;
		}
		if (topic == Topic.SOCCER_TOPIC) {
			return this.likesSoccer;
		}
		if (topic == Topic.VOLLEYBALL_TOPIC) {
			return this.likesVolleyball;
		}
		if (topic == Topic.RACING_TOPIC) {
			return this.likesRacing;
		}
		if (topic == Topic.ROCK_TOPIC) {
			return this.likesRock;
		}
		if (topic == Topic.CLASSIC_TOPIC) {
			return this.likesClassic;
		}
		if (topic == Topic.DUBSTEP_TOPIC) {
			return this.likesDubstep;
		}
		if (topic == Topic.SWIMMING_TOPIC) {
			return this.likesSwimming;
		}
		if (topic == Topic.PARTY_TOPIC) {
			return this.likesParty;
		}
		// don't be interested in something by default
		return false;
	}
	
	/**
	 * Deliver the given message to the profile inbux
	 * @param m the message to deliver
	 */
	public void receiveMessage(Message m) {
		this.lastIncomingMessage = m;
	}


	
}
