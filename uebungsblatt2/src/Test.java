/**
 * A test controller for KITBook
 * @author Forever Alone Guy
 */
public class Test {

	/**
	 * @param args the arguments passed to the test application
	 */
	public static void main(String[] args) {
		// once upon a time, around the epoch...
		Timestamp t = new Timestamp(0, 0, 1, 1, 1970);
		
		// oh, look, they were all born on the same day!
		// what a coincidence!
		Person p1 = new Person("Klaus-Dieter", t);
		Person p2 = new Person("Alexander", t);
		p2.setSchool(new School("KitKat", "Center of the World"));

		Person p3 = new Person("Florian", t);
		
		// oh look, it's 1970
		KITBook b = new KITBook(p1, p2, p3, t);
		
		if (b.containsPerson(p1) == true)
			System.out.println("Klaus-Dieter is already using KittehBook to find new friends!");
		b.getProfile(p1);
		b.addFriendship(p3, p2);
		if (b.areFriends(p2, p3) == true)
			System.out.println("Alexander and Florian are friends!");
		b.sendMessage(p1, p2, "¡Hola Sir Alexander!");
		
		Profile p = new Profile(p2);
		p.setStatus("Chilling at the Infobau", t);
		p.addInterestFor(Topic.DUBSTEP_TOPIC);
		p.addInterestFor(Topic.JAZZ_TOPIC);
		p.removeInterestFor(Topic.JAZZ_TOPIC);
		if (p.hasInterestFor(Topic.DUBSTEP_TOPIC) == true)
			System.out.println("Alexander likes dubstep!");
		if (p.hasInterestFor(Topic.JAZZ_TOPIC) == false)
			System.out.println("Alexander doesn't really like Jazz...");;
		
		System.out.println(p2.toString());
		System.out.println(p.toString());
		System.out.println(p2.getBirthday().toString());
		System.out.println(p2.getSchool().toString());
	}

}
