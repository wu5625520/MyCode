public class TestThread {
    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        MyThread myThread3 = new MyThread();
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
        testSingle single = testSingle.getSingle();
        testSingle single1 = testSingle.getSingle();
        System.out.println(single == single1);
    }
}
class MyThread extends Thread{
    private static int number = 100;
    private static final Object obj = new Object();
    @Override
    public void run() {
        while(number >0 )
        synchronized(obj) {
            if (number > 0)
                System.out.println(getName() + ' ' + number--);
        }
//        try {
//            sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
class testSingle{
    private static testSingle t;
    public static testSingle getSingle(){
        if(t == null){
            synchronized (testSingle.class){
                if(t == null)   t = new testSingle();
            }
        }
        return t;
    }
}
