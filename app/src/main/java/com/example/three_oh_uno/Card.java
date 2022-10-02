package com.example.three_oh_uno;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Card {
    private float x,y;
    private float width;
    private float length;
    private Paint paint;
    private Paint strokePaint;
    private Paint mainLabelPaint;
    private Paint miniLabelPaint;
    private CardColor cardColor;
    private int cardNumber; // TODO: Designate 10, 11, 12, 13, 14 to +2, +4, Switch, Skip, and Wildcard
                            // Possible: If number is negative, designate card is an enemy's deck?
    public Card()
    {
        x = y = 300;
        width = 200;
        length = 300;
        paint = new Paint();
        strokePaint = new Paint();
        mainLabelPaint = new Paint();
        miniLabelPaint = new Paint();

        paint.setARGB(255, 0, 0, 0);
        strokePaint.setColor(Color.WHITE);
        strokePaint.setStyle(Paint.Style.STROKE);
        mainLabelPaint.setColor(Color.WHITE);
        mainLabelPaint.setTextSize(width/2);
        miniLabelPaint.setColor(Color.WHITE);
        miniLabelPaint.setTextSize(width/4);
        mainLabelPaint.setTextAlign(Paint.Align.CENTER);
        miniLabelPaint.setTextAlign(Paint.Align.CENTER);
        cardNumber = 0;

        setCardColor(CardColor.CARD_RED);
    }

    public Card(float _x, float _y, float _width, float _length, CardColor _cardColor)
    {
        x = _x;
        y = _y;
        width = _width;
        length = _length;
        cardColor = _cardColor;
    }
    /* DrawRect, by default, takes the distance of the left edge from the left edge of the canvas
    and vice-versa for the coordinates, instead of from a center point like drawCircle.
    By doing it this way, dividing our width and length by 2, we can define a card as the x,y center point
    and it's a little nicer to deal with
     */
    public void draw(Canvas canvas){
        float left = x-width/2;
        float right = x+width/2;
        float top = y-length/2;
        float bottom = y+length/2;
        strokePaint.setStrokeWidth(width/10);
        canvas.drawRect(left, top, right, bottom, paint);
        canvas.drawRect(left, top, right, bottom, strokePaint);
        strokePaint.setStrokeWidth(width/20);
        canvas.save();
        canvas.rotate(45, x, y);
        float ovalLeft = (float)(x-width*(0.375));
        float ovalRight = (float)(x+width*(0.375));
        float ovalTop = (float)(y-length*(0.4));
        float ovalBottom = (float)(y+length*(0.4));
        canvas.drawOval(ovalLeft, ovalTop, ovalRight, ovalBottom, strokePaint);
        canvas.restore();
        drawCardNumber(canvas);

    }

    public void setCenter(float _x, float _y)
    {
        x = _x;
        y = _y;
    }

    public void setCardColor(CardColor _cardColor)
    {
        cardColor = _cardColor;
        switch(cardColor)
        {
            case CARD_NULL: case CARD_BLACK:
                paint.setARGB(255, 0, 0,0);
                break;
            case CARD_RED:
                paint.setColor(0xFFC40C00);
                break;
            case CARD_BLUE:
                paint.setColor(0xFF0849A3);
                break;
            case CARD_GREEN:
                paint.setColor(0xFF358716);
                break;
            case CARD_YELLOW:
                paint.setColor(0xFFE5D30C);
                break;
        }
    }

    public void drawCardNumber(Canvas canvas)
    {
        float mainTextY = y - (mainLabelPaint.descent() + mainLabelPaint.ascent()) / 2;
        float miniTextY = y - (miniLabelPaint.descent() + miniLabelPaint.ascent()) / 2;
        if(cardNumber < 10 && cardNumber >= 0)
        {
            canvas.drawText(String.valueOf(cardNumber), x, mainTextY, mainLabelPaint);
            canvas.drawText(String.valueOf(cardNumber), (float)(x-width*0.35), (float)(miniTextY-length*0.35), miniLabelPaint);
            canvas.drawText(String.valueOf(cardNumber), (float)(x+width*0.35), (float)(miniTextY+length*0.35), miniLabelPaint);
        }
        // if(cardNumber > 10)

    }

    public void setLengthWidth(int _length, int _width)
    {
        length = _length;
        width = _width;
    }


}
