package com.lxx.spb2hotdev.trascation;

public class TwoPhaseCommitExample {

    public static void main(String[] args) {
        // 初始化协调者和参与者
        Coordinator coordinator = new Coordinator();
        Participant participant1 = new Participant("PARTICIPANT1");
        Participant participant2 = new Participant("PARTICIPANT2");

        // 执行业务逻辑
        coordinator.executeBusinessLogic();
    }
}





