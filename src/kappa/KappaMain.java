package kappa;

import java.io.*;
import java.util.*;

/**
* String操作
* 正規表現
*/
public class KappaMain {

	public static void main(String[] args) {
		System.out.println("KAPPA MAIN");
		
//		Regex rgx = new Regex();
//		rgx.action();

		try {
			ProcessBuild pb = new ProcessBuild();
			pb.build();
			
		} catch(Exception e) {
			
		}
	}

}