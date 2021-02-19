package sl.springboot.server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

public class Encoder {

    public static void main(String[] args) throws Exception, FileNotFoundException {
        String gbk = new String("adfsdf".getBytes("gbk"));
        gbk = changeCharset("天气","gbk");
        FileOutputStream op = new FileOutputStream("d://1.txt");
        op.write(gbk.getBytes());
        op.close();

    }

    public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
        if (str != null) {
        //用默认字符编码解码字符串。与系统相关，中文windows默认为GB2312
            byte[] bs = str.getBytes();
            return new String(bs, newCharset); //用新的字符编码生成字符串
        }
        return null;
    }
}
