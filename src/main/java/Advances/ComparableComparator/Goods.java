package Advances.ComparableComparator;

// https://www.youtube.com/watch?v=iCKc2-vslbg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=491

/**
 *  Goods class
 *
 *   1) for making Goods "sortable", we need to implement Comparable interface
 *      and override compareTo() method
 */
public class Goods implements Comparable{

    // attr
    private String name;
    private double price;

    // constructor
    public Goods(){

    }

    public Goods(String name, double price){
        this.name = name;
        this.price = price;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // methods

    // toString
    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    // implement the ordering logic : low price -> high price
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            // method 1)
            // if cur price > compared price -> return positive integer (1)
            if (this.price > goods.price){
                return 1;
            } // if cur price < compared price -> return negative integer (-1)
            else if (this.price < goods.price){
                return -1;
            }
            // if cur price == compared price -> return zero (0)
            else{
                return 0;
                // in case price are equals, if we also need to compare their name
                //return this.name.compareTo(goods.name);
            }
            // method 2)
            //return Double.compare(this.price, goods.price);

        }
        throw new RuntimeException("input (price) type mismatch!");
    }
}
