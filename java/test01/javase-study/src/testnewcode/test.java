package testnewcode;

import java.io.InputStream;

/**
 * @author wxy
 * @title: MyClassLoader
 * @description: TODO
 * @date 2021/8/2316:59
 */
public class test{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                Class<?> findClass = null;
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if(is == null){
                    return super.loadClass(name);
                }
                try {
                    byte[] byteArray = new byte[is.available()];
                    is.read(byteArray);
                    findClass = defineClass(name,byteArray, 0, byteArray.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return findClass;
            }
        };
//        Object obj =myLoader.loadClass("testnewcode.test").newInstance();
//        Object obj =myLoader.loadClass("testnewcode.TestInterfaceClassLoader").newInstance();
//        System.out.println(myLoader.loadClass("testnewcode.TestInterfaceClassLoader").getClassLoader());
//        System.out.println(TestInterfaceClassLoader.class == myLoader.loadClass("testnewcode.TestInterfaceClassLoader"));
        System.out.println(TestInterfaceClassLoader.class);
        System.out.println(myLoader.loadClass("testnewcode.TestInterfaceClassLoader"));
//        System.out.println(obj instanceof TestInterfaceClassLoader);
    }
}