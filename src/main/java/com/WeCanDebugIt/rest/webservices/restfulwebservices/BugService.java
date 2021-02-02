package com.WeCanDebugIt.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Service;

@Service
public class BugService {
    private BugRepository bugRepository;

    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public Iterable<Bug> getAllBugs(){
        return bugRepository.findAll();
    }

    public Bug addBug(Bug bug){
        bugRepository.save(bug);
        return bug;
    }
}
