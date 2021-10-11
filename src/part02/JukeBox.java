package part02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import part01.*;

/**This Jukebox class imitates a jukebox
 * Where you have to enter coins which will be used to play the tunes in the 
 * console application among other features.
 * 
 * @author Matthew Brankin
 *
 */
public class JukeBox extends MP3Player {

	private int credit = 0; // Set to 0
	private int costPerCredit = 0; // Set to 0
	private int change = 0; // Int to hold left over coins


	// JukeBox constructor to call parent class and to set the credit to 0
	// and the costPerCredit to 50p
	public JukeBox() {
		// Super calls the MP3Player parent class
		super();

		credit = 0;
		costPerCredit = 50;
		//Set to 50p

	}

	/*
	 * Method to add coins into the jukebox
	 */
	public void insertCoin(int coin) {
		
		if(this.costPerCredit > 0) {
			coin += change;
			credit += coin / costPerCredit;
			change = coin % costPerCredit;

			System.out.println("Credits added successfully");
			System.out.println("Current credit: " + credit);
			System.out.println("Change: " + change);

		} else {
			System.out.println("Tune free to play!!");
		}
	}

	/**
	 * @param - tuneID
	 * This overrides the play method found in the super class.
	 * It checks to see if there are enough credits to play a tune.
	 */
	public  String play(int tuneId) {
		String str = "";

		if(costPerCredit > 0 ) {
			if (credit > 0) {
				credit--;
				str += super.play(tuneId);
				str += "\nCurrent Credit: " + credit;
				return str;
			} else {
				return "Not enough credits!";
			}
		} else {
			return super.play(tuneId);
		}
	}


	//Switch off method that overrides the one found in the super class.
	// It saves data to a csv file
	public boolean switchOff() {
		String myDir = "C:/Users/Mbran/eclipse-workspace/Assessment2/src/part02/myjukeBox.csv";
		try {
			// Prints the file
			PrintWriter pw = new PrintWriter(myDir);

			pw.println("Tune ID, Title, Artist, Playcount");
			String arr[] = super.getTuneInfo();

			for(int i = 0; i < arr.length; i++) {
				pw.println(arr[i].split(":")[0].trim() + "," 
						+ arr[i].split(":|by")[1].trim() + ","
						+ arr[i].split("by|\\[")[1].trim() + ","
						+ arr[i].split("\\[|\\]")[1].trim());
			}
			pw.println("\nCredits: " + ", " + credit);
			pw.println("\nChange: " + ", " + change);

			System.out.println("File Contents successfully written");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}


	// Switch on method that overrides the one found in MP3Player.java
	// It reads the data and prints the results to the console application
	public boolean switchOn() {

		String myDir = "C:/Users/Mbran/eclipse-workspace/Assessment2/src/part02/myjukeBox.csv";

		try {
			Scanner input = new Scanner(new File(myDir));
			input.useDelimiter(",");

			while(input.hasNext()) {
				System.out.print(input.next() + "|");

			}
			System.out.println();
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * @param costPerCredit the costPerCredit to set
	 */
	public void setCostPerCredit(int costPerCredit) {
		this.costPerCredit = costPerCredit;
	}



}
