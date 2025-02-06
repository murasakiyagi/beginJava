package eta;

import java.io.*;
import java.util.*;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;


/*

*/
public class Listener {

	Pane pane;
	ObservableList<Node> obsv;//リスナーが発生時の変更を追跡できるリスト
	ListChangeListener<Node> lcl;//ObservableListに対する変更を受け取る。関数型インターフェイス
	ListChangeListener.Change<Node> lclc;//変更のリポート
	
	public Listener() {
		this.pane = new Pane();
		obsv = pane.getChildren();
	}

	public void action() {
//		lclCreate();
	}


	private void lclCreate() {
		obsv.addListener(new ListChangeListener<Node>() {
		     public void onChanged(Change<Node> c) {
		         while (c.next()) {
		             if (c.wasPermutated()) {//変更は配列変更だけだったか
	                     for (int i = c.getFrom(); i < c.getTo(); ++i) {
	                          //permutate
	                     }
	                 } else if (c.wasUpdated()) {
	                          //update item
	                 } else {
	                     for (Node remitem : c.getRemoved()) {
//	                         remitem.remove(Outer.this);
	                     }
	                     for (Node additem : c.getAddedSubList()) {
//	                         additem.add(Outer.this);
	                     }
	                 }
	             }
	         }
	     });
	}

}