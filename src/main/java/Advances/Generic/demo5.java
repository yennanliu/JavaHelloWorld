package Advances.Generic;

// https://www.youtube.com/watch?v=fGNOpFN0rv8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=570

/** demo5 : generic example : DAO */
import Advances.Generic.dao.EmployeeDAO;
import Advances.Generic.dao.StudentDAO;
import java.util.List;
import org.junit.jupiter.api.Test;

public class demo5 {
  @Test
  public void test1() {
    EmployeeDAO dao1 = new EmployeeDAO();

    dao1.add(new Employee());
    List<Employee> list1 = dao1.getList(10);

    System.out.println(list1);
  }

  @Test
  public void test2() {
    StudentDAO dao1 = new StudentDAO();

    dao1.add(new Student());
    List<Student> list1 = dao1.getList(10);

    System.out.println(list1);
  }
}
