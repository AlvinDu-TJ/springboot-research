package sl.springboot.test.java8.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTest {
    public static void main(String[] args)  {
        if(1== 1) {
            System.out.println("a"+System.getProperty("line.separator")+"b");
            return;
        }

        // 创建字节输出流对象, try with, 自动释放资源
        try(FileOutputStream fos = new FileOutputStream("e:\\1\\a.txt")){
            fos.write(97);
        }catch (Exception e){
            e.printStackTrace();
        }


        try(FileInputStream fis = new FileInputStream("e:\\1\\a.txt")){
            int b;
            while( ( b= fis.read()) != -1 ){
                System.out.println(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
