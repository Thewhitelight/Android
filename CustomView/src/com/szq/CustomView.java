package com.szq;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;

public class CustomView extends View {
	private Paint paint;

	public CustomView(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		paint = new Paint();
	}

	public CustomView(Context context, AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		super(context, attrs);
		paint = new Paint();
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.CustomView);
		int textColor = ta.getColor(R.styleable.CustomView_textColor, 0xFFFFFF);
		float textSize = ta.getDimension(R.styleable.CustomView_textSize, 20);
		paint.setTextSize(textSize);
		paint.setColor(textColor);
		ta.recycle();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint.setStyle(Style.FILL);

		paint.setColor(Color.BLUE);

		canvas.drawText("自定义View", 100, 100, paint);
	}
	/*
	 * format可以自定义的属性 
	 * reference 
	 * string 
	 * color 
	 * dimension 
	 * boolean 
	 * integer 
	 * float
	 * fraction 
	 * enum 
	 * flag
	 */
}
