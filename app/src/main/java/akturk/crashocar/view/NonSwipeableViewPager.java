package akturk.crashocar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import akturk.crashocar.R;
import akturk.crashocar.event.PageTitleEvent;
import akturk.crashocar.provider.BusProvider;

public final class NonSwipeableViewPager extends ViewPager implements ViewPager.OnPageChangeListener {

    private String[] mTitleArray;

    public NonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOnPageChangeListener(this);

        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.nswp);
        int mArrayResourceValue = mTypedArray.getInt(0, 0);

        this.mTitleArray = context.getResources().getStringArray(mArrayResourceValue);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }

    @Override
    public void onPageSelected(int i) {
        PageTitleEvent mEvent = new PageTitleEvent(mTitleArray[i]);
        BusProvider.getInstance().post(mEvent);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);
    }
}