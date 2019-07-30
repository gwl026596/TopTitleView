package com.williamgeng.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by william.geng on 2019/7/29.
 */

public class TopView extends Toolbar {

    private TextView tvTitle;
    private TextView tvRightToolbar;
    private ImageView imgRightToolbar;
    private ImageView imgLeftToolbar;
    private setListener listener;

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
        Toolbar toolbar = layout.findViewById(R.id.toolbar);
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
                if (null!=listener){
                    listener.leftBack();
                }
            }
        });
        imgRightToolbar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null!=listener){
                    listener.rightImg();
                }
            }
        });
        tvRightToolbar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null!=listener){
                    listener.rightText();
                }
            }
        });
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.toolbarview);
        String title = mTypedArray.getString(R.styleable.toolbarview_title_toolbar);
        int resourceId = mTypedArray.getResourceId(R.styleable.toolbarview_right_toolbar_img, R.drawable.vertical_guide);
        String right_toolbar = mTypedArray.getString(R.styleable.toolbarview_right_toolbar);
        int color = mTypedArray.getColor(R.styleable.toolbarview_title_color_toolbar, Color.BLACK);
        int right_color = mTypedArray.getColor(R.styleable.toolbarview_right_color_toolbar, Color.BLACK);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(right_toolbar)) {
            imgRightToolbar.setVisibility(GONE);
            tvRightToolbar.setVisibility(VISIBLE);
            tvRightToolbar.setText(right_toolbar);
        } else {
            imgRightToolbar.setVisibility(VISIBLE);
            tvRightToolbar.setVisibility(GONE);
            imgRightToolbar.setImageResource(resourceId);
        }

        tvTitle.setTextColor(color);
        tvRightToolbar.setTextColor(right_color);
    }

    public interface setListener {
        void leftBack();
        void rightText();
        void  rightImg();
    }
}
