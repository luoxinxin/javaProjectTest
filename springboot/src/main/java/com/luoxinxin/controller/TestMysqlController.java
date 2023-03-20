package com.luoxinxin.controller;

import com.luoxinxin.domain.SysPost;
import com.luoxinxin.domain.SysUser;
import com.luoxinxin.mapper.SysPostMapper;
import com.luoxinxin.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestMysqlController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysPostMapper sysPostMapper;

    @RequestMapping("/testRedirect")
    public String testRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("hello");
        response.sendRedirect("www.baidu.com");
        System.out.println("world");
        return "redirect:www.baidu.com";
    }


    @RequestMapping("/testMysql")
    @ResponseBody
    public String testMysql(){
        return "testMysql";
    }

    @RequestMapping("/testMysql1")
    @ResponseBody
    @Transactional
    public List<Map<String,Object>> testMysql1(){
        String sql="select * from sys_user";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    @RequestMapping("/testMysql2")
    @ResponseBody
    public String testMysql2(){
        SysUser sysUser = new SysUser();
        List<SysUser> list = sysUserService.selectSysUserList(sysUser);
        StringBuilder user = new StringBuilder();
        for (SysUser u:list) {
            user.append(u.toString());
        }
        return user.toString();
    }

    @RequestMapping("/testMysql3")
    @ResponseBody
    public String testMysql3(){
        SysPost sysPost = new SysPost();
        Long postId = 1L;
        List<SysPost> list = sysPostMapper.selectAllByPostId(postId);
        StringBuilder user = new StringBuilder();
        for (SysPost u:list) {
            user.append(u.toString());
        }
        return user.toString();
    }

    public void testSys(String a, int b){

    }
    public static void main(String[] args) {
        String a = "";
        List list = new ArrayList();
        list.add(6);

/*       while(b>0){

            System.out.println("t1");
        }*/
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                    synchronized (a) {
                        while((int)list.get(0)>0) {
                            int c = Integer.parseInt(list.get(0).toString());
                            System.out.println(c--);
                            list.set(0,c);
                            System.out.println("t1");
                        }
                    }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                    synchronized (a) {
                        while((int)list.get(0)>0) {
                        int c = Integer.parseInt(list.get(0).toString());
                        System.out.println(c--);
                        list.set(0,c);
                        System.out.println("t2");
                        }
                    }

            }
        });
        t1.start();
        t2.start();
    }





}
