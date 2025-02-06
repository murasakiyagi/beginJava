package delta;

import java.io.*;
import java.util.*;


public class Generics<T extends Sample> {

	T t;
	List<T> tlist;

	public Generics(T t) {
		this.t = t;
		tlist = new ArrayList<>();
	}
	
	/**
	* 格納したらリストごと返す。
	*/
	public <T> List<T> add(T t) {
		return tlist.add(t);
	}

	//これはエラー
	//このクラスのインスタンス変数を外部でつくったとき、TにSampleパラメーター（中身のないただの型）が渡された場合（というより示された場合）、このクラスのコンストラクタ引数もSampleになるのだが、あくまで外部での話。
	//なので
	public T create() {
		return new Generics<T>(new Sample());
		return new Generics<Sample>(new Sample());
	}

	public void action() {
		String str = """
T == Objectと考えていい。
Sampleのメソッドは使えない。
	Generics<Sample> g = new Generics<>();
	g.method(t -> {
		t.sampleMethod();
	});
""";
		System.out.println(str);
	}

}