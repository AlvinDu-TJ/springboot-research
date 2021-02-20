package sl.springboot.test.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.Tailer;

import java.io.File;

public class TailerTest {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir");

        File file = FileUtil.file(path + "/example.properties");

        Tailer tailer = new Tailer(file, Tailer.CONSOLE_HANDLER, 2);
        tailer.start();
    }
}
