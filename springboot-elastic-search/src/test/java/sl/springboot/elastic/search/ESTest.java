package sl.springboot.elastic.search;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sl.springboot.elastic.search.bean.Article;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ESTest {

    @Autowired
    JestClient jestClient;

    @Test
    public void test1(){
        // 保存一个文档

        Article a = new Article();
        a.setName("aaa");
        a.setId(1);
        a.setTitle("title");
        Index index = new Index.Builder(a).index("atguigu").id("1").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
