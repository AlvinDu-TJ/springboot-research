package sl.springboot.test.pattern.singelton;

public class EnumSingleton {


    private EnumSingleton(){
        super();
    }

    /**
     * 多线程下有线程安全问题
     * @return
     */
    public static EnumSingleton getInstance(){
        return InstanceEnum.INSTANCE.getInstance();
    }

    private enum InstanceEnum {
        INSTANCE;

        private EnumSingleton instance;

        InstanceEnum() {
            instance = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return instance;
        }
    }
}
