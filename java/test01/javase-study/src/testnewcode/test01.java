package testnewcode;

import java.lang.reflect.Array;
import java.util.*;

/**
　　* @description: 对区间进行排序
　　* @author wxy
　　* @date 2021/8/19 10:04
　　*/
public class test01{
    static int n = 5;
    public static void main(String[] args) throws InterruptedException {
        printByN(1);
        Thread.sleep(500000);
    }
    public static void printByN(int n){
        /*
        1 2 3 4 5 6 7 8 9 10 11 ... 100 101 102
         */
        ArrayList<Character> charList = new ArrayList<>();
        charList.add('0');
        while(charList.size() <= n){
            printChar(charList, charList.size() - 1, true, n);
            if(charList.size() <= n)
                System.out.println();
        }

    }
    public static void printChar(ArrayList<Character> charList, int bit, boolean updateStatus, int n){

        //递归终止条件
        if(updateStatus){
            if(charList.get(bit) == '9'){
                if(bit == 0){
                    charList.set(0, '1');
                    charList.add('0');
                    if(charList.size() <= n)
                        System.out.print(charList.get(0) + "0");
                    return;
                }
                else{
                    charList.set(bit, '0');
                }
            }
            else{
                updateStatus = false;
                charList.set(bit, (char)(charList.get(bit) + 1 ));
            }
        }
        if(bit == 0){ //最高位不进1,直接输出
            System.out.print(charList.get(0));
            return;
        }
        printChar(charList, bit - 1, updateStatus, n);
        if(charList.size() <= n)
            System.out.print(charList.get(bit));
    }
}