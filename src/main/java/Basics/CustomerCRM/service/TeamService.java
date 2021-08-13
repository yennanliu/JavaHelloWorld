package Basics.CustomerCRM.service;

// https://www.youtube.com/watch?v=4mopAdK6kN8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=395

import Basics.EmployeeCRM.team.domain.Employee;
import Basics.EmployeeCRM.team.domain.Programmer;

/**
 *  dev team member add/modify/delete/
 *
 */

public class TeamService {
    //attr
    private static int counter = 1; // increasing, for member id
    private final int MAX_MEMBER = 5; // mex members in a dev team
    private Programmer[] team = new Programmer[MAX_MEMBER]; // storage dev team members
    private int total; // current total member count in dev team

    // getter, setter

    // constructor
    public TeamService (){
        super();
    }

    // method
    /** get all members in dev team*/
    public Programmer[] getTeam(){
        //return null;
        Programmer[] result = new Programmer[total];
        for (int i=0; i < team.length; i++){
            result[i] = this.team[i];
        }
        return result;
    }

    public void addMember(Employee e){

    }

    public void removeMember(int memberId){

    }
}
