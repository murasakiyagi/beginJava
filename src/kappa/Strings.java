package kappa;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;


/**
* String操作
* 正規表現
*/
public class Strings {

//	String splStr;
//	String[] splArr;
//
//	public Strings() {}
//
//	/**
//	* 何かする
//	*/
//	public void action() {
//		sample();
//		
//		splStr = trim( join(",", splArr) );
//			System.out.println(splStr.length() +" :"+ splStr + ";");
//		
//		biArr();
//		
//		String nakata = "nakata";
//			System.out.println(nakata.indexOf("naka"));
//			System.out.println(nakata.indexOf("kata"));
//		
////	一致するところ
////		commonPiece("nakata", "tanaka");
////		commonPiece("tanaka", "nakana");
////		commonPiece("tanaka", "sakaba");
////		commonPiece("KOBATO", "SIBARI");
//		commonPiece("BATOMO", "SIBARI");
//		boyerInspection();
//		stringParts("ABCDE", "BCD");
////		stringParts("SIBARI", "KOBATO");
//
////	正規表現
//
//
////	繰り返し文字(列)
//		repetChars();
//
//	}
//
//	/**
//	* わざわざ作った。配列を文字列化
//	* @param s 繋ぎの文字列
//	* @param arr 文字列化する配列
//	*/
//	private String join(String s, String[] arr) {
//		return String.join(s, arr);
//	}
//	
//	/**
//	* わざわざ作った。文字列の頭と尾にスペースがある場合取り除く
//	* @param str 対象の文字列
//	*/
//	private String trim(String str) {
//		return str.trim();
//	}
//
//	private void sample() {
//		splArr = new String[] {" a", "b", "c "};
////		splStr = String.join(" ", splArr);
//	}
//
//	private void biArr() {
//		String[] ss = {
//			"abc",
//			"def",
//			"ghi"
//		};
////		ssをsssにしたい
////		String[][] sss = {
////			{"a", "b", "c"},
////			{"d", "e", "f"},
////			{"g", "h", "i"}
////		};
//		sssPrint( phaseUp(ss) );
//	}
//
//	/**
//	* 配列の次元を上げる
//	* @param ss １次元配列
//	*/
//	private String[][] phaseUp(String[] ss) {
//		int li = ss.length;
//		int lj = ss[0].length();
//		String[][] sss = new String[li][lj];
//		for(int i=0; i < lj; i++) {
//			String[] splited = ss[i].split("");
//			sss[i] = splited;
//		}
//		return sss;
//	}
//
//	/**
//	* 配列の次元を下げる
//	* @param sss ２次元配列
//	*/
//	private String[] phaseDown(String[][] sss) {
//		String[] ss = new String[sss.length];
//
//		return ss;
//	}
//
//	private void sssPrint(String[][] sss) {
//		for(String[] ss : sss) {
//			System.out.println(Arrays.toString(ss));
//		}
//	}
//
//
//
////一致--------------
////	Boyer-Moore法。patの全部が一致するか
//	int bmMatch(String txt, String pat) {
//		int pt;//txtをなぞるカーソル
//		int pp;//patをなぞるカーソル
//		int txtlen = txt.length();//txtの文字数
//		int patlen = pat.length();//patの文字数
//		int[] skip = new int[Character.MAX_VALUE + 1];//スキップテーブル
//		//Character.MAX_VALUE == '\uFFFF' == 65535//char型で表現できる文字数
//		//スキップテーブルの作成
//		for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
//			skip[pt] = patlen;
//		}
//		//patの最後の文字(char)とその他の文字はpatlen。それ以外の文字のスキップ値はpatのインデックス
//		for(pt = 0; pt < patlen; pt++) {
//			skip[pat.charAt(pt)] = patlen - pt - 1;
//		}
//			System.out.println("TXTLEN:"+ txtlen +"  PATLEN:"+ patlen + "  PT：" + pt);
//		//この時点で　pt == patlenである
//		//探索
//		while(pt < txtlen) {
//			//patの末尾文字から比較していく。
//			//txtは
//			//ヒットしたらpatの着目文字と比較文字を前にずらしていく
//			//txt=abcdef, pat=cdeのとき、pt==2, pp==2, スキップ値 c=1, d=2, その他=3
//			//	１、txtのc と　patのe　を比較
//			//	２、不一致。pt += cのスキップ値(==1)とpatの移動分(patlen-pp==0)の大きい分を足す
//			//	３、pt==4, pp==2。e と e を比較
//			//	４、一致。内部ホイールで両方前にずらしていき全一致（pp==0）でリターン（ホイール脱出）する。
//			pp = patlen -1;//patの末尾文字に着目。（一応説明）-1は０スタートのインデックス対応
//			while(txt.charAt(pt) == pat.charAt(pp)) {
//				if(pp == 0) {
//					return pt;//探索成功
//				}
//				pp--;
//				pt--;
//			}
//				System.out.print("SKIP：" + skip[txt.charAt(pt)]);
//			pt += (skip[txt.charAt(pt)] > patlen - pp) ? skip[txt.charAt(pt)] : patlen - pp;
//				System.out.println("  PT：" + pt +"  PP：" + pp);
//
//		}
//		return -1;//探索失敗
//	}
//
//		private void boyerInspection() {
//			String s1 = "abcdef";
//			String s2 = "cde";
//			
//			int idx = bmMatch(s1, s2);//文字列s1から文字列s2をBM法で探索
//			
//			if(idx == -1) {
//				System.out.println("NOT MATCH");
//			} else {
//				//マッチ文字の直前までの”半角”での文字数を求める
//				int len = 0;
//				for(int i = 0; i < idx; i++) {
//					len += s1.substring(i, i + 1).getBytes().length;
//				}
//				len += s2.length();
//
//				System.out.println((idx + 1) + " MATCH");
//				System.out.println("テキスト：" + s1);
//				System.out.printf(String.format("パターン：%%%ds\n", len), s2);
//			}
//		}
//
//
////	共通する文字列。あれにこれがあるか
//	public void commonPiece(String are, String kore) {
//			System.out.println("commonPiece");
//		int max = 0;
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i=0; i < kore.length(); i++) {
//			String sub = kore.substring(i, kore.length());
//			if(are.indexOf(sub) != -1) {
//				max = Math.max(max, sub.length());
//				sb.append(sub + " ");
//				break;
//			}
//		}
//		//あれこれ逆
//		for(int i=0; i < are.length(); i++) {
//			String sub = are.substring(i, are.length());
//			if(kore.indexOf(sub) != -1) {
//				max = Math.max(max, sub.length());
//				sb.append(sub + " ");
//				break;
//			}
//			
//			if(max >= (are.length() - i)) {//処理回数減らし
//				break;
//			}
//		}
//		
//			System.out.println(max +" "+ sb.toString());
//			System.out.println("commonPiece END");
//	}
//
////5文字であらゆる連続の組み合わせ
////	ABCD	ABCDE	//元の文字列のlengthと同じが１個
////	ABC		ABCD	//len - 1 が２
////	BCD		BCDE
////	AB		ABC		//len - 2　が３
////	BC		BCD		//  3 = len - 2;
////	CD		CDE
////			AB		//len - 3 が４
////			BC		//	４ = len - 1
////			CD
////			DE
////			A		//１文字が５個
//
//	private void stringParts(String str, String hi) {//連続した部品
//		int len = str.length();
//		Set<String> set = new LinkedHashSet<String>();
//		for(int i = 0; i < len; i++) {
//			for(int j = 0; j <= i; j++) {
//					System.out.print("I" + i +" J"+j +" L" + (len-i+j));
//					System.out.println("  " + str.substring(j, len - i + j));
//				set.add(str.substring(j, len - i + j));
//			}
//		}
//
//		System.out.println("stringParts" + set.size() + set.toString());
//
//		int ans = 0;
////		NavigableSet<String> reset = kari.descendingSet();//逆にするTreeSetのみ
//
//		for(String s : set) {
//					System.out.println(s);
//			if(hi.indexOf(s) != -1) {
//				ans = s.length();
//					System.out.println(ans +" "+ s);
//				break;
//			}
//		}
//
//	}
//
//
//
//		/**
//		* 「あれ」に「これの部分」が含まれるなら、それを返す。
//		* これの頭から削っていく
//		*/
//		private String suber(String are, String kore) {
//			StringBuilder sb = new StringBuilder();
//			for(int i=0; i < kore.length(); i++) {
//				String sub = kore.substring(i, kore.length());
//				if(are.indexOf(sub) != -1) {
//					sb.append(sub);
//					break;
//				}
//			}
//			return sb.toString();
//		}
//
////----------------
//
////正規表現
//
//	private void regex() {
//		String str = "STR";
//		String pat = "\s(.)\1+";
//		System.out.println(str + pat);
//	}
//
//
//
////----------------
//
////繰り返し文字
//	private void repetChars() {
//		int limit = 2;//繰り返す回数
//		//static
//		String spc = "   ";//半角スペース３
//		String str = " ";
//		String prin = str.repeat(limit);//スペースも可能
//		System.out.println(prin);
//		
//			System.out.println(spc.length() + spc +";");
//	
//		//使わないだろう
//		prin = String.join("", Stream.generate( () -> "繰り返したい文字列").limit(limit).collect( Collectors.toList() ) );
//		System.out.println(prin);
//
//	}
//
//
////----------------
//
//	private void stringUtil(String[] strs) {
//		String s = """
//結構厄介なのが文字列の操作。
//scanner.nextLine()で受け取った文字列を分解して、処理してまた文字列を戻して返す。
//String[] strs = str.split(",");//指定の文字列(正規表現)で切って（切断文字を残す場合は"(,)"）配列にして返す。
//String str = String.join(",", strs);
//
//strs = {"###", 
//		"...", 
//		"###"};
//String[][] strss = strs.split("");
//strss = new String[] {
//	{"#","#","#"},
//	{".",".","."},
//	{"#","#","#"},
//}
//		""";
//		
//		String[][] strss = new String[3][3];
//		int len = strs.length;
//    	for(int i=0; i < len; i++) {
//			strss[i] = strs[i].split("");
//		}
//		
//    	for(int i=0; i < len; i++) {
//			strs[i] = String.join("", strss[i]);
//		}
//	}

}