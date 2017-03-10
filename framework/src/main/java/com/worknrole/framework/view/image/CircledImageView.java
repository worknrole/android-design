package com.worknrole.framework.view.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by worknrole on 22/01/17.
 *
 * Create a Circled image view when passing a {@link Bitmap}
 *
 * ~ Many things to add and update ~
 */

public class CircledImageView extends AppCompatImageView {

    //region Constructors
    public CircledImageView(Context context) {
        super(context);
    }

    public CircledImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircledImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //endregion


    //region Lifecycle
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int height = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int size = width > height ? height : width;
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap currentBitmap = ((BitmapDrawable)drawable).getBitmap();
            currentBitmap = currentBitmap.copy(Bitmap.Config.ARGB_8888, true);
            Bitmap circleBitmap = createCircleBitmap(currentBitmap, getWidth());
            canvas.drawBitmap(circleBitmap, 0, 0, null);
            currentBitmap.recycle();
        }
    }
    //endregion


    //region Custom methods

    /**
     * Create a circle {@link Bitmap}
     * @param bitmap    The bitmap to change into circle
     * @param size      The desire bitmap size
     * @return the circled bitmap created from the one pass in parameter
     */
    private Bitmap createCircleBitmap(Bitmap bitmap, int size) {
        Bitmap circleBitmap;
        Bitmap tmpBitmap = (bitmap.getWidth() > size || bitmap.getHeight() > size) ?
                Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false) :
                bitmap;

        int width = tmpBitmap.getWidth();
        int height = tmpBitmap.getHeight();
        circleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Rect rect = new Rect(0, 0, width, height);
        final Paint backgroundCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundCirclePaint.setFilterBitmap(true);
        backgroundCirclePaint.setDither(true);
        backgroundCirclePaint.setColor(Color.WHITE);

        Canvas canvas = new Canvas(circleBitmap);
        canvas.drawCircle(width * 0.5f, height * 0.5f, width * 0.5f, backgroundCirclePaint);
        backgroundCirclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(tmpBitmap, rect, rect, backgroundCirclePaint);

        tmpBitmap.recycle();
        return circleBitmap;
    }
    //endregion
}
