package epsilon;

import java.io.*;
import java.util.*;
import java.awt.Point;

/**
* 配列の長さを変更するlengthExpansion()
* 滲み
* レイクフィッシュ
* ブロック消し
* 
* ------
* 二次元配列における縦と横の記号の定義
* 
* 対になる記号(言葉) [h, w] [y, x] [i, j] [row, column]
* 
* 	本来(一般的に)
* 	上下に数値が変化する { h, y, i, row }
* 	左右　　　　　　　　 { w, x, j, col }
* 
* 	しかしながら、Point(x, y)の並びと配列の[i][j]の並びが逆になるので、
* 	[i][j]の並びを優先して、[i][j]と(x,y)の関連が生まれる時には、[i,x][j,y]の組み合わせを採用する。
* 	メソッドnine()にprintArr()を常設した。この結果を見ると、
* 	右に行くほどyが増え、下に行くほどxが増えるという数学グラフ的におかしなことになっているが、
* 	[i][j]の関係から見るとよく見る形になっている。
* 
* h:高さheight　w:幅width
* 数学のグラフより、x:横軸 y:縦軸
* row:行（横行） column:列（縦列）
* 二重for文において
* 	int cnt = 1;
* 	int[][] ints = new int[2][3];
* 	for(int i=0; i < 2; i++) {
* 		for(int j=0; j < 3; j++) {
* 			int[i][j] = cnt++;
* 		}
* 	}
* i==0:[1,2,3]
* i==1:[4,5,6]
* 
* 	for(int j=0; j < 3; j++) {
* 		for(int i=0; i < 2; i++) {
* 			int[i][j] = cnt++;
* 		}
* 	}
* i==0:[1,3,5]
* i==1:[2,4,6]
* 
* ------
* 
*/

public class BinaryArray {

	int h, w;//範囲マスの数。１から始まる。最低h=1,w=1;
	int[][] iss;

	BiArrNum ban;

	public BinaryArray() {}
	public BinaryArray(BiArrNum ban) {
		this.ban = ban;
		this.iss = ban.getIntss();
	}
	

	public void action(FieldMonitorStage fms) {
		System.out.println("BINARY ARRAY");
		

//		lengthExpansionInspection();
//		nijimiInspection();
//		lakeFishInspection();
//		brockKesiInspection();
//		rotationInspection();
		nanameInspection();
		
		fms.renewal(iss);

	}

	public void printArr(String s, Object[][] objss) {
		String fmt = "  %1$s------";
		System.out.println(String.format(fmt, s));
		for(Object[] objs : objss) {
			System.out.println(Arrays.toString(objs));
		}
		System.out.println("  ------");
	}
	
	public void listPrint(String s, List<List<String>> lilis) {
		int h = lilis.size();
		int w = lilis.get(0).size();
        for(int i=0; i < h; i++) {
            for(int j=0; j < w; j++) {
                if(j == w-1) {
                    System.out.print(lilis.get(i).get(j));
                } else {
                    System.out.print(lilis.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }
	}

	private void printFor(String s, Object[] objs) {
			System.out.println(s);
		for(Object obj : objs) {
			System.out.println(obj);
		}
	}



	/**
	* 配列の長さを調整する方法を示す
	* 二次元配列そのままをディープコピーする方法はない。１行ごとくり返す
	*/
	private int[] lengthExpansion(int[] ints, int i) {
		int[] reArr;
		if(i == 1) {
			
//			reArr = Arrays.copyOf(ints, 6);//長くする
			reArr = Arrays.copyOf(ints, 2);//短くする
		
		} else if(i == 2) {
			
//引数１の配列の、引数２から引数５のインデックス要素を、引数３の配列の引数４の位置から置く
//			reArr = new int[6];
//			System.arraycopy(ints, 1, reArr, 1, ints.length-1);
			reArr = new int[2];
			System.arraycopy(ints, 2, reArr, 0, 2);//[3, 4]


		} else if(i == 3) {
			//返されるlistは変更不可(add()とかが使えない)である
			List<Integer> list = Arrays.stream(ints)
										.boxed()
										.toList();
//				System.out.println(list.toString());
			List<Integer> subl = new ArrayList<Integer>(list);//ここに格納してしまえば変更可能。
//			subl.addAll(list);
			subl.addAll(List.of(6,7));
				System.out.println("SUBL " + subl.toString());
				
//			ここまではint[]をList<Integer>に変換
//			ここからList<Integer>をint[]に変換、、、できるか？
			Integer[] tegs = list.toArray(new Integer[0]);
				System.out.println("TEGS " + Arrays.toString(tegs));

			List<Integer> tegList = Arrays.asList(tegs);
				System.out.println("TEGARR " + tegList.toString());
				System.out.println("TEGARR " + (tegList instanceof List<Integer>));

//			Stream.mapToInt(ToIntFunction)、ラムダ式・メソッド参照
			int[] strm = subl.stream()
//							.mapToInt(itg -> itg.intValue())
							.mapToInt(Integer::intValue)
							.toArray();
				System.out.println("STRM " + Arrays.toString(strm));

			reArr = strm;
		} else {
			reArr = ints;
		}
		
		return reArr;
	}

	private void lengthExpansionInspection() {
		int[] arr = {1,2,3,4};
			System.out.println(Arrays.toString(lengthExpansion(arr, 3)));
	}


	private void rotationInspection() {
		int r = 2;
		int c = 2;
		int h = 3;
		int w = 4;
		boolean b = true;
		
		int[][] picss = {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 }
		};

		printArr("rotationInspection", intTeger(picss));
        picss = rotation(picss, b);
		printArr("rotationInspection", intTeger(picss));


	}

		private Integer[][] intTeger(int[][] intss) {
			int h = intss.length;
			int w = intss[0].length;
			Integer[][] kari = new Integer[h][w];
	        for(int i=0; i < h; i++) {
	            for(int j=0; j < w; j++) {
					kari[i][j] = intss[i][j];
	            }
	        }
	        return kari;
		}

	/**
	* ２次元配列を90度毎に回転させる。
	*/
	private int[][] rotation(int[][] intss, boolean b) {
		int h = intss.length;
		int w = intss[0].length;
		int[][] rotss = new int[w][h];//h,w逆になる
		
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
            	if(b) {//右回転
                	rotss[j][h - 1 - i] = intss[i][j];
            	} else {//左回転
                    rotss[w - 1 - j][i] = intss[i][j];
            	}
            }
        }
        return rotss;
	}




	    private void nine(int r, int c, int[][] intss, int end, int[][] picss) {
	        int h = intss.length;
	        int w = intss[0].length;
	        
	        for(int i= -end; i <= end; i++) {
	            for(int j= -end; j <= end; j++) {
	                if(ban.inArea(r+i, c+j, h, w)) {
	                    picss[i + end][j + end] = intss[r+i][c+j];
	                }
	            }
	        }
	    }


//斜め
	private void nanameInspection() {
		int[][] picss = {
			{  1,  2,  3,  4 },
			{  5,  6,  7,  8 },
			{  9, 10, 11, 12 },
			{ 13, 14, 15, 16 },
			{ 17, 18, 19, 20 },
			{ 17, 18, 19, 20 }
		};

//		nanameMigiUe(picss);
		nanameHidariUe(picss);
	}

	/**
	* ２次元配列の斜めの列を取得
	* 右上から左下
	* 
	*/
	private void nanameMigiUe(int[][] intss) {
		int h = intss.length;
		int w = intss[0].length;
//			System.out.println("HW " + h +","+ w);
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				list.clear();
				if(i == 0 || j == w - 1) {
					for(int k = 0; k <= Math.min(j, h - 1 - i); k++) {
						list.add(intss[i + k][j - k]);
					}
					System.out.println(list);
				}
//for(k)のループ条件
//	wが小さければ左境界に当たるのでjに依存する
//	wが大きければ下端境界に当たるのでh - 1 - iに依存する
			}
		}
	}
	
		/**
		* 左上から右下
		*/
		private void nanameHidariUe(int[][] intss) {
			int h = intss.length;
			int w = intss[0].length;
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					list.clear();
					if(i == 0 || j == 0) {
						for(int k = 0; k <= Math.min(h - 1 - i, w - 1 - j); k++) {
							list.add(intss[i + k][j + k]);
						}
						System.out.println(list);
					}
				}
			}
		}


//にじみ

	private void nijimiInspection() {
		int[] ins = {0,3,0,0,0,3,0};//7
//		int[] ins = {0,0,3,0,0};//5
//		nijimi(ins);

		String[][] sss = {
			{".", ".", "#", "."},
			{".", "#", "#", "."},
			{"#", "#", "#", "."},
			{".", "#", ".", "."}
		};//4,4
		nijimi2(sss);
	}

//０と2で構成される配列がある。2の隣が０なら2に変換する。
//そして変換した後、今度は０の隣を０に変換する
	public void nijimi(int[] ins) {
		int[] oped = Arrays.copyOf(ins, ins.length);
			ins[0] = 3;
			System.out.println("OPED" + Arrays.toString(oped));
			
//		手順
//		change D	{2,3,2,0,2,3,2}				{2,3,2,0,2,3,2}
//		reChange	{3,3,3,0,3,3,3}			 	{2,3,2,0,2,3,2}
//		change E	{3,3,1,0,1,3,3}				{2,3,1,0,1,3,2}
//		rechange	{3,3,0,0,0,3,3}				{3,3,0,0,0,3,3}
//要素数n==7。これの左右、2n。さらに全探索で０か３に揃える、2n^2。
//operationの回数mは、m * 2n^2で、オーダー=n^2になるので気にしない。
//つまり、reChangeをせずに一度の全探索で処理ができれば累乗はなくなる

		operation(ins, 'D', oped);
		ins = Arrays.copyOf(oped, oped.length);//リチェンジ
		
			System.out.println("INS" + Arrays.toString(ins));
		
		operation(ins, 'E', oped);
		ins = Arrays.copyOf(oped, oped.length);

			System.out.println("INS" + Arrays.toString(ins));
	}

	private void operation(int[] ins, char ope, int[] oped) {
		for(int i=0; i < ins.length; i++) {
			//全探索。確定
			if(ope == 'D') {
				if(ins[i] == 3) {
					two(i, oped, ins.length, 3);
				}
			} else {//'E'
				if(ins[i] == 0) {
					two(i, oped, ins.length, 0);
				}
			}
		}//for.end
		
		System.out.println("OPED" + Arrays.toString(oped));
	}

	private int[] two(int x, int[] oped, int l, int v) {
		for(int i=-1; i <= 1; i+=2) {
			if(inArea2(x + i, l)) {
				oped[x+i] = v;
			}
		}
		return oped;
	}

	private boolean inArea2(int x, int l) {
        boolean boo = true;
        if(x < 0 || x >= l) { boo = false; }
        return boo;
	}


//２次元の場合
	public void nijimi2(String[][] sss) {
		int h = sss.length;
		int w = sss[0].length;

		String[][] oped = new String[h][w];
		
		for(int i=0; i < sss.length; i++) {
			oped[i] = Arrays.copyOf(sss[i], sss[i].length);
		}

		operation2(sss, 'D', oped, h, w);
//		sss = reChange(sss, oped);

		operation2(sss, 'E', oped, h, w);
//		sss = reChange(sss, oped);
	}

	private void operation2(String[][] sss, char ope, String[][] oped, int h, int w) {
		String tkn = (ope == 'D') ? "#" : ".";
			System.out.println("TKN " + tkn);
			
		for(int i=0; i < sss.length; i++) {
			for(int j=0; j < sss[i].length; j++) {
				//全探索。確定
				if(sss[i][j].equals(tkn)) {
					four(i, j, oped, h, w, tkn);
				}
			}
		}//for.end
		
//		System.out.println("OPED" + Arrays.toString(oped));
		reChange(sss, oped);
	}
		
		private String[][] reChange(String[][] sss, String[][] oped) {
			for(int i=0; i < sss.length; i++) {
				sss[i] = Arrays.copyOf(oped[i], oped[i].length);
					System.out.println("RE " + Arrays.toString(sss[i]));
			}
			return sss;
		}

	private String[][] four(int r, int c, String[][] oped, int h, int w, String v) {
		for(int i=-1; i <= 1; i+=2) {
			if(ban.inArea(r + i, c, h, w)) {
				oped[r+i][c] = v;
			}
			if(ban.inArea(r, c + i, h, w)) {
				oped[r][c+i] = v;
			}
		}
		return oped;
	}



//Stringの場合のみ、String[][] -> String[]のままやる
	public void nijimi3() {
		int h = 4;
		int w = 4;
		String[] ss = {
			"..#.",
			".##.",
			"###.",
			".#.."
		};//4,4
		StringBuilder[] sb = new StringBuilder[h];
		for(int i=0; i < ss.length; i++) {
			sb[i] = new StringBuilder(ss[i]);
		}
		StringBuilder[] oped = Arrays.copyOf(sb, sb.length);
			printFor("BUILDER", oped);
			
		operation3(ss, 'D', oped, h, w);
		reBuild(ss, oped);
		operation3(ss, 'E', oped, h, w);
		reBuild(ss, oped);
			printFor("SS", ss);
	}

	private void operation3(String[] ss, char c, StringBuilder[] oped, int h, int w) {
		String tkn = (c == 'D') ? "#" : ".";
		for(int i=0; i < ss.length; i++) {
			for(int j=0; j < ss[i].length(); j++) {
				if(ss[i].substring(j,j+1).equals(tkn)) {
					fourC(i, j, oped, h, w, tkn);
				}
			}
		}//for.end
	}


	private StringBuilder[] fourC(int r, int c, StringBuilder[] oped, int h, int w, String v) {
		for(int i=-1; i <= 1; i+=2) {
			if(ban.inArea(r + i, c, h, w)) {
				oped[r+i].replace(c, c+1, v);
			}
			if(ban.inArea(r, c + i, h, w)) {
				oped[r].replace(c+i, c+i+1, v);
			}
		}
		return oped;
	}
	
		private void reBuild(String[] ss, StringBuilder[] oped) {
			for(int i=0; i < ss.length; i++) {
				ss[i] = oped[i].toString();
			}
		}


//-------------------
//レイクフィッシュ
	private void lakeFishInspection() {
		int[][] intss = {
			{1,2,3,20},
			{4,5,6,10},
			{7,8,9,10}
		};
		String[][] strss = {
			{".", "#"},
			{"#", "."}
		};
		System.out.println("LAKE FISH  " + lakeFish(intss, strss));
	}


	/**
	* 大きな配列の中の、一部を切り取りる。
	* amiメソッドによって取得した合計値の一番大きな値を選別
	* @param intss 大きな２次元配列
	* @param strss 小さな２次元配列
	*/
	public int lakeFish(int[][] intss, String[][] strss) {
		int h = intss.length;
		int w = intss[0].length;
		int r = strss.length;
		int c = strss[0].length;
		
		int hr = h - r + 1;
		int wc = w - c + 1;
		int max = 0;
        for(int i=0; i < hr; i++) {
            for(int j=0; j < wc; j++) {
				max = Math.max(max, ami(i, j, intss, strss));
            }
        }
        return max;
	}

		/**
		* 大きなBiArrから、小さなBiArrのtrueになる部分の合計を返す
		* 	intss=	[1,2,3]		strss=	[., #](レテラル省略)
		* 			[4,5,6]				[#, .]
		* 			[7,8,9]
		* 	i=1, j=1での時、"#"をtrueとすれば、６と８の合計を返す
		*
		* @param i intssの縦
		* @param j intssの横
		* @param intss 大きな２次元配列
		* @param strss 小さな２次元配列
		* @return strssの値によってtrueになる、intssの合計
		*/
	    private int ami(int i, int j, int[][] intss, String[][] strss) {
	        int fish = 0;
	        for(int k=0; k < strss.length; k++) {
	            for(int l=0; l < strss[0].length; l++) {
	                if(strss[k][l].equals("#")) {
	                    fish += intss[i + k][j + l];
	                }
	            }
	        }
	        
	        return fish;
	    }



//ブロック消し
	private void brockKesiInspection() {
		int h = 4;
		int w = 5;

        String[][] strss = {
        	{"b", "g", "y", "r", "r"},
        	{"b", "y", "b", "y", "r"},
        	{"b", "r", "r", "r", "r"},
        	{"b", "r", "b", "y", "g"}
        };
        String[][] dltss = new String[h][w];
        String[][] falss = new String[w][h];

        for(int i=0; i < h; i++) {
            for(int j=0; j < w; j++) {
                brockFour(i, j, strss, dltss, falss);
            }
        }

		printArr("STR",strss);
		printArr("DLT",dltss);

		fall(falss, h, w);
		
	}

    private void fall(String[][] falss, int h, int w) {
        List<List<String>> lilis = new ArrayList<List<String>>();
        for(int i=0; i < w; i++) {
            int cnt = 0;
            List<String> list = new ArrayList<String>(Arrays.asList(falss[i]));
            lilis.add(list);
            for(int j=0; j < h; j++) {
                int last = list.lastIndexOf("#");
                
                if(last > j) {
                    String s = "#";
                    list.remove(last);
                    list.add(cnt++, s);
                }
            }
        }


		listPrint("", lilis);
//        for(int i=0; i < h; i++) {
//            for(int j=0; j < w; j++) {
//                if(j == w-1) {
//                    System.out.print(lilis.get(j).get(i));
//                } else {
//                    System.out.print(lilis.get(j).get(i) + " ");
//                }
//            }
//            System.out.println();
//        }
        
    }


	/**
	* あるポイントの上下左右についてそれぞれイコールなら、dltssの同じポイントを"#"にする。
	* 
	* 
	* 
	*/
	public void brockFour(int r, int c, String[][] strss, String[][] dltss, String[][] falss) {
		int hlen = strss.length;
		int wlen = strss[0].length;
        String s = strss[r][c];
        
        for(int i=-1; i <= 1; i++) {
            if(ban.inArea(r + i, c, hlen, wlen) && i != 0) {
                if(s.equals(strss[r+i][c])) {
                    dltss[r+i][c] = "#";
                    dltss[r][c] = "#";
                    falss[c][r] = "#";
                } else if(dltss[r][c] == null || !dltss[r][c].equals("#")) {
                    dltss[r][c] = s;
                    falss[c][r] = s;
                }
            }
            if(ban.inArea(r, c + i, hlen, wlen) && i != 0) {
                if(s.equals(strss[r][c+i])) {
                    dltss[r][c+i] = "#";
                    dltss[r][c] = "#";
                    falss[c][r] = "#";
                } else if(dltss[r][c] == null || !dltss[r][c].equals("#")) {
                    dltss[r][c] = s;
                    falss[c][r] = s;
                }
            }
        }
	}


}//class.end