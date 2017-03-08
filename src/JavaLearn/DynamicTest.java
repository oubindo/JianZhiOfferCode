package JavaLearn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by oubin on 17-2-23.
 */
public class DynamicTest {

    public static void consumer(Interface i){
        i.getName();
        i.getId(6);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RealObject object = new RealObject();
        consumer(object);
        System.out.println("============");

        ClassLoader classLoader = Interface.class.getClassLoader();
        Class<?>[] classes = new Class[]{Interface.class};
        InvocationHandler handler = new DynamicHandler(object);
        Interface proxy = (Interface) Proxy.newProxyInstance(classLoader, classes, handler);
        consumer(proxy);
        System.out.println("=============");
        RealObject object1 = new RealObject();
        Class clazz = Class.forName("JavaLearn.RealObject");
        Method test = clazz.getDeclaredMethod("testPrivate");
        test.setAccessible(true);
        test.invoke(object1);
    }

    public static class DynamicHandler implements InvocationHandler{
        public Object proxied;

        public DynamicHandler(Object proxied) {
            System.out.println("dynamichandler construct");
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy name = " + proxy.getClass());
            System.out.println("proxy method name =" + method.getName());
            System.out.println("args =" + Arrays.toString(args));

            if ("getId".equals(method.getName())){
                args = new Object[]{Integer.valueOf(9)};
            }
            Object invokeObject = method.invoke(proxied, args);
            if (invokeObject != null) {
                System.out.println("invoke object: " + invokeObject);
            } else {
                System.out.println("invoke object is null");
            }
            return invokeObject;
        }
    }


}
