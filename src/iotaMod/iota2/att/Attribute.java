package iota2.att;

import java.io.*;
import java.util.*;


//existence：存在
public abstract class Attribute implements AttFace {

	int team, type;

	public Attribute(int team, int type) {
		this.team = team;
		this.type = type;
	}

	public int getTeam() { return team; }
	public void setTeam(int team) { this.team = team; }
	
	public int getType() { return type; }
	public void setType(int type) { this.type = type; }

}