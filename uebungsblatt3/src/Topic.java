/**
 * This class models a topic which members of the KITBook can be interested in.
 * A topic is represented by a keyword describing it.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public final class Topic {

	/** keyword which describes this topic */
	private String keyword;
	
	
	/**
	 * topic "soccer"
	 */
	public static final Topic SOCCER = new Topic("Soccer");
	
	
	/**
	 * topic "racing"
	 */
	public static final Topic RACING = new Topic("Racing");
	
	
	/**
	 * topic "volleyball"
	 */
	public static final Topic VOLLEYBALL = new Topic("Volleyball");
	
	/**
	 * topic "swimming"
	 */
	public static final Topic SWIMMING = new Topic("Swimming");
	
	/**
	 * topic "rock music"
	 */
	public static final Topic ROCK = new Topic("Rock");
	
	/**
	 * topic "jazz music"
	 */
	public static final Topic JAZZ = new Topic("Jazz");
	
	/**
	 * topic "classic music"
	 */
	public static final Topic CLASSIC = new Topic("Classic");
	
	/**
	 * topic "dubstep"
	 */
	public static final Topic DUBSTEP = new Topic("Dubstep");
	
	/**
	 * topic "party"
	 */
	public static final Topic PARTY = new Topic("Party");
	
	/**
	 * Constructs a new topic from the given keyword
	 * @param keyword keyword which describes the new topic
	 */
	private Topic(String keyword) {
		this.keyword = keyword;
	}
	
	/**
	 * Returns the keyword describing this topic.
	 * @return the keyword describing this topic
	 * @uml.property  name="keyword"
	 */
	public String getKeyword() {
		return keyword;
	}
	
	/**
	 * Returns a string representation of this topic.
	 * @return a string representation of this topic
	 */
	public String toString() {
		return "Topic(" + keyword + ")";
	}
	
}
