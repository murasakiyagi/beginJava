package eta;

import java.io.*;
import java.util.*;

import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;


public class Transparent {

	Pane pane;
	Group group;
	Pane oya;
	Pane cpane;//チャイルドステージのペイン
	double cnt = 0;
	Rectangle red;
	Rectangle blue;
	Rectangle green;
	Rectangle black;
	List<Rectangle> recList = new ArrayList<Rectangle>();

	String[] labels;

	public Transparent() {}
	public Transparent(Pane oya, Parent cpane) {
		this.pane = new Pane();
		this.group = new Group();
		this.oya = oya;
		this.cpane = (Pane)cpane;
		pane.setId("koPane");
		oya.setId("oyaPane");
		pane.setMouseTransparent(false);//このクラスのPaneを透過するか？

			recInit();
			rect(oya, "red");
			rect(pane, "green");
			rect(pane, "blue");
			rect(pane, "brack");//１番最後、つまり１番手前のこれしかviewOrderの変更は効かない
			btnSet();
		
		jukeiPanes(2,2);
		oya.getChildren().add(pane);
		
			kakeizu(oya, pane);
			kakeizu(oya, new Pane());


			
	}

	public void action() {
		System.out.println("TRANSPARENT");
		System.out.println("モジュラー");
			kakeiju(oya, 0, 0, 0.0, 0.0);
//			kakeiju(pane);
	}


		private void kakeizu(Pane oya, Pane ko) {
			if( oya.getChildren().contains(ko) ) {
				System.out.println("はっいてる");
			} else {
				System.out.println("ない");
			}
		}

		private void kakeiju(Pane oya, int layerX, int layerY, double clx, double cly) {
			
			for(Node nd : oya.getChildren()) {
				var clss = nd.getClass();
				String csname = clss.getSimpleName();
				var spclss = nd.getClass().getSuperclass();
				String spname = spclss.getSimpleName();
				
				if(csname.equals("Pane")) {
//					if(spname.equals("Parent")) {
//						System.out.println("　ペアレントだ");
//					}
//					System.out.println("　ペインだ");
					Rectangle kari = new Rectangle(layerX, layerY, 10, 20);
						Color cari = Color.color(clx, cly, 1);
					kari.setFill(cari);

					kari.setId("KARI." + (layerX));
					cpane.getChildren().add(kari);
					
					kakeiju( (Pane)nd, layerX+10, layerY+layerX, clx+0.2, cly);//再帰
					
					layerY += 30;
					cly += 0.2;
					System.out.println("　ペインだ" + layerX +" "+ layerY +" "+ clx +" "+ cly);
				} else {
//					System.out.println("　じゃない");
				}
				
				
//				nodeSetting(nd);
			}
		}

		private void paneSetting(Pane p) {
			
		}

		private void nodeSetting(Node node) {
			Parent rent = node.getParent();
			if(rent != null) {
				System.out.println("ペアレント " + rent);
			}
		}

		private void jukeiPanes(int k, int l) {
			Pane[] psk = new Pane[k];
			for(int i=0; i < k; i++) {
				psk[i] = new Pane();
				pane.getChildren().add(psk[i]);
				
				Pane[] psl = new Pane[l];
				for(int j=0; j < l; j++) {
					psl[j] = new Pane();
					psk[i].getChildren().add(psl[j]);
				}
			}
		}


	private void btnSet() {
		String[] ss = { "BLUE UP", "BLUE DW", "GREEN UP", "GREEN DW", "PANE UP", "PANE DW" };
		labels = ss;
		
		for(int i=0; i < ss.length; i++) {
			Button kari = new Button( ss[i] );
			kari.setTranslateX(300);
			kari.setTranslateY(25 * i);
			kari.setOnAction(e -> btnAct(e));
			pane.getChildren().add(kari);
		}
	}

	public void recInit() {
		red = createRec(0,0,Color.RED,"red");
		blue = createRec(0,80,Color.BLUE,"blue");
		green = createRec(80,0,Color.GREEN,"green");
		black = createRec(80,80,Color.BLACK,"black");
		black.setStyle("-fx-fill: yellow;");
//		blue.getStyleClass().add("my-rect");

		recList.addAll(List.of(blue, green, black));
		
		//オーダーが小さいほど前に映る
//		red.setViewOrder(2.0);//redのあるpのオーダーも2.0
//		blue.setViewOrder(3.0);//blue,greenのあるpaneは0.0
//		green.setViewOrder(4.0);
//		green.setStyle("-fx-view-order: 0.5");
	}


	public void rect(Pane p, String s) {
		if(s.equals("red")) {
			p.getChildren().add(red);
		} else if(s.equals("blue")) {
			p.getChildren().add(blue);
		} else if(s.equals("green")) {
			p.getChildren().add(green);
		} else {
			p.getChildren().add(black);
		}
//		System.out.println(pane.getChildren().toString());
	}

		private Rectangle createRec(int x, int y, Color color, String name) {
			Rectangle kari = new Rectangle(x, y, 100, 100);
			kari.setFill(color);
			kari.setId(name);
			kari.setOnMousePressed(e -> press(e));
			return kari;
		}

			private void press(MouseEvent e) {
				PickResult picr = e.getPickResult();
				Node node = picr.getIntersectedNode();
				String name = node.getClass().getSimpleName();

				System.out.println(name +" "+ node.getId());

			}


	private void btnAct(ActionEvent e) {
		System.out.println("CHILDLEN  GREEN -> BLUE -> BLACK");
		System.out.println("BEFOUR " + pane.getViewOrder() +" "+ black.getViewOrder() +" "+ blue.getViewOrder() +" "+ green.getViewOrder());
pane.setViewOrder(9.0);
		Button kari = (Button)e.getTarget();
		
		if(kari.getText().equals("PANE UP")) {
			black.setViewOrder(black.getViewOrder() + 0.5);
		} else 
		if(kari.getText().equals("PANE DW")) {
			black.setViewOrder(black.getViewOrder() - 0.5);
		} else 
		if(kari.getText().equals("BLUE UP")) {
			blue.setViewOrder(blue.getViewOrder() + 0.5);
		} else 
		if(kari.getText().equals("BLUE DW")) {
			blue.setViewOrder(blue.getViewOrder() - 0.5);
		} else 
		if(kari.getText().equals("GREEN UP")) {
			green.setViewOrder(green.getViewOrder() + 0.5);
		} else 
		if(kari.getText().equals("GREEN DW")) {
			green.setViewOrder(green.getViewOrder() - 0.5);
		}
		System.out.println("AFTER " + pane.getViewOrder() +" "+ black.getViewOrder() +" "+ blue.getViewOrder() +" "+ green.getViewOrder());
		System.out.println();
	}


	private void recInfo() {
			System.out.println("\nREC INFO\n");
		for(Rectangle rec : recList) {
			System.out.println(rec);
			System.out.println(rec.getStyle());
			System.out.println(rec.isFocusTraversable());
			System.out.println(rec.isFocused());
		}
			System.out.println("------");
	}
}