package com.lxx.spb2hotdev.es;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ESTest {


    @Autowired
    FunctionESTest functionESTest;



    @Test
    void BeanClassUtil1() throws IOException {
//        Article article = new Article();
//        article.setId("123");
//        article.setTitle("qwe");
//        article.setContent("zxc");
//        articleService.saveArticle(new Article());
        functionESTest.test();
        functionESTest.test1();
    }

}
