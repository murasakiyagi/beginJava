package epsilon;

import java.io.*;
import java.util.*;


public class SingleArray {

    public SingleArray() {}

    public void action() {
        int[] ints = {1,2,3,4};
        Integer[] primObj = primObjChenge(ints);
        List<Integer> primList = primListChange(ints);
            printArr(primObj);
            printList(primList);

        int[] objPrim = objPrimChenge(primObj);
        int[] listPrim = listPriChange(primList);
            printArr(objPrim);
            printArr(listPrim);


            System.out.println( iceCone(ints) );
    }

    //オブプリ変換
    private int[] objPrimChenge(Integer[] itgArr) {
    	List<Integer> oblist = Arrays.asList(itgArr);
    	return oblist.stream().mapToInt(Integer::intValue).toArray();
    }

	//プリオブ変換
    private Integer[] primObjChenge(int[] intArr) {
    	List<Integer> prlist = Arrays.stream(intArr).boxed().toList();
    	return prlist.toArray(new Integer[0]);
    }

    //プリリス変換
    private List<Integer> primListChange(int[] intArr) {
        return Arrays.stream(intArr).boxed().toList();
    }

    //リスプリ変換
    private int[] listPriChange(List<Integer> itgList) {
        return itgList.stream().mapToInt(Integer::intValue).toArray();
    }


//  配列の隣り合う値を処理するしていき、最終的に処理された１つの値を返す
    static int iceCone(int[] ints) {//逆さ円錐
        int len = ints.length;
        int[] down = new int[len-1];
        int ans = 0;
        
        for(int i=0; i < ints.length-1; i++) {
            
            down[i] = ints[i] + ints[i+1];
                System.out.println(Arrays.toString(down));

            if(i == ints.length-2) {
                len--;
                i = -1;
                ints = Arrays.copyOf(down, down.length);
                ans = down[0];
                down = new int[len-1];
            }
        }
        return ans;
    }


    private void printArr(int[] arr) {//二つ必要
        System.out.println(Arrays.toString(arr));
    }
    private void printArr(Object[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    private void printList(List list) {
        System.out.println(list.toString());
    }

}