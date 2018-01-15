package com.testing.kmin.timelinetextpj;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

public class TapPageActivity extends AppCompatActivity
    implements TapOneFragment.OnFragmentInteractionListener,
        TapTwoFragment.OnFragmentInteractionListener,
        TapThreeFragment.OnFragmentInteractionListener

{
    private PagerAdapterClass adapter;
    private ViewPager pager;
    private PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_page);
        tabs = findViewById(R.id.tabs);
        pager = findViewById(R.id.pager);
        adapter = new PagerAdapterClass(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        tabs.setIndicatorColor(0xFF663523); // 커스터마이즈 함수들은 astuetz에서 확인 가능        tabs.setUnderlineColor(0xFF687686);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private class PagerAdapterClass extends FragmentPagerAdapter {
        private final String[] TITLES = {"일번", "이번", "삼번"};

        public PagerAdapterClass(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TapOneFragment.newInstance("","",position);
                case 1:
                    return new TapTwoFragment();
                default:
                    return new TapThreeFragment();
            }
        }

    }
}
