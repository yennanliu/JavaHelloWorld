package dev;

// https://www.runoob.com/w3cnote/fastjson-intro.html
// https://blog.csdn.net/xuexi_gan/article/details/114915890
// https://github.com/yennanliu/til/blob/master/README.md#20221029

// import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dev.bean.Car;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FastJsonTest1 {

  /**
   * // java Map<String, List<Catelog2Vo>> result = JSON.parseObject(CatelogJSON, new
   * TypeReference<Map<String, List<Catelog2Vo>>>() {} );
   */

  /**
   * https://www.runoob.com/w3cnote/fastjson-intro.html
   *
   * <p>Java obj -> json
   */
  @Test
  public void JavaObj2Json1() {

    List<Car> cars = new ArrayList<Car>();
    cars.add(new Car(1, "TESLA", 1000));
    cars.add(new Car(2, "BMW", 999));
    cars.add(new Car(3, "BENZ", 362));

    String jString1 = JSON.toJSONString(cars);

    System.out.println(
        ">>> jString1 = "
            + jString1); // jString1 =
                         // [{"brand":"TESLA","id":1,"idAndBrand":"1-TESLA","price":1000.0},{"brand":"BMW","id":2,"idAndBrand":"2-BMW","price":999.0},{"brand":"BENZ","id":3,"idAndBrand":"3-BENZ","price":362.0}]
  }

  @Test
  public void Str2Json_1() {

    // https://juejin.cn/post/6989067030775545886
    // https://www.w3cschool.cn/fastjson/fastjson-ex2.html

    // TODO Auto-generated method stub
    // String str =
    // "{\"cases\"[{\"classname\":\"HttpGet\",\"url\":\"https://www.baidu.com\"},{\"classname\":\"HttpPost\",\"url\":\"https:www.qq.com\"}]}";
    // String str =
    // "{\"cases\"[{\"classname\":\"HttpGet\",\"url\":\"https://www.baidu.com\"},{\"classname\":\"HttpPost\",\"url\":\"https:www.qq.com\"}]}";
    // String str = "{\"avBar\":[{\"barAge\":174398800,\"barDate\":\"2011-11-23
    // 23:30:33\",\"barName\":\"sss_0.62378174\"}";
    String str = "{'area':{'area':'1','pagetype':'home'},'pagetype':'home'}";
    JSONObject json;
    try {
      json = JSON.parseObject(str);
      System.out.println(json);
      System.out.println(json.get("pagetype"));
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
