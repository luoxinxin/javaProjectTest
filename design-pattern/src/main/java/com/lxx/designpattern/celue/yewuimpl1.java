package com.lxx.designpattern.celue;

import java.util.HashMap;
import java.util.Map;

public class yewuimpl1 extends AbstractYewu {
    @Override
    public boolean support(RequestInterface req) {
        return true;
    }

    @Override
    public Map<String, String> getDate() {
        return new HashMap<>();
    }
}
