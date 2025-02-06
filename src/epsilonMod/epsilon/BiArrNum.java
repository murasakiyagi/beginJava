package epsilon;

import java.io.*;
import java.util.*;
import java.awt.Point;

/*
ある２次元座標(R,C)の上下左右斜めをターゲットにする、
	four()(４マス)からnine()および、未制作のone()two()

配列の長さを変更するlengthExpansion()
滲み
レイクフィッシュ
*/

public class BiArrNum {

	int h, w;//範囲マスの数。１から始まる。最低h=1,w=1;
	int[][] iss;

	public BiArrNum() {}
	public BiArrNum(int[][] iss) {
		this.iss = iss;
	}
	
	public void action(FieldMonitorStage fms) {
		System.out.println("BINARY ARRAY NUMBERS");
		
		numsInspection(0,0,this.iss,fms);

	}

		private void printFor(String s, Object[] objs) {
				System.out.println(s);
			for(Object obj : objs) {
				System.out.println(obj);
			}
		}

	public int[][] getIntss() {
		return iss;
	}

//ナンバーズ
//タイプはなんでもいい
	private void numsInspection(int r, int c, int[][] intss, FieldMonitorStage fms) {
//		nine(0, 0, intss, 1);
//		nine(4, 3, intss, 2);
//		eight(r, c, intss, 1);
//		eight(4, 3, intss, 2);
		eightDonut(4, 4, intss, 3, 3);
//		five(r, c, intss, 1);
//		five(4, 3, intss, 2);
//		four(r, c, intss, 1);
//		four(4, 3, intss, 2);
//		anFive(r, c, intss, 1);
//		anFive(4, 4, intss, 3);
//		anFour(r, c, intss, 1);
//		anFour(4, 4, intss, 3);
//		turnFive(4, 3, intss, 2);
//		radialFour(4, 4, intss, 3);
//		radialFive(3, 3, intss, 3);
//		two(3, 2, intss, 2, 1, -1);
//		one(2, 2, intss, 2, -9, 0);
//		ratio(0, 0, intss, 8, 3);
//		even(0, 0, intss, 4);
//		evenDonut(0, 0, intss, 8, 5);
		fms.renewal(intss);
	}

	/**
	* one ~ nineとその変形がある。２次元配列の部分の値を変更する。
	* ここでまとめてdocのparamを示すので、各ナンバーズメソッドはここを参照。
	* @param r ２次元配列の１次元目。縦の中心座標
	* @param c ２次元配列の２次元目。横の中心座標
	* @param intss 操作対象の２次元配列。int[][]だが値の変更でしか関係がないので別の型でもいい
	* @param end 中心座標からの距離
	* @param rsig 非対称の場合シグナムを要求される。プラスかマイナスか０
	* @param csig 非対称の場合シグナムを要求される。プラスかマイナスか０
	*/
    public void numbers(int r, int c, int[][] intss, int end, int rsig, int csig) {}


    public void one(int r, int c, int[][] intss, int end, int rsig, int csig) {
			System.out.println("\n ONE");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);

		rsig = (int)Math.signum(rsig);
		csig = (int)Math.signum(csig);

		for(int i = 0; i <= end; i++) {
			int rg = i * rsig;
			int cg = i * csig;
			if(inArea(r + rg, c + cg, hlen, wlen)) {
				System.out.println((r+rg) +" "+ (c+cg) +" "+ intss[r+rg][c+cg]);
				intss[r+rg][c+cg] = valChange(intss[r+rg][c+cg]);
			}
		}
	}

	/**
	* 比例。y = ax ：xが１増えるとyはax増える
	* 起点が０(i=0)。endは含まない(i<end)
	* @param fix 比例定数
	*/
	public void ratio(int r, int c, int[][] intss, int end, int fix) {
			System.out.println("\n RATIO");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
		
        for(int i = 0; i < end; i++) {
        	//挙動の若干違う方法も残しておく
//			if(inArea(r+(i+fix)/fix, c + i, hlen, wlen)) {
//				intss[r+(i+fix)/fix][c+i] = valChange(intss[r+(i+fix)/fix][c+i]);
//			}

			//通常のx = ayの形
//			if(inArea(r+i/fix, c + i, hlen, wlen)) {
//				intss[r+i/fix][c+i] = valChange(intss[r+i/fix][c+i]);
//			}
			//通常のy = axの形
			if(inArea(r + i, c+i/fix, hlen, wlen)) {
				intss[r+i][c+i/fix] = valChange(intss[r+i][c+i/fix]);
			}
		}
	}


	/**
	* 直角。方向の概念あり「0:左上、1:上右、2:右下、3:下左」
	*/
    public void two(int r, int c, int[][] intss, int end, int rsig, int csig) {
			System.out.println("\n FOUR");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
		
		rsig = (int)Math.signum(rsig);
		csig = (int)Math.signum(csig);
		
        for(int i = 0; i <= end; i++) {
        	int g = i * rsig;
			if(inArea(r + g, c, hlen, wlen) && i != 0) {
				System.out.println((r+g) +" "+ c +" "+ intss[r+g][c]);
				intss[r+g][c] = valChange(intss[r+g][c]);
			}
			g = i * csig;
			if(inArea(r, c + g, hlen, wlen)) {
				System.out.println(r +" "+ (c+g) +" "+ intss[r][c+g]);
				intss[r][c+g] = valChange(intss[r][c+g]);
			}
		}
	}

	/**
	* 鋭角。（鈍角はobtuse）
	*/
    public void acuteTwo(int r, int c, int[][] intss, int end, int rsig, int csig) {
			System.out.println("\n FOUR");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
		
		rsig = (int)Math.signum(rsig);
		csig = (int)Math.signum(csig);
		
        for(int i = 0; i <= end; i++) {
        	int g = i * rsig;
			if(inArea(r + g, c, hlen, wlen) && i != 0) {
				System.out.println((r+g) +" "+ c +" "+ intss[r+g][c]);
				intss[r+g][c] = valChange(intss[r+g][c]);
			}
			g = i * csig;
			if(inArea(r, c + g, hlen, wlen)) {
				System.out.println(r +" "+ (c+g) +" "+ intss[r][c+g]);
				intss[r][c+g] = valChange(intss[r][c+g]);
			}
		}
	}



	/**
	* 三方
	*/
    public void tree(int r, int c, int[][] intss, int end, int rsig, int csig) {
			System.out.println("\n FOUR");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
		
		rsig = (int)Math.signum(rsig);
		csig = (int)Math.signum(csig);
		
        for(int i = 0; i <= end; i++) {
        	int g = i * rsig;
			if(inArea(r + g, c, hlen, wlen) && i != 0) {
				System.out.println((r+g) +" "+ c +" "+ intss[r+g][c]);
				intss[r+g][c] = valChange(intss[r+g][c]);
			}
			g = i * csig;
			if(inArea(r, c + g, hlen, wlen)) {
				System.out.println(r +" "+ (c+g) +" "+ intss[r][c+g]);
				intss[r][c+g] = valChange(intss[r][c+g]);
			}
		}
	}


    public void four(int r, int c, int[][] intss, int end) {
			System.out.println("\n FOUR");
//		このクラスでhlen,wlenは共通で使うが、このクラスの用途として、書き方を示す書物的な位置付けにあるのでメソッド化しない。
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);

//fiveとの差分。両方に「i != 0」がある。
        for(int i = -end; i <= end; i++) {
			if(inArea(r + i, c, hlen, wlen) && i != 0) {
				System.out.println((r+i) +" "+ c +" "+ intss[r+i][c]);
				intss[r+i][c] = valChange(intss[r+i][c]);
			}
			if(inArea(r, c + i, hlen, wlen) && i != 0) {
				System.out.println(r +" "+ (c+i) +" "+ intss[r][c+i]);
				intss[r][c+i] = valChange(intss[r][c+i]);
			}
		}
	}


    public void five(int r, int c, int[][] intss, int end) {
			System.out.println("\n FIVE");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);

//nineとの差分。１重for文である。その代わり、縦横別の条件処理およびそのどちらかに「&& i!=0」を追記し、
//[r+0][c+0]がダブらないように施してある
        for(int i = -end; i <= end; i++) {
			if(inArea(r + i, c, hlen, wlen) && i != 0) {
				System.out.println((r+i) +" "+ c +" "+ intss[r+i][c]);
				intss[r+i][c] = valChange(intss[r+i][c]);
			}
			if(inArea(r, c + i, hlen, wlen)) {
				System.out.println(r +" "+ (c+i) +" "+ intss[r][c+i]);
				intss[r][c+i] = valChange(intss[r][c+i]);
			}
		}
	}


    public void anFour(int r, int c, int[][] intss, int end) {
			System.out.println("\n ANGLE FOUR");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);

//anfive()との差分。片方は「r+i, c+i」もう一方は「r-i, c+i」
        for(int i = -end; i <= end; i++) {
			if(inArea(r + i, c + i, hlen, wlen) && i != 0) {
				System.out.println((r+i) +" "+ (c+i) +" "+ intss[r+i][c+i]);
				intss[r+i][c+i] = valChange(intss[r+i][c+i]);
			}
			if(inArea(r - i, c + i, hlen, wlen) && i != 0) {
				System.out.println((r-i) +" "+ (c+i) +" "+ intss[r-i][c+i]);
				intss[r-i][c+i] = valChange(intss[r-i][c+i]);
			}
		}
	}

    public void anFive(int r, int c, int[][] intss, int end) {
			System.out.println("\n ANGLE FIVE");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);

//five()との差分。片方は「r+i, c+i」もう一方は「r-i, c+i」
        for(int i = -end; i <= end; i++) {
			if(inArea(r + i, c + i, hlen, wlen) && i != 0) {
				System.out.println((r+i) +" "+ (c+i) +" "+ intss[r+i][c+i]);
				intss[r+i][c+i] = valChange(intss[r+i][c+i]);
			}
			if(inArea(r - i, c + i, hlen, wlen)) {
				System.out.println((r-i) +" "+ (c+i) +" "+ intss[r-i][c+i]);
				intss[r-i][c+i] = valChange(intss[r-i][c+i]);
			}
		}
	}

	/**
	* 放射。中心無し
	* fourとanFourの合成
	* 1 0 1 0 1
	* 0 1 1 1 0
	* 1 1 0 1 1
	* 0 1 1 1 0
	* 1 0 1 0 1
	*/
    public void radialFour(int r, int c, int[][] intss, int end) {
			System.out.println("\n RADIAL FOUR");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);

//five()との差分。片方は「r+i, c+i」もう一方は「r-i, c+i」
        for(int i = -end; i <= end; i++) {
			if(inArea(r + i, c + i, hlen, wlen) && i != 0) {//左上から右下
				System.out.println((r+i) +" "+ (c+i) +" "+ intss[r+i][c+i]);
				intss[r+i][c+i] = valChange(intss[r+i][c+i]);
			}
			if(inArea(r - i, c + i, hlen, wlen) && i != 0) {//左下から右上
				System.out.println((r-i) +" "+ (c+i) +" "+ intss[r-i][c+i]);
				intss[r-i][c+i] = valChange(intss[r-i][c+i]);
			}
			if(inArea(r + i, c, hlen, wlen) && i != 0) {//縦
				intss[r+i][c] = valChange(intss[r+i][c]);
			}
			if(inArea(r, c + i, hlen, wlen) && i != 0) {//横
				intss[r][c+i] = valChange(intss[r][c+i]);
			}
		}
	}

	/**
	* 放射。中心有り
	* fiveとanFiveの合成
	* 1 0 1 0 1
	* 0 1 1 1 0
	* 1 1 1 1 1
	* 0 1 1 1 0
	* 1 0 1 0 1
	*/
    public void radialFive(int r, int c, int[][] intss, int end) {
			System.out.println("\n RADIAL FIVE");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);

//five()との差分。片方は「r+i, c+i」もう一方は「r-i, c+i」
        for(int i = -end; i <= end; i++) {
			if(inArea(r + i, c + i, hlen, wlen) && i != 0) {//左上から右下
				System.out.println((r+i) +" "+ (c+i) +" "+ intss[r+i][c+i]);
				intss[r+i][c+i] = valChange(intss[r+i][c+i]);
			}
			if(inArea(r - i, c + i, hlen, wlen)) {//左下から右上
				System.out.println((r-i) +" "+ (c+i) +" "+ intss[r-i][c+i]);
				intss[r-i][c+i] = valChange(intss[r-i][c+i]);
			}
			if(inArea(r + i, c, hlen, wlen) && i != 0) {//縦
				intss[r+i][c] = valChange(intss[r+i][c]);
			}
			if(inArea(r, c + i, hlen, wlen) && i != 0) {//横
				intss[r][c+i] = valChange(intss[r][c+i]);
			}
		}
	}


	/**
	* Fiveの反転。eightのダメな方
	* 11011
	* 11011
	* 00000
	* 11011
	* 11011
	*/
    public void turnFive(int r, int c, int[][] intss, int end) {
			System.out.println("\n TURN FIVE");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
        
        for(int i = -end; i <= end; i++) {
            for(int j = -end; j <= end; j++) {
//				eightのダメな方の条件式「(i!=0) && (j!=0)」
				if(inArea(r + i, c + j, hlen, wlen) && (i!=0) && (j!=0) ) {
					System.out.println((r+i) +" "+ (c+j) +" "+ intss[r+i][c+j]);
					intss[r+i][c+j] = valChange(intss[r+i][c+j]);
				}
			}
		}
	}


    public void eight(int r, int c, int[][] intss, int end) {
			System.out.println("\n EIGHT");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
        
        for(int i = -end; i <= end; i++) {
            for(int j = -end; j <= end; j++) {
//nine()との差分。「&& !( (i==0) && (j==0) )」が正解で、「&& (i!=0) && (j!=0)」はダメ
//「!( (i==0) && (j==0) )」は両方が０じゃないの場合で、「(i!=0) && (j!=0)」はどちらかが０でfalse
				if(inArea(r + i, c + j, hlen, wlen) && !((i == 0) && (j == 0)) ) {
					System.out.println((r+i) +" "+ (c+j) +" "+ intss[r+i][c+j]);
					intss[r+i][c+j] = valChange(intss[r+i][c+j]);
				}
			}
		}
	}
	
	/**
	* 外周。nineと同じ状態にするならto==0、外殻１マスにするなら(end==to)。
	* eightと同じならto==1
	* @param end 中心からの距離
	* @param to 外殻の厚さ。endとの相対
	*/
    public void eightDonut(int r, int c, int[][] intss, int end, int to) {
//外周だけ変更
			System.out.println("\n EIGHT");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
        
        for(int i = -end; i <= end; i++) {
            int abi = Math.abs(i);
            for(int j = -end; j <= end; j++) {
            	int abj = Math.abs(j);
//eight()との差分。ここでは「||」（もしくは）を使っている。
				if(inArea(r + i, c + j, hlen, wlen) 
					&& ((abi >= to) || (abj >= to))//abi,abjはend以下なので
				) {
//					System.out.println((r+i) +" "+ (c+j) +" "+ intss[r+i][c+j]);
					intss[r+i][c+j] = valChange(intss[r+i][c+j]);
				}
			}
		}
	}

    public void nine(int r, int c, int[][] intss, int end) {
			System.out.println("\n NINE OVER");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
        
        for(int i = -end; i <= end; i++) {
            for(int j = -end; j <= end; j++) {
				if(inArea(r + i, c + j, hlen, wlen)) {
//					System.out.println((r+i) +" "+ (c+j) +" "+ intss[r+i][c+j]);
					intss[r+i][c+j] = valChange(intss[r+i][c+j]);
				}
			}
		}
	}


	/**
	* even偶数。ナンバーズは奇数だけ
	* 起点が０(i=0)。endは含まない(i<end)
	* 
	*/
    public void even(int r, int c, int[][] intss, int end) {
			System.out.println("\n EVEN");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
        
        for(int i = 0; i < end; i++) {
            for(int j = 0; j < end; j++) {
				if(inArea(r + i, c + j, hlen, wlen)) {
//					System.out.println((r+i) +" "+ (c+j) +" "+ intss[r+i][c+j]);
					intss[r+i][c+j] = valChange(intss[r+i][c+j]);
				}
			}
		}
	}

	/**
	* 
	* 
	* 
	* @param to ?
	*/
    public void evenDonut(int r, int c, int[][] intss, int end, int to) {
			System.out.println("\n EVEN");
		int hlen = intss.length;
		int wlen = intss[0].length;
			System.out.println("len " + hlen +" "+ wlen);
        
        for(int i = 0; i < end; i++) {
            int abi = Math.abs(i);
            for(int j = 0; j < end; j++) {
            	int abj = Math.abs(j);
            	int sa = end - to;
            	
				if(inArea(r + i, c + j, hlen, wlen) 
					&& ((i < to || i >= sa) || (j < to || j >= sa))
				) {
//					System.out.println((r+i) +" "+ (c+j) +" "+ intss[r+i][c+j]);
					intss[r+i][c+j] = valChange(intss[r+i][c+j]);
				}
			}
		}
	}


//２次元配列のout of boundsエラー回避
    public boolean inArea(int r, int c, int h, int w) {
//    	hrが１始まりである場合、呼び出し時にinArea(h-1,w-1,r,c)とする
        boolean boo = true;
        if(0 > r || r >= h) { boo = false; }
        if(0 > c || c >= w) { boo = false; }
        
        return boo;
    }

		private void inAreaInspection(int minR, int maxR, int minC, int maxC) {
				System.out.println("\n inAreaInspection");
			for(int i = minR; i < maxR; i++) {
				for(int j = minC; j < maxC; j++) {
					System.out.println(i +" "+ j +" "+ inArea(i, j, h, w));
				}
			}
		}

//ターゲット範囲のデータを変更する。このクラスではintを使っているが、適宜タイプを変更する
		private int valChange(int val) {
			if(val == 0) {
				return 1;
			} else {
				return 0;
			}
		}


	public void printArr(Object[][] objss) {
		System.out.println("  OBJSS------");
		for(Object[] objs : objss) {
			System.out.println(Arrays.toString(objs));
		}
		System.out.println("  ------");
	}


	public void printTarminal(Point[][] numArr) {
			System.out.println("  printTarminal----");

        for(int i= -1; i <= 1; i++) {
            for(int j= -1; j <= 1; j++) {
            	Point p = numArr[i][j];
				int x = (int)p.getX();
				int y = (int)p.getY();
				System.out.println(x +" "+ y);
			}
		}

        for(int i=0; i < h; i++) {
            for(int j=0; j < w; j++) {
//            	if(numArr[i][j] == null) {
//					System.out.print(".");
//            	} else {
//					System.out.print("#");
//				}
			}
			System.out.println();
		}
			System.out.println("  ------------");
	}


	private void rowColumn() {
		String s = """
二次元配列における縦と横の記号の定義

対になる記号(言葉) [h, w] [y, x] [i, j] [row, column]

	本来(一般的に)
	上下に数値が変化する { h, y, i, row }
	左右　　　　　　　　 { w, x, j, col }

	しかしながら、Point(x, y)の並びと配列の[i][j]の並びが逆になるので、
	[i][j]の並びを優先して、[i][j]と(x,y)の関連が生まれる時には、[i,x][j,y]の組み合わせを採用する。
	メソッドnine()にprintArr()を常設した。この結果を見ると、
	右に行くほどyが増え、下に行くほどxが増えるという数学グラフ的におかしなことになっているが、
	[i][j]の関係から見るとよく見る形になっている。

h:高さheight　w:幅width
数学のグラフより、x:横軸 y:縦軸
row:行（横行） column:列（縦列）
二重for文において
	int cnt = 1;
	int[][] ints = new int[2][3];
	for(int i=0; i < 2; i++) {
		for(int j=0; j < 3; j++) {
			int[i][j] = cnt++;
		}
	}
i==0:[1,2,3]
i==1:[4,5,6]

	for(int j=0; j < 3; j++) {
		for(int i=0; i < 2; i++) {
			int[i][j] = cnt++;
		}
	}
i==0:[1,3,5]
i==1:[2,4,6]

		""";
	}



}//class.end