package sl.springboot.test.pattern.singelton;

/**
 * 懒汉模式
 */
public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy(){
        super();
    }

    /**
     * 多线程下有线程安全问题
     * @return
     */
    public static SingletonLazy getInstance(){
        if(null == instance){
            return new SingletonLazy();
        }
        return instance;
    }
}
