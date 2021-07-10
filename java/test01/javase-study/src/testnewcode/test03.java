package testnewcode;

/**
 * @author wxy
 * @title: test03
 * @description: 测试值传递和引用传递
 * 结论：
 * 1、Java中其实还是值传递的，只不过对于对象参数，值的内容是对象的引用，对引用直接赋值，相当于改变了指针的指向，不影响原指向的对象
 * 2、数组名传递的是地址值，改变该地址值直接改变原指向。
 * @date 2021/7/1014:55
 */
public class test03 {
    public static void main(String[] args){
        person A = new person("tom", 12);
        person[] array = new person[2];
        array[0] = new person();
        change(A, array);
        System.out.println(A);
        System.out.println(array[0]);
    }
    public static void change(person B, person ch[]){
        person temp = new person("wxy", 27);
//        B = temp;
        B.name = "changed";
        ch = new person[3];
        ch[0] = temp;

    }

}
class person{
    String name;
    Integer age;

    public person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public person() {
        name = "define";
        age = 0;
    }
}
