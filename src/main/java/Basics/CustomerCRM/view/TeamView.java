package Basics.CustomerCRM.view;

// https://www.youtube.com/watch?v=5kA26LIcXHU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=399
// https://www.youtube.com/watch?v=UGjEUpcR2Pw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=400

import Basics.CustomerCRM.service.TeamService;
import Basics.EmployeeCRM.team.domain.Employee;
import Basics.EmployeeCRM.team.service.NameListService;
import Basics.EmployeeCRM.team.utils.TSUtility;

public class TeamView {

    // attr
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    // method
    public void enterMainMenu(){

        // if keep looping
        boolean loopFlag = true;
        char menu = 0;

        while(loopFlag){

            if (menu != '1'){
                listAllEmployees();
            }

            System.out.println("1) Employee List 2) Add Member 3) Remove Member 4) Exist. Please select (1 to 4)\n");

            menu = TSUtility.readMenuSelection();

            switch (menu){
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
                    if (isExist == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    /** show all employees */
    private void listAllEmployees(){

        System.out.println("--------------------- List All Employees --------------------- \n");

        Employee[] employees =  listSvc.getAllEmployees();

        if (employees == null || employees.length == 0){

            System.out.println("No employee in company !");
        }else{

            System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tDevice");

            for (int i =0; i < employees.length; i++){
                System.out.println(employees[i]);
            }
        }

        System.out.println("--------------------- List All Employees --------------------- \n");
    }

    private void getTeam(){
        System.out.println("getTeam");
    }

    private void addMember(){
        System.out.println("addMember");
    }

    private void deleteMember(){
        System.out.println("deleteMember");
    }

    /** entry point */
    public static void main(String[] args){
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
