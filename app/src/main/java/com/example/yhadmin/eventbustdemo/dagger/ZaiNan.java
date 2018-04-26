package com.example.yhadmin.eventbustdemo.dagger;

/*
 *  @项目名：  EventBustDemo 
 *  @包名：    com.example.yhadmin.eventbustdemo.dagger
 *  @文件名:   ZaiNan
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/4/23 17:03
 *  @描述：    TODO
 */

import javax.inject.Inject;

public class ZaiNan {
    @Inject//在属性上则表示需要依赖，这里是需要 Baozi 的依赖
    Baozi  mBaozi;
    @Inject
    Noodle mNoodle;
    //在构造方法上则表示可提供依赖，这里是可提供 ZaiNan 的依赖
    @Inject
    public ZaiNan() {

    }
    @Inject
    String resturant;

    public String eat() {
        StringBuilder sb = new StringBuilder();
        sb.append("我从 ");
        sb.append(resturant.toString());
        sb.append("订的外卖，");
        sb.append("我吃的是 ");
        if ( mBaozi != null ) {
            sb.append(mBaozi.toString());
        }

        if (mNoodle != null) {
            sb.append("  ");
            sb.append(mNoodle.toString());
        }
        return sb.toString();
    }
/*    public String eat() {
        StringBuilder sb = new StringBuilder();
        sb.append("我吃的是 ");
        if (mBaozi != null) {
            sb.append(mBaozi.toString());
        }

        if (mNoodle != null) {
            sb.append("  ");
            sb.append(mNoodle.toString());
        }
        return sb.toString();
    }*/
}
