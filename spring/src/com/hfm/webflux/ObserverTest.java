package com.hfm.webflux;

import java.util.Observable;
import java.util.Observer;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-09-30 19:45
 * @Description 观察者设计模式
 * @date 2020/9/30
 */
public class ObserverTest {
    public static void main(String[] args) {
        MyObservable myObservable = new MyObservable();

        // 实现 Observer 接口,创建观察者对象
        Observer observer1 = new Observer() {
            /**
             * 重写 update 方法
             * @param o
             * @param arg
             */
            @Override
            public void update(Observable o, Object arg) {
                String str = (String) arg;
                System.out.println(str);
            }
        };

        // 多个观察者对象
        Observer observer2 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                String str = (String) arg;
                System.out.println(str);
            }
        };

        // 添加观察者
        myObservable.addObserver(observer1);
        myObservable.addObserver(observer2);

        // 被观察者发布消息
        myObservable.publish("被观察者发布消息!");
    }
}

/**
 * 创建 Observerable 被观察者子类
 */
class MyObservable extends Observable{
    /**
     * 被观察者发送消息,并通知观察者对象
     */
    public void publish(String str){
        // 标识状态改变
        this.setChanged();
        // 通知观察者，并传参数
        this.notifyObservers(str);
    }
}