package com.builders.cliente.utils;

public class StringUtils {

    public static String upper(String string) {
        if (string != null)
            return string.toUpperCase();
        return null;
    }

    public static String retiraMascara(String string) {
        if (string != null)
            return string.replaceAll("[^0-9]+", "");
        return null;
    }
}
