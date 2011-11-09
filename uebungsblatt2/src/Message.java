/**
 * The class {@code Message} represents a message.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 * @author Forever Alone Guy
 */
public class Message {

	/** the text of the message */
	private String text;
	
	/** the time at which the message is sent */
	private Timestamp time;
	
	/** the sender of the message */
	private Person issuer;

	/**
	 * @return the text of the message
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the time at which the message is sent
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * @return the sender of the message
	 */
	public Person getIssuer() {
		return issuer;
	}

	/**
	 * Constructs a new message instance with the given properties
	 * @param message the text to set for the new message instance
	 * @param time sending time to set for the new message instance
	 * @param issuer the sender to set for the new message instance
	 */
	public Message(String message, Timestamp time, Person issuer) {
		this.text = message;
		this.time = time;
		this.issuer = issuer;
	}
	
	/**
	 * @return a string representation of this message
	 */
	public String toString() {
		// do not include the school because it is not essential to the identification of the person
		return "Message \"" + this.getText() + "\" sent on " + this.getTime().toString() + " by " + this.getIssuer().toString();
	}

}
