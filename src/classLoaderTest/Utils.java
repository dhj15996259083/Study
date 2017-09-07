package classLoaderTest;

import java.lang.reflect.Method;

public class Utils {
    public static Object invokeFatherMehtod(Object o, String name, Class<?>[] parameterTypes, Object[] params) throws Exception {
        Method method = o.getClass().getSuperclass().getDeclaredMethod(name, parameterTypes);
        method.setAccessible(true);
        return method.invoke(o, params);
    }
}
