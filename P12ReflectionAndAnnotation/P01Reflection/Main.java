package P12ReflectionAndAnnotation.P01Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = Reflection.class;
       // Class clazz2 = Class.forName("P12ReflectionAndAnnotation.P01Reflection.P12ReflectionAndAnnotation.P2GettersAndSetters.Reflection");

        System.out.println(clazz.toString());
        System.out.println(clazz.getSuperclass().toString());
        Class[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Constructor reflectionConstructor = clazz.getDeclaredConstructor();
        Reflection reflection = (Reflection)reflectionConstructor.newInstance();
        System.out.println(reflection);
    }
}
