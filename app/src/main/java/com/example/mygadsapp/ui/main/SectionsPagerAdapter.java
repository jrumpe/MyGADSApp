package com.example.mygadsapp.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mygadsapp.Fragments.LearningLeadersFragment;
import com.example.mygadsapp.Fragments.SkillIQLeadersFragment;
import com.example.mygadsapp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LearningLeadersFragment();
            case 1:
                return new SkillIQLeadersFragment();
        }
        return new LearningLeadersFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Learning Leaders";
            case 1:
                return "Skill IQ Leaders";
        }
        return "";
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}