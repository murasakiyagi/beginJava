package eta;

import java.io.*;
import java.util.*;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

/*Nodeのレンダリング
viewOrder:レンダリングの重ね順。小さいほど前
focus:焦点、ピント
travers:横切り。監視者と物体Aの間に物体Bが入る状態

ObservableList = Pane.getChildren()
	viewOrderが同じなら、listの順序が重ね順。新しいほど前


		正直viewOrderは（だけでは）使えない。
		Paneにadd()するときに重なり順は変わるが、その後のviewOrderは値は残るが、”実質”全ての子のが０になる。
		例えば、a.setViewOrder(1.0); b.setViewOrder(2.0);
			add(a); add(b);
			
			orderをいじらなかった場合：手前　b a　奥
			orderをいじった場合　　　：手前　a b　奥
			
			そして、動的にa.setViewOrder(a.getViewOrder() + 0.5)をした後
			a.getViewOrder() == 1.5 であり、「手前　a b　奥」この状態であるはずなのに「手前　b a　奥」に変化する。
			つまり、”実質”　b.getViewOrder() - a.getViewOrder() == 0.5　ではなく　-0.5　となる。

		さらに、動的変更はlastChildにしか効果はない！

		なのでやはり、getChildren().sorted()を実装する方がいいかもしれない

*/
public class Test {

	Pane pane;
	double cnt = 0;
	Rectangle red;
	Rectangle blue;
	Rectangle green;
	Rectangle black;
	List<Rectangle> recList = new ArrayList<Rectangle>();

	String[] labels;

	public Test() {}
	public Test(Pane p) {
		this.pane = new Pane();

			rect(p, "red");
			rect(pane, "green");
			rect(pane, "blue");
			rect(pane, "brack");//１番最後、つまり１番手前のこれしかviewOrderの変更は効かない

		btnSet();
		p.getChildren().add(pane);
//		black.setViewOrder(1.0);
	}

	public void action() {
		System.out.println("ETA TEST");
		System.out.println("モジュラー");
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

	public void rect(Pane p, String s) {
		red = createRec(0,0,Color.RED,"red");
		blue = createRec(0,90,Color.BLUE,"blue");
		green = createRec(90,0,Color.GREEN,"green");
		black = createRec(90,90,Color.BLACK,"black");
		black.setStyle("-fx-fill: yellow;");
//		blue.getStyleClass().add("my-rect");
		
		recList.addAll(List.of(blue, green, black));
		
		//オーダーが小さいほど前に映る
//		red.setViewOrder(2.0);//redのあるpのオーダーも2.0
//		blue.setViewOrder(3.0);//blue,greenのあるpaneは0.0
//		green.setViewOrder(4.0);
//		green.setStyle("-fx-view-order: 0.5");
		
		if(s.equals("red")) {
			p.getChildren().add(red);
		} else if(s.equals("blue")) {
			p.getChildren().add(blue);
		} else if(s.equals("green")) {
			p.getChildren().add(green);
		} else {
			p.getChildren().add(black);
		}
		System.out.println(pane.getChildren().toString());
	}

		private Rectangle createRec(int x, int y, Color color, String name) {
			Rectangle kari = new Rectangle(x, y, 100, 100);
			kari.setFill(color);
			kari.setId(name);
			return kari;
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

//	private void btnAct(ActionEvent e) {
//		//paneのオーダーを2.0より大きくするとpが１番手前に来る
////		pane.setViewOrder(cnt += 0.5);
//////		green.setViewOrder(cnt += 0.5);
////		System.out.println(pane.getViewOrder());
//
////		recInfo();
//
//		Button kari = (Button)e.getTarget();
//		
//		if(kari.getText().equals("PANE UP")) {
//			black.setViewOrder(black.getViewOrder() + 0.5);
//		} else 
//		if(kari.getText().equals("PANE DW")) {
//			black.setViewOrder(black.getViewOrder() - 0.5);
//		} else 
//		if(kari.getText().equals("BLUE UP")) {
//			blue.setViewOrder(blue.getViewOrder() + 0.5);
//			double d = blue.getViewOrder();
//			blue.setStyle("-fx-view-order: " + String.valueOf(d));
//		} else 
//		if(kari.getText().equals("BLUE DW")) {
//			blue.setViewOrder(blue.getViewOrder() - 0.5);
//			double d = blue.getViewOrder();
//			blue.setStyle("-fx-view-order: " + String.valueOf(d));
//		} else 
//		if(kari.getText().equals("GREEN UP")) {
//			green.setViewOrder(green.getViewOrder() + 0.5);
//			double d = green.getViewOrder();
//			green.setStyle("-fx-view-order: " + String.valueOf(d));
//		} else 
//		if(kari.getText().equals("GREEN DW")) {
//			green.setViewOrder(green.getViewOrder() - 0.5);
//			double d = green.getViewOrder();
//			green.setStyle("-fx-view-order: " + String.valueOf(d));
//		}
//		System.out.println(pane.getViewOrder() +" "+ black.getViewOrder() +" "+ blue.getViewOrder() +" "+ green.getViewOrder());
////		System.out.println("BLACK STYLE" + black.getStyle());
////		System.out.println("GREEN STYLE" + green.getStyle());
////		System.out.println("BLUE STYLE" + blue.getStyle());
//
////		System.out.println(e);
////		System.out.println(e.getTarget());
////		Button kari = (Button)e.getTarget();
////		System.out.println(kari.getText());
////		System.out.println(e.getTarget().toString());
//	}


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