package com.aqinn.howdoes.rxjava;

/**
 * 观察者
 * @Author Aqinn
 * @Date 2021/3/11 8:07 下午
 */
public interface Observer<T> {

    void onSubscribe();

    void onNext(T t);

    void onComplete();

    void onError(Throwable e);

}
