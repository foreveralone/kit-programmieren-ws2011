/**
 * A test class to test with a shell interface
 * @author Forever Alone Guy
 *
 */
public class Shell {

	/**
	 * The main method of this program
	 * @param args the arguments to this program
	 */
	public static void main(String[] args) {
		
		Timestamp t = new Timestamp(0, 0, 1, 1, 1970);
		KITBook b = new KITBook(t);
		// add a few people
		b.addPerson(new Person("Alexander", t));
		b.addPerson(new Person("Florian", t));
		Person axel = new Person("Axel", t);
		b.addPerson(axel);
		Person friede = new Person("Friede", t);
		b.addPerson(friede);
		
		// axel and friede love bild.de!
		Link.BILD.likedBy(b.getProfile(axel));
		Link.BILD.likedBy(b.getProfile(friede));
		// test if the similarity thing works
		Person similarToAxel = b.findMostSimilarTo(axel);
		System.out.println("Most similar to " + axel.toString() + " is " + similarToAxel.toString());
		
		System.out.println("Take your protein pills and put your helmet on!");
		while (true) {
			// get the string
			String s = Terminal.askString("major-tom@spacecraft $ ");
			// clean up the string
			s = s.trim();
			// split into an array
			String[] cmd = s.split("\\s+");
			// lower-case commands
			if (cmd.length > 0)
				cmd[0] = cmd[0].toLowerCase();
			
			if (cmd.length == 1 && cmd[0].equals("quit")) {
				// exit the for loop
				System.out.println("Over and out.");
				break;
				
			} else if (cmd.length == 1 && cmd[0].equals("list")) {
				// list all profile in the KITBook
				for (int i = 0; i < b.getPersons().length; i++) {
					System.out.println(b.getPersons()[i].toString());
				}
				
			} else if (cmd.length == 1 && cmd[0].equals("all-links")) {
				// I'll just assume that "bekannte Links" are my constants
				// because I don't really have a getter for liked links...
				// Axel will love this link!
				System.out.println(Link.BILD.toString());
				// Kind of Blue...
				System.out.println(Link.MILES_DAVIS.toString());
				// I wanna make you happy!
				System.out.println(Link.THE_KOOKS.toString());
				
			} else if (cmd.length == 2 && cmd[0].equals("list-friends")) {
				Profile p = b.getProfile(cmd[1]);
				if (p == null) {
					// print an error message in case the Profile was not found
					System.out.println("list-friends requires a sindle valid Person identifier!");
					continue;
				}
				// print all the friends
				for (int i = 0; i < p.getFriends().length; i++) {
					System.out.println(p.getFriends()[i].getOwner().toString());
				}
				
			} else if (cmd.length == 2 && cmd[0].equals("list-interests")) {
				Profile p = b.getProfile(cmd[1]);
				if (p == null) {
					// Profile not found - error and continue
					System.out.println("list-interests requires a single valid Person identifier!");
					continue;
				}
				// loop over the Profile's interests
				for (int i = 0; i < p.getInterests().length; i++) {
					// print the interest
					System.out.println(p.getInterests()[i].toString());
				}
				
			} else if (cmd.length == 3 && cmd[0].equals("add-friendship")) {
				Profile p1 = b.getProfile(cmd[1]);
				Profile p2 = b.getProfile(cmd[2]);
				if (p1 != null && p2 != null) {
					// if both Persons have profiles, add a friendship
					if (!b.addFriendship(p1.getOwner(), p2.getOwner())) {
						System.out.println("add-friendship failed!");
					}
				}
				else
					System.out.println("add-friendship requires two valid Person identifiers!");
				
			} else if (cmd.length == 3 && cmd[0].equals("remove-friendship")) {
				// get the persons and check if they even exist
				Profile p1 = b.getProfile(cmd[1]);
				Profile p2 = b.getProfile(cmd[2]);
				if (p1 != null && p2 != null) {
					// of both given Persons have profiles, remove the friendship
					if (!b.removeFriendship(p1.getOwner(), p2.getOwner())) {
						System.out.println("remove-friendship failed!");
					}
				}
				else
					System.out.println("remove-friendship requires two valid Person identifiers!");
				
			} else if (cmd.length == 3 && cmd[0].equals("post-link")) {
				// get the profile and check if it's valid
				Profile p = b.getProfile(cmd[1]);
				if (p == null) {
					System.out.println("Invalid Person names given!");
					continue;
				}
				// instantiate the new link
				Link l = new Link(cmd[2], new Topic[0]);
				// post the link
				p.postLink(l);
				
			} else {
				// something went wrong - wrong command?
				System.out.println("Ground control to major Tom, your circuits dead, there's something wrong.");
				System.out.println("Invalid command format");
			}
		}
	}

}
