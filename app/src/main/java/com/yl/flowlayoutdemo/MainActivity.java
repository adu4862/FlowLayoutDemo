package com.yl.flowlayoutdemo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yl.flowlayoutdemo.ui.FlowLayout;
import com.yl.flowlayoutdemo.utils.ColorUtils;
import com.yl.flowlayoutdemo.utils.DrawableUtil;

public class MainActivity extends AppCompatActivity {


    private int vPadding;
    private int hPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] arr = {"QQ", "视频", "放开那三国", "电子书", "酒店", "单机", "小说", "斗地主", "播放器", "捕鱼达人2", "机票", "游戏", "熊出没之熊大快跑", "美图秀秀", "QQ", "视频", "放开那三国", "电子书", "酒店", "单机", "小说", "斗地主", "播放器", "捕鱼达人2", "机票", "游戏", "熊出没之熊大快跑", "美图秀秀"};
        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.fl);
        vPadding = getDimens(R.dimen.dp8);
        hPadding = getDimens(R.dimen.dp8);
        int padding = getDimens(R.dimen.dp4);


        //第一行.设置flowLayout的padding和条目之间的距离
        flowLayout.setPaddingAndSpacing(padding, hPadding, vPadding);

        // 第二行.设置textview监听,这里用来自定义每个Textview
        flowLayout.setmTextViewListener(new FlowLayout.TextViewListener() {
            @Override
            public void settextView(final TextView textView) {
                textView.setTextSize(16);
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(Color.WHITE);
                textView.setPadding(hPadding, vPadding, hPadding, vPadding);
                //下面是代码生成的随机背景颜色选择器,不需要的小伙伴忽略就好啦,不忽略的可用看我备注,嘻嘻
                Drawable normal = DrawableUtil.generateDrawable(ColorUtils.randomColr(), hPadding);
                Drawable presed = DrawableUtil.generateDrawable(ColorUtils.randomColr(), hPadding);
                Drawable selector = DrawableUtil.generateSelector(presed, normal);
                textView.setBackgroundDrawable(selector);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        //第三行.添加数据给流布局
        flowLayout.setDataToFlowLayout(arr);


    }
    /**
     * 获取dp资源,并自动转换成px
     *
     * @param id
     * @return
     */
    private int getDimens(int id) {
        return getResources().getDimensionPixelSize(id);

    }

}
