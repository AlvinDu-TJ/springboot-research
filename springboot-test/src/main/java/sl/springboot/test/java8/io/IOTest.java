package sl.springboot.test.java8.io;

import java.io.*;
import java.util.Arrays;

public class IOTest {

    public static void main(String[] args) throws IOException {
        if(1==1 ){
            byte[] bytes = "冬".getBytes();
            System.out.println(Arrays.toString(bytes));
            String s = new String(bytes);
            System.out.println(s);

            byte[] bytes1 = "冬".getBytes("GBK");
            System.out.println(Arrays.toString(bytes1));
            String s2 = new String(bytes1, "GBK");
            System.out.println(s2);
            return;
        }

        FileOutputStream fileOutputStream = new FileOutputStream("myfile.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
        bos.write("hello \r\n".getBytes());
        bos.write("world \r\n".getBytes());
        bos.flush();
        bos.close();

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("1.txt"));
        outputStreamWriter.write("中国");
        outputStreamWriter.close();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("1.txt"));

        int ch;
        // read 是一次读取一个字符
        while ((ch = inputStreamReader.read()) != -1){
            System.out.println((char)ch);
        }
        inputStreamReader.close();


    }
}
