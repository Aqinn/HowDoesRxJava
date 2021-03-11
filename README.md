# HowDoesRxJava
[![](https://img.shields.io/badge/license-MIT-blue)](https://github.com/Aqinn/HowDoesRxJava/blob/master/LICENSE)
[![](https://img.shields.io/badge/version-1.0-brightgreen)](https://github.com/Aqinn/HowDoesRxJava)

RxJava 的简易实现(Simple implementation of RxJava), 旨在理解 RxJava 的实现原理。

## 类图（Class Diagram）

![image](https://github.com/Aqinn/HowDoesRxJava/blob/master/uml_rxjava.png)

## 样例用法（Sample）

``` java
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
```

```
订阅成功！
Halo, zzq
Halo, zzf
消息处理完成
异常处理中
java.lang.Exception: 没有错误，测试而已
	at com.aqinn.howdoes.rxjava.test.Client$1.subscribeActual(Client.java:22)
	at com.aqinn.howdoes.rxjava.Observable.subscribe(Observable.java:16)
	at com.aqinn.howdoes.rxjava.test.Client.main(Client.java:25)
```