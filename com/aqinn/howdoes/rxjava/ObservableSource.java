package com.aqinn.howdoes.rxjava;

/**
 * 被观察者 - 抽象出订阅行为
 * @Author Aqinn
 * @Date 2021/3/11 8:15 下午
 */
public interface ObservableSource<T> {

    void subscribe(Observer<T> observer);

}
