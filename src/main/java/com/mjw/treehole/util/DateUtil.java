package com.mjw.treehole.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author mengjw
 */
public class DateUtil {

    /**
     * 获取当前的时间
     *
     * @return
     */
    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
        return sdf.format(new Date());
    }

}
