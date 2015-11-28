package com.syp.myview.view3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2015/10/4.
 */
public class MyText extends BaseView {

    Paint paint = new Paint();
    private float rx = 0;

    public MyText(Context context) {
        super(context);
    }

    public MyText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }


    @Override
    protected void drawSub(Canvas canvas) {
        paint.setTextSize(60);
        canvas.drawText("MyText", rx, 160,  paint);
    }

    @Override
    protected void logic() {
        rx += 3;
        if(rx > getWidth()){
            rx = 0 - paint.measureText("MyText");
        }
    }
}
