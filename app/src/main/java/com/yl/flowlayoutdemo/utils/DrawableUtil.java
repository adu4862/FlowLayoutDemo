package com.yl.flowlayoutdemo.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class DrawableUtil {
    /**
     * 生成圆角图片
     * @param rgb 图片颜色
     * @param radius 图片角度
     * @return Drawable对象
     */
    public static Drawable generateDrawable(int rgb,float radius){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(rgb);
        drawable.setCornerRadius(radius);
        return drawable;
    }

    /**
     * 代码动态生成选择器
     * @param pressed 按下的图片
     * @param normal 默认的图片
     * @return 选择器
     */
    public static Drawable generateSelector(Drawable pressed,Drawable normal){
        StateListDrawable drawable = new StateListDrawable();
        //设置按下的图片
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        //设置默认的图片
        drawable.addState(new int[]{}, normal);
        //设置选择器过度动画(sdk10以上才可以是动画生效)
        if (Build.VERSION.SDK_INT>10) {
            drawable.setEnterFadeDuration(300);
            drawable.setExitFadeDuration(300);
        }
        return drawable;

    }
}
