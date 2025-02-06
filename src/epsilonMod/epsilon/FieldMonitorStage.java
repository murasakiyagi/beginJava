package epsilon;

import java.io.*;
import java.util.*;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;


public class FieldMonitorStage extends Stage {

	Stage pare;
	Pane pane = new Pane();

	//インスタンスするだけで出る
	public FieldMonitorStage(Stage pare) {
		super();
		this.pare = pare;
		position();
		Scene scene = new Scene(pane, 300, 300);
		this.setTitle("FieldMonitorStage");
		this.setScene(scene);
		this.show();
	}
	
	private void position() {
		setX(pare.getX() + pare.getWidth());
//		setY(pare.getY() + pare.getHeight());
	}


	public void renewal(int[][] field) {
		masuNarabeRect(field, 100, 0);
	}


	public void masuNarabeRect(int[][] field, int slideX, int slideY) {//action
//		pane.getChildren().clear();
		
//		for(int i=0; i < fl.getRow(); i++) {
//			for(int j=0; j < fl.getCol(); j++) {
		for(int i=0; i < field.length; i++) {
			for(int j=0; j < field[i].length; j++) {
				Rectangle rect = new Rectangle(j*10+10+slideX, i*10+10+slideY, 10, 10);
				rect.setStrokeType(StrokeType.INSIDE);
				rect.setStrokeWidth(1);
				rect.setStroke(Color.SILVER);
				if(field[i][j] > 0) {
					rect.setFill(Color.BLUE);
				} else {
					rect.setFill(Color.WHITE);
				}
				pane.getChildren().add(rect);
			}
		}
		
		numberRowCol(field);
	}


	public void numberRowCol(int[][] field) {
		for(int i=0; i < field.length; i++) {
			Text txI = new Text(0, i*10+20, String.valueOf(i));
			if(i >= 10) {
				txI.setFont(new Font(5));
			} else {
				txI.setFont(new Font(10));
			}
			pane.getChildren().add(txI);
			
			for(int j=0; j < field[i].length; j++) {
				Text txJ = new Text(j*10+10, 10, String.valueOf(j));
				if(j >= 10) {
					txJ.setFont(new Font(5));
				} else {
					txJ.setFont(new Font(10));
				}
				pane.getChildren().add(txJ);
			}
		}

	}


//	QuickUtil qu = new QuickUtil(this);//サブクラスも大丈夫
//	public void print(Object... objs) {
//		qu.print(objs);
//	}
//
//
//	public void infomation() {
//		String info = """
//用途：マスを並べたフィールドを小さく見せる
//
//		""";
//		
//		print(info);
//	}

}