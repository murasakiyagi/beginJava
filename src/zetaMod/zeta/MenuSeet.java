package zeta;

import java.io.*;
import java.util.*;


import javafx.scene.layout.Pane;

import javafx.scene.control.ContextMenu;
import javafx.scene.input.ContextMenuEvent;//conMenuリクエストで発生するイベント
import javafx.scene.control.Menu;//extends MenuItem
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Side;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

//構造
//	ContextMenu {
//		Menu {
//			MenuItem;
//		}
//	}
//

public class MenuSeet {

	private Pane p;
	private Button btn;
	private Rectangle rect;

	public MenuSeet(Pane p) {
//		ContextMenu.getOwnerWindow();がnullだとだめ。
//		show()するまでnullで、した後引数のNodeやWindowからownerがセットされる
		this.p = p;
		btnInit();
//		rectInit();
		System.out.println("ACTION");
	}

	ContextMenu ctxmenu = new ContextMenu();//Menu1なに、キャラセレクトで始めに出る
	ContextMenu ctxmenu2 = new ContextMenu();//Menu2やめる、始めから選択アクションが終わるまで
	ContextMenu ctxmenu3 = new ContextMenu();//Menu3どこ
	ContextMenu ctxmenu4 = new ContextMenu();//Menu4だれ
	
	Menu menu1what = new Menu("なに？");//最初の質問
	Menu menu2build = new Menu("つくる");//次の質問

	//MenuItem[] whatMenuIs = new MenuItem[7];//あと
	MenuItem[] whatMenuIs = {
		new MenuItem(""),//[0]
		new MenuItem("やめる"),
		new MenuItem("どこ"),
		new MenuItem("だれ"),
		new MenuItem("待つ"),//[4]
		new MenuItem("いどう"),
		new MenuItem("追いかけ"),
		new MenuItem("こわす")
	};

	MenuItem[] buildMenuIs = {
		new MenuItem("おうち"),//[8]
		new MenuItem("はし"),
		new MenuItem("さく")//[10]
	};
//	Popup ppup = new Popup();

	public void action() {
		eventSetting();
		System.out.println("ACTION");
		jukeizu();
	}

	private void eventSetting() {
		//キャラ選択時のメニュー〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜
		menu1what.getItems().addAll(whatMenuIs[4], whatMenuIs[5], whatMenuIs[6], menu2build, whatMenuIs[7]);//なに？の次
		menu2build.getItems().addAll(buildMenuIs[0], buildMenuIs[1], buildMenuIs[2]);//つくるの次
	
		ctxmenu.getItems().addAll(menu1what);
		ctxmenu2.getItems().addAll(whatMenuIs[1]);
		ctxmenu3.getItems().addAll(whatMenuIs[2]);
		ctxmenu4.getItems().addAll(whatMenuIs[3]);

		//イベントセット
		for(MenuItem item : whatMenuIs) {
			item.setOnAction(e -> menuEve(e));
		}
		for(MenuItem item : buildMenuIs) {
			item.setOnAction(e -> menuEve(e));
		}
	}


	private void btnInit() {
		this.btn = new Button("MENU");
		this.btn.setContextMenu(ctxmenu);
		this.btn.setTranslateX(100);
		this.btn.setTranslateY(100);
		this.btn.setOnAction(e -> btnClick(e));
		p.getChildren().add(btn);
	}

	private void rectInit() {
		this.rect = new Rectangle(50, 50, Color.BLUE);
		this.rect.setOnMouseClicked(e -> rectClick(e));
		p.getChildren().add(this.rect);
	}

	public void gestInit(Rectangle gest) {
		gest.setOnMouseClicked(e -> {
			ctxmenu.show(gest, Side.BOTTOM, 0, 0);
		});
	}


	private void btnClick(ActionEvent e) {
		System.out.println(e);
		System.out.println(ctxmenu);
		System.out.println(ctxmenu.getItems());
		System.out.println(btn);
		System.out.println(ctxmenu.getOwnerNode());
		System.out.println(ctxmenu.getOwnerWindow());
		ctxmenu.show(btn, Side.BOTTOM, 0, 0);
			owner();
	}

	private void rectClick(MouseEvent e) {
		System.out.println(e);
		System.out.println(ctxmenu.getOwnerNode());
		System.out.println(ctxmenu.getOwnerWindow());
		ctxmenu.show(rect, Side.BOTTOM, 0, 0);
	}

		public void owner() {
			System.out.println("OWNER" + ctxmenu.getOwnerWindow());
		}

	public void eats() {
//		ちょー簡単。だけど、ボタン以外からコンテキストメニューを出す時はめんどい方を使う
		MenuButton m = new MenuButton("Eats");
		m.getItems().addAll(new MenuItem("Burger"), new MenuItem("Hot Dog"));
		m.setTranslateX(100);
		p.getChildren().add(m);
	}



	private void menuEve(ActionEvent e) {//選択肢を選んだ時

		System.out.println(e.getSource());
		System.out.println(e.getSource().toString());

		if(e.getSource() == whatMenuIs[4]) {
			System.out.println("Menu item - No.4");
			System.out.println(whatMenuIs[4].getText());
		} else {
			System.out.println("fail");
		}


		ctxHide();
		
	}

	private void ctxHide() {
		ctxmenu.hide();//多重開示を回避
		ctxmenu2.hide();//やめる
		ctxmenu3.hide();
		ctxmenu4.hide();
	}
	

	public void jukeizu() {
		String str = "z?,a/b,c?:d,f?/g:h";
		String str2 = "hello";
		String str3 = "world";
		String tdq = """
なに?
まつ.いどう.追いかけ.つくる?こわす.
おうち.はし.さく.%2$s ! %1$s
		""";
		String fmted = String.format(tdq, str2, str3);

		var vared = tdq.split("\s");
		
		System.out.println(vared);
		System.out.println(tdq.split("(\s)").toString());
		System.out.println(tdq.split("\s").toString());
		System.out.println(fmted);

		int[] ins = {1,2};
		String inst = Arrays.toString(ins);
//		String inde = Arrays.deepToString(ins);
		System.out.println(inst);
//		System.out.println(inde);

		String[] strs = {"a", "b"};
		String tost = Arrays.toString(strs);
		String deep = Arrays.deepToString(strs);
		System.out.println(tost);
		System.out.println(deep);

	}




}