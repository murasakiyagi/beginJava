package gamma.javadoc;

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
public class JavadocTest {

	/**
	* このクラスの名前
	*/
	private String name;


	/**
	* コンストラクタ
	* こんこん
	*/
	public JavadocTest() {}
	public JavadocTest(String name) {
		this.name = name;
	}

	/**
	* javadocについての説明を出力する
	* @param str 文字列
	* @return 文字列
	*/
	public String action(String str) {
		String message = """
対象クラスディレクトリ
	root/src/gammaMod/gamma/javadoc/JavadocTest.java

パッケージ(バイナリ名)
	gamma.javadoc.JavadocTest;

コマンド
javadoc -d docs/test src/gammaMod/gamma/javadoc/JavadocTest.java

FX付きコマンド
javadoc -p $FX -encoding UTF-8 -d docs/test src/gammaMod/module-info.java src/gammaMod/gamma/GammaMain.java
	「-p $FX」は必須
	「-encoding UTF-8」は必須かわからん


	ルート直下にdocs/testディレクトリ生成
	docs/test/gamma/javadoc/JavadocTest.html　開く
		""";
		System.out.println(message);
		return str + "!";
	}

	/**
	* 何もしない。void型なら＠returnも書かない
	* @throws Exception :エグゼぷしょん
	*/
	public static void men() throws Exception {
		
	}

}