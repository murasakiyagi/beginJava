package iota2.exist;

import java.io.*;
import java.util.*;

import javafx.geometry.Point2D;

public interface Pointable {

	public Point2D getPd();
	public double getCol();
	public double getRow();
	
	public void setCol(double col);
	public void setRow(double row);
	public void setPos(double col, double row);
	public void setPos(Point2D pd);
	
	public void addPos(double col, double row);
	public void addPos(Point2D pd);
	
}