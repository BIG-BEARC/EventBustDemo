package com.example.yhadmin.eventbustdemo.dagger;

import dagger.Component;

/*
 *  @项目名：  EventBustDemo 
 *  @包名：    com.example.yhadmin.eventbustdemo.dagger
 *  @文件名:   Platform
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/4/23 17:11
 *  @描述：    TODO
 */

@Component(modules = ShangJiaAModule.class)//Component 注解，生成接口的对应实现类，moudules =？ 指定依赖的模块接口
public interface Platform {
    ZaiNan waimai();
}
