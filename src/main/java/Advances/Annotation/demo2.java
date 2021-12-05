package Advances.Annotation;

// https://www.youtube.com/watch?v=yExYHSR67TU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=509

import java.util.ArrayList;

public class demo2 {
}


// T is generic type
// we can decorate the generic type with user-defined-annotation (@MyAnnotation3) via `ElementType.TYPE_USE` in @Target({ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
class Generic<@MyAnnotation3 T>{
    // attr

    // method
    public void show() throws @MyAnnotation3 RuntimeException{

        ArrayList<@MyAnnotation3  String> list = new ArrayList<> ();

        int num = (@MyAnnotation3  int) 10L;
    }

}