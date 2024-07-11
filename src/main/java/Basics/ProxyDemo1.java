package Basics;

// https://www.youtube.com/watch?v=hNHutM_k7EM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=354

interface Network {
  // attr
  // method
  void browse();
}

/**
 * Design pattern : Proxy
 *
 * <p>1) use proxy class instead of the actual "true" class 2) using case: - safety -> prevent
 * actual class to be visited directly - remote proxy -> RMI - delay loading -> load the proxy class
 * first, if needed, load the actual class
 *
 * <p>3) Types - static proxy (this example) - dynamic proxy -> "java reflection", we will cover
 * this later
 */
public class ProxyDemo1 {
  public static void main(String[] args) {

    // run
    Server server = new Server();

    // polymorphism (put server into public ProxyServer(Network work))
    ProxyServer proxyServer = new ProxyServer(server);
    // or, can use below
    // ProxyServer proxyServer = new ProxyServer(new Server());

    /**
     * NOTE : we're not explicitly using Server class below, but we run browse method via "proxy"
     * (e.g. proxyServer) class
     */
    proxyServer.browse();
  }
}

/** proxied class */
class Server implements Network {
  // attr

  // constructor

  // method
  @Override
  public void browse() {
    System.out.println("Server browse");
  }
}

/** proxy class */
class ProxyServer implements Network {
  // attr
  private final Network work;

  // constructor
  public ProxyServer(Network work) {
    this.work = work;
  }

  // method
  public void check() {
    System.out.println("Prepare before connect to internet ...");
  }

  @Override
  public void browse() {
    check();
    // System.out.println();
    work.browse();
  }
}
