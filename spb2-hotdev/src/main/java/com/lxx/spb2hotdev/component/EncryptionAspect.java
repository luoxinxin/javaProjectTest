package com.lxx.spb2hotdev.component;

import com.lxx.spb2hotdev.annotation.DecryptField;
import com.lxx.spb2hotdev.annotation.EncryptField;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Aspect
@Component
public class EncryptionAspect {

    //返回之前进行加密
    @AfterReturning(pointcut = "@annotation(com.lxx.spb2hotdev.annotation.EncryptField)", returning = "result")
    public void encryptResponse(JoinPoint joinPoint, Object result) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        try {
            for (Field field : result.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(EncryptField.class)) {
                    field.setAccessible(true);
                    String fieldValue = (String) field.get(result);
                    //加密
//                    field.set(result, EncryptionUtils.encrypt(fieldValue));
                    field.set(result, fieldValue+"hello");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * 请求到来之前进行解密
     * @param joinPoint
     */
//    @Before("execution(* com.example.ApiController.postData(..)) && @annotation(DecryptField)")
    @Before("execution(* com.lxx.spb2hotdev.controller.TestController.*(..))")
//    @Before("@annotation(PostMapping)")
    public void decryptRequest(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            try {
                for (Field field : arg.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(DecryptField.class)) {
                        field.setAccessible(true);
                        String fieldValue = (String) field.get(arg);
                        //解密
//                        field.set(arg, EncryptionUtils.decrypt(fieldValue));
                        field.set(arg, fieldValue+"hello");
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

