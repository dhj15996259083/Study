package classLoaderTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;

// 通过反射调用defineClass1本地方法也没用，推测该方法中也限制了java.包的加载
public class MyClassLoader3 extends ClassLoader {
    private final ProtectionDomain defaultDomain =
            new ProtectionDomain(new CodeSource(null, (Certificate[]) null),
                    null, this, null);

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {

        synchronized (getClassLoadingLock(name)) {
            if ("java.lang.String".equals(name)) {
                long t0 = System.nanoTime();
                long t1 = System.nanoTime();
                Class c = findClass(name);

                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            } else {
                return this.getParent().loadClass(name);
            }
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replace('.', '/').concat(".class");
        File file = new File("/Users/daihuijun/IdeaProjects/Study/temp/" + path);
        byte[] b = new byte[10 * 1024 * 1024];
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int len = inputStream.read(b);
            return myDefineClass(name, b, 0, len);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new ClassNotFoundException(name);
    }

    protected Class<?> myDefineClass(String name, byte[] b, int off, int len)
            throws Exception {
        Class[] classes = new Class[]{String.class, byte[].class, int.class, int.class, ProtectionDomain.class, String.class};

        String source = (String) Utils.invokeFatherMehtod(this, "defineClassSourceLocation", new Class[]{ProtectionDomain.class}, new Object[]{defaultDomain});
        Object[] params = new Object[]{name, b, off, len, defaultDomain, source};

        Class<?> c = (Class) Utils.invokeFatherMehtod(this, "defineClass1", classes, params);

        if (defaultDomain.getCodeSource() != null) {
            Certificate certs[] = defaultDomain.getCodeSource().getCertificates();
            if (certs != null)
                setSigners(c, certs);
        }
        System.out.println(c.getClassLoader());
        return c;
    }
}
