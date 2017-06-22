package com.test.jiazheng.mydemo.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.test.jiazheng.mydemo.R;
import com.test.jiazheng.mydemo.base.BaseActivity;

public class SplashActivity extends BaseActivity {
//    @BindView(R.id.iv_splash_image)
//    ImageView mIvSplashImage;
//    @BindView(R.id.iv_background)
//    ImageView mIvBackground;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        // 闪屏的核心代码
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        MainActivity.class); // 从启动动画ui跳转到主ui
                startActivity(intent);
//                overridePendingTransition(R.anim.in_from_right,
//                        R.anim.out_to_left);
                SplashActivity.this.finish(); // 结束启动动画界面
            }
        }, 4000); // 启动动画持续3秒钟

//        ButterKnife.bind(this);
//        String[] images = getResources().getStringArray(R.array.splash_background);
//        int position = new Random().nextInt(images.length - 1) % (images.length);
//        Picasso.with(this)
//                .load(images[position])
//                .into(mIvBackground);
//        Picasso.with(this)
//                .load("file://" + ViewUtils.getAppFile(this, "images/user.png"))
//                .error(getResources().getDrawable(R.drawable.userimage))
//                .into(mIvSplashImage);
//        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
//        animation.setDuration(1000);
//        mIvSplashImage.startAnimation(animation);
//        animation.setAnimationListener(new AnimationImpl());
    }

//    private class AnimationImpl implements Animation.AnimationListener {
//        @Override
//        public void onAnimationStart(Animation animation) {
//        }
//
//        @Override
//        public void onAnimationEnd(Animation animation) {
//            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//            startActivity(intent);
//            SplashActivity.this.finish();
//        }
//
//        @Override
//        public void onAnimationRepeat(Animation animation) {
//
//        }
//    }
}
