package com.lxx.spb2hotdev.trascation;

public class Participant {
    private final String participantId;
//    private final Jedis jedis = new Jedis("localhost");

    public Participant(String participantId) {
        this.participantId = participantId;
    }

    public void prepare(String transactionId) {
        // 模拟事务准备操作
        System.out.println(participantId + ": Prepared for transaction " + transactionId);
    }

    public void commit(String transactionId) {
        // 模拟事务提交操作
        System.out.println(participantId + ": Committed for transaction " + transactionId);
    }

    public void abort(String transactionId) {
        // 模拟事务回滚操作
        System.out.println(participantId + ": Aborted for transaction " + transactionId);
    }
}

