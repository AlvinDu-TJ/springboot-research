package sl.springboot.test.java8.bean;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class IfThen {

    private Consumer<Map> c;
    private Predicate<Map> p;

    public IfThen(Predicate<Map> p, Consumer<Map> c) {
        this.c = c;
        this.p = p;
    }

    public Consumer<Map> getC() {
        return c;
    }

    public void setC(Consumer<Map> c) {
        this.c = c;
    }

    public Predicate<Map> getP() {
        return p;
    }

    public void setP(Predicate<Map> p) {
        this.p = p;
    }
}
