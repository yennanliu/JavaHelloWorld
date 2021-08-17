package Basics.CustomerCRM.service;

// https://www.youtube.com/watch?v=4mopAdK6kN8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=395
// https://www.youtube.com/watch?v=vBp_tt2gxYI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=395
// https://www.youtube.com/watch?v=coOGqYVKq8A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=398

import Basics.EmployeeCRM.team.domain.Architect;
import Basics.EmployeeCRM.team.domain.Designer;
import Basics.EmployeeCRM.team.domain.Employee;
import Basics.EmployeeCRM.team.domain.Programmer;
import Basics.EmployeeCRM.team.service.Status;
import Basics.EmployeeCRM.team.service.TeamException;

/**
 *  dev team member add/modify/delete/
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
        // get how many architects/designers/programmers currently
        int numOfArch = 0;
        int numOfDes = 0;
        int numOfPro = 0;
        for (int i = 0; i < total; i++){
            // NOTE : we start from the `small` group to `big` group
            // (e.g. we have least Architect, then Designer, and Programmer)
            if (team[i] instanceof Architect){
                numOfArch ++;
            }else if(team[i] instanceof Designer){
                numOfDes ++;
            }else if(team[i] instanceof Programmer){
                numOfPro ++;
            }
        }

        // V1
        if (p instanceof Architect){
            // if more than 1 Architect
            if (numOfArch >= 1){
                throw new TeamException("more than 1 Architect !");
            }
        else if (p instanceof Designer){
            if (numOfDes > 2){
                throw new TeamException("more than 2 Designer !");
                }
            }
        else if (p instanceof Programmer){
            if (numOfPro > 3){
                throw new TeamException("more than 3 Programmer !");
                }
            }
        }

       /**
        * *** NOTE : WE CAN'T WRITE LOGIC LIKE BELOW
        *  -> below cases may happen
        *
        *  1) for (p instanceof Architect && numOfArch >= 1)
        *    -> could be cases that instanceof Architect is true
        *    -> but numOfArch >= 1 is false
        *    -> So, the logic will go to ` else if (p instanceof Designer && numOfDes > 2) `
        *    -> which is not what we want
        *
        *  2) consider case :
        *    -> there are 2 designers in team, now we want add 1 new Architect
        *    -> V1 (above) will work properly, while V2 (below) will be wrong
        */

// V2
//        if (p instanceof Architect && numOfArch >= 1){
//                throw new TeamException("more than 1 Architect !");
//        }
//        else if (p instanceof Designer && numOfDes > 2){
//                    throw new TeamException("more than 2 Designer !");
//        }
//        else if (p instanceof Programmer && numOfPro > 3){
//                    throw new TeamException("more than 3 Programmer !");
//            }
//        }

        // add p (member) to existing team
        team[total] = p;
        total ++;

        // update member status
        p.setStatus(Status.BUSY);
        p.setMemberId(counter ++);
    }

    /** remove member from team */
    public void removeMember(int memberId) throws TeamException {
         int i = 0;
         // NOTE below syntax (;i < total; i++)
         for (;i < total; i++){
             // if memberId is found, delete it, and break the loop
             if (team[i].getMemberId() == memberId){
                 team[i].setStatus(Status.FREE);
                 break;
             }
         }

        // memberId is NOT found
        if (i == total){
            throw new TeamException("memberId is NOT found");
        }

        // move remaining members to left (1 index) for occupying the removed member index
        // e.g. [1,2,3,4]
        // remove 2
        // -> [1,,3,4] -> [1,3,4]
        for (int j = i + 1; j < total; j ++){
            team[j-1] = team[j];
        }
        // set last element as null
        team[total - 1] = null;
        total --;
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
