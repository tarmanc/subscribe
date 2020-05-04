package com.armanc.subscribe.controller;


import com.armanc.subscribe.entity.Subscriber;
import com.armanc.subscribe.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@org.springframework.web.bind.annotation.RestController
@RequestMapping("/subscribers")
public class RestController {

    @Autowired
    SubscribeService service;


    //Get a single user by ID
    @GetMapping("/{id}")
    public Subscriber getSubById(@PathVariable long id) {
            return service.getSubByID(id);
    }

    //Get a single user by user name
    @GetMapping("/user/{name}")
    public Subscriber getSubByName(@PathVariable("name") String userName) {
        return service.getSubByName(userName);
    }


    //Update Subscription status by user name
    @PatchMapping("/user/{name}")
    public String subUnsubByName(@PathVariable("name") String name) {
        return service.subUnsub(name);
    }

    //Update Subscription status by id
    @PatchMapping("/{id}")
    public String subUnsubById(@PathVariable long id) {
        return service.subUnsub(id);
    }

}
