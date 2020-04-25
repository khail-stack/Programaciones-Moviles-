package patitas.com.pe.veteriapp.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import patitas.com.pe.veteriapp.R;
import patitas.com.pe.veteriapp.fragments.OrdersFragment;
import patitas.com.pe.veteriapp.fragments.PetsFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    Context context;

    public TabsPagerAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);

        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PetsFragment.newInstance();
            case 1:
                return OrdersFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.pets_title);
            case 1:
                return context.getResources().getString(R.string.orders_title);
        }
        return null;
    }

}

