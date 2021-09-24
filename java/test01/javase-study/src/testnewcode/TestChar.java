package testnewcode;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxy
 * @title: TestChar
 * @description: TODO
 * @date 2021/7/219:51
 */
public class TestChar {
    public static void main(String[] args) {
        Runnable window = new Window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        thread1.start();
        thread2.start();
//        WindowExtend windowExtend = new WindowExtend();
//        WindowExtend windowExtend1 = new WindowExtend();
//        windowExtend.start();
//        windowExtend1.start();
    }
}
class Window implements Runnable{
    private static int i = 100;
    int j = 10;
    @Override
    public void run() {
        while(j > 0){
            show();
        }
    }
    private void show() {
//        System.out.println(this);
        System.out.println(Thread.currentThread().getName() +"----" + j--);
    }
}
class WindowExtend extends Thread{
    private static int i = 1000;
    @Override
    public void run() {
        for(int i = 0; i < 50; i++){
            show();
        }
    }

    private static void show() {
        System.out.println(Thread.currentThread().getName() +"----" + i--);
    }
}
