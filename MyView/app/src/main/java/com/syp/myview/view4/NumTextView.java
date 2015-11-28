package com.syp.myview.view4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.syp.myview.R;

/**
 * Created by Administrator on 2015/10/4.
 */
public class NumTextView extends BaseView {

    Paint paint = new Paint();

    private float textSize = 0;
    private int line = 0;
    private float mX = 0;
    private boolean xScroll = false;


    public NumTextView(Context context) {
        super(context);
    }

    public NumTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.NumTextView);
        line = typedArray.getInt(R.styleable.NumTextView_lineNum, 1);
        xScroll = typedArray.getBoolean(R.styleable.NumTextView_xScroll, false);
        typedArray.recycle();
    }


    @Override
    protected void drawSub(Canvas canvas) {
        for(int i = 0; i< line ; i++){
            textSize = 30 + i;
            paint.setTextSize(textSize);
            canvas.drawText("极客学院", mX, textSize + textSize * i, paint);
        }
    }

    @Override
    protected void logic() {
        if(xScroll){
            mX += 3;
            if(mX > getWidth()){
                mX = - paint.measureText("极客学院");
            }
        }
    }
}
