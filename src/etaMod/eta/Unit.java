package eta;

import java.io.*;
import java.util.*;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;


public class Unit {

	int num;
	String name;
	String type;
	Color iro;
	Rectangle rec;
	
	public Unit(int num, String name, String type, String siki) {
		this.num = num;
		this.name = name;
		this.type = type;
		this.iro = iroDori(siki);
		this.rec = recBuild(siki);
	}

	public Integer getNum() {
		return num;
	}

	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public Color getIro() {
		return iro;
	}

	public Rectangle getRec() {
		return rec;
	}
	
	private Color iroDori(String siki) {
		if(siki.equals("red")) { return Color.RED; }
		if(siki.equals("blue")) { return Color.BLUE; }
		if(siki.equals("green")) { return Color.GREEN; }
		if(siki.equals("black")) { return Color.BLACK; }
		return null;
	}

	private Rectangle recBuild(String siki) {
		int x = 0;
		int y = 0;
		int h = 0;
		int w = 0;
		if(siki.equals("red")) { x = 20; y = 0; h = 20; w = 80; }
		if(siki.equals("blue")) { x = 0; y = 20; h = 80; w = 20; }
		if(siki.equals("green")) { x = 0; y = 30; h = 80; w = 20; }
		if(siki.equals("black")) { x = 30; y = 0; h = 20; w = 80; }
		Rectangle kari = new Rectangle(h, w, iro);
		kari.setTranslateX(x);
		kari.setTranslateY(y);
		kari.setUserData(siki);
		kari.setViewOrder(num);
		kari.setOnMouseClicked(e -> clickEvent(e));
		return kari;
	}

	private void clickEvent(MouseEvent e) {
		rec.setViewOrder(rec.getViewOrder() + 1);
			System.out.println(name +" "+ rec.getViewOrder());
	}

}