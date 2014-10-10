package akturk.crashocar.fragment;

import android.support.annotation.NonNull;

import akturk.crashocar.R;
import akturk.crashocar.adapter.InformationPagerAdapter;
import akturk.crashocar.view.NonSwipeableViewPager;
import butterknife.InjectView;

public final class InformationFragment extends BaseFragment {

    public static final int POSITION = 0;

    @InjectView(R.id.fragment_information_viewpager)
    protected NonSwipeableViewPager mViewPager;

    private InformationPagerAdapter mAdapter;

    @Override
    public void onResume() {
        super.onResume();

        mAdapter = new InformationPagerAdapter(getContext(), getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    @NonNull
    @Override
    protected int getFragmentTitleResource() {
        return R.string.title_information;
    }

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_information;
    }
}
