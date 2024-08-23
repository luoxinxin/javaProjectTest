package com.lxx.designpattern.celue;

import java.util.Map;

/**
 * 工厂+策略+模版
 * 这里是模版模式的使用
 */
public abstract class AbstractYewu implements yewuInterface {

    @Override
    public void excute(RequestInterface req) {
        getDate();
    }

    public abstract Map<String, String> getDate();
}
