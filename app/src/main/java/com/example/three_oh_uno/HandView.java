package com.example.three_oh_uno;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class HandView extends SurfaceView {

    public static final int cardHeight = 200;
    public static final int cardWidth = 120;
    public static final int cardBorder = 10;
    public static final int cardSpacing = 30;

    Paint cardPaint = new Paint();
    Paint cardBorderPaint = new Paint();
    Paint backgroundPaint = new Paint();

    private HandModel handModel;

    public HandView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);

        cardPaint.setColor(0xFFFF0000);  //red
        cardPaint.setStyle(Paint.Style.FILL);
        cardBorderPaint.setColor(0xFF000000);  //black
        cardBorderPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setColor(0xFF949494);  //gray
        backgroundPaint.setStyle(Paint.Style.FILL);

        handModel = new HandModel();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);

        int xOffset = 500;

        for (int i = 0; i < 6; i ++) {
            canvas.drawRect( xOffset + i * 130 + 10, 10, xOffset + i * 130 + cardWidth, cardHeight, cardBorderPaint);
            canvas.drawRect(xOffset + i * 130 + 20, 20, xOffset + i * 130 + cardWidth - cardBorder, cardHeight - cardBorder, cardPaint);
        }
    }
}
