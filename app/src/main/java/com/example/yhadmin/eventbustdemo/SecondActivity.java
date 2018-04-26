package com.example.yhadmin.eventbustdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yhadmin.eventbustdemo.msgbean.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity
        extends AppCompatActivity
{

    private static final String TAG = "SecondActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button) findViewById(R.id.sendMessageBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("Hello !....."));
            }
        });
        Log.e(TAG,"-----------onCreate");

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
        Log.e(TAG, "-----------onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG,"-----------onRestart");
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        savedInstanceState.putString("key","数据");
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
