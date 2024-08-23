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


/**
 * 适配器的核心是 适配 适配当前所需的实现的场景
 *
 * 通过组合的方式实现适配器模式
 *
 * 适配器模式的主要目的是将一个不兼容的接口转换为另一个兼容的接口，使得原本不兼容的类可以一起工作。它关注的是接口的转换
 *
 * 在这里 微信支付是一个不兼容的支付， 需要转换成现在需要的实现方式（实现了Payment接口的）
 */
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
// 支付方式强制要求实现了 Payment接口
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
