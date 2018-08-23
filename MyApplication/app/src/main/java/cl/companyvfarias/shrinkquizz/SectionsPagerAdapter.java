package cl.companyvfarias.shrinkquizz;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) { super(fm);
    }

    //Cantidad de fragamentos a colocar
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return PartyFragment.newInstance();

            case 1:
                return LuckyFragment.newInstance();

            case 2:
                return MatchFragment.newInstance();

            default:
                return PartyFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position)
        {
            case 0: return "Party";

            case 1: return "Lucky";

            case 2: return "Match";

            default: return "Party";
        }


    }
}
