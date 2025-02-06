package eta;

import java.io.*;
import java.util.*;
import java.time.*;

import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;


public class UnitManager {

	Pane pane;
	List<Unit> unitList = new ArrayList<Unit>();

	public UnitManager(Pane pane) {
		this.pane = pane;
		this.pane.setOnMouseClicked(e -> clickEvent(e));
	}

	public void action() {
		creates();
//		compare();
		sortTime();
	}

	public void creates() {
		unitList.add(new Unit(1,"taro","mel","red"));
		unitList.add(new Unit(2,"jiro","mel","blue"));
		unitList.add(new Unit(3,"hana","fem","green"));
		unitList.add(new Unit(4,"miki","fem","black"));
		for(Unit u : unitList) {
			pane.getChildren().add(u.getRec());
		}
	}

	public void compare() {
//		var sorted = pane.getChildren().sorted( Comparator.comparing( Node::toString ) );
//		var sorted = pane.getChildren().sorted();
//		pane.getChildren().setAll(sorted);
		for(int i=0; i < pane.getChildren().size(); i++) {
			System.out.println( pane.getChildren().get(i).getUserData().toString() );
		}
	}

	public void sortTime() {
//		long stt = System.currentTimeMillis();
//
//		while(System.currentTimeMillis() - stt < 10000) {
//			long now = System.currentTimeMillis() - stt;
//			if(now > 1000 && now < 5000) {
//				
//			}
//		}

		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("実行");
			}
		};

		Timer time = new Timer();
		time.schedule(task, 2000);
		time.schedule(tasker(0, 11, time), 2000 * 2);
		time.schedule(tasker(1, 12, time), 2000 * 3);
		time.schedule(tasker(2, 13, time), 2000 * 4);
		time.schedule(tasker(3, 14, time), 2000 * 5);
	}

		private TimerTask tasker(int i, int n, Timer time) {
			TimerTask task = new TimerTask() {
				public void run() {
					unitList.get(i).getRec().setViewOrder(n);
					System.out.println(unitList.get(i).getRec().getViewOrder());
					
					if(i == 3) {
						time.cancel();
					}
				}
			};
			
			return task;
		}

	private void clickEvent(MouseEvent e) {
		sortTime();
	}

}