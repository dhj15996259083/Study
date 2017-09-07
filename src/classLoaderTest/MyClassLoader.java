package classLoaderTest;

import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader {
    public MyClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    public Class<?> myFindClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

}
