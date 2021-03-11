package com.aqinn.howdoes.rxjava;

/**
 * 被观察者
 *
 * @Author Aqinn
 * @Date 2021/3/11 7:54 下午
 */
public abstract class Observable<T> implements ObservableSource<T> {

    protected abstract void subscribeActual(Observer<? super T> observer);

    @Override
    public void subscribe(Observer<T> observer) {
        observer.onSubscribe();
        subscribeActual(observer);
    }

}
