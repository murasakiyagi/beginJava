package theta;

import java.io.*;
import java.util.*;


public class Seigyo {

	public Seigyo() {}

	public void action() {
		System.out.println("BETA TEST");
		System.out.println("モジュラー");
		
		ifBreak();
	}

	/**
	* 下のコードは有効か？
		for() {
			if() {
				if() {
					break;
				}
			}
		}
	* 有効である
	*/
	private void ifBreak() {
		List<String> list = List.of("A", "B", "C");
		for(String s : list) {
			if(true) {
				if(s.equals("B")) {
					break;
				}
			}
			System.out.println(s);
		}
	}

}