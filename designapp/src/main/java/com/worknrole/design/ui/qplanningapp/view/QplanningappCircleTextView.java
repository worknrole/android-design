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
 *
 * Static builder for circle and date
 */

public class QplanningappCircleTextView extends CircleView {

    //region Constructors
    public QplanningappCircleTextView(Context context) {
        super(context);
    }

    public QplanningappCircleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public QplanningappCircleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public QplanningappCircleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
                getResources().getString(R.string.qplanningapp_today_day),
                getResources().getDimensionPixelOffset(R.dimen.qplanningapp_circle_day_x),
                getResources().getDimensionPixelOffset(R.dimen.qplanningapp_circle_day_y),
                paint);

        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.qplanningapp_circle_month_size));
        canvas.drawText(
                getResources().getString(R.string.qplanningapp_today_month),
                getResources().getDimensionPixelOffset(R.dimen.qplanningapp_circle_month_x),
                getResources().getDimensionPixelOffset(R.dimen.qplanningapp_circle_month_y),
                paint);
    }
    //endregion
}
