package com.syp.myview.view4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/10/4.
 */
public abstract class BaseView extends View {

    private Mythread mythread;
    Paint paint = new Paint();
    public BaseView(Context context){
        super(context);
    }

    public BaseView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    protected abstract void drawSub(Canvas canvas);{

    }

    protected abstract void logic();{

    }

    @Override
    protected final void  onDraw(Canvas canvas) {
        super.onDraw(canvas);

       if(null == mythread){
          mythread = new Mythread();
           mythread.start();
       }else{
           drawSub(canvas);
       }

    }
    private boolean running = true;

    @Override
    protected void onDetachedFromWindow() {
        running = false;
        super.onDetachedFromWindow();
    }

    class Mythread extends Thread{

        @Override
        public void run() {
            super.run();

            while (running){
                logic();
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
