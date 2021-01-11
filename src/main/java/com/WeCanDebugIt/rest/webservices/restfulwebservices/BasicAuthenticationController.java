package com.WeCanDebugIt.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4201")
@RestController
public class BasicAuthenticationController {

    //map a get to uri hello-world
//    @GetMapping(path="/hello-world")
//    public String helloWorld(){
//        return "Hello World";
//    }

    //create bean and return it back
    @GetMapping (path="/basicauth")
    public AuthenticationBean helloWorldBean(){
//        throw new RuntimeException("Some error has happened! Contact support");
        return new AuthenticationBean("You are authenticated");
    }

//    @GetMapping (path="/hello-world/path-variable/{name}")
//    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
//
//        return new HelloWorldBean(String.format("Hello World, %s ", name));
//    }
}
