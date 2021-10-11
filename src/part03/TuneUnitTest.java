package part03;

import part01.Tune;
import part01.MP3Player;
import java.util.ArrayList;
import part01.Genre;

/**
 * This class tests the Tune.java
 * @author Matthew Brankin
 *
 */
public class TuneUnitTest {

	public static void main(String[] args) {
		System.out.println("Test Cases for class: Tune\n");
		System.out.println("++++++++++++++++++++++++++++\n");
		getTitleTest();
		getArtistTest();
		getDurationTest1();
		getDurationTest2();
		getStyleTest();
		toStringTest();
		getPlaycountTest1();
		getPlaycountTest2();
		getTuneIDTest();
		getNextTuneIDTest();
		tuneConstructorTest();
	}

	private static void getTitleTest() {
		String expectedRes = "Accidentally in Love";
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		String result = track.getTitle();

		if (expectedRes.equals(result)) {
			System.out.println("Pass - Test 1: getTitleTest" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 1: getTitleTest" + "\n");
			return;
		}

	}

	private static void getArtistTest() {
		String expectedRes = "Counting Crows";
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		String result = track.getArtist();

		if (expectedRes.equals(result)) {
			System.out.println("Pass - Test 2: getArtistTest" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 2: getArtistTest " + "\n");
			return;
		}

	}

	private static void getDurationTest1() {
		int expectedRes = 240;
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		int result = track.getDuration();

		if (expectedRes == result) {
			System.out.println("Pass - Test 3: getDurationTest1" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 3: getDurationTest1" + "\n");
			return;
		}
	}

	private static void getDurationTest2() {
		int expectedRes = 30;
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		int result = track.getDuration();

		if (expectedRes == result) {
			System.out.println("Pass - Test 4: getDurationTest2" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 4: getDurationTest2" + "\n");
			return;
		}
	}

	private static void getStyleTest() {
		Genre expectedRes = Genre.POP;
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		String result = track.getStyle();

		if (expectedRes.toString() == result) {
			System.out.println("Pass - Test 5: getStyleTest" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 5: getStyleTest" + "\n");
			return;
		}

	}

	private static void toStringTest() {
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		String expectedRes = track.getTitle();
		expectedRes += " by " + track.getArtist() + ",";
		expectedRes += " " + track.getDuration() + ",";
		expectedRes += " " + track.getStyle() + "\n";

		String result = track.toString();

		if(expectedRes.equals(result)) {
			System.out.println("Pass - Test 6: toStringTest" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 6: toStringTest" + "\n");
			return;
		}
	}

	private static void getPlaycountTest1() {
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		int expectedres = 0;
		int result = track.getPlayCount();

		if(expectedres == result) {
			System.out.println("Pass - Test 7: getPlayCount" + "\n");
		} else {
			System.out.println("Fail - Test 7: getPlayCount" + "\n");
		}
	}

	private static void getPlaycountTest2() {
		int expectedres = 3;
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		track.play();
		track.play();

		if(expectedres == track.getPlayCount()) {

			System.out.println("Pass - Test 8: getPlayCount2" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 8: getPlayCount2" + "\n");
			return;
		}
	}
	
	private static void tuneConstructorTest() {
		String expectedTitle = "Accidentally in Love";
		String expectedArtist = "Counting Crows";
		int expectedDuration = 240;
		Genre expectedGenre = Genre.POP;
		
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		String resTitle = track.getTitle();
		String resArtist = track.getArtist();
		int resDuration = track.getDuration();
		String resGenre = track.getStyle();
		
		if(expectedTitle.equals(resTitle) && expectedArtist.equals(resArtist) 
				&& expectedDuration == resDuration 
				&& expectedGenre.toString().equals(resGenre)) {
			System.out.println("Pass - Test 11: tuneConstructorTest" + "\n");
		} else {
			System.out.println("Fail - Test 11: tuneConstructorTest" + "\n");
		}
	}
	
	private static void getTuneIDTest() {
		int expectedID = 9;
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		int resID = track.getId();
		
		if(expectedID == resID) {
			System.out.println("Pass - Test 9: getTuneIDTest" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 9: getTuneIDTest" + "\n");
			return;
		}
	}
	
	private static void getNextTuneIDTest() {
		int expectedID = 10;
		Tune track = new Tune("Accidentally in Love", "Counting Crows", 240, Genre.POP);
		int resID = track.getId();
		
		if(expectedID == resID) {
			System.out.println("Pass - Test 10: getNextTuneIDTest" + "\n");
			return;
		} else {
			System.out.println("Fail - Test 10: getNextTuneIDTest" + "\n");
			return;
		}
	}

}
