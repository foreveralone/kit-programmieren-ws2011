/**
 * The class {@code Message} represents a message.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class Message {

	/** the text of the message */
	private String text;
	
	/** the time at which the message is sent */
	private Timestamp time;
	
	/** the sender of the message */
	private Person issuer;

	
	/**
	 * Constructs a message with the given values.
	 * @param text the content of the message
	 * @param time the time at which the message was sent
	 * @param owner the sender of the message
	 */
	public Message(String text, Timestamp time, Person owner) {
		this.text = text;
		this.time = time;
		this.issuer = owner;
	}

	/**
	 * Returns this message's sending time.
	 * @return this message's sending time
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * Returns this message's issuer.
	 * @return this message's issuer
	 */
	public Person getIssuer() {
		return issuer;
	}

	/**
	 * Returns this message's text.
	 * @return this message's text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns a string representation of this message.
	 * @return a string representation of this message
	 */
	public String toString() {
		return issuer + ": '" + text + "'";
	}
	
	/**
	 * @return true if this Message is equal to the Message other, else false
	 */
	public boolean equals(Message other) {
		return (this.getText().equals(other.getText())
				&& this.getTime().equals(other.getTime()));
	}
}
