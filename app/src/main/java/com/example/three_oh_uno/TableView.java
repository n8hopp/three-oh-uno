package com.example.three_oh_uno;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class TableView extends SurfaceView {

	private final Paint paint1;
	private final Paint paint2;
	private final Paint tableColor;
	private int canvasWidth;
	private int canvasHeight;
	private int halfCardWidth;
	private int halfCardHeight;
	public TableView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint1 = new Paint();
		paint2 = new Paint();
		tableColor = new Paint();
		paint1.setARGB(255, 255, 255, 255);
		paint2.setARGB(255, 255, 0, 0); // Two separate colors to differentiate stacked rectangles if the rectangles are stacked
												   // or to make text on cards the opposite color
		tableColor.setARGB(255, 50, 255, 50);
		tableColor.setStyle(Paint.Style.FILL);

		paint1.setTextAlign(Paint.Align.CENTER);
		paint2.setTextAlign(Paint.Align.CENTER);

		paint1.setTextSize(20);
		paint2.setTextSize(paint1.getTextSize());

	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawRect(0, 0, (getWidth()), (getHeight()), tableColor);
		canvas.drawRect((getWidth()/2)-50, 50, (getWidth()/2)+50, 200, paint1);
		canvas.drawText("3 cards", (getWidth()/2), 130, paint2);
		canvas.drawRect(50, (getHeight()/2)-50, 200, (getHeight()/2)+50, paint2);
		canvas.drawText("4 cards", 125, (getHeight()/2)+5, paint1);
		canvas.drawRect((getWidth()-200), (getHeight()/2)-50, (getWidth()-50), (getHeight()/2)+50, paint1);
		canvas.drawText("6 cards", (getWidth()-125), (getHeight()/2)+5, paint2);
		canvas.drawRect((getWidth()/2)+25,  (getHeight()/2)-75, (getWidth()/2)+125, (getHeight()/2)+75, paint2);
		canvas.drawRect((getWidth()/2)-125,  (getHeight()/2)-75, (getWidth()/2)-25, (getHeight()/2)+75, paint1);

		/* Nate:
			This is all godawful. Please make this dynamic ASAP. I cannot deal with manually
			adjusting text location 5 pixels at a time. God save me.
		 */

	}
}
