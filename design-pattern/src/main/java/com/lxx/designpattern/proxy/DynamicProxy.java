package com.lxx.designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk实现动态代理
 */
public class DynamicProxy {

    public static void main(String[] args) {
        cglibTest();
        System.out.println("-----分割线-----");
        jdkTest();
    }

    private static void cglibTest() {
        CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        UserServiceImpl proxyImp = (UserServiceImpl)proxy.getProxy(UserServiceImpl.class);
        proxyImp.add();
    }

    private static void jdkTest(){
        UserService service = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        UserService proxy = (UserService) handler.getProxy();
        proxy.add();
    }


}

interface UserService {
    default void add() {}
}

class UserServiceImpl implements UserService {
    @Override
    public void add() {// TODO Auto-generated method stub
        System.out.println("--------------------add----------------------");
    }
}

/**
 * jdk动态代理
 */
class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        PerformanceMonior.begin(target.getClass().getName()+"."+method.getName());
        System.out.println("-----------------begin "+method.getName()+"-----------------");
        Object result = method.invoke(target, args);
        System.out.println("-----------------end "+method.getName()+"-----------------");
//        PerformanceMonior.end();
        return result;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}


/**
 * cglib动态代理
 */
class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //实现 MethodInterceptor 接口方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("前置代理");
        //通过代理类调用父类中的方法
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("后置代理");
        return result;
    }
}

