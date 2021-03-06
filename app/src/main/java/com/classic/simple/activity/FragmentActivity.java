package com.classic.simple.activity;

import android.os.Bundle;

import com.classic.simple.R;
import com.classic.simple.fragment.ImageFragment;
import com.classic.simple.fragment.TextFragment;

import butterknife.OnClick;

public class FragmentActivity extends AppBaseActivity {
    private ImageFragment mImageFragment;
    private TextFragment  mTextFragment;
    private boolean       isImageFragment;

    @Override public int getLayoutResId() {
        return R.layout.activity_fragment;
    }

    @Override public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        getSupportActionBar().setTitle("Fragment示例");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mImageFragment = new ImageFragment();
        mTextFragment = new TextFragment();
        isImageFragment = true;

        if(savedInstanceState == null){
            onSwitchButtonClick();
        }
    }

    @OnClick(R.id.btn_switch)
    public void onSwitchButtonClick(){
        isImageFragment = !isImageFragment;
        /**
         * 参数1：被替换为Fragment的视图id
         * 参数2：BaseFragment对象
         */
        changeFragment(R.id.fragment_layout, isImageFragment ? mImageFragment : mTextFragment);
    }
}
