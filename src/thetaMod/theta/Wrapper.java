package theta;

import java.io.*;
import java.util.*;


public class Wrapper {

	public Wrapper() {}

	public void action() {
		Integer teg = 10;
		Number num = 20;
		num = 30;
		wrap(num);
		
		int[] ints = { 1 };
		int ger = change(teg, ints);
			System.out.println(ints[0] +" "+ ger +" "+ teg +" "+ num);
	}

	/**
	* Integerなどのプリミティブ型のラッパークラスは、1度値を入れると変更不可。
	* 時々、戻り値のついでに、別の変数の値を変えたい時、つまりvoid型のようにメソッド内部で値を変えたいけどできない。
	* プリミティブ数値型の配列ならインクリメントなども使えるし、voidで変更を保持できる。
	*/
	private int change(Integer teg, int[] ints) {
		teg++;
		ints[0]++;
		int kari = 100 + teg;
		return kari;
	}

	/**
	* Numberはアブストラクト
	* Integerなどのように通常の計算式は使えないし、値を引き出すにもメソッドのオーバーライドが必要。
	*/
	private void wrap(Number num) {
//		num += 1;//できない
		num = num.intValue() + 40;//オーバーライドせなかん。
//		num = num + 40;
	}


}