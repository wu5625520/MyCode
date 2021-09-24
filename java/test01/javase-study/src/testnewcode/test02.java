package testnewcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wxy
 * @title: 测试try 和finally中的return 语句
 * @description:
 * @date 2021/7/99:33
 */
public class test02 {
    public static void main(String[] args){
        String s = "9";
        String show = show(s);
        System.out.println(show);

    }
    public static <T> T show(T t){
        return t;
    }

}
class base01<T>{
    T t;
    public base01(T t){
        this.t = t;
    }
    public <E> E show(E e){
        System.out.println(e);
        return e;
    }
}