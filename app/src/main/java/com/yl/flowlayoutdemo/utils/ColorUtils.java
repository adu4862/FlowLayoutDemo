package com.yl.flowlayoutdemo.utils;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class ColorUtils {
    /**
     *
     * @return 返回一个随机的颜色int值(不能太灰)
     */
    public static int randomColr(){
        Random random = new Random();
        int r = random.nextInt(180);
        int g = random.nextInt(180);
        int b = random.nextInt(180);
        return Color.rgb(r, g, b);
    }
}
