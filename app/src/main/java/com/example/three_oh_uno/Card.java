package com.example.three_oh_uno;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Card {
    private float x,y;
    private float width;
    private float length;
    private Paint paint;
    private CardColor cardColor;

    public Card()
    {
        x = y = 0;
        width = 200;
        length = 300;
        paint = new Paint();
        paint.setARGB(255, 0, 0, 0);
        cardColor = CardColor.CARD_NULL;
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

        canvas.drawRect(left, top, right, bottom, paint);
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
                paint.setColor(0xC40C00);
                break;
            case CARD_BLUE:
                paint.setColor(0x0849A3);
                break;
            case CARD_GREEN:
                paint.setColor(0x358716);
                break;
            case CARD_YELLOW:
                paint.setColor(0xE5D30C);
                break;
        }
    }


}
