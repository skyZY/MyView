package com.syp.myview.view3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import java.util.Random;

/**
 * Created by Administrator on 2015/10/4.
 */
public class LogicView extends BaseView {


    private float rX = 0 ;

    private RectF rectF = new RectF(50, 60, 150,160);
    private  float sweepAngle = 0;

    int r;
    int g;
    int b;

    public LogicView(Context context){
        super(context);
    }

    public LogicView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
    @Override
    protected void logic() {
        Random random = new Random();
        rX += 3;
        if(rX > getWidth()){
            rX = 0 - paint.measureText("LogicView");
        }

        sweepAngle ++;
        if(sweepAngle > 360){
            sweepAngle = 0;
        }
        r = random.nextInt(256);
        g = random.nextInt(256);
        b = random.nextInt(256);
        paint.setARGB(255, r, g ,b);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        paint.setTextSize(40);
        canvas.drawText("LogicView", rX, 30, paint);
        canvas.drawArc(rectF, 0, sweepAngle, true, paint);
    }
}
