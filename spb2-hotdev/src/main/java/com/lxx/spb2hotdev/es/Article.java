package com.lxx.spb2hotdev.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "articles"
//       ,type = "article"
)
public class Article {

    @Id
    private String id;

    private String title;

    private String content;

}

