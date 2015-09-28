package com.azhuoinfo.cqurity.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

import com.azhuoinfo.cqurity.R;

import java.util.jar.Attributes;

public class HistroyView extends View {
	private Paint cir,rect;
	private boolean isShowRect = true;
	
	public HistroyView(Context context , AttributeSet attributes) {
		super(context ,attributes);
		cir = new Paint();
		rect = new Paint();
		cir.setAntiAlias(true);
		cir.setStyle(Style.FILL);
		cir.setColor(getResources().getColor(R.color.circle_color));
		rect.setAntiAlias(true);
		rect.setStyle(Style.FILL);
		rect.setColor(Color.GRAY);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(isShowRect){
			canvas.drawRect(19, 0+10,21,getHeight(),rect);
		}
		canvas.drawCircle(20, 10, 10, cir);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	public void setShowRect(boolean isShowRect ){
		this.isShowRect = isShowRect;
	}
}
