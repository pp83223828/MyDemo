package com.test.jiazheng.mydemo.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.test.jiazheng.mydemo.R;
import com.test.jiazheng.mydemo.base.BaseActivity;
import com.test.jiazheng.mydemo.modules.home.Test1Fragment;
import com.test.jiazheng.mydemo.modules.dashboard.Test2Fragment;
import com.test.jiazheng.mydemo.modules.notifications.Test3Fragment;
import com.test.jiazheng.mydemo.modules.my.Test4Fragment;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar mBottomNavgation;
    private FragmentManager fm;
    private Test1Fragment test1fragment;
    private Test2Fragment test2fragment;
    private Test3Fragment test3fragment;
    private Test4Fragment test4fragment;
    private Fragment mCurrentFrag;
    private Long firstTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        initView();
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                switchContent(test1fragment);
                break;
            case 1:
                switchContent(test2fragment);
                break;
            case 2:
                switchContent(test3fragment);
                break;
            case 3:
                switchContent(test4fragment);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void initView() {
        test1fragment = new Test1Fragment();
        test2fragment = new Test2Fragment();
        test3fragment = new Test3Fragment();
        test4fragment = new Test4Fragment();
        mBottomNavgation = (BottomNavigationBar) findViewById(R.id.bnv_main_bottom);

        initNavigation();
        switchContent(test1fragment);
    }

    //下方Tab
    private void initNavigation() {
        mBottomNavgation
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
//                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, getString(R.string.main_title_home)).setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_dashboard_black_24dp, getString(R.string.main_title_dashboard)).setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_notifications_black_24dp, getString(R.string.main_title_notifications)).setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_person_black_24dp, getString(R.string.main_title_my)).setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .setTabSelectedListener(this)
                .initialise();
    }

    /**
     * 动态添加fragment，不会重复创建fragment
     *
     * @param to 将要加载的fragment
     */
    public void switchContent(Fragment to) {
        if (mCurrentFrag != to) {
            if (!to.isAdded()) {// 如果to fragment没有被add则增加一个fragment
                if (mCurrentFrag != null) {
                    fm.beginTransaction().hide(mCurrentFrag).commit();
                }
                fm.beginTransaction()
                        .add(R.id.main_view, to)
                        .commit();
            }
            else {
                fm.beginTransaction().hide(mCurrentFrag).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
            mCurrentFrag = to;
        }
    }

    @Override
    public void onBackPressed() {
//        if (drawerOpen) {
//            mDrawerLayout.closeDrawers();
//            return;
//        }
//        if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
//            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//        }
//        RxBus.getDefault().postWithCode(RxConstants.BACK_PRESSED_CODE, RxConstants.BACK_PRESSED_DATA);
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 1500) {
            showLongToast(this, getString(R.string.main_title_notifications));
            firstTime = secondTime;
        }
        else {
            System.exit(0);
        }
    }
}
