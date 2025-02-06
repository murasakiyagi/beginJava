package theta.lamdaSiki;

import java.io.*;
import java.util.*;

//import theta.lamdaSiki.FuncFace;
//import theta.lamdaSiki.FuncFace2;

/**
* ラムダ式について
* 
* 
* 
*/
public class LamdaSiki {

	public LamdaSiki() {}

	public void action() {
//		noNameClass();
//		lamdaSiki();

		funcUse1();
		funcUse2();

	}

//Comarator<T>を使った例　ーーーーーー
//@FunctionalInterface public interface Comarator<T>
//関数型インターフェイスを表すアノテーション@FunctionalInterface。（なくてもいい）
//関数型インターフェイスは
//	「ラムダ式またはメソッド参照の代入先として使用できます。」
//	抽象メソッドを一つだけ持つ。staticやdefaultは例外。
//	Comarator<T>には「boolean equals(Object)」があるが、これはObjectクラスからの継承なので例外。
//	インスタンスを作れる。
//Comarator<T>の関数メソッド public int compare(T t1, T t2);


//以下、使用例

	//無名クラスを使った書き方
	public void noNameClass() {
		List<Member> mmbList = Member.samples();
		printArr("NoNAME before", mmbList);
		
		//無名クラス使用
		//List.sort(Comarator<T>)としてComarator<T>を要求している。（TはList<T>と同じ）
		//compare(T,T)はオーバーライドしなくてはいけないので、わからなくてもコンパイラが教えてくれる。
		mmbList.sort(//Collections.sort(List, Comparator)と同じ
			//ここが無名クラス
			new Comparator<Member>() {
				@Override
				public int compare(Member mmb1, Member mmb2) {
					return mmb1.height - mmb2.height;
				}
			}
		);
		
		
		printArr("NoNAME after", mmbList);
	}

	//ラムダ式を使った書き方
	public void lamdaSiki() {
		List<Member> mmbList = Member.samples();
		printArr("LAMDA before", mmbList);
		
		//ラムダ式
		//sort()の要求は固定されている、関数型インターフェイスもすることは決まっている。
		//あとすることは、compare()に渡す変数名と処理だ。compare()の処理はリストの順序づけの計算方法のこと。
		mmbList.sort((mmb1, mmb2) -> mmb1.height - mmb2.height);
		
		printArr("LAMDA after", mmbList);
	}


//Comarator<T>を使った例、終わり　ーーーーーー


	private void funcUse1() {
		FuncUser fu = new FuncUser(1, 2);
		fu.funcer(
			new FuncFace() {
				@Override
				public int run(int a, int b) {
					return a * b;
				}
			}
		);
	}
	
	private void funcUse2() {
		FuncUser fu = new FuncUser(1, 2);
//		fu.funcer( (a, b) -> a * b );
		fu.funcer( 100, (a, b) -> a * b );
	}


	public void printArr(String text, List<?> list) {
		System.out.println(text);
		for(var val : list) {
			System.out.println(val);
		}
		System.out.println();
	}

}


class FuncUser {

	int a, b;

	FuncUser(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void funcer(FuncFace ff) {
		System.out.println(ff.run(a, b));
	}
	
	//このオーバーロード自体は問題ない
	public void funcer(FuncFace2 ff2) {
		System.out.println(ff2.run(a + 1, b + 1));
	}

	public void funcer(int num, FuncFace2 ff2) {
		System.out.println(num +" "+ ff2.run(a + 1, b + 1));
	}

	public void funcer(int num, int num2) {
		System.out.println(num +" "+ num2);
	}

}

class Member {

	String name;
	int height;//身長
	int month;//誕生月
	
	Member(String name, int height, int month) {
		this.name = name;
		this.height = height;
		this.month = month;
	}
	
	public String toString() {
    	return name + "/" + height + "/" + month;
	}
	
	static List<Member> samples() {
		String[] names = { "alfa", "bravo", "charl", "delta", "ecoh" };
		int[] heis = { 140, 130, 120, 120, 110 };
		int[] moons = { 3, 1, 4, 3, 2 };
		List<Member> mmbList = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			Member mmb = new Member(names[i], heis[i], moons[i]);
			mmbList.add(mmb);
		}
		return mmbList;
	}

}