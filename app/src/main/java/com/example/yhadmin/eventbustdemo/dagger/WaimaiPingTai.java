package com.example.yhadmin.eventbustdemo.dagger;

import com.example.yhadmin.eventbustdemo.MainActivity;

import dagger.Component;

/*
 *  @项目名：  EventBustDemo 
 *  @包名：    com.example.yhadmin.eventbustdemo.dagger
 *  @文件名:   WaimaiPingTai
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/4/23 17:59
 *  @描述：    TODO
 */
@Component(modules = {ShangJiaAModule.class,ActivityModule.class})
public interface WaimaiPingTai {
    ZaiNan waimai();
    //表示对参数对象 ZaiNan 进行依赖注入
    void zhuru(ZaiNan ZaiNan);

    void inject(MainActivity mainActivity);
}
