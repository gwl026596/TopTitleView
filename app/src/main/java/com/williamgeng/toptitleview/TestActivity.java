
package com.williamgeng.toptitleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.williamgeng.wight.TopView;


public class TestActivity extends AppCompatActivity {
    TopView topView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
         topView= findViewById(R.id.topView);
        //initImmersionBar();
        setLitener();
    }


    /*protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.keyboardEnable(true)
                .statusBarColor(R.color._ffffff)
                .navigationBarWithKitkatEnable(false)
                .statusBarDarkFont(true, 0.2f)
                .fitsSystemWindows(true)
                .init();
    }*/

    private void setLitener() {
        topView.setListener(new TopView.setListener() {
            @Override
            public void leftBack() {
                finish();
            }

            @Override
            public void rightText() {
                Toast.makeText(TestActivity.this,"点击了标题栏右边文本",Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightImg() {
                Toast.makeText(TestActivity.this,"点击了标题栏右边图片",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*if (null!=mImmersionBar){
            mImmersionBar.destroy();
        }*/
    }
}
