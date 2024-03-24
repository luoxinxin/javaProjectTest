package com.lxx.bill.constant;

public class Constants {
    /**
     * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）
     */
    public static final String[] JSON_WHITELIST_STR = { "org.springframework", "com.lxx" };

    public static final String WECHAT = "微信";
    public static final String ALIPAY = "支付宝";

    public static final String STATUS_NORMAL = "0";

    public static final String IGNORE_STATUS_NORMAL = "0";
    public static final String[] WECHAT_WHITELIST_STR = { "微信", "财付通快捷支付" };
    public static final String[] ALIPAY_WHITELIST_STR = { "支付宝", "" };
}
