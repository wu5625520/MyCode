package testnewcode;

/**
 * @author wxy
 * @title: 测试try 和finally中的return 语句
 * @description:
 * @date 2021/7/99:33
 */
public class test02 {
    public static void main(String[] args){
        System.out.println(get().toString());
    }
    static Integer  get(){
        int i = 6;
        try {
            return i;
        } finally {
            i = 888;
        }
    }
}
