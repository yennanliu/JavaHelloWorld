package Basics.EmployeeCRM.team.service;

// https://www.youtube.com/watch?v=nxXTXqKs8GU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=391

import Basics.EmployeeCRM.team.domain.Employee;
import Basics.EmployeeCRM.team.domain.Equipment;
//import static Basics.EmployeeCRM.team.service.Data.*;

/**
 *  NameListService
 *
 *   1) class for adding data (employee) to Employee array
 */

public class NameListService {

    // attr
    private Employee[] employees;

    // constructor

    /**
     *   Instantiate employees and its elements
     *
     * 1) offer employee bases on data
     * 2) construct different instances bases in type in data
     *    -> e.g. Employee, Programmer, Designer, Architect ...
     */
    public NameListService(){
        employees = new Employee[Data.EMPLOYEES.length];
        //employees = new Employee[EMPLOYEES.length]; // if want to use, need to import static Basics.EmployeeCRM.team.service.Data.*;

        // identify which role (Programmer, Designer, Architect) to instantiate
        for (int i=0; i < employees.length; i ++){

            // get employee type
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]); // transfer to int via Integer.parseInt

            // get employee basic fields
            int id =  Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name =  Data.EMPLOYEES[i][2];
            int age =  Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary =  Double.parseDouble(Data.EMPLOYEES[i][4]);  // note the syntax : Double.parseDouble

            switch (type){

                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;

//                case Data.PROGRAMMER:
//                    Equipment equipment = createEquipment(i);
//                    employees[i] = new Employee(id, name, age, salary, equipment);
//                    break;

                case Data.DESIGNER:
                    break;

                case Data.ARCHITECT:
                    break;
            }
        }
    }

    // method
    public Employee[] getAllEmployees(){
        return null;
    }

    public Employee getAllEmployees(int id){
        return null;
    }

    // get equipment from employee's index
    private Equipment createEquipment(int index){

        int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);

        String modelOrName = Data.EQUIPMENTS[index][1];
        String display = Data.EQUIPMENTS[index][2];

        switch (key){

            case Data.PC:  // 21
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
}
