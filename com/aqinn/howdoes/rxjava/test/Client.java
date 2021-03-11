package com.aqinn.howdoes.rxjava.test;

import com.aqinn.howdoes.rxjava.Observable;
import com.aqinn.howdoes.rxjava.Observer;

/**
 * 客户端
 *
 * @Author Aqinn
 * @Date 2021/3/11 7:43 下午
 */
public class Client {

    public static void main(String[] args) {
        // 以下做法不是被实例化，只是通过匿名内部类实现了一个子类并实例化了子类
        Observable<String> observable = new Observable<String>() {
            @Override
            protected void subscribeActual(Observer<? super String> observer) {
                observer.onNext("zzq");
                observer.onNext("zzf");
                observer.onComplete();
                observer.onError(new Exception("没有错误，测试而已"));
            }
        };
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe() {
                System.out.println("订阅成功！");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Halo, " + s);
            }

            @Override
            public void onComplete() {
                System.out.println("消息处理完成");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("异常处理中");
                e.printStackTrace();
            }
        });
    }

}
