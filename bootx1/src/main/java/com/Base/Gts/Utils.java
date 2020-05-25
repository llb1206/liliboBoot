package com.Base.Gts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Utils {

    public static String nowTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String Uuid() {

        ConcurrentHashMap a = new ConcurrentHashMap();
        return UUID.randomUUID().toString();
    }
}
