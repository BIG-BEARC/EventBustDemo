package com.example.yhadmin.eventbustdemo.dagger;

/*
 *  @项目名：  EventBustDemo 
 *  @包名：    com.example.yhadmin.eventbustdemo.dagger
 *  @文件名:   ShangJiaAModule
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/4/23 17:20
 *  @描述：    TODO
 */

import dagger.Module;
import dagger.Provides;

@Module//提供依赖的模块
public class ShangJiaAModule {

    String restaurant;

    public ShangJiaAModule(String restaurant) {
        this.restaurant = restaurant;
    }

    @Provides//提供依赖
    public Baozi provideBaozi() {
        return new Baozi("豆沙包");
    }

    @Provides
    public Noodle provideKangshifu() {
        return new Kangshifu();
    }

  /*  一个类不可以被多次注入依赖
    @Provides
    public Noodle provideNoodle(TongYi noodle) {
        return noodle;
    }*/

    /*因为在 TongYi 的构造方法中添加了 @Inject 注解，表明为可提供依赖，故可直接使用参数作为依赖注入
     @Provides
     public Noodle provideNoodle() {
         return new TongYi();
     }*/

   /* @Provides
    public String provideResturant() {
        return "王小二包子店";
    }
*/
    @Provides
    public String provideResturant() {
        return restaurant;
    }

}
