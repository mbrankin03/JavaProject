package part03;

import java.util.ArrayList;

import part01.Genre;
import part01.Tune;
import part01.MP3Player;

/**
 * This class tests the MP3Player.java
 * @author Matthew Brankin
 *
 */
public class MP3PlayerIntegrationTest {

	public static void main(String[] args) {
		System.out.println("Test case for class: MP3Player");
		System.out.println("\n++++++++++++++++++++\n");

		getTuneInfoTest();
		getTuneInfoTest2();
		getTuneInfoArtistTest();
		getTuneInfoGenre();
		playTest();
		playTest2();
		addTune();
		switchOnTest();
		switchOffTest();
	}

	private static void getTuneInfoTest() {
		MP3Player test = new MP3Player();

		test.addtune("Fly me to the Moon", "Frank Sinatra", 100, Genre.JAZZ);

		String[] result = test.getTuneInfo();

		for (int i = 0; i < result.length; i++) {
			System.out.println("\nTest Case 1: getTuneInfo --  " + result[i]);
		}
	}

	private static void getTuneInfoTest2() {
		MP3Player test = new MP3Player();

		test.addtune(null, null, 0, null);

		System.out.println("\nTest Case 2: getTuneInfo -- " + test.getTuneInfo());
	}

	private static void getTuneInfoArtistTest() {
		MP3Player test = new MP3Player();

		test.addtune("Fly me to the Moon", "Frank Sinatra", 100, Genre.JAZZ);
		test.addtune("Moon River", "Frank Sinatra", 100, Genre.JAZZ);
		test.addtune("ABC", "ki", 100, Genre.JAZZ);
		String[] test1 = test.getTuneInfo();

		String[] temp = new String[test1.length];
		for (int i = 0; i < test1.length; i++) {
			temp[i] = test1[i].split("by|\\[")[1].trim();
//			System.out.println(temp[i]);
		}
		String artist = temp[1];
		String[] expRES = test.getTuneInfo(artist);

		for (int i = 0; i < test1.length - 1; i++) {
			System.out.println("\nTest Case 3: getTuneInfo(Artist) -- " + expRES[i]);
		}

	}

	private static void getTuneInfoGenre() {
		MP3Player test = new MP3Player();

		test.addtune("Fly me to the Moon", "Frank Sinatra", 100, Genre.JAZZ);
		test.addtune("ABC", "Frank Sinatra", 100, Genre.JAZZ);
		String[] test1 = test.getTuneInfo();

		String[] res = test.getTuneInfo(Genre.JAZZ);
		for (int i = 0; i < test1.length; i++) {
			System.out.println("\nTest Case 4: getTuneInfo(Genre) -- " + res[i]);
		}
	}

	private static void playTest() {
		MP3Player test = new MP3Player();

		test.addtune("Fly me to the Moon", "Frank Sinatra", 100, Genre.JAZZ);

		System.out.println("\nTest Case 5: playTest -- " + test.play(7));
	}

	private static void playTest2() {
		MP3Player test = new MP3Player();

		test.addtune("Fly me to the Moon", "Frank Sinatra", 100, Genre.JAZZ);

		System.out.println("\nTest Case 6: playTest -- " + test.play(1));
	}

	private static void addTune() {
		MP3Player test = new MP3Player();

//		test.addtune("1", "Frank Sinatra", 100, Genre.JAZZ);
//		test.addtune("1", "Frank Sinatra", 100, Genre.JAZZ);
		test.addtune(null, null, 0, null);

		String[] temp = test.getTuneInfo();

		try {
			for (int i = 0; i < temp.length; i++) {
				System.out.println("\nTest Case 7: addTune -- " + temp[i]);
			}
		} catch (Exception e) {
			System.out.println("\nTest Case 7: addTunes -- Null");
		}
	}

	private static void switchOnTest() {
		MP3Player test = new MP3Player();
		System.out.println("\nTest Case 8: Switch On -- " + test.switchOn());
	}

	private static void switchOffTest() {
		MP3Player test = new MP3Player();
		System.out.println("\nTest Case 9: Switch Off -- " + test.switchOff());

	}
}
