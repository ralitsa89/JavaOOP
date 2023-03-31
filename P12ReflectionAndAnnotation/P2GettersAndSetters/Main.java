package P12ReflectionAndAnnotation.P2GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException,
            NoSuchFieldException {

//        Class clazz = P12ReflectionAndAnnotation.P2GettersAndSetters.Reflection.class;
//
//        Method[] methods = clazz.getDeclaredMethods();
//
//        Arrays.stream(methods)
//                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
//                .sorted(Comparator.comparing(Method::getName))
//                .forEach(method -> System.out.printf("%s will return class %s%n", method.getName(), method.getReturnType()));
//
//        Arrays.stream(methods)
//                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1 )
//                .sorted(Comparator.comparing(Method::getName))
//                .forEach(method -> System.out.printf("%s and will set field of class %s%n",
//                        method.getName(), method.getParameterTypes()[0].getName()));

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        TreeSet<Method> getters = filterMethodsBy(methods, "get");

        TreeSet<Method> setters = filterMethodsBy(methods, "set");

        Function<Class<?>, String> formatType = c -> c == int.class ? "class int" : c.toString();

        getters.stream()
                .forEach(m -> {
                    System.out.printf("%s will return %s%n", m.getName(), formatType.apply(m.getReturnType()));
                });

        setters.stream()
                .forEach(m -> {
                    System.out.printf("%s and will set field of %s%n", m.getName(), formatType.apply(m.getParameterTypes()[0]));
                });
    }

    public static TreeSet<Method> filterMethodsBy(Method[] methods, String filter) {
        return Arrays.stream(methods)
                .filter(m -> m.getName().contains(filter))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Method::getName))));
    }

}

