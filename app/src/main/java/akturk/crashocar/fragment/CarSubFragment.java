package akturk.crashocar.fragment;

import android.support.annotation.NonNull;

import akturk.crashocar.R;

public final class CarSubFragment extends BaseSubFragment {

    public static final int SUB_POSITION = 1;

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sub_indentification;
    }
}
