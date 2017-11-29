package classLoaderTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader2 extends ClassLoader {
    private static final MyClassLoader2.HelpLoader helpLoader;

    static {
        URL url = null;
        try {
            url = new URL("file:/Users/daihuijun/IdeaProjects/Study/temp/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        helpLoader = new MyClassLoader2().new HelpLoader(new URL[]{url});
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                long t1 = System.nanoTime();
                c = findClass(name);

                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    class HelpLoader extends URLClassLoader {
        public HelpLoader(URL[] urls) {
            super(urls);
        }

        public Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return helpLoader.findClass(name);
    }
}
