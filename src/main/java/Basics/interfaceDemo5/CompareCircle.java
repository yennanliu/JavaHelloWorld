package Basics.interfaceDemo5;

// https://www.youtube.com/watch?v=LfIyZ-iAJyE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=357

public class CompareCircle extends Circle implements CompareObject {
    //attr

    //constructor
    public CompareCircle(double radius){
        super(radius);
    }

    // method
    @Override
    public int compareTo(Object o) {
        // if this and o are from the same reference
        if (this == o){
            return 0;
        }
        // if o is the instance of Circle, -> then we can compare them
        if (o instanceof CompareCircle) {
            CompareCircle c = (CompareCircle) o;
            // wrong
            //return (int) (this.getRadius() - c.getRadius());
            // correct
//            if (this.getRadius() > c.getRadius()){
//                return 1;
//            } else if (this.getRadius() < c.getRadius()){
//                return  -1;
//            } else {
//                return 0 ;
//            }
            /**
             *  double -> Double
             *   when we use Double rather than double,
             *   we can use the comparable method defined in Double
             *   for comparision directly
             */
            // public Double getRadius()
            return this.getRadius().compareTo(c.getRadius());
        }
            // if type not match -> return 0 (raise an exception could be better)
            else {
                return 0;
                //throw new RuntimeException("insert data type is not matching");
            }
    }
}
