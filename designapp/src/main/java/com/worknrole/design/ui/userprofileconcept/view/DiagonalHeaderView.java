package com.worknrole.design.ui.userprofileconcept.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.worknrole.design.R;

/**
 * Created by worknrole on 22/01/17.
 *
 * View used into the header view to draw a quadrilateral with a diagonal
 * draws at the bottom
 */

public class DiagonalHeaderView extends RelativeLayout {

    //region Properties
    /**
     * Value of the diagonal bottom line
     */
    private static final float DIAGONAL_PERCENT = 0.76f;

    private Drawable mDrawable;
    //endregion


    //region Constructors
    public DiagonalHeaderView(Context context) {
        this(context, null);
    }

    public DiagonalHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiagonalHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeFromAttributeSet(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DiagonalHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeFromAttributeSet(context, attrs);
    }
    //endregion


    //region Lifecycle
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mDrawable != null) {
            // Draw diagonal bitmap
            Bitmap currentBitmap = ((BitmapDrawable)mDrawable).getBitmap();
            currentBitmap = currentBitmap.copy(Bitmap.Config.ARGB_8888, true);
            Bitmap backBitmap = createDiagonalBitmap(currentBitmap, getWidth());
            canvas.drawBitmap(backBitmap, 0, 0, null);
            currentBitmap.recycle();

            // Set dark filter
            drawDiagonalShape(canvas, ContextCompat.getColor(getContext(), R.color.upc_colorDarkHeaderFilter));

        } else {
            // Draw white background diagonal view
            drawDiagonalShape(canvas, Color.WHITE);
        }
    }
    //endregion


    //region Custom methods
    /**
     * Initialized some custom attributes
     * @param context   The current context
     * @param attrs     The attrs where to retrieved the custom attributes
     */
    protected void initializeFromAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.DiagonalHeaderView, 0, 0);

        try {
            mDrawable = typedArray.getDrawable(R.styleable.DiagonalHeaderView_src);
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * Draw the quadrilateral with a diagonal draws at the bottom
     * @param canvas    The canvas where to draw all shape
     * @param color     The quadrilateral color
     * @return  The {@link Paint} used to draw the shape
     */
    private Paint drawDiagonalShape(Canvas canvas, int color) {

        Paint backPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backPaint.setStyle(Paint.Style.FILL);
        backPaint.setColor(color);

        Point topLeft = new Point(0,0);
        Point topRight = new Point(getWidth(), 0);
        Point bottomRight = new Point(getWidth(), (int)(getHeight()*DIAGONAL_PERCENT));
        Point bottomLeft = new Point(0, getHeight());

        Path path = new Path();
        path.moveTo(topLeft.x, topLeft.y);
        path.lineTo(topRight.x, topRight.y);
        path.lineTo(bottomRight.x, bottomRight.y);
        path.lineTo(bottomLeft.x, bottomLeft.y);
        path.lineTo(topLeft.x, topLeft.y);
        path.close();

        canvas.drawPath(path,backPaint);
        return backPaint;
    }

    /**
     * Draw the quadrilateral with a diagonal draws at the bottom with a Bitmap
     * @param bitmap    The bitmap to draw into the quadrilateral
     * @param width      The width of the quadrilateral
     * @return  The bitmap draws into the quadrilateral
     */
    private Bitmap createDiagonalBitmap(Bitmap bitmap, int width) {
        Bitmap quadBitmap;
        float scale = (bitmap.getWidth() < width) ? width/bitmap.getWidth() : 1f;
        Bitmap tmpBitmap = Bitmap.createScaledBitmap(bitmap, width, (int)(getHeight()*scale), false);

        int tmpWidth = tmpBitmap.getWidth();
        int tmpHeight = tmpBitmap.getHeight();
        quadBitmap = Bitmap.createBitmap(tmpWidth, tmpHeight, Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(quadBitmap);
        Rect rect = new Rect(0, 0, tmpWidth, tmpHeight);
        Paint backPaint = drawDiagonalShape(canvas, Color.WHITE);
        backPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(tmpBitmap, rect, rect, backPaint);

        tmpBitmap.recycle();
        return quadBitmap;
    }
    //endregion
}