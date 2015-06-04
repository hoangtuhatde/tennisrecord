package com.example.hatde.tennisrecord;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Saturn on 6/3/2015.
 */
public class BangTiSo extends LinearLayout {

    int num_set;
    String player_1 = "A";
    String player_2= "B";
    int current_player = 1;
    int background_color = Color.WHITE;
    int line_color = Color.parseColor("#088da5");

    private Paint mPaint;
    public int mFontSize = 12;

    private int mWidth = 700;
    private int mHeight = 200;
    public BangTiSo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }
    public BangTiSo(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);


        // Then allow overrides from XML
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.BangTiSo,
                0, 0);

        try {
            background_color = a.getColor(R.styleable.BangTiSo_background_color, Color.WHITE);
            line_color = a.getColor(R.styleable.BangTiSo_line_color, Color.BLUE);

        } finally {
            a.recycle();
        }

        commonSetup();
    }
    private void commonSetup() {


        mPaint = new Paint();
        mPaint.setColor(line_color);
        // Scale the desired text size to match screen density
        mPaint.setTextSize(mFontSize * getResources().getDisplayMetrics().density);
        mPaint.setStrokeWidth(2f);
        setPadding(5, 5, 5, 5);

    }
    //@Override
    //protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //setMeasuredDimension(mWidth, mHeight);

    //}
    public BangTiSo(Context context) {
        super(context);
        initializeViews(context);
        commonSetup();
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.matchboard, this);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*int top = getPaddingTop();
        int bot = mHeight - getPaddingBottom();
        int leftSide = (int) (mWidth*0.10f);
        int rightSide = (int) (mWidth*0.90f);
        Paint.Style oldStyle = mPaint.getStyle();
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(leftSide, top, rightSide, bot, mPaint);
        mPaint.setStyle(oldStyle);*/
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
}
