package iota;

import java.io.*;
import java.util.*;


public class Ko1 extends Oya {

	static String family = "千鳥";
	private int age = 40;

	public Ko1(String name) {
		super(name);
//		this.family = family;
//		this.name = name;
//		this.age = age;
	}

	static void diner() {
		System.out.println("DINER:" + family);
	}

//	public void action() {
//		print(family, name);
//	}


//	private long cnt = 0;
//	protected void print(Object... objs) {
//		System.out.print(cnt++ +" "+ print0());
//		for(int i=0; i < objs.length; i++) {
//			System.out.print(" " + objs[i]);
//		}
//		System.out.println();
//	}
//	private String print0() {
//		return " !" + getClass().getSimpleName() + "! ";
//	}
}