package theta;

import java.io.*;
import java.util.*;


public class Maths {

	public Maths() {}

	public void action() {
		marume();
	}


	/**
	* 少数の丸め
	*/
	private void marume() {
		double d = 3.14;
		float fl = 1.55f;
		
		//四捨五入
		long lg = Math.round(d);
		int it = Math.round(fl);
			System.out.println("ROUND " + lg +" "+ it);

		//切り上げ
		double ceiled = Math.ceil(d);
			System.out.println("CEIL " + ceiled);
		
		//切り捨て
		double floored = Math.floor(d);
			System.out.println("FLOOR " + floored);
	}


}