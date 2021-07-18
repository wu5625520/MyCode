package testnewcode;

/**
 * @author wxy
 * @title: TestEnum
 * @description: 学习枚举
 * @date 2021/7/1510:43
 */
public class TestEnum {
    public static void main(String[] args){
//        System.out.println(SIZE.LARGE.getSize());
//        SIZE[] values = SIZE.values();
//        for(int i = 0; i < values.length; i++)
//            System.out.println(values[i]);
//
        SIZE small = SIZE.valueOf("SMALL");
//        System.out.println(small);
        switch (small) {
            case SMALL:
                System.out.println("small");
                break;
            case LARGE:
                System.out.println("large");
                break;
        }
    }
}
enum SIZE{
    SMALL,MEDIEM,LARGE;
}
