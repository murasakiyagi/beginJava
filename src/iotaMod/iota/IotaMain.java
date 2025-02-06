package iota;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class IotaMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
//		Pane p = new Pane();
//		Scene sn = new Scene(p, 400, 300);
//		stage.setScene(sn);
//		stage.show();
		
		Oya oya = new Oya("一");
		oya.action();
		oya.diner();
		
		Ko1 ko1 = new Ko1("百福");
		ko1.action();
		ko1.diner();
		
		Ko2 ko2 = new Ko2("一二三");
		ko2.action();
		ko2.diner();
		
		Mago11 mago = new Mago11("無");
		mago.action();
		mago.diner();
		
	}

}