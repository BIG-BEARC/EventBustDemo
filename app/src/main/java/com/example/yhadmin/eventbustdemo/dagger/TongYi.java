package com.example.yhadmin.eventbustdemo.dagger;

/*
 *  @项目名：  EventBustDemo 
 *  @包名：    com.example.yhadmin.eventbustdemo.dagger
 *  @文件名:   TongYi
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/4/23 17:28
 *  @描述：    TODO
 */

import javax.inject.Inject;

public class TongYi
        extends Noodle
{
    @Inject//可提供依赖
    public TongYi() {
    }

    @Override
    public String toString() {
        return "统一方便面";
    }

}
