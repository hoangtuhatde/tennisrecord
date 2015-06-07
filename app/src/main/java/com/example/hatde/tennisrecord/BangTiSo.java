package com.example.hatde.tennisrecord;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Saturn on 6/3/2015.
 */
public class BangTiSo extends LinearLayout {

    BoardInfo boardInfo;

    //int background_color = Color.WHITE;
    //int line_color = Color.parseColor("#088da5");
    private View convertView;
    private Paint mPaint;
    public int mFontSize = 12;

    private LayoutInflater inflater;
    private int mWidth = 700;
    private int mHeight = 200;
    public BangTiSo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }
    public BangTiSo(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);


        /*// Then allow overrides from XML
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.BangTiSo,
                0, 0);

        try {
            //background_color = a.getColor(R.styleable.BangTiSo_background_color, Color.WHITE);
            //line_color = a.getColor(R.styleable.BangTiSo_line_color, Color.BLUE);

        } finally {
            a.recycle();
        }*/


    }
    //@Override
    //protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //setMeasuredDimension(mWidth, mHeight);

    //}
    public BangTiSo(Context context) {
        super(context);
        initializeViews(context);

    }

    private void initializeViews(Context context) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.matchboard, this);

        boardInfo = new BoardInfo();
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

    //Đặt thông tin cho bảng điểm
    public void setInfo(BoardInfo info)
    {
        boardInfo = info;

        //Cập nhật lại bảng điểm
        setPlayer1(boardInfo.Player1);
        setPlayer1(boardInfo.Player2);
        setNumSet(boardInfo.numSet);
        for(int i = 0; i < boardInfo.player1_score.size();i++)
        {
            setScore(1, i + 1, boardInfo.player1_score.get(i));
        }
        for(int j = 0; j < boardInfo.player2_score.size();j++)
        {
            setScore(2, j + 1, boardInfo.player2_score.get(j));
        }
    }
    //Đặt tên cho player1
    public void setPlayer1(String name)
    {
        TextView player1 = (TextView)convertView.findViewById(R.id.txPlayer1);
        boardInfo.Player1 = name;
        player1.setText(name);

    }
    //Đặt tên cho player2
    public void setPlayer2(String name)
    {
        TextView player2 = (TextView)convertView.findViewById(R.id.txPlayer2);
        boardInfo.Player2 = name;
        player2.setText(name);
    }
    //Đặt số set trận đấu
    public boolean setNumSet(int set)
    {
        if(boardInfo.numSet == set)//nếu ko thay đổi
        {
            return true;
        }
        if(set <= 0 || set > 6)//vượt quá số set
        {
            return false;
        }
        boardInfo.numSet = set;

        //Cài lại player 1
        TableRow row1 = (TableRow)convertView.findViewById(R.id.csrow1);
        row1.removeAllViews();

        TextView temp_player1 = (TextView)inflater.inflate(R.layout.tvplayer_layout, null);
        temp_player1.setId(R.id.txPlayer1);
        row1.addView(temp_player1);
        setPlayer1(boardInfo.Player1);
        for(int i =0; i < boardInfo.numSet; i++)
        {
            TextView v = (TextView)inflater.inflate(R.layout.tvscore_layout, null);
            row1.addView(v);
        }

        //Cài lại player 2
        TableRow row2 = (TableRow)convertView.findViewById(R.id.csrow2);
        row2.removeAllViews();

        TextView temp_player2 = (TextView)inflater.inflate(R.layout.tvplayer_layout, null);
        temp_player2.setId(R.id.txPlayer2);
        row2.addView(temp_player2);
        setPlayer2(boardInfo.Player2);
        for(int i =0; i < boardInfo.numSet; i++)
        {
            TextView v = (TextView)inflater.inflate(R.layout.tvscore_layout, null);
            row2.addView(v);
        }
        return true;
    }

    //Ghi điểm
    public void setScore(int player, int set, String score)
    {
        //KT input
        if(player != 1 && player != 2)
        {
            return;
        }
        if(set <= 0 || set > boardInfo.numSet)
        {
            return;
        }

        if(player == 1)
        {
            boardInfo.player1_score.set(set - 1, score);
        }
        else if(player == 2)
        {
            boardInfo.player2_score.set(set - 1, score);
        }

        //Lấy TextView
        TableLayout tableLayout = (TableLayout) convertView.findViewById(R.id.cstable);
        TableRow row =  (TableRow)tableLayout.getChildAt(player-1);
        TextView setScore = (TextView) row.getChildAt(set);

        //Ghi điểm
        setScore.setText(score);
    }
    //Ghi điểm
    public void setScore(int player, int set, String score, boolean istemp)
    {
        if(!istemp)
        {
            return;
        }
        //KT input
        if(player != 1 && player != 2)
        {
            return;
        }
        if(set <= 0 || set > boardInfo.numSet)
        {
            return;
        }

        //Lấy TextView
        TableLayout tableLayout = (TableLayout) convertView.findViewById(R.id.cstable);
        TableRow row =  (TableRow)tableLayout.getChildAt(player-1);
        TextView setScore = (TextView) row.getChildAt(set);

        //Ghi điểm
        setScore.setText(score);
        setScore.setBackgroundColor(Color.BLACK);
        setScore.setTextColor(Color.YELLOW);
    }
}
