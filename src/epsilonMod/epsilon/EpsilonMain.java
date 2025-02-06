package epsilon;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class EpsilonMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane p = new Pane();
		Scene sn = new Scene(p, 400, 300);
		stage.setScene(sn);
		stage.show();
		
//		Algorithm algo = new Algorithm();
//		algo.action();
		
//		Sorter st = new Sorter();
//		st.action();
		
//		SingleArray sa = new SingleArray();
//		sa.action();
		
		FieldMonitorStage fms = new FieldMonitorStage(stage);

//		fms.masuNarabeRect(intss,0,0);
//		fms.numberRowCol(intss);
//		

		BiArrNum ban = new BiArrNum(new int[9][9]);
		ban.action(fms);

		BinaryArray ba = new BinaryArray(ban);
		ba.action(fms);

//		Loop loop = new Loop();
//		loop.action();
	}

}