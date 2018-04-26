package com.example.yhadmin.eventbustdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yhadmin.eventbustdemo.dagger.DaggerPlatform;
import com.example.yhadmin.eventbustdemo.dagger.DaggerWaimaiPingTai;
import com.example.yhadmin.eventbustdemo.dagger.ShangJiaAModule;
import com.example.yhadmin.eventbustdemo.dagger.WaimaiPingTai;
import com.example.yhadmin.eventbustdemo.dagger.ZaiNan;
import com.example.yhadmin.eventbustdemo.msgbean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

public class MainActivity
        extends AppCompatActivity
{
    @Inject
    int testvalue;

    private static final String TAG = "MainActivity";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault()
                .register(this);
        mTextView = (TextView) findViewById(R.id.tv_text);
        Button button = (Button) findViewById(R.id.secondActivityBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        final ZaiNan zaiNan = DaggerPlatform.builder()
                                            //在构造方法中为 shangJiaAModule 注入品牌名称，通过构造函数方式
                                            .shangJiaAModule(new ShangJiaAModule("周黑鸭"))
                                            .build()
                                            .waimai();

        final ZaiNan zainan1 = DaggerWaimaiPingTai.builder()
                                                  .shangJiaAModule(new ShangJiaAModule("肯打鸡"))
                                                  .build()
                                                  .waimai();

        findViewById(R.id.test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, zainan1.eat(), Toast.LENGTH_SHORT)
                     .show();
            }
        });


        findViewById(R.id.test_module).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, zaiNan.eat(), Toast.LENGTH_SHORT)
                     .show();
            }
        });

        WaimaiPingTai waimaiPingTai = DaggerWaimaiPingTai.builder()
                                               .shangJiaAModule(new ShangJiaAModule("武大郎"))
                                               .build();
        //将当前 zaiNan 作为参数对象注入到方法 zhuru 中
        waimaiPingTai.zhuru(zaiNan);
        findViewById(R.id.test_zr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, zaiNan.eat(), Toast.LENGTH_SHORT)
                     .show();
            }
        });
        WaimaiPingTai wmpt = DaggerWaimaiPingTai.builder()
                                               .shangJiaAModule(new ShangJiaAModule("火锅店"))
                                               .build();
        //将当前 Activity 作为参数对象注入到方法 injiect 中
        wmpt.inject(this);
        findViewById(R.id.test_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"testvalue is "+ testvalue, Toast.LENGTH_SHORT)
                     .show();
            }
        });
    }

    @Subscribe
    public void onEvent(MessageEvent messageEvent) {
        Log.d("cylog", "receive it");
        mTextView.setText(messageEvent.getMsg());
        Toast.makeText(MainActivity.this, messageEvent.getMsg(), Toast.LENGTH_SHORT)
             .show();

    }

    @Override
    protected void onStart() {
        Log.e(TAG,"-----------onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG,"-----------onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG,"-----------onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG,"-----------onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG,"-----------onRestart");
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e(TAG,"-----------onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e(TAG,"-----------onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG,"-----------onDestroy");
        EventBus.getDefault()
                .unregister(this);
        super.onDestroy();
    }
}
