package com.lxx.designpattern.proxy.demo;

interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
}

class BankAccountImpl implements BankAccount {
    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

class BankAccountProxy implements BankAccount {
    private BankAccount bankAccount;


    public BankAccountProxy(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void deposit(double amount) {
        // 检查调用者是否具有管理员权限
        if (!isAdmin()) {
            throw new SecurityException("Access denied. Only administrators can deposit.");
        }
        // 记录日志
        System.out.println("Logging deposit: " + amount);
        bankAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        // 检查调用者是否具有足够的余额
        double balance = 100;//外部传入值
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        // 记录日志
        System.out.println("Logging withdraw: " + amount);
        bankAccount.withdraw(amount);
    }

    private boolean isAdmin() {
        // 模拟检查管理员权限的逻辑
        // 可以根据实际情况进行实现
        return true;
    }
}

public class AccessControlExample {
    public static void main(String[] args) {
        // 创建原始的银行账户对象
        BankAccountImpl bankAccount = new BankAccountImpl();

        // 创建代理对象，并将银行账户对象传递给它
        BankAccountProxy proxy = new BankAccountProxy(bankAccount);

        // 尝试通过代理进行存款操作（只有管理员可以）
        try {
            proxy.deposit(1000);
        } catch (SecurityException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }

        // 尝试通过代理进行取款操作（需要足够的余额）
        try {
            proxy.withdraw(500);
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }
}
