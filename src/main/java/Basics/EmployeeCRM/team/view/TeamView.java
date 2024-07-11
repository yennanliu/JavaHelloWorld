package Basics.EmployeeCRM.team.view;

// https://www.youtube.com/watch?v=mwg4N3epx9Y&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=502

import Basics.EmployeeCRM.team.domain.Employee;
import Basics.EmployeeCRM.team.service.NameListService;
import Basics.EmployeeCRM.team.service.TeamException;
import Basics.EmployeeCRM.team.service.TeamService;
import Basics.EmployeeCRM.team.utils.TSUtility;

public class TeamView {

  // attr
  private final NameListService listSvc = new NameListService();
  private final TeamService teamSvc = new TeamService();

  /** entry point */
  public static void main(String[] args) {
    TeamView view = new TeamView();
    view.enterMainMenu();
  }

  // method
  public void enterMainMenu() {

    // if keep looping
    boolean loopFlag = true;
    char menu = 0;

    while (loopFlag) {

      if (menu != '1') {
        listAllEmployees();
      }

      System.out.println(
          "1) Employee List 2) Add Member 3) Remove Member 4) Exist. Please select (1 to 4)\n");

      menu = TSUtility.readMenuSelection();

      switch (menu) {
        case '1':
          getTeam();
          break;
        case '2':
          addMember();
          break;
        case '3':
          deleteMember();
          break;
        case '4':
          System.out.println("Exit ? (Y/N) ");
          char isExist = TSUtility.readConfirmSelection();
          if (isExist == 'Y') {
            loopFlag = false;
          }
          break;
      }
    }
  }

  /** show all employees */
  private void listAllEmployees() {

    System.out.println("--------------------- List All Employees --------------------- \n");

    Employee[] employees = listSvc.getAllEmployees();

    if (employees == null || employees.length == 0) {

      System.out.println("No employee in company !");
    } else {

      System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tDevice");

      for (int i = 0; i < employees.length; i++) {
        System.out.println(employees[i]);
      }
    }

    System.out.println("--------------------- List All Employees --------------------- \n");
  }

  private void getTeam() {
    System.out.println("getTeam");
  }

  private void addMember() {

    System.out.println("--------------------- Add Member --------------------- \n");
    System.out.println("Plz enter the to-add member id");
    int id = TSUtility.readInt();

    try {
      Employee emp = listSvc.getEmployee(id);
      teamSvc.addMember(emp);
      System.out.println("add member OK !");
      TSUtility.readReturn();
    } catch (TeamException e) {
      System.out.println("add member failed ! " + e.getMessage());
    }
  }

  private void deleteMember() {
    System.out.println("--------------------- Delete Member --------------------- \n");

    System.out.println("Plz enter the to-delete member id");
    int memberId = TSUtility.readInt();

    System.out.println("Confirm to Delete ? (Y/N)");
    char isDelete = TSUtility.readConfirmSelection();

    // if Not delete
    if (isDelete == 'N') {
      return;
    }

    // if delete
    try {
      teamSvc.removeMember(memberId);
      System.out.println("delete member OK!");
    } catch (TeamException e) {
      System.out.println("delete member failed!" + e.getMessage());
    }
    // back to the main program
    TSUtility.readReturn();
  }
}
