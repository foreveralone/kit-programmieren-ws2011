/**
 * The class {@code InterestListElem} represents an Element in an InterestList
 * @author Forever Alone Guy
 */
public class InterestListElem {

	/**
	 * the Topic of interest held by this list element
	 */
	private Topic topic;
	
	/**
	 * the next element in the list
	 */
	private InterestListElem nextElement;

	/**
	 * Constructs a new list element with the given topic
	 * @param t the Topic of interest to be held by the new list element
	 */
	public InterestListElem(Topic t) {
		this.topic = t;
	}
	/**
	 * @return the next element in the list
	 */
	public InterestListElem getNextElement() {
		return nextElement;
	}

	/**
	 * @param nextElement the list element to set as the next element
	 */
	public void setNextElement(InterestListElem nextElement) {
		this.nextElement = nextElement;
	}

	/**
	 * @return the topic held by this list element
	 */
	public Topic getTopic() {
		return topic;
	}
	
	
}
