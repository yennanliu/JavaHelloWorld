package org.example.DynamicProxy;

// https://youtu.be/pjGu5Y8e2vU?si=SVfsG5ZuCKAlJI96&t=1050

import org.example.Calculator;
import org.example.CalculatorImpl;

/** Testing ProxyFactory.java */
public class TestProxyFactory {
  public static void main(String[] args) {

    // dynamically create proxied instance (動態創建代理對象)
    ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
    Calculator Proxy = (Calculator) proxyFactory.getProxy();
    // call target method (呼叫代理對象方法)
    Proxy.add(1, 2);

    Proxy.mul(2, 7);
  }
}
