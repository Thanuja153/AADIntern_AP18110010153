package com.example.tabnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
ViewPager vp;
TabLayout tl;
    private int[] tabIcons = {
            R.drawable.ic_tab_contacts,
            R.drawable.ic_tab_favourite,
            R.drawable.ic_tab_call
    };
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp=findViewById(R.id.pager);
        tl=findViewById(R.id.Tab);
        vp.setAdapter(new TabAdapter(getSupportFragmentManager()));
        tl.setupWithViewPager(vp);
        Icons();


    }
    private void Icons() {
        tl.getTabAt(0).setIcon(tabIcons[0]);
        tl.getTabAt(1).setIcon(tabIcons[1]);
        tl.getTabAt(2).setIcon(tabIcons[2]);
    }


    class TabAdapter extends FragmentPagerAdapter
    {

        public TabAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new Chats();
                case 1:
                    return new Status();
                case 2:
                    return new Calls();

            }
            return null;
        }

        @Override
        public int getCount() {

            return 3;
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "CHATS";
                case 1:
                    return "STATUS";
                case 2:
                    return "CALLS";
            }
            return super.getPageTitle(position);
        }
    }
}