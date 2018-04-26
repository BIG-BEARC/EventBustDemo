package com.example.yhadmin.eventbustdemo.msgbean;

/*
 *  @项目名：  EventBustDemo 
 *  @包名：    com.example.yhadmin.eventbustdemo.msgbean
 *  @文件名:   MessageEvent
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/4/20 14:24
 *  @描述：    事件实体类
 */

public class MessageEvent {
    private  String msg;

    public MessageEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
