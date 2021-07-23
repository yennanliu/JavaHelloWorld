package Basics.EmployeeCRM.team.service;

// https://www.youtube.com/watch?v=wcC_8L6Yf9o&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=388

public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
            {"10", "1", "BillGates", "22", "3000"},
            {"13", "2", "ElonMask", "32", "18000", "15000", "2000"},
            {"11", "3", "Jobs", "23", "7000"},
            {"11", "4", "JackDorsey", "24", "7300"},
            {"12", "5", "サンダー・ピチャイは", "28", "10000", "5000"},
            {"11", "6", "Mark Elliot Zuckerberg", "22", "6800"},
            {"12", "7", "Andy Jassy", "29", "10800","5200"},
            {"13", "8", "Tim Cook", "30", "19800", "15000", "2500"},
            {"12", "9", "Dr. CC Wei", "26", "9800", "5500"},
            {"11", "10", "Jensen Huang", "21", "6600"},
            {"11", "11", "Susan Diane Wojcicki", "25", "7100"},
            {"12", "12", "kiki", "27", "9600", "4800"}
    };

    //EQUIPMENTS as blow will accompany with EMPLOYEES array elements (above)
    //PC      :21, model, display
    //NoteBook:22, model, price
    //Printer :23, name, type
    public static final String[][] EQUIPMENTS = {
            {},
            {"22", "IPHONE", "6000"},
            {"21", "IPHONE", "17"},
            {"21", "SAMSUNG", "inch"},
            {"23", "PIXEL", "激光"},
            {"21", "IPHONE", "17 inch"},
            {"21", "NOKIA", "17寸"},
            {"23", "SONY", "model A"},
            {"22", "SONY", "5800"},
            {"21", "DELL", "NEC 17 inch"},
            {"21", "BLACKBERRY","9 inch"},
            {"22", "NOKIA", "5800"}
    };
}
