package iota2.exist;

import java.io.*;
import java.util.*;

import javafx.geometry.Point2D;

//existence：存在
public abstract class Existence implements Existable {

	private double col, row;
	private double hp;

	public Existence(double col, double row, double hp) {
		this.col = col;
		this.row = row;
		this.hp = hp;
	}

//POS
	public Point2D getPd() { return new Point2D(col, row); }
	public double getCol() { return col; }
	public double getRow() { return row; }
	public void setCol(double col) { this.col = col; }
	public void setRow(double row) { this.row = row; }
	public void setPos(double col, double row) {
		this.col = col;
		this.row = row;
	}
	public void setPos(Point2D pd) {
		this.col = pd.getX();
		this.row = pd.getY();
	}
	public void addPos(double col, double row) {
		this.col += col;
		this.row += row;
	}
	public void addPos(Point2D pd) {
		this.col += pd.getX();
		this.row += pd.getY();
	}

//HP
	public double getHp() { return hp; }
	public void setHp(double hp) { this.hp = hp; }
	public void addHp(double hp) { this.hp += hp; }

}