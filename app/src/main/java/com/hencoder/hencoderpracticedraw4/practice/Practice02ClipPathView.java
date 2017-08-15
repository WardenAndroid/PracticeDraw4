package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends View
{
	Paint paint = new Paint();
	Bitmap bitmap;
	Point point1 = new Point(200, 200);
	Point point2 = new Point(600, 200);

	public Practice02ClipPathView(Context context)
	{
		super(context);
	}

	public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs)
	{
		super(context, attrs);
	}

	public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	{
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);

		int i = canvas.save();
		canvas.save();
		Path p1 = new Path();
		p1.addCircle(300, 400, 100, Path.Direction.CW);
		canvas.clipPath(p1);
		canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
		canvas.restore();

		Path p2 = new Path();
		p2.addCircle(300 + (point2.x - point1.x), 400, 100, Path.Direction.CW);
		p2.setFillType(Path.FillType.INVERSE_WINDING);
		canvas.clipPath(p2);
		canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
		canvas.restoreToCount(i);

		Path p3 = new Path();
		p3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
		p3.addCircle(300, 700, 100, Path.Direction.CW);
		canvas.drawPath(p3, new Paint());
	}
}
