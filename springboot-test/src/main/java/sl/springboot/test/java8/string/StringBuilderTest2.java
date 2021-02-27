package sl.springboot.test.java8.string;

public class StringBuilderTest2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<20;i++){
            char t = (char)('a'+i);
            sb.append(t);
        }
        System.out.println(sb);
        // 倒转
        sb.reverse();
        System.out.println(sb);
        sb.setCharAt(0,'z');
        System.out.println(sb);

        //链式调用
        sb.insert(0, 'w').insert(1, 'a').insert(2, 'n');
        System.out.println(sb);

        sb.deleteCharAt(2).deleteCharAt(1).deleteCharAt(0);
        System.out.println(sb);


    }
}
