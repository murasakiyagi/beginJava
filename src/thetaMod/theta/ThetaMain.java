package theta;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import theta.lamdaSiki.LamdaSiki;
import theta.lamdaSiki.MethodSansyo;

public class ThetaMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		Pane p = new Pane();
		Scene sn = new Scene(p, 400, 300);
		stage.setScene(sn);
		stage.show();
		
		Test ts = new Test();
		ts.action();

		Maths mt = new Maths();
		mt.action();
		
		Wrapper wr = new Wrapper();
		wr.action();
		
		Seigyo sg = new Seigyo();
		sg.action();
		
		LamdaSiki ls = new LamdaSiki();
		ls.action();
		
		MethodSansyo ms = new MethodSansyo();
		ms.action();
	}

}