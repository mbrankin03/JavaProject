package part01;

public enum Genre {

	/*
	 * list of possible values
	 *
	 *when assigned - the associated constructor is called with
	 *
	 *its integer equivalent. This is used when toString() is called
	 *
	 *for an Enum value - used to index an associated String
	 */
	
	
	ROCK (0),
	POP (1),
	DANCE (2),
	JAZZ (3),
	CLASSICAL (4),
	OTHER (5);
	
	private int info;
	
	private Genre(int num){
		info = num;
	}
	
	private String Definitions[] = {"Rock and Roll",
			                        "Easy Listening Pop",
			                        "Techno Dance",
			                        "Smooth Jazz",
			                        "Classical",
			                        "Unknown Genre"};
	
	public String toString() {
		return Definitions[info];
	}
	
}
