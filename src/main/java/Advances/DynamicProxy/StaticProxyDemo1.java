package Advances.DynamicProxy;

// https://www.youtube.com/watch?v=lpzuJ0zYO9A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=661

/**
 *  Review : static proxy
 *
 *  -> static : proxy class - proxied class relation is fixed since compile step
 */

/** factory */
interface ClothFactory{
    void produceCloth();
}

/** proxy class (代理類) */
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; // init instance with proxied class (e.g. ClothFactory)

    // constructor
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {

        System.out.println(">>> (ProxyClothFactory) proxy factory start ...");

        // run factory's produceCloth method, will be dynamic when different "proxied class" is loaded ( e.g. ProxyClothFactory(ClothFactory factory) )
        factory.produceCloth();

        System.out.println(">>> (ProxyClothFactory) proxy factory do more ...");
    }

}

/** proxied class (被代理類) */
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println(">>> Nike factory produces AF1");
    }

}

public class StaticProxyDemo1 {
    public static void main(String[] args) {

        // 1) create "proxied class" (被代理類) instance
        NikeClothFactory nike = new NikeClothFactory();

        // 2) create "proxy class" (代理類) instance
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        // 3) run
        proxyClothFactory.produceCloth();
    }

}
