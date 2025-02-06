package eta;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class EtaMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane p = new Pane();
		Scene sn = new Scene(p, 400, 300);
//			sn.getStylesheets().add("../rsrc/testCss.css");//できない
		stage.setScene(sn);
		stage.show();
		//インスタンスするだけ
		ChildStage cstg = new ChildStage(stage);
			System.out.println("cstg.getPane" + cstg.getPane());
		
//		UnitManager um = new UnitManager(p);
//		um.action();
		
//		Test ts = new Test(p);
//		ts.action();

		Transparent tp = new Transparent(p, cstg.getPane());
		tp.action();
	}

}