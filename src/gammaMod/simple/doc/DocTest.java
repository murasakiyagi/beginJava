package simple.doc;

import java.io.*;
import java.util.*;
import java.lang.Exception;

/**
* 一行目。クラスおよびメンバーの説明文
* この行は直上行の続きになる
* @author 作者
* @version 1.01
* この行は直上行の続きになる
*/
//@Infomation(version = "1.1", description = "自作あの")
public class DocTest {

	/**
	* このクラスの名前
	* {@literal <Object>}
	*/
	private String name;
	
	/**
	* このドックが示す定数は「{@value}」です。
	*/
	final String VAL = "TEISU";

	/**
	* コンストラクタ
	* こんこん
	* ついでに「@value」のテスト「{@value #VAL}」
	*/
	public DocTest() {}
	/**
	* コンストラクタ２
	* @param name 名前を書かないと０点
	*/
	public DocTest(String name) {
		this.name = name;
	}

	/**
	* javadocについての説明を出力する
	* @param str 文字列
	* @return 文字列を返す
	*/
	public String action(String str) {
		String message = """
対象クラスディレクトリ
	root/src/gammaMod/simple/doc/DocTest.java

パッケージ(バイナリ名)
	simple.doc.DocTest;

コマンド
javadoc -d docs/simple src/gammaMod/simple/doc/DocTest.java

	ルート直下にdocs/testディレクトリ生成
	docs/simple/simple/doc/DocTest.html　開く
		""";
		
		String message2 = """
パッケージの違うメインクラスと一緒
コマンド
javadoc -d docs/simple src/gammaMod/simple/SimpleMain.java src/gammaMod/simple/doc/DocTest.java
		""";
		return str + "!";
	}

	/**
	* 何もしない。void型なら＠returnも書かない
	* エラーを吐くので「＠throws Exception 説明文」を書く
	* @throws Exception :エグゼぷしょん
	*/
	public static void men() throws Exception {
		
	}

}