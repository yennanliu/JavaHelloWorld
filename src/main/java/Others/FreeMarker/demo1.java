package Others.FreeMarker;

// http://blog.appx.tw/2017/05/10/freemarker1/
// http://blog.appx.tw/2017/05/11/freemarker2/

import Others.FreeMarker.bean.Book;
import Others.FreeMarker.bean.User;
import Others.FreeMarker.bean.User2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

public class demo1 {

    @Test
    public void test1(){

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + path);

        //初始化freemarker設定
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        //指定樣版所在位置 (這裡是classpath的templates資料夾底下)
        cfg.setClassForTemplateLoading(demo1.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        //封裝資料的物件，可以是一般物件，也可以是List, Map 等集合物件
        User user = new User("Terry", "Taiwan");

        //取得樣版處理後輸出到 StringWriter
        StringWriter sw = new StringWriter();
        try {
            cfg.getTemplate("helloworld.ftl").process(user, sw);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //透過StringWriter的toString()取得內容，後續可以進行處理
        System.out.println(sw);
    }

    @Test
    public void test2(){

        //初始化freemarker設定
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        //指定樣版所在位置 (這裡是classpath的templates資料夾底下)
        cfg.setClassForTemplateLoading(demo1.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        //封裝資料的物件，可以是一般物件，也可以是List, Map 等集合物件
        //User user = new User("Terry", "Taiwan");
        User user = new User();
        user.setLocation("UK");
        user.setName("Jim");

        //取得樣版處理後輸出到 StringWriter
        StringWriter sw = new StringWriter();
        try {
            cfg.getTemplate("helloworld2.ftl").process(user, sw);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //透過StringWriter的toString()取得內容，後續可以進行處理
        System.out.println(sw);

        // save
    }

    @Test
    public void test3(){

        //初始化freemarker設定
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        //指定樣版所在位置 (這裡是classpath的templates資料夾底下)
        cfg.setClassForTemplateLoading(demo1.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        //封裝資料的物件，可以是一般物件，也可以是List, Map 等集合物件
        User2 user = prepareData();

        //取得樣版處理後輸出到 StringWriter
        StringWriter sw = new StringWriter();
        try {
            cfg.getTemplate("helloworld3.ftl").process(user, sw);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //透過StringWriter的toString()取得內容，後續可以進行處理
        System.out.println(sw);
    }

    private static User2 prepareData() {
        User2 user = new User2("Terry", "Taiwan", 201234, new Date());
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java in Action", "Anderson"));
        books.add(new Book("Oracle tutorial", "Tom"));
        user.setBooks(books);
        return user;
    }

}
