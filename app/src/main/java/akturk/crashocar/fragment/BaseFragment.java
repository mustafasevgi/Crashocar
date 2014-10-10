package akturk.crashocar.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Bus;

import akturk.crashocar.event.PageTitleEvent;
import akturk.crashocar.provider.BusProvider;
import butterknife.ButterKnife;

abstract class BaseFragment extends Fragment {

    @Override
    public void onResume() {
        super.onResume();

        getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        getBus().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.inject(this, mView);

        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        getBus().unregister(this);
    }

    protected final Bus getBus() {
        return BusProvider.getInstance();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        String mTitle = getString(getFragmentTitleResource());
        PageTitleEvent mEvent = new PageTitleEvent(mTitle);
        getBus().post(mEvent);
    }

    protected final Context getContext() {
        return getActivity().getBaseContext();
    }

    protected abstract
    @StringRes
    @NonNull
    int getFragmentTitleResource();


    protected abstract
    @LayoutRes
    @NonNull
    int getLayoutResource();

}
