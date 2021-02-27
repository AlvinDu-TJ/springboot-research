package sl.springboot.test.java8.innerClass;

public class Outer {
    private int age = 12;

    //这个叫成员内部类 可以访问外部类所有的变量和方法。成员内部类依赖于外部类的实例
    class Inner{
        private int age = 13;
        public void print(){
            int age = 14;
            System.out.println("局部变量" + age);
            System.out.println("内部变量" + this.age);
            System.out.println("外部实例的hashcode2"+Outer.this.hashCode());
            // 这里的Outer.this 代表外部类的一个实例，因为成员内部类是依赖于外部类的实例而存在的， 所以此处这么写.
            System.out.println("外部类变量" + Outer.this.age);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println("外部实例的hashcode1"+outer.hashCode());
        Inner inner = outer.new Inner();
        inner.print();


    }
}
