package epsilon;

import java.io.*;
import java.util.*;


/**
* ループ
*/
public class Loop {

	public Loop() {}

	/**
	* 何かする
	*/
	public void action() {
		orikaesi(0,10);
			System.out.println(-10 % 10 == 0);
		siharaiTuri(234);
	}

	/**
	* 折り返し
	* 一定の区間の値の中で折り返しを繰り返す。
	* 
	* 
	*/
	private void orikaesi(int min, int max) {
		int cnt = 0;
		int num = min;
		int sig = 1;
		while(cnt++ <= 100) {
			num += sig;
			//この処理が後
			if(num % max == 0) {
				sig = sig * -1;
			}
			System.out.println(num);
		}
		
	}

	private void orikaesi2(int min, int max) {
		int cnt = 0;
		int num = min;
		int sig = 1;
		while(cnt++ <= 100) {
			num += sig;
			//この処理が後
			if(num >= max | num <= min) {
				sig = sig * -1;
			}
			System.out.println(num);
		}
		
	}

	/**
	* 支払いと釣りの硬貨の枚数。最小値
	*/
	private void siharaiTuri(int price) {
		int min = 999;//上限
		for(int i=0; i < 999; i++) {//i=back
			int give = price + i;//支払額
			int maisu = pittari(give) + pittari(i);//支払額とお釣りの最小枚数
			min = Math.min(min, maisu);
		}
        System.out.println(min);
	}

	/**
	* 肝：price / coins[i]
	*/
	private int pittari(int price) {
		int cnt = 0;
        int[] coins = { 500, 100, 50, 10, 5, 1 };
		for(int i=0; i < coins.length; i++) {
			cnt = cnt + price / coins[i];//各コインの枚数
			price = price % coins[i];
		}
		return cnt;
	}


}