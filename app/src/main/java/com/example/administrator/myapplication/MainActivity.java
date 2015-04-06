package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private static final String TAG =MainActivity.class.getName() ;
    private ViewPager viewPager;
    private int[] mImgIds = new int[]{R.mipmap.guide_image1, R.mipmap.guide_image2, R.mipmap.guide_image3};
    private List<ImageView> mImageViews = new ArrayList<ImageView>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viwePager);
        viewPager.setPageTransformer(true,new DepthPageTransformer());


        Log.v(TAG,"invoke!");

        viewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(mImgIds[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                mImageViews.add(imageView);

                return imageView;
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView(mImageViews.get(position));
            }

            @Override
            public int getCount() {
                return mImgIds.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });


    }


}
