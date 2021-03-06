package com.ace.member.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.ace.member.R;
import com.og.utils.Utils;

public class RoundRectImageView extends AppCompatImageView {
	private Paint paint;

	public RoundRectImageView(Context context) {
		this(context, null);
	}

	public RoundRectImageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RoundRectImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		paint = new Paint();
	}

	/**
	 * 绘制圆角矩形图片
	 */
	@Override
	protected void onDraw(Canvas canvas) {

		Drawable drawable = getDrawable();
		if (null != drawable) {
			try {
				Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
				Bitmap b = getRoundBitmap(bitmap, Utils.dip2px(5));
				final Rect rectSrc = new Rect(0, 0, b.getWidth(), b.getHeight());
				final Rect rectDest = new Rect(0, 0, getWidth(), getHeight());
				paint.reset();
				canvas.drawBitmap(b, rectSrc, rectDest, paint);
			} catch (ClassCastException e) {
				//当图片是svg时
				setBitmapFromVectorDrawable(drawable, canvas);
			}
		} else {
			super.onDraw(canvas);
		}
	}

	private void setBitmapFromVectorDrawable(Drawable drawable, Canvas canvas) {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
			drawable = (DrawableCompat.wrap(drawable)).mutate();
		}
		Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(bitmap);
//		drawable.setBounds(0, 0, c.getWidth(), c.getHeight());
		drawable.draw(c);
		Bitmap b = getRoundBitmap(bitmap, Utils.dip2px(5));
		final Rect rectSrc = new Rect(0, 0, b.getWidth(), b.getHeight());
		final Rect rectDest = new Rect(0, 0, getWidth(), getHeight());
		paint.reset();
		canvas.drawBitmap(b, rectSrc, rectDest, paint);
	}

	/**
	 * 获取圆角矩形图片方法
	 *
	 * @param bitmap
	 * @param roundPx,一般设置成14
	 * @return Bitmap
	 */
	private Bitmap getRoundBitmap(Bitmap bitmap, int roundPx) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;

		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		int x = bitmap.getWidth();

		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}
}
