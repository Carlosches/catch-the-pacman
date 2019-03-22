package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class PacManTest {

	/**
	 * relationship with the class of the model
	 */
	
	private PacMan pac;
	
	/**
	 * first stage, it is empty since the constructor of the PacMan class will be tested
	 */
	private void setupScenary1() {
	
	}
		
	
	/**
	 * test to verify the correct creation of a PacMan and the correct functioning of trivial methods
	 */
	@Test
	void pacMan() {
		setupScenary1();
		
		pac = new PacMan(20, 150, 69, 50, "RIGHT", 0,  false );
		assertNotNull("The new PacMan is null", pac);
		
	
		
		// test the getters
		assertTrue("the value of the position x is not assigned correctly", pac.getPosX() == 150);
		assertTrue("the value of the direction is not assigned correctly", pac.getPosY() == 69);
		assertTrue("the value of the direction is not assigned correctly", pac.getWaitTime() == 50);
		assertTrue("the value of the first position is not assigned correctly", pac.getDirection().equals("RIGHT"));
		assertTrue("the magic constant is not calculated correctly", pac.getBounces() == 0);
		assertTrue("the magic constant is not calculated correctly", !pac.isState());
		
		
		
		// test the setters
		pac.setPosX(45);
		pac.setPosY(320);
		pac.setDirection("LEFT");
		pac.setBounces(15);
		pac.setState(true);
		assertTrue("the value of the position x is not assigned correctly", pac.getPosX() == 45);
		assertTrue("the value of the direction is not assigned correctly", pac.getPosY() == 320);
		assertTrue("the value of the first position is not assigned correctly", pac.getDirection().equals("LEFT"));
		assertTrue("the magic constant is not calculated correctly", pac.getBounces() == 15);
		assertTrue("the magic constant is not calculated correctly", pac.isState());
		
		
	}
}
