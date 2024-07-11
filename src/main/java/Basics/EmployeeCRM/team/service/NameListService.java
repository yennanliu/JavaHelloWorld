package Basics.EmployeeCRM.team.service;

// https://www.youtube.com/watch?v=nxXTXqKs8GU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=391
// https://www.youtube.com/watch?v=NIDV6Ol1QLw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=392

import Basics.EmployeeCRM.team.domain.*;

// import static Basics.EmployeeCRM.team.service.Data.*;

/**
 * NameListService
 *
 * <p>1) class for adding data (employee) to Employee array
 */
public class NameListService {

  // attr
  private final Employee[] employees;

  // constructor

  /**
   * Instantiate employees and its elements
   *
   * <p>1) offer employee bases on data 2) construct different instances bases in type in data ->
   * e.g. Employee, Programmer, Designer, Architect ...
   */
  public NameListService() {
    employees = new Employee[Data.EMPLOYEES.length];
    // employees = new Employee[EMPLOYEES.length]; // if want to use, need to import static
    // Basics.EmployeeCRM.team.service.Data.*;

    // identify which role (Programmer, Designer, Architect) to instantiate
    for (int i = 0; i < employees.length; i++) {

      // get employee type
      int type = Integer.parseInt(Data.EMPLOYEES[i][0]); // transfer to int via Integer.parseInt

      // get employee basic fields
      int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
      String name = Data.EMPLOYEES[i][2];

      int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
      double salary =
          Double.parseDouble(Data.EMPLOYEES[i][4]); // note the syntax : Double.parseDouble

      // NOTE : below we declare equipment, but NOT implement
      //        -> PROGRAMMER, DESIGNER will implement their equipment themself
      Equipment equipment;

      double bonus;

      int stock;

      switch (type) {
        case Data.EMPLOYEE:
          employees[i] = new Employee(id, name, age, salary);
          break;

        case Data.PROGRAMMER:
          equipment = createEquipment(i);
          employees[i] = new Programmer(id, name, age, salary, equipment);
          break;

        case Data.DESIGNER:
          equipment = createEquipment(i);
          bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
          employees[i] = new Designer(id, name, age, salary, equipment, bonus);
          break;

        case Data.ARCHITECT:
          equipment = createEquipment(i);
          bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
          stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
          employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
          break;
      }
    }
  }

  // method
  // get equipment from employee's index
  private Equipment createEquipment(int index) {

    int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);

    String modelOrName = Data.EQUIPMENTS[index][1];
    String display = Data.EQUIPMENTS[index][2];

    switch (key) {
      case Data.PC: // 21
        return new Basics.EmployeeCRM.team.domain.PC(modelOrName, display);

      case Data.NOTEBOOK: // 22
        double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
        new Basics.EmployeeCRM.team.domain.NoteBook(modelOrName, price);
        break;

      case Data.PRINTER: // 23
        String type = Data.EQUIPMENTS[index][2];
        new Basics.EmployeeCRM.team.domain.Printer(modelOrName, type);
        break;
    }
    return null;
  }

  public Employee[] getAllEmployees() {
    return employees;
  }

  public Employee getEmployee(int id) throws TeamException {
    for (int i = 0; i < employees.length; i++) {
      if (employees[i].getId() == id) { // basic data type (int), so can use `==`
        return employees[i];
      }
    }
    throw new TeamException("employee id not existed !");
  }
}
