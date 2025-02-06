package iota2;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import iota2.exist.Existence;
import iota2.att.AttFace;
import iota2.ability.Ability;


public class Iota2Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
//		Pane p = new Pane();
//		Scene sn = new Scene(p, 400, 300);
//		stage.setScene(sn);
//		stage.show();
		
		Unit un = new Unit(1,2,100,3,4,5,6);
		exis(un);
		abili(un.getAbility());
		unAbl(un);
	}

	void exis(Existence exis) {
		System.out.println("EXISTENCE " + exis);
		exis.addHp(-40);
		exis.addPos(10, 10);
		System.out.println(exis.getPd() +" "+ exis.getHp());
			//コンパイルエラー
//			System.out.println(exis.getName());
	}

	void abili(Ability abl) {
		System.out.println("ABILITY " + abl);
		abl.setPower(abl.getPower() + 20);
		abl.setTough(abl.getTough() + 20);
		System.out.println(abl.getPower() +" "+ abl.getTough());
	}

	void unAbl(Unit unit) {
		System.out.println("UNIT " + unit + unit.getName());
		unit.setPower(unit.getPower() + 30);
		unit.setTough(unit.getTough() + 30);
		System.out.println(unit.getPower() +" "+ unit.getTough());
	}

}