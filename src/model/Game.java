package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Game {
	/**
	 * attribute that represents the level of the game
	 */
	private int level;
	/**
	 * pacmans who will move in the game
	 */
	private List<PacMan> pacMans;
	/**
	 * attribute that represents the table of best scores
	 */
	private Score score;
	
	/**
	 * represents the place of the serialized file
	 */
	private static final String PATH_FILE = "data/Score.pac";
	
	/**
	 * game builder
	 * @throws FileNotFoundException, when the file is not found
	 * @throws ClassNotFoundException, when the class is not found
	 * @throws IOException, some error occurs with the handling of the files
	 */
	
	public Game() throws FileNotFoundException, ClassNotFoundException, IOException {
		pacMans = new ArrayList<PacMan>();
		loadScore();
	}
	
	/**
	 * this method is responsible for loading the text file to create a new game or new pacmans to play
	 * @param path, This is where the file to be read is located
	 * @param sep, the file's text separator
	 * @throws IOException, some error occurs with the handling of the files
	 */
	
	public void loadGame(String path, String sep) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr); 
		
		String line = br.readLine(); 
		this.level = Integer.parseInt(br.readLine());
		  
		
		while(line != null) {
			
			if(line.charAt(0) != '#') {
				String[] parts = line.split(sep);
				
				double radius = Double.parseDouble(parts[0]);
				double posX = Double.parseDouble(parts[1]);
				double posY = Double.parseDouble(parts[2]);
				int time = Integer.parseInt(parts[3]);
				String direction = parts[4];
				int bounces = Integer.parseInt(parts[5]);
				boolean state= Boolean.parseBoolean(parts[6]);
				
				PacMan pac = new PacMan(radius, posX, posY, time, direction, bounces, state);
				
				pacMans.add(pac);
			}
			
			line = br.readLine();

		}
		
		br.close();
		fr.close();
	}
	
	/**
	 * this method is responsible for generating a report with the current status of the pacmans or the game
	 * @return rep, the report of the pacmans
	 */
	public String report() {
		String rep = "#nivel" + "\n" + level + "\n" + "#radius posX posY wait time direction bounces satate" + "\n";
		
		for(int i=0; i<pacMans.size(); i++) {
			rep += pacMans.get(i).getRadius() + " " +  pacMans.get(i).getPosX() + " " +  pacMans.get(i).getPosY() + " " + 
				pacMans.get(i).getWaitTime() + " " +  pacMans.get(i).getDirection() + " " +  pacMans.get(i).getBounces() + " " + pacMans.get(i).isState() + "\n";
		}
		
		return rep;
	}
	
	/**
	 * this method is responsible for saving the current state of the game in a text file
	 * @param path, This is where the file to be read is located
	 * @throws FileNotFoundException, when the file is not found
	 */
	public void saveGame(String path) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(path));
		
		String r = report();
		
		pw.print(r);
		pw.close();
	}
	
	
	/**
	 * This method is responsible for saving the best scores by serialization so that it persists when closing the application.
	 * @throws FileNotFoundException, when the file is not found
	 * @throws IOException, some error occurs with the handling of the files
	 */
	
	public void saveScore() throws FileNotFoundException, IOException {
		File fl = new File(PATH_FILE);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fl));
		oos.writeObject(score);
		
		oos.close();
			
		
	}
	/**
	 * 
	 * This method is responsible for loading the best scores through serialization
	 * @throws FileNotFoundException,when the file is not found
	 * @throws IOException, some error occurs with the handling of the files
	 * @throws ClassNotFoundException,  when the class is not found
	 */
	public void loadScore() throws FileNotFoundException, IOException, ClassNotFoundException {
		File fl = new File(PATH_FILE);
		
		if(fl.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fl));
			score = (Score) ois.readObject();
			
			ois.close();
 		}else {
			score = new Score();
		}
		
	}
	
	/**
	 * 
	 * @return pacMans, the list of  pacmans
	 */
	public List<PacMan> getPacMans(){
		return pacMans;
	}


	/**
	 * 
	 * @return the square of scores
	 */
	public Score getScore() {
		return score;
	}


	/**
	 * 
	 * @return the game level
	 */
	public int getLevel() {
		return level;
	}



	


	

	
	
}
