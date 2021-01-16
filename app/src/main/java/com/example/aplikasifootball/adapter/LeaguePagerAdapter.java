package com.example.aplikasifootball.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.aplikasifootball.fragments.LastEventFragment;
import com.example.aplikasifootball.fragments.NextEventFragment;
import com.example.aplikasifootball.fragments.TeamFragment;


public class LeaguePagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;

    String idLeague;
    public LeaguePagerAdapter(@NonNull FragmentManager fm, int tabCount, String idLeague) {
        super(fm,tabCount);
        this.tabCount=tabCount;
        this.idLeague=idLeague;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return NextEventFragment.newInstance(idLeague);
            case 1:
                return LastEventFragment.newInstance(idLeague);
            case 2:
                return TeamFragment.newInstance(idLeague);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}