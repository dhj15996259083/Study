package classLoaderTest;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public String getName() {
        return "Test";
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(System.getProperty("sun.boot.class.path"));
//
        URL url = new URL("file:/Users/daihuijun/IdeaProjects/Study/temp/");
        URLClassLoader classLoader = new MyClassLoader(new URL[]{url});
        try {
            Thread.currentThread().setContextClassLoader(classLoader);
            System.out.println("MyClassLoader测试：");
            Class<?> clazz = classLoader.loadClass("classLoaderTest.TestClass");
            Object o = clazz.newInstance();
            Method method = o.getClass().getMethod("getMain", null);
            Main main = (Main) method.invoke(o, null);

            System.out.println(o.getClass().getClassLoader());
            System.out.println(main.getName().getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("MyClassLoader2测试：");
            ClassLoader classLoader2 = new MyClassLoader2();
            Class<?> clazz2 = classLoader2.loadClass("apple.applescript.AppleScriptEngine");
            System.out.println(clazz2.getClassLoader());

            Class<?> clazzString = classLoader2.loadClass("java.lang.String");
            System.out.println(clazzString.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(10);
            System.out.println("MyClassLoader3测试：");
            ClassLoader classLoader3 = new MyClassLoader3();
            Class<?> clazz3 = classLoader3.loadClass("apple.applescript.AppleScriptEngine");
            System.out.println(clazz3.getClassLoader());

            Class<?> clazzString3 = classLoader3.loadClass("java.lang.String");
            System.out.println(clazzString3.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
