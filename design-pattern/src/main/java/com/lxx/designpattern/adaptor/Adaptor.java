package com.lxx.designpattern.adaptor;

// 支付接口
interface Payment {
    void pay(double amount);
}

// 支付宝支付类
class Alipay implements Payment {
    public void pay(double amount) {
        System.out.println("Using Alipay to pay: " + amount);
    }
}

// 微信支付类
class WechatPay {
    public void payment(double amount) {
        System.out.println("Using Wechat Pay to pay: " + amount);
    }
}

// 微信支付适配器
class WechatPayAdapter implements Payment {
    private WechatPay wechatPay;

    public WechatPayAdapter(WechatPay wechatPay) {
        this.wechatPay = wechatPay;
    }

    public void pay(double amount) {
        wechatPay.payment(amount);
    }
}

// 支付方式选择类
class PaymentSelector {
    private Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void pay(double amount) {
        payment.pay(amount);
    }
}

// 示例
public class Adaptor {
    public static void main(String[] args) {
        PaymentSelector paymentSelector = new PaymentSelector();

        // 使用支付宝支付
        Payment alipay = new Alipay();
        paymentSelector.setPayment(alipay);
        paymentSelector.pay(100);

        // 使用微信支付（适配器）
        WechatPay wechatPay = new WechatPay();
        Payment wechatPayAdapter = new WechatPayAdapter(wechatPay);
        paymentSelector.setPayment(wechatPayAdapter);
        paymentSelector.pay(200);
    }
}
