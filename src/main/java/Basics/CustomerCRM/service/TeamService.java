package Basics.CustomerCRM.service;

// https://www.youtube.com/watch?v=4mopAdK6kN8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=395

import Basics.EmployeeCRM.team.domain.Employee;
import Basics.EmployeeCRM.team.domain.Programmer;
import Basics.EmployeeCRM.team.service.TeamException;

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

    /** add member to dev team */
    public void addMember(Employee e) throws TeamException {
        // if members are full
        if (total >= MAX_MEMBER){
            System.out.println("members full !");
            throw new TeamException("members full !");
        }
        // if member is not developer, can't be added
        if (!(e instanceof Programmer)){
            throw new TeamException("members not developer, can't be added !");
        }
        // if member already in dev team
        if (isExist(e)){
            throw new TeamException("members already in dev team !");
        }

        // if member already belongs to some other team
        // if member is off (can't be added)
        Programmer p = (Programmer) e; // Downcasting
        if (p.getStatus().getNAME().equalsIgnoreCase("BUSY")){
            throw new TeamException("member already belongs to some other team");
        }else if (p.getStatus().getNAME().equalsIgnoreCase("VOCATION")){
            throw new TeamException("member is off (in holiday)");
        }

        // at most 1 architect in the team

        // at most 2 designers in the team

        // at most 3 programmers in the team
    }

    public void removeMember(int memberId){

    }

    // check if member already in dev team
    private boolean isExist(Employee e){
        for (int i=0; i < total; i ++){
            if (team[i].getId() == e.getId()){
                return true;
            }
        }
        return false;
    }
}
