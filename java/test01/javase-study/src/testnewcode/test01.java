package testnewcode;

/**
 * @author wxy
 * @title: test01
 * @description: 测试子类重写父类方法后，在父类中调用的是哪一个？C++中调用的还是父类的。
 * @date 2021/7/99:19
 */
public class test01 extends base{
    public static void main(String[] args){
        test01 test01 = new test01();
    }
    public void show(){
        System.out.println("I am belong to the derived class.");
    }
}
class base{
    public base(){
        System.out.println("I am the constructor of base class.");
        show();
    }
    public void show(){
        System.out.println("I am belong to the base class.");
    }
}
