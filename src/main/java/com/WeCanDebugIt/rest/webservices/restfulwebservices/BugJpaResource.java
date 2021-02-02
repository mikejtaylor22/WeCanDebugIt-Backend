package com.WeCanDebugIt.rest.webservices.restfulwebservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
public class BugJpaResource {


    @Autowired
    private BugJpaRepository bugJpaRepository;

    @GetMapping("/jpa/users/bugs")
    public List<Bug> getAllBugs() {

        return bugJpaRepository.findAll();
    }

    @GetMapping("/jpa/users/{username}/bugs")
    public List<Bug> getUserBugs(@PathVariable String username) {
        return bugJpaRepository.findByUsername(username);

    }


    @GetMapping("/jpa/users/{username}/bugs/{id}")
    public Bug getBug(@PathVariable String username, @PathVariable long id) {
        return bugJpaRepository.findById(id).get();

    }

    @PutMapping("/jpa/users/{username}/bugs/{id}")
    public ResponseEntity<Bug> updateBug(@PathVariable String username, @PathVariable long id, @RequestBody Bug bug) {
        Bug bugUpdate = bugJpaRepository.save(bug);
        return new ResponseEntity<Bug>(bug, HttpStatus.OK);
    }


    @PostMapping("/jpa/users/{username}/bugs")
    public ResponseEntity<Void> createBug(@PathVariable String username, @RequestBody Bug bug) {
        Bug createdBug = bugJpaRepository.save(bug);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdBug.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping("/jpa/users/{username}/bugs/{id}")
    public ResponseEntity<Void> deleteBug(@PathVariable String username, @PathVariable long id) {

        bugJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
