package Mu;

import java.io.*;
import java.util.*;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class KousiView {

	Pane p;
	
	public KousiView() {
		this.p = new Pane();
	}

	public void grid() {
		for(int i = 0; i < 10; i++) {
			Line line = new Line(i, 0, i, 100);
			line.setStartX();
		}
	}


	public Pane getPane() {
		return p;
	}

}