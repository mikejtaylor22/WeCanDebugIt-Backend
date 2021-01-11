package com.WeCanDebugIt.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BugHardCodedService {
    private static List<Bug> bugs = new ArrayList();

    private static long idCounter = 100;


    static {
        bugs.add(new Bug("Cannot Access Website",++idCounter,"Open",new Date(),"When Accessing the website I am receiving a 404 error. It is bad","mike"));
        bugs.add(new Bug("Slow loading options",++idCounter,"Open",new Date(),"The website is taking way too long to load when creating a new bug","mike"));
        bugs.add(new Bug("I fell off my chair",++idCounter,"Open",new Date(),"My chair broke. The arms are not holding me in any longer","mike"));
        bugs.add(new Bug("Code Sprint 1",++idCounter,"Open",new Date(),"Starting code sprint to develop bug tracker","joe"));
        bugs.add(new Bug("All Bug data not populating",++idCounter,"Open",new Date(),"All Bug Data is not populating when clicked","Andrea"));
    }

    public List<Bug> findAll(){
        return bugs;
    }

    public Bug save(Bug bug){
        if(bug.getId() == -1 || bug.getId() == 0){
            bug.setId(++idCounter);
            bugs.add(bug);
        }   else {
            deleteBugById(bug.getId());
            bugs.add(bug);
        }
        return bug;
    }



    public Bug deleteBugById(long id){
        Bug bug = findById(id);

        if(bug == null){
            return null;
        }
        if(bugs.remove(bug)){
            return bug;
        }
        return null;
    }

    public Bug findById(long id){
        for(Bug bug: bugs){
            if(bug.getId() == id){
                return bug;
            }
        }
        return null;
    }

    public List<Bug> findByUsername(String username){
        List<Bug> userBugs = new ArrayList();
        for(Bug bug: bugs){
            if(bug.getUsername().equalsIgnoreCase(username)){
                userBugs.add(bug);
            }
        }
        return userBugs;
    }
}
