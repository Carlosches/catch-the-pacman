package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class GameTest {
	
	
	/**
	 * relationship with the class of the model
	 */
	private Game game;
	
	/**
	 * first stage, it is empty since the constructor of the Game class will be tested
	 */
	private void setupScenary1() {
	
	}
	
	/**
	 * second stage,a new game is created
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	private void setupScenary2() throws FileNotFoundException, ClassNotFoundException, IOException {     
		
		game = new Game();
	
	}
	/**
	 * test to verify the correct creation of a game and the correct functioning of trivial methods
	 * 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	
	
	// this method throws the exceptions and does not manage them, 
	//because in the case of the other methods they will be verified
	@Test
	void game() throws FileNotFoundException, ClassNotFoundException, IOException { 
		setupScenary1();
		
		game = new Game();
			
			assertNotNull("The new game is null", game);
			assertNotNull("The list of the pac-mans is null", game.getPacMans());
			assertNotNull("The score is null", game.getScore());

		
	
	}
	
	/**
	 * Test to verify the correct reading of the game file to load
	
	 */
	@Test
	void loadGame() {
		try {
			setupScenary2();
			game.loadGame("data/levelZero.txt", " ");
		} catch (FileNotFoundException e) {
			fail("the file was not found");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			fail("the class was not found");
		
			e.printStackTrace();
		} catch (IOException e) {
			fail("Error reading the file");
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Test to verify that the current game state is saved correctly in a text file
	
	 */
	@Test
	void saveGame() {
		try {
			setupScenary2();
			game.saveGame("data/savedGame.txt");
		} catch (FileNotFoundException e) {
			fail("the file was not found");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			fail("the class was not foun");
			e.printStackTrace();
		} catch (IOException e) {
			fail("Error reading the file");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * test to verify that the table of the best scores is loaded correctly
	
	 */
	@Test
	void loadScore() {
		try {
			setupScenary2();
			game.loadScore();
		} catch (FileNotFoundException e) {
			fail("the file was not found");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			fail("the class was not foun");
			e.printStackTrace();
		} catch (IOException e) {
			fail("Error reading the file");
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Test to verify that the state of the scores persists when the application closes
	
	 */
	@Test
	void saveScore() {
		try {
			setupScenary2();
			game.saveScore();
		} catch (FileNotFoundException e) {
			fail("the file was not found");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			fail("the class was not foun");
			e.printStackTrace();
		} catch (IOException e) {
			fail("Error reading the file");
			e.printStackTrace();
		}
	}

}
