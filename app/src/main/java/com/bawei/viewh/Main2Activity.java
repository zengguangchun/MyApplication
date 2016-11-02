package com.bawei.viewh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.aa.myapplication.R;

public class Main2Activity extends View {
    private int circleColor;
    private int textColor;
    private int arcColor;
    private float textSize;
    private String  text;
    private int startAngle;
    private int width;
    private int height;
    private float mRadius;
    private Paint mArcPaint;
    private Paint mTextPaint;
    private Paint mCirclePaint;
    private RectF mRectF;
    private int sweepAngle;
    private int mCircleXY;
    public Main2Activity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    public Main2Activity(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.Main2Activity);
        if (ta != null) {
            circleColor = ta.getColor(R.styleable.Main2Activity_circleColor, 0);
            arcColor = ta.getColor(R.styleable.Main2Activity_arcColor, 0);
            textColor = ta.getColor(R.styleable.Main2Activity_textColor, 0);
            textSize = ta.getDimension(R.styleable.Main2Activity_textSize, 50);
            text = ta.getString(R.styleable.Main2Activity_text);
            startAngle = ta.getInt(R.styleable.Main2Activity_startAngle, 0);
            sweepAngle = ta.getInt(R.styleable.Main2Activity_sweepAngle, 90);
            ta.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=getWidth();
        height=getHeight();
        init();
    }

    private void init() {
        int length = Math.min(width, height);
        mCircleXY = length / 2;
        mRadius = length * 0.5f / 2;
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(circleColor);
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(arcColor);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((width * 0.1f));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(textColor);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSth(canvas);
    }

    private void drawSth(Canvas canvas) {
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mArcPaint);
        canvas.drawText(text, 0, text.length(), mCircleXY, mCircleXY + textSize
                / 4, mTextPaint);
    }
}
