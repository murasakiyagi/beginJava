package iota2.ability;

import java.io.*;
import java.util.*;


//Ability : 能力
public class Ability implements AbilityFace {

	int power, tough;

	public Ability(int power, int tough) {
		this.power = power;
		this.tough = tough;
	}

	public int getPower() { return power; }
	public void setPower(int power) { this.power = power; }
	
	public int getTough() { return tough; }
	public void setTough(int tough) { this.tough = tough; }

}