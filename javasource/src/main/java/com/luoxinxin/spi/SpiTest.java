package com.luoxinxin.spi;

import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<IShort> shouts = ServiceLoader.load(IShort.class);
        for (IShort s : shouts) {
            s.shout();
        }
    }
}
