package com.syp.myview.view2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Administrator on 2015/10/4.
 */
public class LogicView extends View {
    Paint paint = new Paint();
    private float rX;
    private Mythread mythread;
    private RectF rectF = new RectF(50, 60, 150,160);
    private  float sweepAngle = 0;

    int r;
    int g;
    int b;


    public LogicView(Context context){
        super(context);
    }

    public LogicView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTextSize(40);
        canvas.drawText("LogicView", rX, 30, paint);

        canvas.drawArc(rectF,0, sweepAngle, true, paint);

       if(null == mythread){
          mythread = new Mythread();
           mythread.start();
       }

    }

    class Mythread extends Thread{
        Random random = new Random();
        @Override
        public void run() {
            super.run();

            while (true){
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
                postInvalidate();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
