package gamma;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

//import gamma.javadoc.JavadocTest;

/**
* Javaコマンドのテストパッケージ
* @author 名無し
* @version 1.01
*/
public class GammaMain extends Application {

	/**
	* パッケージのメインメソッド
	* @param args 入力
	*/
	public static void main(String[] args) {
		launch(args);
	}
	/**
	* FXのメイン
	* @param stage GUIステージ
	* @throws Exception 何かしらの例外
	*/
	@Override
	public void start(Stage stage) throws Exception {
		Pane p = new Pane();
		Scene sn = new Scene(p, 400, 300);
		stage.setScene(sn);
		stage.show();
		
//		JavadocTest jd = new JavadocTest();
//		jd.action("world");
		
	}


}