package testnewcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wxy
 * @title: TestCollectionsReverse
 * @description: TODO
 * @date 2021/9/1310:04
 */
public class TestCollectionsReverse {
    public static void main(String[] args) {
        List<Integer> li1 = new LinkedList<>();
        li1.add(1);
        li1.add(2);
        li1.add(3);
        li1.add(4);
        List<Integer> li2 = new LinkedList<>();
        li2.add(1);
        li2.add(2);
        li2.add(3);
        li2.add(4);
        List<List<Integer>> lili = new LinkedList<List<Integer>>();
        lili.add(li1);
        lili.add(li2);
        System.out.println("翻转前：" + lili);
        for(List<Integer> x : lili)
            Collections.reverse(x);
        System.out.println("翻转后：" + lili);
    }
}
