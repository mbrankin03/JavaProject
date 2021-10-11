package part01;

/**
 * This class models a Tune and defines some of the functions
 * 
 * @author Matthew Brankin
 *
 */
public class Tune {

	/**
	 * tuneId - Unique number that identifies the tune
	 * nextTuneID - set to 1 - Used to count the object instances
	 * title - Title of the tune
	 * artist - Artist of the tune
	 * duration - Duration of the tune
	 * playCount - Used to count how many times a tune has been played
	 * Style - The 'style'(genre) of a tune object
	 */

	private int tuneId;
	private static int nextTuneId = 1;
	private String title;
	private String artist;
	private int duration;
	private int playCount = 0;
	private Genre style;


	/** This is a constructor method for the Tune Object. It sets up
	 * the tune's title, artist, duration and style.
	 * @param title
	 * @param artist
	 * @param duration
	 * @param style
	 */
	public Tune(String title, String artist, int duration, Genre style) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.style = style;
		this.tuneId = nextTuneId++;
		this.playCount = playCount;
	}

	/**
	 * This method returns all the details of the Tune
	 * 
	 * @return str - a String containing 
	 * title, artist,
	 * duration and genre
	 */
	public String toString() {
		String str = "";
		str += this.title + " by ";
		str +=  this.artist + ", ";
		str +=   this.duration + ", ";
		str += this.getStyle() + "\n"; 
		return str;
	}

	// This method returns a string that displays a tune being played
	// The playcount also increments.
	/**
	 * @return - res - returns the TuneId, title and artist
	 * of a tune and displays the tune being 'played'.
	 */
	public String play() {
		String res = "";
		res += "Now playing ... " + getId() + ": " + getTitle() + " by " + getArtist();
		playCount++;
		getPlayCount();
		return res;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return tuneId;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}


	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}


	/**
	 * @return the playCount
	 */
	public int getPlayCount() {
		return playCount;
	}

	/**
	 * @return the style
	 */
	public String getStyle() {
		return style.toString();
	}
}
