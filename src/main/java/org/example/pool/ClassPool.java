package org.example.pool;


import org.example.factory.Factory;
import org.example.temp.TempClass;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClassPool<T> {
    Queue<T> pool;
    Factory<T> factory;
    public ClassPool(Factory<T> factory) {
        pool = new ConcurrentLinkedQueue<>();
        this.factory = factory;
    }

    public synchronized T getExample(Integer x) {
        T obj = pool.poll();
        if (obj == null) {
            obj = factory.getT(x);
        } else {
            //赋值
        }
        return obj;
    }
    public synchronized void returnExample(T obj) {
        pool.offer(obj);
    }
}
