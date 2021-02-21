package sl.springboot.test.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Zodiac;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.ObjectUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. clone 使用序列化方式进行深克隆
        String sdf = ObjectUtil.cloneByStream(new String("sdf"));

        // 2. 类型转换 Convert类
        String[] b = { "1", "2", "3", "4" };
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);

        Object[] a = { "a", "你", "好", "", 1 };
        List<String> list = Convert.convert(new TypeReference<List<String>>() {}, a);

        list.forEach(System.out::println);


        double c = 67556.32;

        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(c);
        System.out.println(digitUppercase);

        //结果为：Long.class
        Class<?> wraped = Convert.wrap(long.class);
        System.out.println(wraped);


        // 日期时间工具
        System.out.println(DateUtil.now());
        System.out.println(DateTime.now());
        System.out.println(Zodiac.getChineseZodiac(DateTime.now()));
        System.out.println(Zodiac.getZodiac(DateTime.now()));


        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();


        // 日期格式自动识别
        String dateStr = "2017-03-01";
        Date date4 = DateUtil.parse(dateStr);


        String dateStr2 = "2017-03-01";
        Date date5 = DateUtil.parse(dateStr);

        //结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");

        //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date);

        // IO 工具类
        BufferedInputStream in = FileUtil.getInputStream("d:/test.txt");
        BufferedOutputStream out = FileUtil.getOutputStream("d:/test2.txt");
        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);

        // File 工具类
        //默认UTF-8编码，可以在构造中传入第二个参数做为编码
        FileReader fileReader = new FileReader("test.properties");
        String result = fileReader.readString();

    }
}
