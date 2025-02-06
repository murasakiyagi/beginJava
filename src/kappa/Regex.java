package kappa;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;



/**
* 用語
	キャプチャ：
	前方参照：
	広報参照：
* 
* 
* 
*/
public class Regex {

	Pattern ptn;
	Matcher mch;

	public void action() {
		int brk = 10;
		while(brk-- >= 0) {
			Scanner sc = new Scanner(System.in);
				print("正規表現文字列を入力");
			String regex = sc.nextLine();
				print("対象文字列を入力");
			String input = sc.nextLine();
				print();
			build(regex, input);
//			build("a*b", "aaaab");
			matchResult(mch);
		}
//		kihon();

	}


//基本ーーーーー
	/**
	* javaの正規表現はStringオブジェクトとして”渡される”
	*/
	public void kihon() {
		//boolean string.maches(String regex) : 正規表現がマッチするか
		String str = "regex";
		print(str);
		print(".*", str.matches(".*"));
		print("/regex/", str.matches("/regex/"));
		print("/Regex/i", str.matches("/Regex/i"));
		
	}

	public boolean matches(String regex, String str) {
		boolean bool1 = str.matches(regex);
		//同義
		boolean bool2 = Pattern.matches(regex, str);
		print(bool1 == bool2);
		return bool1;
	}

	public void build(String regex, String input) {
		ptn = pattern(regex);
		mch = matcher(ptn, input);
		print(mch.matches(), mch.toString());
	}
	
	private void matchResult(MatchResult result) {
		try {
			print(
				"MATCH RESULT",
				"\n START  ", result.start(),
				"\n END  ", result.end(),
				"\n GROUP  ", result.group()
			);
		} catch(IllegalStateException ise) {
			print("NO MATCH  ", result);
		}
	}
	
	/**
	* コンパイル済みの正規表現
	* ただの文字列を正規表現としての意味合いを持たせる?
	* Pattern p = Pattern.compile("a*b");
	* Matcher m = p.matcher("aaaab");
	* boolean b = m.matches();
	*/
	public Pattern pattern(String regex) {
		return Pattern.compile(regex);
	}

	/**
	* マッチの意味は、「合同である」ではなく「比較する」である。
	* Matcherは比較エンジンである。
	* 
	* 
	*/
	public Matcher matcher(Pattern pattern, String input) {
		return pattern.matcher(input);
	}


//基本。終わりーーーーー

//応用
	/**
	* 探す文字列が、対象文字列内に存在、散在しているか
	* 	例えば、"abcd"がそのまま、あるいは分割
			"a" + "bcd"
			"ab" + "cd"
			"abc" + "d"という状態で適当な文字列内にあるか
	* 
	*/
	public void splitMatch(String regex, String input) {
		//例："abcd"がtextに散在するか
//		String regex = "abcd";
		String text = "xabxcdx";
		int len = regex.length();
		String[] rgxs = new String[len];
		rgxs[0] = ".*" + regex + ".*";
		for(int i = 1; i < len; i++) {
			String be = regex.substring(0, i);
			String af = regex.substring(i, len);
			rgxs[i] = ".*" + be + ".*" + af + ".*";
				//beとafに挟まれる文字数を制限するなら
				rgxs[i] = ".*" + be + ".." + af + ".*";
				rgxs[i] = ".*" + be + ".{n}" + af + ".*";
			
			//２分割ではなく全ての文字が散在にする場合
			String spl[] = regex.split("");
			StringBuilder sb = new StringBuilder(".*");
			for(String s : spl) {
				sb.append(s + ".*");
			}
			rgxs[i] = sb.toString();
		}
	}

	public void print(Object... objs) {
		for(Object obj : objs) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}

}