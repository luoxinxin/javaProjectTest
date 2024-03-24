package com.luoxinxin.threadLocal;

/**
 * 将threadLocal 定义为static final 共享的
 */
public class ThreadLocalStaticFinalTest {
    private static final ThreadLocal<String> sharedThreadLocal = new ThreadLocal<>();

    public void setThreadLocalValue(String value) {
        sharedThreadLocal.set(value);
    }

    public String getThreadLocalValue() {
        return sharedThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalStaticFinalTest instance1 = new ThreadLocalStaticFinalTest();
        ThreadLocalStaticFinalTest instance2 = new ThreadLocalStaticFinalTest();

        instance1.setThreadLocalValue("Value from Instance 1");
        instance2.setThreadLocalValue("Value from Instance 2");

        // Both instances share the same ThreadLocal object
        System.out.println("Instance 2 Value: " + instance2.getThreadLocalValue()); // Output: Instance 2 Value: Value from Instance 2
        System.out.println("Instance 1 Value: " + instance1.getThreadLocalValue()); // Output: Instance 2 Value: Value from Instance 2
    }
}

