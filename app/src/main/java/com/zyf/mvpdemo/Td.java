package com.zyf.mvpdemo;

/**
 * @author zyf
 * @date 2018/1/31
 * @time 18:17
 */

public class Td<T extends Td> {
    Td mTd;

    @SuppressWarnings("uncheck")
    public static <T extends Td> T gg(T t) {
        return (T) new Td<>();
    }
}
