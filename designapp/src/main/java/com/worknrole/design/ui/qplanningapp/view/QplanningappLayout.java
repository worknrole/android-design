package com.worknrole.design.ui.qplanningapp.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.fragment.SocialFragment;
import com.worknrole.design.ui.qplanningapp.fragment.TodaysFragment;

/**
 * Created by worknrole on 10/03/17.
 */

public class QplanningappLayout extends ViewPager {

    //region Properties
    private FloatingActionButton mEditionBtn;
    private TextView mToolbarTitle;
    private View mLine;
    //endregion


    //region Constructors
    public QplanningappLayout(Context context) {
        super(context);
    }

    public QplanningappLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //endregion


    //region Lifecycle
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        if (getContext() instanceof AppCompatActivity) {
            addOnPageChangeListener(createOnPageChangeListener());
            setAdapter(new FragmentStatePagerAdapter(((AppCompatActivity)getContext()).getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return position == 0 ? new TodaysFragment() : new SocialFragment();
                }

                @Override
                public int getCount() {
                    return 2;
                }
            });

        } else {
            throw new NullPointerException("QPALayout: context not an instance of AppCompatActivity");
        }
    }
    //endregion


    //region Initializer
    private ViewPager.OnPageChangeListener createOnPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            private int maxTranslationX = getResources().getDimensionPixelOffset(R.dimen.slide_line_max_translation_X);
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mLine != null) {
                    float value = maxTranslationX * positionOffset;
                    if (positionOffset == 0) {
                        value = (position == 0) ? 0.0f : maxTranslationX;
                    }
                    mLine.animate()
                            .translationX(value)
                            .setInterpolator(new AccelerateInterpolator())
                            .setDuration(0)
                            .start();
                }
            }

            @Override
            public void onPageSelected(final int position) {

                if (mToolbarTitle != null) {
                    mToolbarTitle.setText(getResources().getString(
                            position == 0 ? R.string.title_ab_qpa : R.string.title_ab_2_qpa));
                }

                if (mEditionBtn != null) {
                    mEditionBtn.animate()
                            .alpha(position == 0 ? 1.0f : 0.0f)
                            .setDuration(500)
                            .setListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animation) {
                                    if (position == 0) mEditionBtn.setVisibility(VISIBLE);
                                }

                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    if (position == 1) mEditionBtn.setVisibility(GONE);
                                }

                                @Override
                                public void onAnimationCancel(Animator animation) {}
                                @Override
                                public void onAnimationRepeat(Animator animation) {}
                            })
                            .start();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        };
    }

    public void setEditionBtn(FloatingActionButton btn) {
        mEditionBtn = btn;
        mEditionBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(QplanningappLayout.this, getResources().getString(R.string.yes), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public void setSlideLine(View line) {
        mLine = line;
    }

    public void setToolbarTitle(TextView title) {
        mToolbarTitle = title;
    }
    //endregion
}
