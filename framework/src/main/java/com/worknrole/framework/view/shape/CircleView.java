package com.worknrole.framework.view.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.worknrole.framework.R;

/**
 * Created by worknrole on 10/03/17.
 */

public class CircleView extends View {

    //region Properties
    private int mColor;
    private int mStartColor;
    private int mEndColor;
    private boolean mUseGradient;
    //endregion


    //region Constructors
    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeFromAttributeSet(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeFromAttributeSet(context, attrs);
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
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }

        final Paint backgroundCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundCirclePaint.setDither(true);
//        setLayerType(LAYER_TYPE_SOFTWARE, backgroundCirclePaint);
//        backgroundCirclePaint.setShadowLayer(10, 0, 10, Color.WHITE);

        if (mUseGradient)
            backgroundCirclePaint.setShader(new LinearGradient(
                    getWidth()*0.5f, getHeight(), getWidth()*0.5f, 0, mStartColor, mEndColor, Shader.TileMode.MIRROR));
        else
            backgroundCirclePaint.setColor(mColor);

        canvas.drawCircle(getWidth() * 0.5f, getHeight() * 0.5f, getWidth() * 0.5f, backgroundCirclePaint);
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
                attrs, R.styleable.CircleView, 0, 0);

        try {
            mColor = typedArray.getColor(R.styleable.CircleView_circleColor, Color.WHITE);
            mStartColor = typedArray.getColor(R.styleable.CircleView_startColor, Color.WHITE);
            mEndColor = typedArray.getColor(R.styleable.CircleView_endColor, Color.WHITE);

            if (typedArray.hasValue(R.styleable.CircleView_startColor) && typedArray.hasValue(R.styleable.CircleView_endColor)) {
                mUseGradient = true;
            }
        } finally {
            typedArray.recycle();
        }
    }
    //endregion
}
