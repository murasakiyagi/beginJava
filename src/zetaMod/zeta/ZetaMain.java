package zeta;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class ZetaMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane p = new Pane();
		Scene sn = new Scene(p, 400, 300);
		stage.setScene(sn);
		stage.show();
			System.out.println(stage);

			Rectangle rect = new Rectangle(50, 50, Color.BLUE);
			p.getChildren().add(rect);



		MenuSeet ms = new MenuSeet(p);
			ms.owner();
		ms.action();
		ms.eats();
			ms.owner();
			
			ms.gestInit(rect);
		System.out.println("ACTION");
		
		Funcky fu = new Funcky();
		fu.action();
		fu.act2();
	}

}