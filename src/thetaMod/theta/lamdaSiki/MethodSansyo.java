package theta.lamdaSiki;

import java.io.*;
import java.util.*;
import java.util.function.*;

//import theta.lamdaSiki.FuncFace;
//import theta.lamdaSiki.FuncFace2;

/**
* メソッドそのものを持ち歩く。
* ラムダ式のように、内容の変更はかなわない。
* 
*/
public class MethodSansyo {

	public MethodSansyo() {}

	public void action() {
		System.out.println("\nMethodSansyo\n");
		
		Consumer<String> cons = System.out::println;
		cons("CONS1", cons);
		cons("CONS2", System.out::println);
		
		String str = "SUPPLIER";
		Supplier<Integer> supl = str::length;
		System.out.println(supl.get() + 10);
		System.out.println(supl( supl ));
		
		
		Sample smpl = new Sample("AAA");
		Function<String, String> func = String::toUpperCase;
//		func = String::toLowerCase;
//		func = (s) -> s.concat();
		func = (s) -> {
			String kari = s.concat(s.toUpperCase());
			if(kari.length() == 6) {
				return "yes";
			} else {
				return "no";
			}
		};
		//そのまま使ってもいいし、
		func.apply("a");
		//Function要求しているメソッドに渡し、さらに加工することもできる。
		System.out.println(smpl.test(func));
		//例としてStringを使ったが、自作クラスのメソッドも形(ジェネリックス)さえ合えば使える。
		func = this::funcMethod;
		System.out.println(smpl.test(func));
	}

	private void cons(String str, Consumer<String> cons) {
		cons.accept(str);
	}

	private String func(String num, Function<String, String> func) {
		return func.apply(num);
	}

	private Integer supl(Supplier<Integer> supl) {
		return supl.get() * 10;
	}

	public String funcMethod(String s) {
		return s + "!!!";
	}

}

class Sample {

	String name;

	Sample(String name) {
		this.name = name;
	}
	
	public int test(Function<String, String> func) {
		String kari = func.apply(name);
			System.out.println("TEST " + kari);
		if(kari.equals("AAA")) {
			return 0;
		} else if(kari.equals("aaa")) {
			return 1;
		} else {
			return 2;
		}
	}

}