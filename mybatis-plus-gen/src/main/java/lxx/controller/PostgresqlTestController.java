package lxx.controller;


import lombok.extern.slf4j.Slf4j;
import lxx.dao.PostgresqlTestMapper;
import lxx.entity.PostgresqlTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lxx
 * @since 2024-05-02
 */
@RestController
@RequestMapping("/postgresqlTest")
@Slf4j
public class PostgresqlTestController {

    @Autowired
    private PostgresqlTestMapper postgresqlTestMapper;

    @RequestMapping("/insert")
    public void insert(){
        PostgresqlTest postgresqlTest = new PostgresqlTest();
        postgresqlTest.setId(1);
        postgresqlTest.setName("lxx");
        postgresqlTestMapper.insert(postgresqlTest);
    }

    @RequestMapping("/selectById")
    public void selectById(){
        PostgresqlTest postgresqlTest = new PostgresqlTest();
        postgresqlTest.setId(1);
        postgresqlTest.setName("lxx");
        PostgresqlTest postgresqlTest1 = postgresqlTestMapper.selectById(1);
        log.info(postgresqlTest1.toString());
    }

    @RequestMapping("/selectByEntity")
    public void selectByEntity(){
        PostgresqlTest postgresqlTest = new PostgresqlTest();
        postgresqlTest.setId(1);
        postgresqlTest.setName("lxx");
        List<PostgresqlTest> list = postgresqlTestMapper.selectByEntity(postgresqlTest);
        log.info(String.valueOf(list.size()));
    }

    @RequestMapping("/deleteById")
    public void deleteById(){
        PostgresqlTest postgresqlTest = new PostgresqlTest();
        postgresqlTest.setId(1);
        postgresqlTest.setName("lxx");
        int i = postgresqlTestMapper.deleteById(1);
        log.info(String.valueOf(i));
    }

    @RequestMapping("/updateById")
    public void updateById(){
        PostgresqlTest postgresqlTest = new PostgresqlTest();
        postgresqlTest.setId(1);
        postgresqlTest.setName("lxx1");
        int i = postgresqlTestMapper.updateById(postgresqlTest);
        log.info(String.valueOf(i));
    }

}

