package com.WeCanDebugIt.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4201")
@RestController
public class BugResource {

    @Autowired
    private BugHardCodedService bugHardCodedService;
    @Autowired
    private BugService bugService;

    @GetMapping("/users/bugs")
    public List<Bug> getAllBugs(){
        return bugHardCodedService.findAll();
    }

//    @GetMapping("/users/bugs")
//    public Iterable<Bug> getAllBugs(){
//        return bugService.getAllBugs();
//    }

    @GetMapping("/users/{username}/bugs")
    public List<Bug> getUserBugs(@PathVariable String username){
        return bugHardCodedService.findByUsername(username);
    }

//    @GetMapping("/users/{username}/bugs")
//    public List<Bug> getUserBugs(@PathVariable String username){
//        return bugRepository.findById(bugHardCodedService.findByUsername(username).get());
//    }

    @GetMapping("/users/{username}/bugs/{id}")
    public Bug getBug(@PathVariable String username, @PathVariable long id){
        return bugHardCodedService.findById(id);
    }

    @PutMapping("/users/{username}/bugs/{id}")
    public ResponseEntity<Bug> updateBug(@PathVariable String username, @PathVariable long id, @RequestBody Bug bug){
        Bug bugUpdate = bugHardCodedService.save(bug);
        return new ResponseEntity<Bug>(bug, HttpStatus.OK);
    }

//    @PutMapping("/users/{username}/bugs/{id}")
//    public void updateBug(@PathVariable String username, @PathVariable long id, @RequestBody Bug bug){
//        Bug bugUpdate = bugService.addBug(bug);
////        return new ResponseEntity<Bug>(bugUpdate, HttpStatus.OK);
//    }

    @PostMapping ("/users/{username}/bugs")
    public ResponseEntity<Void> updateBug(@PathVariable String username, @RequestBody Bug bug) {
        Bug createdTodo = bugHardCodedService.save(bug);
        //get current resource URL
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

//    @PostMapping ("/users/{username}/bugs")
//    public void addBug(@PathVariable String username, @RequestBody Bug bug) {
//        Bug newBug = bugService.addBug(bug);
//
//    }



    @DeleteMapping("/users/{username}/bugs/{id}")
    public ResponseEntity<Void> deleteBug(@PathVariable String username, @PathVariable long id){
        Bug bug = bugHardCodedService.deleteBugById(id);
        if(bug != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
