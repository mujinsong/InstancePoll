import org.example.factory.Factory;
import org.example.pool.ClassPool;
import org.example.temp.TempClass;

public class Test {
    public static void t1(int n,ClassPool<TempClass> pool) {
        for (int i=0;i<n;++i) {
            TempClass t = new TempClass(1);
            t.getX();
        }
    }
    public static void t2(int n,ClassPool<TempClass> pool) {
        for (int i=0;i<n;++i) {
            TempClass t = pool.getExample(2);
            t.getX();
            pool.returnExample(t);
        }
    }
    public static void main(String[] args) {
        long start;
        long end;
        int n =10000000;
        Factory<TempClass> factory = new Factory<>(TempClass.class);
        ClassPool<TempClass> pool = new ClassPool<>(factory);
        start=System.nanoTime();
        t1(n,pool);
        end = System.nanoTime();
        System.out.println("t1:"+(end-start));
        start=System.nanoTime();
        t2(n,pool);
        end = System.nanoTime();
        System.out.println("t2:"+(end-start));
    }
}
