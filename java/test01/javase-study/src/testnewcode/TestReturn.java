package testnewcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wxy
 * @title: TestReturn
 * @description: 局部函数什么样的变量？指针可以返回？
 * @date 2021/7/138:43
 */
class outClass {
    private int age = 12;
    public void outPrint(final int x){
        class InClass {
            public void InPrint() {
                System.out.println(x);
                System.out.println( age);
            }
        }
        new InClass( ).InPrint();
    }

    public static void main(String[] args) {
        new outClass().outPrint(666);
    }
}

