package com.vivo.animtest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        button.setOnClickListener(this);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();

                //实现多种效果组合，方法1
/*              ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F).setDuration(1000).start();
                ObjectAnimator.ofFloat(imageView, "translationX", 0, 200F).setDuration(1000).start();
                ObjectAnimator.ofFloat(imageView, "translationY", 0, 200F).setDuration(1000).start();*/

                //实现多种效果组合，方法2
               /* PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation", 0F, 360F);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX", 0F,200F);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY", 0F, 200F);
                ObjectAnimator.ofPropertyValuesHolder(imageView,p1,p2,p3).setDuration(1000).start();*/

                //实现动画集合
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationX", 0, 200F);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200F);
                AnimatorSet set = new AnimatorSet();
                //实现动画合成
                //set.playTogether(animator1, animator2, animator3);
                //实现动画有序播放
                //set.playSequentially(animator1, animator2, animator3);
                //实现每一个动画有序播放，顺序控制
                set.play(animator2).with(animator3);
                set.play(animator1).after(animator2);
                set.setDuration(1000);
                set.start();
                break;
            case R.id.imageView:
/*              Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
                TranslateAnimation animation = new TranslateAnimation(0,200,0,0);
                animation.setFillAfter(true);
                animation.setDuration(2000);
                imageView.startAnimation(animation);*/
                ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F).setDuration(1000).start();
                Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

