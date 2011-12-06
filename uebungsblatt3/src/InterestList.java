/**
 * Represents a list of Topics of interest
 * @author Forever Alone Guy
 */
public class InterestList {

	/**
	 * the first element in the linked list
	 */
	public InterestListElem firstElement;
	
	/**
	 * Constructs an empty list
	 */
	public InterestList() {
		// TODO: duh!
		super();
	}
	
	/**
	 * Checks if the given topic is represented in this list
	 * @param topic the topic to check for
	 */
	public boolean contains(Topic topic) {
		// declare a variable that always points to the element we want to look at
		InterestListElem e = this.firstElement;
		// loop while we have not reached the end of the list
		while (e != null) {
			// check if we have found the topic we are looking for
			if (e.getTopic().equals(topic)) {
				// return true if we have found the topic
				return true;
			}
			// else, just skip to the next element
			e = e.getNextElement();
		}
		// if the whole list was iterated without finding the topic, return false
		return false;
	}
	
	/**
	 * Adds the given topic to the list
	 * @param topic the topic to add to the list
	 * @return true if the operation was successful, else false
	 */
	public boolean add(Topic topic) {
		// do not append if this already contains this topic or if topic is null
		if (topic == null || this.contains(topic)) {
			return false;
		}
		
		InterestListElem newElement = new InterestListElem(topic);

		// check if we have the special case of an empty list
		if (this.firstElement != null) {
			// e will point to the last element in the list after the loop
			InterestListElem e = this.firstElement;
			// loop while we have not reached the last element in the list
			while (e.getNextElement() != null) {
				// not the last element yet, just skip to the next element
				e = e.getNextElement();
			}
			e.setNextElement(newElement);
		} else {
			// firstElement is null, so we just make the new element the first element!
			this.firstElement = newElement;
		}
		// we have added the element - return true
		return true;
	}
	
	/**
	 * Remove the list element with the given Topic of interest from the list
	 * @param topic the topic to remove
	 * @return true if the operation was successful, else false
	 */
	public boolean remove(Topic topic) {
		// if the topic is null or we do not contain this topic or if we are empty, fail
		if (topic == null || !this.contains(topic) || this.getSize() == 0) {
			return false;
		}
		
		// loop while we have not reached the last element in the list
		InterestListElem e = this.firstElement;
		while (e.getNextElement() != null) {
			if (e.getNextElement().getTopic().equals(topic)) {
				// remove e.getNextElement and return
				e.setNextElement(e.getNextElement().getNextElement());
				return true;
			}
			// not the element before the one we want to remove yet, just skip to the next element
			e = e.getNextElement();
		}
		// the element to remove was not found (should never happen because we do checks above)
		return false;
		
	}
	
	/**
	 * Get the number of elements in this list
	 * @return the number of elements held by this list
	 */
	public int getSize() {
		int count = 0;
		
		// loop while we have not reached the end of the list
		InterestListElem e = this.firstElement;
		while (e != null) {
			count++;
			// skip to the next element
			e = e.getNextElement();
		}
		
		return count;
	}
	
	/**
	 * Return an array of all Topics of interest held by this list
	 * @return the array with all Topics
	 */
	public Topic[] getTopics() {
		Topic[] topics = new Topic[this.getSize()];
		
		InterestListElem e = this.firstElement;
		for (int i = 0; i < this.getSize(); i++) {
			// fill the topics array with the topic at index i in the list
			topics[i] = e.getTopic();
			// skip to the next element
			e = e.getNextElement();
		}
		return topics;
	}




}
