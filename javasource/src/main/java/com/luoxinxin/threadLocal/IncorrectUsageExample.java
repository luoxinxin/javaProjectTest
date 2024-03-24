package com.luoxinxin.threadLocal;

public class IncorrectUsageExample {
    private final ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private final ThreadLocal<String> threadLocal2 = new ThreadLocal<>();


    public void setThreadLocalValue(String value1, String value2) {
        threadLocal1.set(value1);
        threadLocal2.set(value2);
    }

    public String getThreadLocalValue() {
        return "ThreadLocal1: " + threadLocal1.get() + ", ThreadLocal2: " + threadLocal2.get();
    }

    public static void main(String[] args) {
        IncorrectUsageExample instance1 = new IncorrectUsageExample();

        instance1.setThreadLocalValue("Value1 from Instance 1", "Value2 from Instance 1");

        // Each instance has its own ThreadLocal objects
        System.out.println("Instance 1 Values: " + instance1.getThreadLocalValue());
        // Output: Instance 2 Values: ThreadLocal1: null, ThreadLocal2: null
    }
}
