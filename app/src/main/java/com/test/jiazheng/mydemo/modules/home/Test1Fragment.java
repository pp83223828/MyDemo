package com.test.jiazheng.mydemo.modules.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.jiazheng.mydemo.R;
import com.test.jiazheng.mydemo.base.BaseFragment;


/**
 *
 */
public class Test1Fragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test1, container, false);
    }
}
