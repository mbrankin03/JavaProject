package part02;

import java.util.ArrayList;
import java.util.Scanner;
import part01.*;

/**
 * 
 * This java file is the Console Application.
 * This is how the user interacts with the MP3Player and the associated methods
 * @author Matthew Brankin
 *
 */


public class JukeBoxConsoleApplication {

	/*
	 * Creating array which contains the options that will be displayed
	 * in the menu for the user to use.
	 */
	
	static final String options[] = {"Select from Full List",
			"Select Tune by Artist",
			"Select Tune by Genre",
			"Add new Tune",
			"Display the Top 10",
			"Switch On",
			"Switch Off",
			"Purchase Credits",
	"Exit"};


	//Creating an int that is equal to the length of the options array e.g 9
	static final int QUIT = options.length;

	// Setting the title of the Menu for the MP3 Player
	static String title = "MP3Player";

	// Creating instances of the Menu
	static Menu myMenu = new Menu(title,options);

	//Creating new Scanner
	static Scanner input = new Scanner(System.in);

	//Creating a boolean for using the switch on and switch off method
	static boolean isOn = true;
	
	//Creating an instance of JukeBox
	static JukeBox jukeBox = new JukeBox();

	public static void main(String[] args) {

		// A method that adds tunes to the array list
		addSomeTunes();

		
		int choice = 0;

		boolean ok = false;

		do {
			//Displays menu and processes user choices
			myMenu.display();
			choice = myMenu.getUserChoice();
			if (choice != QUIT) {
				switch(choice) {
				case 1:
					// Displays all of the tune info for all tunes
					selectFromFullList();
					break;
				case 2:
					 //Displays the tunes specified by a particular artist
					selectTuneByArtist();
					break;
				case 3: 
					// Displays the tunes specified by a particular genre
					selectFromGenre();
					break;
				case 4: 
					// Adds a new tune to the array list
					addATune();
					break;
				case 5:
					// Displays the top 10 tracks
					displayTop10();
					break;
				case 6:
					// Switch on method to turn on the JukeBox
					/**
					 * @param - Jukebox
					 */
					switchOn(jukeBox);
					break;
				case 7: 
					// Switch off method to turn off the JukeBox
					/**
					 * @param - Jukebox
					 */
					switchOff(jukeBox);
					break;
				case 8:
					//Method to purchase credits to use to play tunes
					PurchaseCredits();
					break;
				default: 
					System.out.println("Please enter a valid number!");
					break;
				}
			} else {
				System.out.println("Goodbye!!");
				break;
			}
		} while (!ok);
	}

	/*
	 * This method allows the user to purchase credits
	 * These credits can then be used to play tunes from the JukeBox
	 */
	private static void PurchaseCredits() {
		if(isOn) {
			int insert = 0;
			String[] coins = {"10p","20p","50p","£1","£2"};
			Menu coinOption = new Menu("Add an amount of coins", coins);
			coinOption.display();
			int coinChoice = coinOption.getUserChoice();
			
			switch(coinChoice) {
			case 1:
				insert = 10;
				break;
			case 2: 
				insert = 20;
				break;
			case 3:
				insert = 50;
				break;
			case 4:
				insert = 100;
				break;
			case 5: 
				insert = 200;
				break;
			}
			
			jukeBox.insertCoin(insert);
			
		}
	}
	
	/*
	 * This method add news Tune instances to the array list in MP3Player.java
	 */
	private static void addSomeTunes(){

		jukeBox.addtune("My Patch", "Jim Noir", 400, Genre.POP);
		jukeBox.addtune("Key of C", "Jim Noir", 400, Genre.POP);
		jukeBox.addtune("All Blues", "Miles Davis", 2000, Genre.JAZZ);
		jukeBox.addtune("Around the World", "Daft Punk", 1500, Genre.DANCE);
		jukeBox.addtune("Song 2", "DJ Krush", 750, Genre.OTHER);
		jukeBox.addtune("Harvest Dawn", "Jeremy Soule", 350, Genre.CLASSICAL);
		jukeBox.addtune("Do you realize?", "The Flaming Lips", 300, Genre.ROCK);

	}

	/*
	 * This method creates a menu of all of the tunes that
	 * are found in the array list. User is then given the option to select a tune 
	 * from the list.
	 */
	
	private static void selectFromFullList() {
		if (isOn) {
			String[] tuneInfo = jukeBox.getTuneInfo();
			ArrayList<String> tuneNames = new ArrayList<String>();

			for(String tuneDetails: tuneInfo) {
				String tunes = tuneDetails.split("\\[")[0];
				if(search(tuneNames, tunes)) {
					continue;
				}else {
					tuneNames.add(tunes);
				}
			}

			String[] songs = new String[tuneNames.size()];

			for(int i = 0; i < tuneNames.size(); i++) {
				songs[i] = tuneNames.get(i);
				
			}

			Menu tuneMenu = new Menu("Choose a Tune - Full List", songs);
			tuneMenu.display();
			int choice = tuneMenu.getUserChoice();
			String[] splitID = songs[choice-1].split(":");
			
			boolean ok = false;
			do {
				try {
					for(int i = 0; i < tuneInfo.length; i++) {
						if(choice > 0 && choice <= songs.length) {
							ok=true;
						}
					}
				} catch (Exception ex) {
					System.out.println("Please enter a valid Tune ID between 1 and " + songs.length);
				}
			} while (!ok);
			System.out.println(jukeBox.play(Integer.parseInt(splitID[0])));

		} else {
			System.out.println("MP3Player is switched off - \nPlease turn it on to use it");
		}
	}

	/*
	 * This method creates a menu of all of the artists that
	 * are found in the array list. User is then given the option to select an artist 
	 * from the list.
	 * When they select an artist, that specified artist's songs will appear in a menu 
	 * which will allow the user to choose a particular song by that artist
	 */
	
	private static void selectTuneByArtist() {
		if (isOn) {

			String[] songs = jukeBox.getTuneInfo();
			ArrayList<String> artistNames = new ArrayList<String>();

			for (String tuneDetails: songs) {
				String artist = tuneDetails.split("by|\\[")[1];
				if (search(artistNames, artist)) {
					continue;
				} else { 
					artistNames.add(artist);

				}
			}
			String[] artists = new String[artistNames.size()];

			for (int i = 0; i < artistNames.size(); i++) {
				artists[i] = artistNames.get(i);
			}


			Menu artistsMenu = new Menu("Choose an Artist", artists);
			artistsMenu.display();

			int choice = artistsMenu.getUserChoice();
			String chosenArtist = artists[choice-1].trim();

			System.out.println("You have selected: " + chosenArtist);

			String[] artistTunes = jukeBox.getTuneInfo(chosenArtist);

			String[] tune = new String[artistTunes.length];

			for(int i = 0; i < artistTunes.length; i++) {
				tune[i] = artistTunes[i].split("by|\\[")[0];

			}
			Menu displayTunes = new Menu("\nChoose the tune: ", tune);
			displayTunes.display();


			int option6 = displayTunes.getUserChoice();
			String[] splitID = tune[option6-1].split(":");
			
			boolean ok = false;
			do {
				try {
					for (int i = 0; i < songs.length; i++ ) {
						if (option6 > 0 && option6 <= tune.length) {
							ok=true;
						} else {
							System.out.println("Please enter a valid Tune ID between 1 and " + tune.length);
							break;
						}
					}
				} catch (Exception ex) {

				}
			} while (!ok);
			System.out.println(jukeBox.play(Integer.parseInt(splitID[0])));

		} else {
			System.out.println("MP3Player is switched off \nPlease turn it on");
		}
	}

	/**
	 * @param - data - A string array list
	 * @param - artist - A string
	 * 
	 * This method is a searching method to check for artists and to ensure that 
	 * there are no duplicates.
	 */
	private static boolean search(ArrayList<String> data, String artist) {
		for (int i = 0; i<data.size(); i++) {
			if (data.get(i).equals(artist)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * This method creates a menu of all of the genres that
	 * are found in the array list. User is then given the option to select a genre
	 * from the list.
	 * When they select a genre, all songs associated with that genre will appear in a
	 * menu. The user will then be given the option to choose a tune.
	 */
	private static void selectFromGenre() {
		if (isOn) {
			String[] songs = jukeBox.getTuneInfo();
			String optionsGen[] = { 
					"Rock and Roll",
					"Easy Listening Pop", 
					"Techno Dance", 
					"Smooth Jazz", 
					"Classical",
			"Unknown Genre" };

			Menu genreMenu = new Menu("\nChoose a Genre", optionsGen);
			genreMenu.display();
			int option1 = genreMenu.getUserChoice();

			Genre option2 = processOptionGenre(option1);
			String[] genreTunes = jukeBox.getTuneInfo(option2);
			//			for(int i = 0; i < genreTunes.length; i++) {
			//				numbers = Integer.parseInt(genreTunes[i].split(":")[0].trim());
			//				System.out.println(numbers);
			//
			//				System.out.println(mp3Player.play(numbers));
			//			}

			Menu genreTunesMenu = new Menu("\nChoose a tune", genreTunes);
			genreTunesMenu.display();
			int option6 = genreTunesMenu.getUserChoice();
			String[] splitID = genreTunes[option6-1].split(":");
			//			System.out.println(splitID[0]);
			boolean isEQ = false;
			System.out.println(jukeBox.play(Integer.parseInt(splitID[0])));
			do {
				try {
					for(int i = 0; i < songs.length; i++) {
						if(option6 > 0 && option6 <= genreTunes.length) {
							isEQ=true;
						} else {
							System.out.println("Please enter a valid Tune ID between 1 and " + genreTunes.length);
							break;
						}
					}
				} catch (Exception ex) {
					System.out.println(jukeBox.play(Integer.parseInt(splitID[0])));
				}

			} while(!isEQ);
			//			System.out.println(mp3Player.play(numbers-1));
		} else {
			System.out.println("MP3Player is switched off \nPlease turn it on");
		}
	}

	/**
	 * This method passes through the MP3Player object to turn on the
	 * JukeBox. 
	 * @param mp3
	 * @return
	 */
	private static boolean switchOn(MP3Player mp3) {
		if (!isOn) {
			jukeBox.switchOn();
			isOn = true;
		} else {
			System.out.println("MP3Player is already switched on");
		}
		return isOn;
	}

	/*
	 * This method displays ten tracks which have been played the most and 
	 * they are sorted in descending order
	 */
	private static void displayTop10() {

		if (isOn) {

			String[] tuneInfo = jukeBox.getTuneInfo();
			String[] plays = new String[tuneInfo.length];
			int[] play = new int [plays.length];

			for (int i = 0; i < tuneInfo.length; i++) {
				plays[i] = tuneInfo[i].split("\\[|\\]")[1];
				play[i] = Integer.parseInt(plays[i].trim());

			}

			boolean sorted = false;
			while(!sorted) {
				sorted = true;

				for(int i = 0; i < play.length - 1; i++) {
					if(play[i] < play[i + 1]) {
						int temp = play[i];
						play[i] = play[i+1];
						play[i+1] = temp;

						// sort list
						String temp1 = tuneInfo[i];
						tuneInfo[i] = tuneInfo[i+1];
						tuneInfo[i+1] = temp1;

						sorted = false;
					}
				}
			}


			System.out.println("Top 10 Tunes");
			System.out.println("++++++++++++++");
			for (int j = 0; j < 10; j++) {
				try {
					System.out.println(j+1 + ". " + tuneInfo[j]);
				} catch (ArrayIndexOutOfBoundsException ex){
					System.out.println(j+1 + ". Not available");

				}
			}
		} else {
			System.out.println("MP3Player is switched off \nPlease turn it on");
		}
	}
	
	

	/**
	 * This method passes through the object of the MP3Player
	 * to turn off the JukeBox
	 * @param mp3
	 * @return
	 */
	private static boolean switchOff(MP3Player mp3) {
		if (isOn) {
			jukeBox.switchOff();
			isOn = false;
		} else {
			System.out.println("MP3Player is already switched off");
		}
		return isOn;
	}

	/*
	 * This method uses a scanner to allow the user to add a tune to the array list
	 * 
	 */
	private static void addATune() {
		if (isOn == true) {
			System.out.println("\nOk - Add a new Tune");

			System.out.println("Please enter the title: ");

			String title = input.nextLine();
			
			System.out.println("Please enter the artist: ");

			String artist = input.nextLine();

			System.out.println("Please enter the duration: ");

			boolean durationok = false;
			int duration = 0;
			do {
				if(input.hasNextInt()) {
					duration = input.nextInt();
					durationok = true;
				} else {
					System.out.println("Please enter a valid Integer Value");
					input.nextLine();
				}
			} while(!durationok);
			
			System.out.println("Please enter the genre: ");

			Genre gen = chooseGenre();

			System.out.println();
			input.nextLine();

			jukeBox.addtune(title, artist, duration, gen);

			System.out.println("\nTrack being added");


		} else {
			System.out.println("MP3Player is switched off \nPlease turn it on");
		}
	}

	/**
	 * This method is used to create a menu of genre options for the user to choose from
	 * in the menu
	 * 
	 * @return - the genre of the track
	 */
	private static Genre chooseGenre() {
		String optionsGen[] = { 
				"Rock and Roll",
				"Easy Listening Pop", 
				"Techno Dance", 
				"Smooth Jazz", 
				"Classical",
		"Unknown Genre" };

		Menu gen = new Menu("Choose Genre", optionsGen);
		gen.display();
		int option = gen.getUserChoice();
		return processOptionGenre(option);
	}

	/**
	 * This method processes the user's choice of genre and returns it so it can 
	 * be used when creating a new tune.
	 * @param - choice
	 */
	private static Genre processOptionGenre(int choice) {
		Genre gen = null;
		switch (choice) {
		case 1:
			System.out.println("Genre: Rock and Roll");
			gen = Genre.ROCK;
			break;
		case 2:
			System.out.println("Genre: Easy Listening Pop");
			gen = Genre.POP;
			break;
		case 3:
			System.out.println("Genre: Techno Dance");
			gen = Genre.DANCE;
			break;
		case 4:
			System.out.println("Genre: Smooth Jazz");
			gen = Genre.JAZZ;
			break;
		case 5:
			System.out.println("Genre: Classical");
			gen = Genre.CLASSICAL;
			break;
		case 6:
			System.out.println("Genre: Unknown Genre");
			gen = Genre.OTHER;
			break;
		default:
			System.out.println("Option " + choice + " is invalid.");
		}
		return gen;
	}

}
