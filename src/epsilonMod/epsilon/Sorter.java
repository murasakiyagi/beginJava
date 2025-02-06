package epsilon;

import java.io.*;
import java.util.*;


public class Sorter {

	String[] smplStrs;
	int[] smplInts;
	double[] smplDbls;
	Map<String, Double> smplMap;
	Map<Double, Member> mmbMap;

	List<Integer> intList = new ArrayList<Integer>();
	Set<Integer> intSet = new HashSet<Integer>();
	int[] ints;

	public Sorter() {
		sampleData();
	}
	
//実行
	public void action() {
		System.out.println("\n---SORTER---\n");
		
		int cnt = 0;
		while(intList.size() < 5) {
			reRandom((int)(Math.random()*10), intList);
			reRandom((int)(Math.random()*10), intSet);
			if(cnt++ >= 10) { break; }
		}
//		System.out.println("CNT " + cnt);

		listSort(intList);
		treeSet(intSet);
		
		valueDeSort();
		memberDeSort();
		
		comparing();
		comparing2();
		
		
		System.out.println("\n---SORTER END---\n");
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

		private int reRandom(int x, Collection<Integer> c) {//再帰
			if(c.contains(x)) {
				int ran = (int)(Math.random()*10);
				return reRandom(ran, c);
			} else {
				c.add(x);
				return -1;
			}
		}

//	コアAPIの自然順序つけメソッド
//	下の方のcomparing()も参考に
	private void listSort(List<Integer> c) {
//		Collections.sort()の引数はListであって、Collectionではない
			System.out.println(c.toString());
		Collections.sort(c);
			System.out.println(c.toString());
	}

	private void treeSet(Collection<Integer> c) {
//		セットは大概自然順序になるが、それは保証されないのでTreeSetを使う
			System.out.println(c.toString());
		TreeSet<Integer> set = new TreeSet<Integer>(c);
		NavigableSet<Integer> reset = set.descendingSet();//逆にする
			System.out.println(reset.toString());
	}

	//StringやIntegerにcompareTo()メソッドが用意されているので活用する
	private void compareTo() {
		String a = "a";
		int n = a.compareTo("b");
			System.out.println(n);//戻り値int
		if(n == 0) {
			
		} else if(n > 0) {
			
		} else {
			
		}
	}



//Mapの値でソートする
	private void valueDeSort() {
//		Map<String, Double> -> Map<Double, String>にしている。
//		Map<String, Double>のままvalueの順序つけするのはめんどいので、
//			Map<Double, String>をfor文で呼び出して、新しいMapにぶち込む

//        TreeMap<Double, String> dsmap = new TreeMap<Double, String>();
        Map<Double, String> dsmap = new LinkedHashMap<Double, String>();
        Map<String, Double> sdmap = new LinkedHashMap<String, Double>();
        Map<String, Double> sdmap2 = new LinkedHashMap<String, Double>();
//		var redsmap = dsmap.descendingMap();//逆順のマップ(変数の型がTreeMapであること)


		for(String s : smplMap.keySet()) {//入力の代わり
			Double d = smplMap.get(s);
            System.out.println(smplMap.get(s) +" "+ s);

			dsCompe(dsmap, d, s);
			dsCompe2(sdmap, d, s);
			dsCompe3(sdmap2, d, s);
		}
            System.out.println("---1---");
            

		//結果
        for(Double d : dsmap.keySet()) {
            System.out.println(d +" "+ dsmap.get(d));
        }
            System.out.println("---2---");

            
		//結果
        for(String s : sdmap.keySet()) {
            System.out.println(sdmap.get(s) +" "+ s);
        }
            System.out.println("---3---");

		//結果
        for(String s : sdmap2.keySet()) {
            System.out.println(sdmap2.get(s) +" "+ s);
        }
            System.out.println("---4---");

	}


//	value側のソートである。mapがTreeMapなら自然順序になる。そうでないなら、重複したところだけ並べ替え
//	本来intで渡されるデータを、Doubleで扱い、重複するなら0.1を足してずらしている。
//		このずらしの方法は適宜考えること。
//	TreeMap以外（LinkedHash）でキー側のソートをするならif(!map.containsKey(d))に追加処理する。意味ないけど
    private Double dsCompe(Map<Double, String> map, Double d, String ato) {
        if(map.containsKey(d)) {//重複する場合
            String saki = map.get(d);
            int c = ato.compareTo(saki);//昇順
//            int c = saki.compareTo(ato);//降順
            if(c > 0) {//a.compareTo(z) == -25
//                     System.out.println("SAKI "+ d +" "+ ato);
                //sakiの再配置はしない
                return dsCompe(map, d + 0.1, ato);//d+0.1にも既存しているか？
            } else {
//                     System.out.println("ATO "+ d +" "+ ato);
                //atoをこのdのKeyに入れ、sakiの再配置をする
                map.put(d, ato);
                return dsCompe(map, d + 0.1, saki);//sakiとatoの役割が入れ替わった
            }
        } else {
            map.put(d, ato);
            return d;
        }
	}

//	ジェネリックすをそのまま
//	TreeMap以外であること
//	重複部分だけソートする場合は「} else if(c > 0) {」以下の処理をしない（単純なput(ato,d)だけする）
//	DoubleやIntegerのhashCode()はプリミティブ値をそのまま返す
    private Double dsCompe2(Map<String, Double> map, Double d, String ato) {
        if(map.containsValue(d)) {//重複する場合
        	String saki = "saki";
	    	for(String k : map.keySet()) {
				if(d.equals(map.get(k))) {
					saki = k;
				}
			}

            int c = ato.compareTo(saki);//昇順
//            int c = saki.compareTo(ato);//降順
            if(c > 0) {//a.compareTo(z) == -25
//                     System.out.println("SAKI "+ d +" "+ ato);
                //sakiの再配置はしない
                return dsCompe2(map, d + 0.1, ato);//d+0.1にも既存しているか？
            } else {
//                     System.out.println("ATO "+ d +" "+ ato);
                //atoをこのdのKeyに入れ、sakiの再配置をする
                map.put(ato, d);
				map.remove(saki);//きも
                return dsCompe2(map, d + 0.1, saki);//sakiとatoの役割が入れ替わった
            }
        } else {
            map.put(ato, d);
            return d;
        }
	}


//	
    private Double dsCompe3(Map<String, Double> map, Double d, String ato) {
        Double reD = d;
        if(map.isEmpty()) {
        	map.put(ato, d);
        } else {
	    	for(String k : map.keySet()) {
	    		double kd = map.get(k);//プリミティブ
	        	int c = d.compareTo(kd);//昇順
	//        	int c = kd.compareTo(d);//降順
				
	        	if(c == 0) {
		        	String saki = k;

		            int c2 = ato.compareTo(saki);//昇順
		//            int c = saki.compareTo(ato);//降順
		
		            if(c2 > 0) {//a.compareTo(z) == -25
		                //sakiの再配置はしない
		                reD = dsCompe3(map, d + 0.1, ato);//d+0.1にも既存しているか？
		                break;
		            } else {
		                //atoをこのdのKeyに入れ、sakiの再配置をする
		                map.put(ato, d);
		                map.remove(saki);//きも
		                reD = dsCompe3(map, d + 0.1, saki);//sakiとatoの役割が入れ替わった
		                break;
		            }
					
	        	} else if(c > 0) {
	        		map.put(ato, d);
	        		break;
	        	} else {
					map.remove(k);//きも
	        		map.put(ato, d);
					reD = dsCompe3(map, kd, k);//sakiとatoの役割が入れ替わった
	        		break;
	        	}
	    	}
	    }
		return reD;
	}


//	一つの構造体に情報が多い場合やっぱりクラスを使うのがいい
	private void memberDeSort() {
            System.out.println("memberDeSort----");
		mmbMap = new TreeMap<Double, Member>();
		for(int i=0; i < 4; i++) {
			String name = smplStrs[i];
			Double hei = smplInts[i] + 0.0;
			Member mmb = new Member(name, hei, smplDbls[i]);
			
			mmbCompe(mmbMap, hei, mmb);
		}
		
        for(Double d : mmbMap.keySet()) {
        	mmbMap.get(d).data(d + " ");
//            System.out.println(mmbMap.get(d).name);
        }
            System.out.println("memberDeSort----END");
	}

//	マップのサイズが大きくなって、dの値が１を超えることのないように
    public Double mmbCompe(Map<Double, Member> map, Double d, Member ato) {
        if(map.containsKey(d)) {// タッパ同じ
            Member saki = map.get(d);
            int c = ato.month.compareTo(saki.month);

            if(c < 0) {
                return mmbCompe(map, d + 0.000001, ato);
            } else if(c > 0) {
                map.put(d, ato);
                return mmbCompe(map, d + 0.000001, saki);
            } else {
//                int c2 = ato.name.compareTo(saki.name);
//                if(c2 > 0) {
//                    // ato.moon += 0.00001;//無意味
//                    return mmbCompe(map, d + 0.000001, ato);
//                } else {
//                    map.put(d, ato);
//                    // saki.moon += 0.00001;//無意味
//                    return mmbCompe(map, d + 0.000001, saki);
//                }

				return deepCompe(map, d, ato, saki);
            }
        } else {
            map.put(d, ato);
            return d;
        }
    }

		public Double deepCompe(Map<Double, Member> map, Double d, Member ato, Member saki) {
			int c = ato.name.compareTo(saki.name);
            if(c > 0) {
                // ato.moon += 0.00001;//無意味
                return mmbCompe(map, d + 0.000001, ato);
            } else {
                map.put(d, ato);
                // saki.moon += 0.00001;//無意味
                return mmbCompe(map, d + 0.000001, saki);
            }
		}


	/**
	* heightを優先に、同率ならmonthで入れ替え
	*/
	private void comparing() {
		List<Member> mmbList = sampleMember();
		printArr("comparing before", mmbList);
		mmbList.sort(
			new Comparator<Member>() {
				@Override
				public int compare(Member mmb1, Member mmb2) {
					int kari = (int)(mmb1.height - mmb2.height);
					if(kari == 0) {
						return (int)(mmb1.month - mmb2.month);
					} else {
						return kari;
					}
				}
			}
		);
		printArr("comparing after", mmbList);
	}

	private void comparing2() {
		List<Member> mmbList = sampleMember();
		printArr("comparing2 before", mmbList);
		mmbList.sort((mmb1, mmb2) -> (int)(mmb1.height - mmb2.height));
		printArr("comparing2 after", mmbList);
	}

	private void sampleData() {
		smplStrs = new String[] { "alfa", "bravo", "charl", "delta", "ecoh" };
		smplInts = new int[] { 14, 13, 12, 12, 11 };
		smplDbls = new double[] { 3.3, 1.1, 4.4, 3.3, 2.2 };
		smplMap = new HashMap<String, Double>();
		for(int i=0; i < 4; i++) {
			smplMap.put(smplStrs[i], smplDbls[i]);
		}
	}

	private List<Member> sampleMember() {
		List<Member> mmbList = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			String name = smplStrs[i];
			Double hei = smplInts[i] + 0.0;
			Member mmb = new Member(name, hei, smplDbls[i]);
			mmbList.add(mmb);
		}
		
		return mmbList;
	}


	public void printArr(String text, List<?> list) {
		System.out.println(text);
		for(var val : list) {
			System.out.println(val);
		}
		System.out.println();
	}

}


class Member {
	String name;
	Double height;//身長
	Double month;//誕生月
	
	public Member(String name, Double height, Double month) {
		this.name = name;
		this.height = height;
		this.month = month;
	}

    public void data(String s) {
        System.out.println(s +" "+ name +" "+ height +" "+ month);
    }
    
    public String toString() {
    	return name + "/" + height + "/" + month;
    }
}



//class MapProper<K, V> {
class MapProper {

	private String key;
	private Double value;
	private int idNum;

	public MapProper(String key, Double value) {

	}

	



//	public int keyConpareTo(K k) {
//		return this.key.compareTo(k);
//	}
//	public int valConpareTo(V v) {
//		return this.value.compareTo(v);
//	}

}





