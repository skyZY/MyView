package com.syp.myview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.syp.myview.R;

/**
 * Created by Administrator on 2015/10/4.
 */
public class MyView extends View {

    private Bitmap bitmap;

    public MyView(Context context){
        super(context);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }

    public MyView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setTextSize(30);
        paint.setColor(0xffff0000);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawText("this is text", 0, 30, paint);

        canvas.drawLine(0, 60, 100, 60, paint);

//        canvas.drawRect(0, 90, 100, 190, paint);

//        Rect r = new Rect(0, 120, 100, 190);
        RectF rectF = new RectF(0, 120, 100, 190);
        canvas.drawRect(rectF, paint);

        canvas.drawRoundRect(rectF, 10, 10, paint);

        canvas.drawCircle(50, 270,50,paint);


        canvas.drawBitmap(bitmap, 0 ,350, paint);

    }
}
