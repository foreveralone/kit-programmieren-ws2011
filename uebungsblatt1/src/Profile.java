/**
 * Represents a profile of a person and all the information associated with that person
 */
public class Profile {
	
	/**
	 * The person that this profile refers to
	 */
	Person owner;
	
	/**
	 * The school attended by this person
	 */
	School school;
	
	/**
	 * A message describing the current status of the person
	 */
	String currentStatusMessage;
	
	/**
	 * The inbox containing the last received messages of this user
	 */
	Message inbox;
	
	/*
	 * Attributes describing what topics the person that this profile refers to is interested in
	 */
	Boolean isInterestedInFussball;
	Boolean isInterestedInVolleyball;
	Boolean isInterestedInMotorsport;
	Boolean isInterestedInSchwimmen;
	Boolean isInterestedInRock;
	Boolean isInterestedInJazz;
	Boolean isInterestedInKlassik;
	Boolean isInterestedInTweenwave;
	Boolean isInterestedInTrolling;
}
