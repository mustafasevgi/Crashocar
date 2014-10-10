package akturk.crashocar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import akturk.crashocar.R;
import akturk.crashocar.fragment.CarSubFragment;
import akturk.crashocar.fragment.IdentificationSubFragment;

public final class InformationPagerAdapter extends BasePagerAdapter {

    public InformationPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(context, fragmentManager);
    }

    @Override
    protected Fragment getFragment(int position) {
        switch (position) {
            case IdentificationSubFragment.SUB_POSITION:
                return new IdentificationSubFragment();
            case CarSubFragment.SUB_POSITION:
                return new CarSubFragment();
            default:
                return null;
        }
    }


    @NonNull
    @Override
    protected int getTitleArrayResource() {
        return R.array.array_information;
    }
}
