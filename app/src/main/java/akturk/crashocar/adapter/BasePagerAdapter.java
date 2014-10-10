package akturk.crashocar.adapter;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import akturk.crashocar.event.PageTitleEvent;
import akturk.crashocar.provider.BusProvider;

abstract class BasePagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] mTitleArray;

    public BasePagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);

        this.mContext = context;
        this.mTitleArray = mContext.getResources().getStringArray(getTitleArrayResource());
    }

    @Override
    public final Fragment getItem(int i) {
        String mPageTitle = mTitleArray[i];
        PageTitleEvent mEvent = new PageTitleEvent(mPageTitle);
        BusProvider.getInstance().post(mEvent);

        return getFragment(i);
    }

    protected abstract Fragment getFragment(int position);

    @Override
    public final int getCount() {
        return mTitleArray.length;
    }

    @Override
    public final CharSequence getPageTitle(int position) {
        return mTitleArray[position];
    }

    protected abstract
    @ArrayRes
    @NonNull
    int getTitleArrayResource();
}
