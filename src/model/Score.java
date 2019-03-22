package model;


import java.io.Serializable;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class Score implements Serializable {
	
	
	
	private Map<Integer, String> hallOfFameLevel0;
	private Map<Integer, String> hallOfFameLevel1;
	private Map<Integer, String> hallOfFameLevel2;
	
	
	public Score() {
		hallOfFameLevel0 = new TreeMap<Integer, String>();
		hallOfFameLevel1 = new TreeMap<Integer, String>();
		hallOfFameLevel2 = new TreeMap<Integer, String>();
	}

	public Map<Integer,String> getHallOfFame0() {
		return hallOfFameLevel0;
			
	}
	public Map<Integer,String> getHallOfFame1() {
		return hallOfFameLevel1;
			
	}
	public Map<Integer,String> getHallOfFame2() {
		return hallOfFameLevel2;
			
	}

	
	
	
}
