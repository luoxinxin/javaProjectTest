package com.lxx.spb2hotdev.trascation;

import redis.clients.jedis.Jedis;

import java.util.UUID;

public class Coordinator {
    private final Jedis jedis = new Jedis("localhost");

    public void executeBusinessLogic() {
        String transactionId = UUID.randomUUID().toString();

        // 事务开始
        startTransaction(transactionId);

        try {
            // 模拟业务逻辑
            System.out.println("Executing business logic...");

            // 向所有参与者发送准备请求
            boolean allParticipantsReady = prepareParticipants(transactionId);

            // 根据参与者的响应决定是否提交或回滚
            if (allParticipantsReady) {
                commitTransaction(transactionId);
            } else {
                abortTransaction(transactionId);
            }
        } catch (Exception e) {
            // 发生异常时回滚事务
            abortTransaction(transactionId);
            e.printStackTrace();
        }
    }

    private void startTransaction(String transactionId) {
        // 记录事务开始
        jedis.set(transactionId, "STARTED");
    }

    private boolean prepareParticipants(String transactionId) {
        // 向所有参与者发送准备请求
        for (Participant participant : getParticipants()) {
            participant.prepare(transactionId);
        }

        // TODO: 根据参与者的响应判断是否所有参与者都准备就绪
        return true;
    }

    private void commitTransaction(String transactionId) {
        // 向所有参与者发送提交请求
        for (Participant participant : getParticipants()) {
            participant.commit(transactionId);
        }

        // 最终提交事务
        jedis.set(transactionId, "COMMITTED");
    }

    private void abortTransaction(String transactionId) {
        // 向所有参与者发送回滚请求
        for (Participant participant : getParticipants()) {
            participant.abort(transactionId);
        }

        // 最终回滚事务
        jedis.set(transactionId, "ABORTED");
    }

    private Participant[] getParticipants() {
        // 返回所有参与者
        return new Participant[]{new Participant("PARTICIPANT1"), new Participant("PARTICIPANT2")};
    }
}

