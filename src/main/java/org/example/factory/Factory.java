package org.example.factory;

import org.example.temp.TempClass;

import java.lang.reflect.Constructor;

public class Factory<T> {
    Class<T> type;
    public Factory(Class<T> type) {
        this.type = type;
    }
    public T getT(Object... args) {
        if (type == null) {
            return null;
        }
        try {
            Class<?>[] parameterTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getClass();
            }
            Constructor<T> constructor = type.getDeclaredConstructor(parameterTypes);
            return constructor.newInstance(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

