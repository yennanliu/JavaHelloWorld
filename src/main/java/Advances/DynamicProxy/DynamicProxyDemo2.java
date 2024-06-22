package Advances.DynamicProxy;

// https://www.youtube.com/watch?v=ySJn484D19Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=686

/**
 * Dynamic proxy demo 2
 *
 * <p>Main purposes :
 *
 * <p>-> 1) how to create proxy class and its instance dynamically based on proxied class which
 * already loaded to memory ? -> via Proxy.newProxyInstance()
 *
 * <p>-> 2) when call method "a" through proxy class, how to call proxied class' method "a"
 * dynamically ? -> via InvocationHandler interface's implementation class, and its invoke() method
 */
public class DynamicProxyDemo2 {}
