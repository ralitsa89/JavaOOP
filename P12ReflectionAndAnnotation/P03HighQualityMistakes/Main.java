package P12ReflectionAndAnnotation.P03HighQualityMistakes;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException,
            NoSuchFieldException {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Field[] declaredFields = clazz.getDeclaredFields();

        TreeSet<Field> fields = collectByName(Arrays.stream(declaredFields));

        filterMembers(fields.stream(), f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        TreeSet<Method> getters = collectByName(filterMembersByName(methods, "get"));

        filterMembers(getters.stream(), g -> !Modifier.isPublic(g.getModifiers()))
                .forEach(g -> System.out.printf("%s have to be public!%n", g.getName()));

        TreeSet<Method> setters = collectByName(filterMembersByName(methods, "set"));

        filterMembers(setters.stream(), s -> !Modifier.isPrivate(s.getModifiers()))
                .forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));
    }

    public static <T extends Member> Stream<T> filterMembersByName(T[] members, String filter) {
        return filterMembers(members, m -> m.getName().contains(filter));
    }

    public static <T extends Member> Stream<T> filterMembers(T[] members, Predicate<T> predicate) {
        return filterMembers(Arrays.stream(members), predicate);
    }

    public static <T extends Member> Stream<T> filterMembers(Stream<T> stream, Predicate<T> predicate) {
        return stream
                .filter(predicate);
    }

    public static <T extends Member> TreeSet<T> collectByName(Stream<T> stream) {
        return stream.collect(Collectors.toCollection(
                () -> new TreeSet<>(Comparator.comparing(Member::getName))));
    }
}

