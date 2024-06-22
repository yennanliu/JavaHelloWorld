package Basics.EmployeeCRM.team.test;

// https://www.youtube.com/watch?v=ebG0TlvIyqM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=393

import Basics.EmployeeCRM.team.domain.Employee;
import Basics.EmployeeCRM.team.service.NameListService;
import org.junit.jupiter.api.Test;

/** test NameListService class */
public class NameListServiceTest {

  @Test
  public void getAllEmployees() {
    NameListService service = new NameListService();
    Employee[] employees = service.getAllEmployees();
    for (int i = 0; i < employees.length; i++) {
      System.out.println(employees[i]);
    }
  }
}
