package eta;

import java.io.*;
import java.util.*;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;

public class ChildStage extends Stage {

	Stage pare;
	Pane pane;

	//インスタンスするだけで出る
	public ChildStage(Stage pare) {
		super();
			System.out.println("ChildStage");
		this.pare = pare;
		position();
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 300, 300);
		this.setTitle("ChildStage");
		this.setScene(scene);
		this.show();
			
			System.out.println("cstg.getPane" + pane);

	}
	
	private void position() {
		setX(pare.getX() + pare.getWidth());
//		setY(pare.getY() + pare.getHeight());
//		setY(pare.getY() + 300);
	}
	
	public Parent getPane() {
		return getScene().getRoot();
	}

}