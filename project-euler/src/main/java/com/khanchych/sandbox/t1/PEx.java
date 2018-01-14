package com.khanchych.sandbox.t1;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

class FloatList extends ArrayList<Float> {}

public class PEx {

    public static Class getGenericParameterClass(Class actualClass, int parameterIndex) {
        return (Class) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[parameterIndex];
    }
    static  class AbstractEntityFactory<E extends Number> {
        public Class getEntityClass() {
            return getGenericParameterClass(this.getClass(), 0);
        }
    }
    public static void main(String[] args) {
        ArrayList<Float> listOfNumbers = new FloatList();

        Class actualClass = listOfNumbers.getClass();
        ParameterizedType type = (ParameterizedType)actualClass.getGenericSuperclass();
        System.out.println(type); // java.util.ArrayList<java.lang.Float>
        Class parameter = (Class)type.getActualTypeArguments()[0];
        System.out.println(parameter); // class java.lang.Float
    }
}
