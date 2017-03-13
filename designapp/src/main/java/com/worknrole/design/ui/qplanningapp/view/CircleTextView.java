package com.worknrole.design.ui.qplanningapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.worknrole.design.R;
import com.worknrole.framework.view.shape.CircleView;

/**
 * Created by worknrole on 13/03/17.
 */

public class CircleTextView extends CircleView {

    //region Constructors
    public CircleTextView(Context context) {
        super(context);
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //endregion


    //region Lifecycle
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.qplanningapp_circle_day_size));
        canvas.drawText(
                getResources().getString(R.string.today_day),
                getResources().getDimensionPixelOffset(R.dimen.qplanningapp_circle_day_x),
                getResources().getDimensionPixelOffset(R.dimen.qplanningapp_circle_day_y),
                paint);

        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.qplanningapp_circle_month_size));
        canvas.drawText(
                getResources().getString(R.string.today_month),
                getResources().getDimensionPixelOffset(R.dimen.qplanningapp_circle_month_x),
                getResources().getDimensionPixelOffset(R.dimen.qplanningapp_circle_month_y),
                paint);
    }
    //endregion
}
