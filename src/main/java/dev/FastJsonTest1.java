package dev;

// https://www.runoob.com/w3cnote/fastjson-intro.html
// https://blog.csdn.net/xuexi_gan/article/details/114915890
// https://github.com/yennanliu/til/blob/master/README.md#20221029

import com.alibaba.fastjson.JSON;
import dev.bean.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FastJsonTest1 {

    /**
     *
     *  // java
     *  Map<String, List<Catelog2Vo>> result =
     *  JSON.parseObject(CatelogJSON, new TypeReference<Map<String, List<Catelog2Vo>>>() {} );
     */

    /**
     *  https://www.runoob.com/w3cnote/fastjson-intro.html
     *
     *  Java obj -> json
     */
    @Test
    public void JavaObj2Json1(){

        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(1,"TESLA",1000));
        cars.add(new Car(2,"BMW",999));
        cars.add(new Car(3,"BENZ",362));

        String jString1 = JSON.toJSONString(cars);

        System.out.println(">>> jString1 = " + jString1); // jString1 = [{"brand":"TESLA","id":1,"idAndBrand":"1-TESLA","price":1000.0},{"brand":"BMW","id":2,"idAndBrand":"2-BMW","price":999.0},{"brand":"BENZ","id":3,"idAndBrand":"3-BENZ","price":362.0}]

    }

}
