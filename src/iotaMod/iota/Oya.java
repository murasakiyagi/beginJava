package iota;

import java.io.*;
import java.util.*;


public class Oya {

	static String family = "九十九";
	protected String name;
	private int age = 100;

	public Oya(String name) {
		this.name = name;
	}

	static void diner() {
		System.out.println("DINER:" + family);
	}

	public void action() {
		print("ACTION", family, name, age);
	}


	private long cnt = 0;
	protected void print(Object... objs) {
		System.out.print(cnt++ +" "+ print0());
		for(int i=0; i < objs.length; i++) {
			System.out.print(" " + objs[i]);
		}
		System.out.println();
	}
	private String print0() {
		return " !" + getClass().getSimpleName() + "! ";
	}
}