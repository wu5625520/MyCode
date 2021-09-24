package testnewcode;

import java.util.LinkedList;

/**
 * @author wxy
 * @title: TestToString
 * @description: TODO
 * @date 2021/9/178:15
 */
public class TestToString {
    public static void main(String[] args) {
        new B();
    }
}
class Base{
    public Base(){
        System.out.println("Base的构造器~");
    }
}
class A{
    {
        System.out.println("A的代码块");
    }
    Base ab = new Base();
    int a = 5;
    public A(){
        System.out.println("A的构造器~");
    }
}
class B extends A{
    {
        System.out.println("B的代码块");
    }
    Base bb = new Base();
    public B(){
        System.out.println("B的构造器");
        a = 666;
    }
}

