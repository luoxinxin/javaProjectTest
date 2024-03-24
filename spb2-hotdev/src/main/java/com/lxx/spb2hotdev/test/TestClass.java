package com.lxx.spb2hotdev.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServlet;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestClass {


    public abstract class Worker {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public abstract int workTime();
    }

    public class Test{

        public  void test(Worker worker){
            System.out.println(worker.getName() + worker.workTime());
        }
        public void main(String[] args) {
            Test test = new Test();
            test.test(new Worker() {
                @Override
                public int workTime() {
                    return 10;
                }
                public String getName() {
                    return "worker";
                }
            });
        }
    }

    public static void main(String[] args) {
//        BeanFactory;
//        XmlBeanFactory;
//        ApplicationContext;
//        HttpServlet;
//        InputStreamReader;
        BigDecimal divide = new BigDecimal("279000").subtract(new BigDecimal("237000")).divide(new BigDecimal("279000"), 4, RoundingMode.DOWN);
        System.out.println();
        BigDecimal bigDecimal = new BigDecimal("0.15");
        System.out.println(bigDecimal.compareTo(divide));
    }

//
//279000
//237000

}
