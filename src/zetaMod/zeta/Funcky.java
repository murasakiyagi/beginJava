package zeta;

import java.io.*;
import java.util.*;
import java.util.function.*;


public class Funcky {

	public Funcky() {}
	
	public void action() {
		Function<String, Integer> f = (str) -> {
			return Integer.parseInt(str);
		};
		System.out.println(f.apply("100") * 2);
	}

	public void act2() {
		Function<String, String> before = (v) -> {
			return "BEFORE " + v;
		};
		Function<String, String> after = (vl) -> {
			return vl + " AFTER";
		};
		
		Function<String, String> f3 = before.andThen(after);
		String s1 = f3.apply("NOW");//ここでようやくapplyの登場
		
		Function<String, String> f4 = after.compose(before);
		String s2 = f4.apply("ERA");
		
		System.out.println(s1);
		System.out.println(s2);

	}

}