package model;

public class PacMan {
	/**
	 * represents one of the directions in which the pacman can be moved
	 */
	public static final String LEFT = "LEFT"; 
	/**
	 * represents one of the directions in which the pacman can be moved
	 */
	public static final String UP = "UP"; 
	/**
	 * represents one of the directions in which the pacman can be moved
	 */
	public static final String RIGHT = "RIGHT"; 
	/**
	 * represents one of the directions in which the pacman can be moved
	 */
	public static final String DOWN = "DOWN"; 
	
	 
	/**
	 * the radius of the pacman
	 */
	private double radius;
	/**
	 * the position in x of the pacman
	 */
	private double posX;
	/**
	 * the position in y of the pacman
	 */
	private double posY;
	/**
	 * the wait time of the pacman
	 */
	private int WaitTime;
	/**
	 * the direction that move the pacman
	 */
	private String direction;
	/**
	 * the bounces number of the pacman
	 */
	private int bounces;
	/**
	 * if the pacman is state
	 */
	private boolean state;
	
	/**
	 * the pacMan builder
	 * @param rad, radius of the pacman
	 * @param x, position in x of the pacman
	 * @param y, position in y of the pacman
	 * @param time, wait time of the pacman
	 * @param dire, direction of the pacman
	 * @param boun, bounces number of the pacman
	 * @param st, state of the pacman
	 */
	public PacMan(double rad, double x, double y, int time, String dire, int boun,
			boolean st) {
		
		radius = rad;
		posX = x;
		posY = y;
		WaitTime = time;
		direction = dire;
		bounces = boun;
		state = st;
	}
	/**
	 
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * 
	 * @return position in x
	 */
	public double getPosX() {
		return posX;
	}
	/**
	 * change the position in x of the pacMan
	 * @param posX the new position in x
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}
	/**
	 * 
	 * @return position in y
	 */
	public double getPosY() {
		return posY;
	}
	/**
	 * change the position in x of the pacMan
	 * @param posX the new position in x
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}

	public int getWaitTime() {
		return WaitTime;
	}

	public String getDirection() {
		return direction;
	}
	public void setDirection(String direc) {
		this.direction = direc;
	}

	public int getBounces() {
		return bounces;
	}

	public void setBounces(int bounces) {
		this.bounces = bounces;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
}
