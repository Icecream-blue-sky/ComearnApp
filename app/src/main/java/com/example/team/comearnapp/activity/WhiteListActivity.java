package com.example.team.comearnapp.activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.team.comearnapp.R;
import com.example.team.comearnapp.engine.fragment.white_list.WhiteListFragment;
import com.example.team.comearnlib.base.mvp_mode.base_model.BaseModel;
import com.example.team.comearnlib.base.mvp_mode.base_presenter.BasePresenter;
import com.example.team.comearnlib.base.mvp_mode.base_view.IBaseView;

import java.util.ArrayList;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

interface WhiteListBaseView extends IBaseView{

}

class WhiteListModel extends BaseModel{

}

class WhiteListPresenter extends BasePresenter<WhiteListBaseView>{

}

public class WhiteListActivity extends AppCompatActivity implements WhiteListBaseView{

    protected CoordinatorTabLayout mCoorTabLayout;
    protected ViewPager mViewPager;

    protected ArrayList<String> mIndicators = new ArrayList<>();
    protected ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_list);

        bindView();

        initIndicators();

        initFragments();

        initViewPager();

        initCoorTabLayout();


    }

    protected void initIndicators() {
        mIndicators.add("非系统");
        mIndicators.add("系统");
    }

    protected void initFragments() {
        mFragments.add(WhiteListFragment.newInstance(false));
        mFragments.add(WhiteListFragment.newInstance(true));
    }

    protected void initViewPager() {
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mIndicators.get(position);
            }
        };
        mViewPager.setAdapter(pagerAdapter);
    }

    protected void initCoorTabLayout() {
        mCoorTabLayout.setTitle("设置白名单");
        mCoorTabLayout.setTranslucentStatusBar(this);
        mCoorTabLayout.setBackEnable(true);
        mCoorTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void bindView() {
        mCoorTabLayout = findViewById(R.id.act_white_list_ctl);
        mViewPager = findViewById(R.id.act_white_list_ctl_vp_content);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
