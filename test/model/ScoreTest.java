package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScoreTest {

	/**
	 * relationship with the class of the model
	 */
	private Score score;
	
	/**
	 * first stage, it is empty since the constructor of the Score class will be tested
	 */
	public void setUpScenary1() {
		
	}
	
	/**
	 * test to verify the correct creation of a Score and its hall of fame
	 */
	
	@Test
	void score() {
		setUpScenary1();
		
		score = new Score();
		
		assertNotNull("The new Score is null", score);
		assertNotNull("The new Score is null", score.getHallOfFame0());
		assertNotNull("The new Score is null", score.getHallOfFame1());
		assertNotNull("The new Score is null", score.getHallOfFame2());
		
			
		
	}
}
