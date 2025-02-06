package simple;

import java.io.*;
import java.util.*;

import simple.doc.DocTest;

/**
* Javaコマンドのテストパッケージ
* @author 名無し
* @version 1.01
*/
public class SimpleMain {

	/**
	* パッケージのメインメソッド
	* @param args 入力
	*/
	public static void main(String[] args) {
		
		DocTest jd = new DocTest();
		jd.action("world");
		
	}


}