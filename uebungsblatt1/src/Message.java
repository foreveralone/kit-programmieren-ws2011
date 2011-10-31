/**
 * Represents a textual message
 */
public class Message {

	/**
	 * The date and time on which this message was sent
	 */
	Timestamp sentTimestamp;
	
	/**
	 * The person that this message was sent by
	 */
	Person sender;
	
	/**
	 * The textual context of this message
	 */
	String content;
}
