/**
 * Represents a topic of interest
 * @author Forever Alone Guy
 */
public class Topic {

	/* standard topics */
	public static final Topic SOCCER_TOPIC = new Topic("22_primates_running_after_a_sphere");
	public static final Topic RACING_TOPIC = new Topic("wroom!");
	public static final Topic VOLLEYBALL_TOPIC = new Topic("volleyball");
	public static final Topic SWIMMING_TOPIC = new Topic("swimmin");
	public static final Topic ROCK_TOPIC = new Topic("tokiohotel");
	public static final Topic CLASSIC_TOPIC = new Topic("i'll_be_bach!");
	public static final Topic JAZZ_TOPIC = new Topic("takefive");
	public static final Topic DUBSTEP_TOPIC = new Topic("tweenwave");
	public static final Topic PARTY_TOPIC = new Topic("ne_fette_fette_party");
	
	/**
	 * a keyword identifier for this topic of interest
	 */
	private String identifier;
	
	/**
	 * Construct a new topic with the given property
	 * @param identifier the identifier for this topic
	 */
	private Topic(String identifier) {
		this.identifier = identifier;
	}
}
