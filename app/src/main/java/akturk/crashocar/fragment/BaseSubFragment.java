package akturk.crashocar.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Bus;

import akturk.crashocar.provider.BusProvider;
import butterknife.ButterKnife;

abstract class BaseSubFragment extends Fragment {

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

    protected Bus getBus() {
        return BusProvider.getInstance();
    }

    protected abstract
    @LayoutRes
    @NonNull
    int getLayoutResource();

}
