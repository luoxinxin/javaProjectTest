package com.luoxinxin.service.impl;

import com.luoxinxin.service.TransactionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

/**
 * 手写事务
 * https://www.jianshu.com/p/3b9c3156b8a8
 */
@Service
public class TransactionTestServiceImpl implements TransactionTestService {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Override
    public void testTransaction() {
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            dataSourceTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }
}
