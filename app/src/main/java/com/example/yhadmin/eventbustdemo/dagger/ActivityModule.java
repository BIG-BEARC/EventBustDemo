package com.example.yhadmin.eventbustdemo.dagger;

/*
 *  @项目名：  EventBustDemo 
 *  @包名：    com.example.yhadmin.eventbustdemo.dagger
 *  @文件名:   ActivityModule
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/4/24 11:35
 *  @描述：    TODO
 */

import dagger.Module;
import dagger.Provides;
@Module
public class ActivityModule {
    @Provides
    public int provideActivityTest(){
        return 1234567890;
    }
}
