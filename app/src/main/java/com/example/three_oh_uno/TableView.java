package com.example.three_oh_uno;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class TableView extends SurfaceView {

	private final Paint cardPaint;
	private final Paint textPaint;
	private final Paint textPaint2;
	private final Paint tableColor;
	private final Paint arrowPaint;

	private Paint faceUp;
	private Path arrowPath;
	private int canvasWidth;
	private int canvasHeight;
	private int halfCardWidth;
	private int halfCardHeight;


	public TableView(Context context, AttributeSet attrs) {
		super(context, attrs);

		setWillNotDraw(false);

		cardPaint = new Paint();
		textPaint = new Paint();
		arrowPaint = new Paint();
		faceUp = new Paint();
		tableColor = new Paint();
		textPaint2 = new Paint();

		cardPaint.setARGB(255, 0, 0, 0); // Set default color of black face down uno card
		textPaint.setARGB(255, 255, 255, 255); // Text color white
		textPaint2.setARGB(255,255,255,255);

		tableColor.setARGB(255, 66, 143, 70);
		tableColor.setStyle(Paint.Style.FILL);

		arrowPaint.setARGB(255, 0, 255, 255);
		arrowPaint.setStyle(Paint.Style.FILL);
		arrowPath = new Path();

		faceUp.setColor(0xFFFF0000);  //red

		cardPaint.setTextAlign(Paint.Align.CENTER);
		textPaint.setTextAlign(Paint.Align.CENTER);

		textPaint2.setTextSize(100); // Only text this paint uses currently is the number on top of face up card
		textPaint2.setFakeBoldText(true);
		textPaint.setTextSize(45);

		// paint2.setTextSize(paint1.getTextSize());
					// Lukas: Refactored paint1 and paint2 to have descriptive names, and be black face down cards


	}

	@Override
	protected void onDraw(Canvas canvas) {
		//Background
		canvas.drawRect(0, 0, (getWidth()), (getHeight()), tableColor);

		// Top card
		canvas.drawRect((getWidth()/2)-100, 50, (getWidth()/2)+100, 350, cardPaint);
		canvas.drawText("3 cards", (getWidth()/2), 200, textPaint);

		// Left card
		canvas.drawRect(50, (getHeight()/2)-100, 350, (getHeight()/2)+100, cardPaint);
		canvas.drawText("4 cards", 200, (getHeight()/2)+5, textPaint);

		// Right card
		canvas.drawRect((getWidth()-350), (getHeight()/2)-100, (getWidth()-50), (getHeight()/2)+100, cardPaint);
		canvas.drawText("6 cards", (getWidth()-200), (getHeight()/2)+5, textPaint);

		// Face up middle card
		canvas.drawRect((getWidth()/2)+25,  (getHeight()/2)-150, (getWidth()/2)+225, (getHeight()/2)+150, cardPaint); //
				// Lukas: Added 30 pixel border to match HandView
		canvas.drawRect((getWidth()/2)+25+25,  (getHeight()/2)-150+25, (getWidth()/2)+225-25, (getHeight()/2)+150-25, faceUp);
				// Draw big number on card

		canvas.drawText("7", getWidth()/2 + 100, getHeight()/2 +30 , textPaint2);


		// Face down middle card
		canvas.drawRect((getWidth()/2)-225,  (getHeight()/2)-150, (getWidth()/2)-25, (getHeight()/2)+150, cardPaint);

		/* Nate:
			This is all godawful. Please make this dynamic ASAP. I cannot deal with manually
			adjusting text location 5 pixels at a time. God save me.
		 */

		// Draw an arrow in front of hand
		arrowPath.moveTo(getWidth()/2, (getHeight()/8)*7); // Beginning location center of 3/4 down the screen
		arrowPath.lineTo(getWidth()/2 - 60, (getHeight()/8)*7); // Tip of arrow pointing left
		arrowPath.lineTo(getWidth()/2 - 20, (getHeight()/8)*7 - 20);
		arrowPath.lineTo(getWidth()/2 - 20, (getHeight()/8)*7 - 10);
		arrowPath.lineTo(getWidth()/2 + 60, (getHeight()/8)*7 - 10);
		arrowPath.lineTo(getWidth()/2 + 60, (getHeight()/8)*7 + 10);

		arrowPath.lineTo(getWidth()/2 - 20, (getHeight()/8)*7 + 10);
		arrowPath.lineTo(getWidth()/2 - 20, (getHeight()/8)*7 + 20);
		arrowPath.lineTo(getWidth()/2 - 60, getHeight()/8*7); // Tip of arrow pointing left
		canvas.drawPath(arrowPath, arrowPaint);

		arrowPath.reset();

	}
}
