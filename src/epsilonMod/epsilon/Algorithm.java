package epsilon;

import java.io.*;
import java.util.*;


public class Algorithm {
//・目次
//再起
//探索
//パターンチェック(文字列探索)
//ユークリッドの互除法


	public Algorithm() {}

	public void action() {
		System.out.println("ACTION");
		Scanner sc = new Scanner(System.in);
//		int x = sc.nextInt();
//		System.out.println(x + "の階乗は" + recurrent(x) + "です");
//		biSearch();

	}

		public void jikken() {
			System.out.println(4 % 0 == 0);
//			ArithmeticException: / by zero
		}

//再帰--------------
	public int recurrent(int num) {//再帰
		if(num > 0) {
			return num * recurrent(num - 1);
		} else {
			saikiComment();
			return 1;
		}
	}

		private void saikiComment() {
			System.out.println("""
　まず、「再帰＝階乗」ではないこと。
　これは簡単な再帰呼び出しのコードだが、プログラムにおける「再帰」はメソッドの中に同じメソッドがある状態と言える。
　注意。条件のない再起もあるが、それは無限ループ""");
		}


//探索---------------
	public void search() {
		
	}

	private void allAtackInspection() {
		
	}
	
	/**
	* 全探索(総当たり)のイメージ
	* int[] ins = { 1,2,3 };
	* 全ての組み合わせは
	* 	1,2,3それぞれの３組
	* 	3つ全てと、組み無しで２組
	* 	1,2 | 1,3 | 2,3 で３組
	* 合計　８組（パターン）
	* これは２進数で表される
	* 	4, 2, 1
	* insの並びをそのまま桁にして
	* 	011	-> 0, 2, 3を呼び出す
	* 000(0) から 111(7)までの８パターン
	* 
	* 重要なことは組み合わせのパターン回数という概念
	* 
	* 
	* @param list
	* @param limit
	*/
//組み合わせ問題にこのプログラムを使うのはやめよう
//代わりにDPダイナミック・プログラミングを使おう
	private void allAtack(List<Integer> list, int limit) {
		int n = list.size();
		int ans = 0;
        for (var i = 0; i < Math.pow(2, n); i++) {
            var sum = 0;//小カップの合計
            var tmp = i;//2進数で表されるはずのパターン回数の１０進数。
            
            //一つのパターンの内容を作る。数値や文字列ではなく、繰り返し回数によって桁を表現している。
            //最初のパターンに作られるのは000（--0）で、最後が111。という2進数のイメージ。
            //n=3の時、2^3==8(0~7)。
            //i=7の時、tmp%2==1==trueなのでsum+=w[j]が処理されるが、
            //	この時点で２進数は、1XX。　tmp/2==3 3%2==1 11X。　tmp/2==1 1%2==1 111
            //	i==7のパターンでは配列の全ての要素を採用する。ということ。
			//２進数掘り下げ。              ２進数表記   １０進数表記
			//  2 ^ 2 == 2 * 2              11          3(4通り)
			//  2 ^ 3 == 2 * 2 * 2          111         7(8通り)
			//なので、２で割れば
			//  (2 ^ 3 == 8) -> (8 / 2 == 4 == 2 ^ 2)
            for (var j = 0; j < n; j++) {
                if (tmp % 2 == 1) {//奇数の場合
                    sum += list.get(j);//小計
                }
                tmp /= 2;//2進数たらしめる式。int tmpなので1/2==0
            }

			//問題の解
            if (sum <= limit) {
                ans = Math.max(ans, sum);
            }
        }
       	System.out.println(ans);
	}

		private void allAtackImage() {
			
		}

		private void allAtack() {//総当たり
			//alistの中にblistの値があるか
			List<Integer> alist = new ArrayList<Integer>();
			List<Integer> blist = new ArrayList<Integer>();
			
			for(Integer b : blist) {
				if(alist.contains(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
			System.out.println("""
contains()は内部で総当たりするそうだ。処理量はalist.size() * blist.size()となる。リストのサイズが膨大なら処理量も膨大になる""");
		}


		private void biSearch() {
//			ArraysおよびCollections(Listの親のCollection<>ではない)のスタティックメソッドに
//			二分探索ができる「.binarySearch()」がある。シグネチャは色々あるので調べながら使う。
			var alist = sampleNums(5);
			var blist = sampleNums(5);
				System.out.println(alist.toString());
			alist.sort(Comparator.naturalOrder());
				System.out.println(alist.toString());
				System.out.println("b" + blist.toString());
			for(Integer b : blist) {
				int k = Collections.binarySearch(alist, b);
					System.out.println(b +" "+ k);
			}
		}

//		特定のメソッドを使わない
//		二分探索法の考え方が見える
		private int binarySearch(int[] arr, int n, int key) {
			int pl = 0;//探索範囲先頭のインデックス
			int pr = n - 1;//探索範囲末尾のインデックス

			do {
				int pc = (pl + pr) / 2;//中央要素のインデックス
				if(arr[pc] == key) {
					return pc;//探索成功
				} else if(arr[pc] < key) {
					pl = pc + 1;//探索範囲を後半に絞り込む
				} else {
					pr = pc - 1;//探索範囲を前半に絞り込む
				}
			} while(pl <= pr);

			return -1;//探索失敗
		}

			private List<Integer> sampleNums(int x) {
				List<Integer> list = new ArrayList<Integer>();
				
				while(list.size() < x) {
					int ran = (int)(Math.random()*10) + 1;
					if(!list.contains(ran)) {
						list.add(ran);
					}
				}
				return list;
			}


//-------------------

//ある配列に、対象のパターン（ptn）が幾つあるか？
//二次元配列では難しすぎるので１次元で試しにやる
	private int patternCheckOne(int[] ints, int[] ptn) {
		int len = ints.length;
		int plen = ptn.length;
		int sa = len - plen;

		int cnt = 0;
		int result = 0;
		if(sa > 0) {
			for(int i = 0; i < len; i++) {
				System.out.println(i +" "+ ints[i]);

				if(i <= sa | cnt > 0) {
					if(ptn[cnt] == ints[i]) {
						cnt++;
							System.out.println("cnt " + cnt);
						if(cnt == plen) {
							result++;
							cnt = 0;
						}
					} else {
						cnt = 0;
							System.out.println("cntf " + cnt);
					}
				} else {
					System.out.println("sa " + sa + " i " + i);
				}
			}
		}
		
		System.out.println("result " + result);
		return result;
	}

	private int patternCheck(int[][] intss, int[][] ptn) {
			System.out.println("\n patternCheck");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);

		int hptn = ptn.length;
		int wptn = ptn[0].length;
		int hsa = hlen - hptn;
		int wsa = wlen - wptn;
		
		int rnt = 0;
		int cnt = 0;
		int result = 0;
		if(hsa > 0 && wsa > 0) {
			for(int i = 0; i < hlen; i++) {
				for(int j = 0; j < wlen; j++) {
					if(i <= hsa && j <= wsa) {
						if(ptn[rnt][cnt] == intss[i][j]) {
							
						} else {
							rnt = 0;
							cnt = 0;
						}
					}
				}
			}
		}
		return result;
	}

	private void patternCheckOneInspection() {
		int[] ints = {0,1,2,3,4,1,2,3,4,5,6};//8
		int[] ptn = {1,2,3};
		patternCheckOne(ints, ptn);
	}

//-------------------

//ユークリッドの互除法
// 1. A , B のうち、いずれかが 0 の場合 手順 3 に進む
// 2. A , B のうち小さい方で大きい方をわり、大きい方をその余りで置き換え、手順 1 に戻る
// 3. このとき、0 でない方の数が求めたい最大公約数になっている。
	private int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		//演算子に注目。大小に関わらず余りは同じ
		return gcd(b, a % b);
	}




}

