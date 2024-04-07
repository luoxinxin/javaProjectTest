package com.lxx.designpattern.celue;

import java.util.Map;

public abstract class AbstractYewu implements yewuInterface {

    @Override
    public void excute(RequestInterface req) {
        getDate();
    }

    public abstract Map<String, String> getDate();
}
