package cn.han_zi.mvpdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.han_zi.mvpdemo.adapter.MainAdapter;
import cn.han_zi.mvpdemo.base.SimpleActivity;
import cn.han_zi.mvpdemo.ui.fragment.hot.HotFragment;
import cn.han_zi.mvpdemo.ui.fragment.theme.ThemeFragment;

public class MainActivity extends SimpleActivity {


    @BindView(R.id.iv_main_tab)
    TabLayout tabLayout;
    @BindView(R.id.viewPager_main)
    ViewPager viewPager;

    private MainAdapter adapter;

    String[] tabTitle = new String[]{"日报","主题","热门"};
    List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        fragments.add(new DialogFragment());
        fragments.add(new ThemeFragment());
        fragments.add(new HotFragment());

        adapter = new MainAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText(tabTitle[0]));
        tabLayout.addTab(tabLayout.newTab().setText(tabTitle[1]));
        tabLayout.addTab(tabLayout.newTab().setText(tabTitle[2]));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText(tabTitle[0]);
        tabLayout.getTabAt(1).setText(tabTitle[1]);
        tabLayout.getTabAt(2).setText(tabTitle[2]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
