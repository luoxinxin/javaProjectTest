package com.lxx.bill.enumbean;


/**
 * @Author husky
 * @Date 2022/3/15 13:23
 * @Description: 指定字符串转指定数字枚举类
 **/
public enum StringToIntegerConverterEnum {

    /**
     * 中文是
     */
    CHINESE_YES("是",1,"中文是"),

    /**
     * 中文否
     */
    CHINESE_NO("否",2,"中文否"),

    /**
     * 小写英文是
     */
    LOWERCASE_ENGLISH_YES("yes",2,"小写英文是"),

    /**
     * 小写英文否
     */
    LOWERCASE_ENGLISH_NO("no",2,"小写英文否"),

    //收支状态 支出 收入 不计收支
    EX_CHINESE("支出", 0, "支出"),
    IN_CHINESE("收入", 1, "收入"),
    NOT_IN_EX_CHINESE("不计收支", 2, "不计收支"),

    //交易状态 交易成功 等待确认收货  还款成功 退款成功  交易关闭
    TRADE_STATU_SUCCESS("交易成功", 0, "交易成功"),
    TRADE_STATUS_WAIT_CONFIRM("等待确认收货", 1, "等待确认收货"),
    TRADE_STATUS_REPAY_SUCCESS("还款成功", 2, "还款成功"),
    TRADE_STATUS_REFUND_SUCCESS("退款成功", 3, "退款成功"),
    TRADE_STATUS_CLOSE("交易关闭", 4, "交易关闭"),

    trade_type_0("日用百货", 0, "日用百货"),
    trade_type_1("投资理财", 1, "投资理财"),
    trade_type_2("餐饮美食", 2, "餐饮美食"),
    trade_type_3("转账红包", 3, "转账红包"),
    trade_type_4("收入", 4, "收入"),
    trade_type_5("信用借还", 5, "信用借还"),
    trade_type_6("其他", 6, "其他"),
    trade_type_7("退款", 7, "退款"),
    trade_type_8("生活服务", 8, "生活服务"),
    trade_type_9("数码电器", 9, "数码电器"),
    trade_type_10("交通出行", 10, "交通出行"),
    trade_type_11("服饰装扮", 11, "服饰装扮"),
    trade_type_12("运动户外", 12, "运动户外"),
    trade_type_13("文化休闲", 13, "文化休闲"),
    trade_type_14("美容美发", 14, "美容美发"),
    trade_type_15("住房物业", 15, "住房物业"),
    trade_type_16("爱车养车", 16, "爱车养车"),
    trade_type_17("账户存取", 17, "账户存取"),
    trade_type_18("充值缴费", 18, "充值缴费"),
    trade_type_19("医疗健康", 19, "医疗健康"),
    trade_type_20("商业服务", 20, "商业服务"),
    trade_type_21("家居家装", 21, "家居家装"),
    trade_type_22("酒店旅游", 22, "酒店旅游"),
    ;

    /**
     * 带转换的字符串
     */
    private String key;

    /**
     * 带转换的字符串
     */
    private Integer value;

    /**
     * 备注，便于阅读
     */
    private String remark;

    /**
     * 私有构造,防止被外部调用
     * @param key 带转换的字符串
     * @param value 字符串转换的数字
     * @param remark 备注，便于阅读
     */
    private StringToIntegerConverterEnum(String key, int value,String remark){
        this.key=key;
        this.value=value;
        this.remark = remark;
    }

    /**
     * 获取键[带转换的字符串]
     * @return
     */
    public String getKey(){
        return this.key;
    }

    /**
     * 获取值[字符串转换的数字]
     * @return
     */
    public int getValue(){
        return this.value;
    }
}