/**
 * Represents a Hyperref given in URL type with implicit http:// prefix (because HTTP is the new TCP)
 * @author Forever Alone Guy
 *
 */
public class Link {

	public static final Link BILD = new Link("bild.de", new Topic[]{ Topic.RACING, });
	public static final Link THE_KOOKS = new Link("thekooks.com", new Topic[]{ Topic.ROCK, });
	public static final Link MILES_DAVIS = new Link("milesdavis.com", new Topic[]{ Topic.JAZZ, });
	
	/**
	 * The "URL" that this object links to
	 * (is there any other protocol than http?)
	 */
	private String target;

	/**
	 * a list of topics that this hyperref is related to
	 */
	private InterestList topicList;

	/**
	 * Constructs a new Link object with the given target and related topics
	 * @param newTarget the target the new Link object shall point to
	 * @param newTopics the list of topics the new Link object shall be related to
	 */
	public Link(String newTarget, Topic[] newTopics) {
		InterestList newTopicList = new InterestList();
		for (int i = 0; i < newTopics.length; i++) {
			newTopicList.add(newTopics[i]);
		}
		this.target = newTarget;
		this.topicList = newTopicList;
	}

	/**
	 * @return the target this Link points to
	 */
	public String getTarget() {
		return target;
	}
	
	/**
	 * @return a String description of the Object
	 */
	public String toString() {
		return "Link to " + this.target;
	}

	/**
	 * Checks two Link instances for equality
	 * @param other the other Link instance to compare with
	 * @return true if target and all topics match, else false
	 */
	public boolean equals(Link other) {
		// if the targets are difference, return not equal
		if (!this.getTarget().equals(other.getTarget()))
			return false;

		// check if all the other topics exist here
		for (int i = 0; i < other.topicList.getTopics().length; i++) {
			Topic t = other.topicList.getTopics()[i];
			if (!this.topicList.contains(t))
				return false;
		}

		// check if all the topics here exist in other
		for (int i = 0; i < this.topicList.getTopics().length; i++) {
			Topic t = this.topicList.getTopics()[i];
			if (!other.topicList.contains(t))
				return false;
		}

		// We hold these truths to be self-evident, that all Links are created equal
		return true;
	}
	
	/**
	 * "Likes" a link by adding all related topics to the given profile
	 * @param p the profile to add the interests to
	 */
	public void likedBy(Profile p) {
		// loop all topics
		Topic[] t = this.topicList.getTopics();
		for (int i = 0; i < t.length; i++) {
			// add interest for the new topic
			p.addInterestFor(t[i]);
		}		
	}


}
