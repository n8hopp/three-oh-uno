package com.example.three_oh_uno;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class HandView extends SurfaceView {

    public static final int cardHeight = 300;
    public static final int cardWidth = 200;
    public static final int cardBorder = 25;
    public static final int cardSpacing = 30;
    public static final int xOffset = 500;
    public static final int yOffset = 50;

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

        for (int i = 0; i < 6; i ++) {
            canvas.drawRect( xOffset + i * (cardSpacing + cardWidth),
                    yOffset,
                    xOffset + i * (cardSpacing + cardWidth) + cardWidth,
                    yOffset + cardHeight, cardBorderPaint);

            canvas.drawRect(xOffset + i * (cardSpacing + cardWidth) + cardBorder,
                    yOffset + cardBorder,
                    xOffset + i * (cardSpacing + cardWidth) + cardWidth - cardBorder,
                    yOffset + cardHeight - cardBorder, cardPaint);
        }
    }
}
