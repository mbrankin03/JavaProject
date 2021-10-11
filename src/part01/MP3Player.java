package part01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class models an MP3Player. It also defines some extra functions
 * such as sorting, creation of a tune, switch on and switch off
 * 
 * @author Matthew Brankin
 *
 */

public class MP3Player implements iPlayer {

	// Creates a new instance of soundData which is an ArrayList
	private ArrayList<Tune> soundData;

	
	/**
	 * This is a constructor method for the MP3Player object. It initialises the soundData
	 * array list.
	 */
	public MP3Player() {
		this.soundData = new ArrayList<Tune>();
	}

	public String[] getTuneInfo() {
		ArrayList<Tune> chosenTunes = new ArrayList<Tune>(); //array list of tune instances
		Tune temp, temp1;

		if(soundData.size() > 0) {
			/**
			 * Adds the data found in soundData to the new arraylist
			 * called chosenTunes		
			 */
			
			for (int i = 0; i < soundData.size(); i++) {
				chosenTunes.add(soundData.get(i));

				/*
				 * Make a temporary array first to add the sound Data contents and then sort
				 */
				
			} 
			//sorting tune instances out alphabetically by title
			for (int j = 0; j < chosenTunes.size(); j++) {
				for (int i = j + 1; i < chosenTunes.size(); i++) {
					if (chosenTunes.get(i).getTitle().toLowerCase().compareTo(chosenTunes.get(j).getTitle().toLowerCase()) < 0) {
						temp = chosenTunes.get(j);
						temp1 = chosenTunes.get(i);
						chosenTunes.set(j, temp1);
						chosenTunes.set(i, temp);
					}
				}
			}


			String[] tunes =  new String[chosenTunes.size()];

			//copying array list chosenTunes to an array called tunes
			if (chosenTunes.size() > 0) {
				for (int i = 0; i<chosenTunes.size(); i++ ) {
					tunes[i] = (chosenTunes.get(i).getId() + ":" + chosenTunes.get(i).getTitle() + " by " + chosenTunes.get(i).getArtist() + " [" +chosenTunes.get(i).getPlayCount() + "]");
				}

			}
			return tunes;
		} else {
			return null;
		}

	}

	public String[] getTuneInfo(String artist) { 

		if(soundData.size() > 0) {
			//array list of tune instances
			ArrayList<Tune> TempTunes = new ArrayList<Tune>();
			Tune temp, temp1;
			/**
			 * Creates a temporary array list that holds the data found in
			 * soundData. It adds the particular artist that is passed in through 
			 * the parameter
			 */
			for (int i = 0 ; i < soundData.size() ; i++) {
				if (artist.equals(soundData.get(i).getArtist())) {
					TempTunes.add(soundData.get(i));
				}
			}
			//sorting tune instances out alphabetically by title
			for (int j = 0; j < TempTunes.size(); j++) {
				for (int i = j + 1; i < TempTunes.size(); i++) {
					if (TempTunes.get(i).getTitle().toLowerCase().compareTo(TempTunes.get(j).getTitle().toLowerCase()) < 0) {
						temp = TempTunes.get(j);
						temp1 = TempTunes.get(i);
						TempTunes.set(j, temp1);
						TempTunes.set(i, temp);
					}
				}
			}

			String [] artistTunes = new String[TempTunes.size()];
			//copying array list chosenTunes to an array called artistTunes
			for (int i = 0; i <TempTunes.size();i++) {
				artistTunes[i] = (TempTunes.get(i).getId() + ":" + TempTunes.get(i).getTitle() + " by " + TempTunes.get(i).getArtist() + " [" +TempTunes.get(i).getPlayCount() + "]");
			}
			return artistTunes;
		} else {
			return null;
		}
	}

	public String[] getTuneInfo(Genre gen) {


		if (soundData.size() > 0) {
			ArrayList<Tune> chosenGenreTunes = new ArrayList<Tune>(); //array list of tune instances for chosen genre
			Tune temp, temp1;
			//Tunes for a particular genre are added to ArrayList
			for (int i = 0; i < soundData.size(); i++) {
				if (gen.toString().equals(soundData.get(i).getStyle())) {
					chosenGenreTunes.add(soundData.get(i));

					/*
					 * Make a temporary array first to add the sound Data contents and then sort
					 */
				} 
			}
			//sorting tune instances out alphabetically by title
			for (int j = 0; j < chosenGenreTunes.size(); j++) {
				for (int i = j + 1; i < chosenGenreTunes.size(); i++) {
					//				if (soundData.get(i).getPlayCount < soundData.get(j).getPlayCount) {
					// Swap them like below
					if (chosenGenreTunes.get(i).getTitle().toLowerCase().compareTo(chosenGenreTunes.get(j).getTitle().toLowerCase()) < 0) {
						temp = chosenGenreTunes.get(j);
						temp1 = chosenGenreTunes.get(i);
						chosenGenreTunes.set(j, temp1);
						chosenGenreTunes.set(i, temp);
					}
				}
			}


			String[] tunes =  new String[chosenGenreTunes.size()];

			//copying array list chosenGenreTunes to an array called tunes
			if (chosenGenreTunes.size() > 0) {
				for (int i = 0; i<chosenGenreTunes.size(); i++ ) {
					tunes[i] = (chosenGenreTunes.get(i).getId() + ": " + chosenGenreTunes.get(i).getTitle() + " by " + chosenGenreTunes.get(i).getArtist());
				}

			}
			return tunes;
		} else {
			return null;
		}
	}

	/**
	 * This method plays the tune that is associated with 
	 * the tuneId parameter.
	 * 
	 * @return returns the play method of Tune.java and plays 
	 * the soundData data. 
	 */
	public String play(int tuneId) {
		if(soundData.size() > 0) {
			for(int i = 0; i < soundData.size(); i++) {
				if(tuneId == soundData.get(i).getId()) {
					return soundData.get(i).play();

				}

			}
		}
		return null;
	}

	/**
	 * @return - returns the boolean 'on'
	 * This method is used to turn off the MP3Player and prints a String
	 * telling the user that the MP3Player is switched off
	 */
	public boolean switchOff() {
		boolean on = true;
		if (on == true) {
			on = false;
			System.out.println("MP3Player is now switched off");
			return on;
		}
		return on;
	}

	/**
	 * @return - returns the boolean 'off'
	 * This method is used to turn on the MP3Player and prints a String
	 * telling the user that the MP3Player is switched on
	 */
	public boolean switchOn() {
		boolean off = false;
		if (off == false) {
			off = true;
			System.out.println("MP3Player is now switched on");
			return off;
		}
		return off;
	}

	/**
	 * @param - title
	 * @param - artist
	 * @param - duration
	 * @param - gen
	 * 
	 * This method is used to create a new tune object
	 * It uses the parameters passed through to create the Tune Object.
	 * 
	 */
	
	@Override
	public boolean addtune(String title, String artist, int duration, Genre gen) {
		if ( title != null && artist != null && duration != 0 && gen != null ) {

			Tune t1 = new Tune(title, artist, duration, gen);
			boolean exists = true;
			for(int i = 0; i < soundData.size(); i++) {
				for(int j = i + 1; j < soundData.size(); j++) {
					if(soundData.get(i).getTitle().compareTo(soundData.get(j).getTitle())>0) {
						Tune temp = soundData.get(i);
						soundData.set(i, soundData.get(j));
						soundData.set(j, temp);
					}
				}
				
				/**
				 * These if statements check to see if the artist and title are
				 * found in the soundData arraylist already.
				 * If they are found it will not add the tune and will turn the boolean false
				 * 
				 */
				if(artist.equals(soundData.get(i).getArtist())) {
					if(title.equals(soundData.get(i).getTitle())) {
						exists=false;
					}
				}
			}
			// If the boolean is true, it will add the tune
			if(exists) {
				soundData.add(t1);
			}
			return true;
		} else {
			return false;
		}
	}
	}



