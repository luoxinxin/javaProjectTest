package com.luoxinxin.commons;

import com.luoxinxin.bean.Hand;
import com.luoxinxin.bean.Person;
import org.apache.commons.lang3.SerializationUtils;

public class DeepCopy {
    public static void main(String[] args) {
        Person source = new Person();
        source.setName("jj");
        source.setAge(11);
        source.setHand(new Hand().setSize(12));

        // 使用 BeanUtilsBean 实现深拷贝
//        BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();

        try {
//            Person target = (Person) beanUtilsBean.cloneBean(source);
            Person target = SerializationUtils.clone(source);


            // 修改目标对象的属性
            target.getHand().setSize(11);

            // 输出源对象和目标对象的属性值
            System.out.println("源对象: " + source);
            System.out.println("目标对象: " + target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
