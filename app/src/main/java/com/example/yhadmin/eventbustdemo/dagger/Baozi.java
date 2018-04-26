package com.example.yhadmin.eventbustdemo.dagger;

/*
 *  @项目名：  EventBustDemo 
 *  @包名：    com.example.yhadmin.eventbustdemo.dagger
 *  @文件名:   Baozi
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/4/23 17:04
 *  @描述：    TODO
 */

import javax.inject.Inject;

public class Baozi {
    String name;

    @Inject
    public Baozi() {
        name = "小笼包";
    }

    public Baozi(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
