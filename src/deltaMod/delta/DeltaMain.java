package delta;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DeltaMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane p = new Pane();
		Scene sn = new Scene(p, 400, 300);
		stage.setScene(sn);
		stage.show();
		
		ClassLoadman clm = new ClassLoadman();
		clm.action();
		clm.getUrl();
//		Image img = new Image(clm.getUrl());
//		ImageView view = new ImageView(img);
//		
//		p.getChildren().add(view);
	}

}