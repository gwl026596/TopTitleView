package com.williamgeng.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by william.geng on 2019/7/29.
 */

public class TopView extends Toolbar {

    private TextView tvTitle;//中间标题
    private TextView tvRightToolbar;//右边标题
    private ImageView imgRightToolbar;//右边图片
    private ImageView imgLeftToolbar;//左边图片
    private setListener listener;//设置监听 如返回按钮，右边完成
    private Toolbar toolbar;//整个根布局设置背景颜色

    public void setListener(setListener listener) {
        this.listener = listener;
    }

    public TopView(Context context) {
        this(context, null);
    }

    public TopView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        initAttrs(context, attrs);
    }

    private void initView() {
        View layout = inflate(getContext(), R.layout.layout_toolbar, this);
        toolbar = layout.findViewById(R.id.toolbar);
        imgLeftToolbar = layout.findViewById(R.id.imgLeftToolbar);
        tvTitle = layout.findViewById(R.id.tvTitle);
        imgRightToolbar = layout.findViewById(R.id.imgRightToolbar);
        tvRightToolbar = layout.findViewById(R.id.tvRightToolbar);
        setListener();
    }

    private void setListener() {
        imgLeftToolbar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != listener) {
                    listener.leftBack();
                }
            }
        });
        imgRightToolbar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != listener) {
                    listener.rightImg();
                }
            }
        });
        tvRightToolbar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != listener) {
                    listener.rightText();
                }
            }
        });
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        int drawableType = R.drawable.shape_right_bg;
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.toolbarview);
        String title = mTypedArray.getString(R.styleable.toolbarview_title_toolbar);//设置中间标题
        int resourceId = mTypedArray.getResourceId(R.styleable.toolbarview_right_toolbar_img, R.drawable.shape_right_bg);//设置右边图片
        int leftResourceId = mTypedArray.getResourceId(R.styleable.toolbarview_left_toolbar_img, R.drawable.back1);//设置左边图片
        String right_toolbar = mTypedArray.getString(R.styleable.toolbarview_right_toolbar);//设置右边标题
        float titleDimension = mTypedArray.getDimension(R.styleable.toolbarview_title_size, 15);//设置中间标题字体大小
        float rightDimension = mTypedArray.getDimension(R.styleable.toolbarview_right_size, 15);//设置右边标题字体大小
        int colorBackGround = mTypedArray.getColor(R.styleable.toolbarview_toolbar_background, Color.WHITE);//设置整体背景颜色
        int color = mTypedArray.getColor(R.styleable.toolbarview_title_color_toolbar, Color.BLACK);//设置中间标题颜色
        int right_color = mTypedArray.getColor(R.styleable.toolbarview_right_color_toolbar, Color.BLACK);//设置右边标题颜色
        toolbar.setBackgroundColor(colorBackGround);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleDimension);
        }
        imgLeftToolbar.setImageResource(leftResourceId);
        if (!TextUtils.isEmpty(right_toolbar)) {
            imgRightToolbar.setVisibility(GONE);
            tvRightToolbar.setVisibility(VISIBLE);
            tvRightToolbar.setText(right_toolbar);
            tvRightToolbar.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightDimension);
        } else {
            imgRightToolbar.setVisibility(VISIBLE);
            tvRightToolbar.setVisibility(GONE);
            if (resourceId != drawableType) {
                imgRightToolbar.setImageResource(resourceId);
            }
        }

        tvTitle.setTextColor(color);
        tvRightToolbar.setTextColor(right_color);
    }

    public interface setListener {
        void leftBack();

        void rightText();

        void rightImg();
    }
}
