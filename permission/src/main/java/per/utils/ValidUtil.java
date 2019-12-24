package per.utils;

import java.util.Collection;

public class ValidUtil {


    public static <T> T email(Class<T> clazz, Collection<?> collection) {


        System.out.println(clazz.getName());

        T t = null;

        collection.forEach(e -> {
            System.out.println(1);
        });

        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return t;
    }

}
