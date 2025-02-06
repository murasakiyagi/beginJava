package iota2;

import java.io.*;
import java.util.*;

import javafx.geometry.Point2D;

import iota2.exist.Existence;
import iota2.att.AttFace;
import iota2.ability.Ability;

//javaは多重継承ができない。
//	(当たり前だけど)１つは継承してもいい。
//	interfaceをここで実装し直す。
//		interface型の変数や、引数にこのクラスを充てられる。
//	それぞれの具象クラスを用意し、コンポジションする。
//		コンポジション型の変数や、引数にこのクラスを渡せない。
//		その代わり、getterを用意して渡す
//public class Unit extends Existence, Attribute, Ability {
public class Unit extends Existence implements AttFace {

	String name;//Unit固有メンバー
	Ability abili;

	public Unit(double col, double row, double hp, int team, int type, int power, int tough) {
		//super = Existence
		super(col, row, hp);
		this.team = team;
		this.type = type;
		this.abili = new Ability(power, tough);
		this.name = "UNITちゃん";
	}



//AttFaceの実装
	int team, type;
	public int getTeam() { return team; }
	public void setTeam(int team) { this.team = team; }
	public int getType() { return type; }
	public void setType(int type) { this.type = type; }


//Abilityの渡し役
	public Ability getAbility() { return abili; }
	
	public int getPower() { return abili.getPower(); }
	public void setPower(int power) { abili.setPower(power); }
	
	public int getTough() { return abili.getTough(); }
	public void setTough(int tough) { abili.setTough(tough); }

//Unit固有メンバー
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }


}