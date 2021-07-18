package testnewcode;

/**
 * @author wxy
 * @title: TestReturn
 * @description: 局部函数什么样的变量？指针可以返回？
 * @date 2021/7/138:43
 */
public class TestReturn {
    public static void main(String[] args){
        TestReturn testReturn = new TestReturn();
        Integer b = testReturn.get();
        System.out.println(b.hashCode());
    }
    public Integer get(){
        Integer a = 66;
        return a;
    }
}
