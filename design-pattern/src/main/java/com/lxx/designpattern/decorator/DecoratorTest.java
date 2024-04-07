package com.lxx.designpattern.decorator;

// 银行账户接口
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// 基本账户类
class BasicAccount implements BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// 利息装饰器类
class InterestDecorator implements BankAccount {
    private BankAccount account;
    private double interestRate;

    public InterestDecorator(BankAccount account, double interestRate) {
        this.account = account;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public double getBalance() {
        return account.getBalance() * (1 + interestRate);
    }
}

// 示例
public class DecoratorTest {
    public static void main(String[] args) {
        // 创建基本账户
        BankAccount basicAccount = new BasicAccount();
        basicAccount.deposit(1000);
        System.out.println("Balance in basic account: " + basicAccount.getBalance()); // 输出：1000.0

        // 添加利息功能
        BankAccount accountWithInterest = new InterestDecorator(basicAccount, 0.05); // 利率为 5%
        System.out.println("Balance in account with interest: " + accountWithInterest.getBalance()); // 输出：1050.0

        // 存入额外资金
        accountWithInterest.deposit(500);
        System.out.println("Balance in account with interest after deposit: " + accountWithInterest.getBalance()); // 输出：1575.0

        // 取出部分资金
        accountWithInterest.withdraw(200);
        System.out.println("Balance in account with interest after withdrawal: " + accountWithInterest.getBalance()); // 输出：1372.5
    }
}

