package com.armanc.subscribe.controller;

import com.armanc.subscribe.entity.Subscriber;
import com.armanc.subscribe.entity.SubscriberDTO;
import com.armanc.subscribe.service.SubscribeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/subscribers")
@AllArgsConstructor
@Api(value = "Subscriber API Documentation")
public class RestController {

    final SubscribeService service;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get All Subscribers", produces = "application/json")
    public List<SubscriberDTO> getAllUsers(
            @RequestParam(name = "op", required = false) @ApiParam(name = "op", value = "Operator", example = ">, <, =") char op,
            @RequestParam(name = "date", required = false) @ApiParam(name = "date", value = "Date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {

        if(localDate != null){
            return service.getByDate(op,localDate);
        }

        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a Subscriber", produces = "application/json")
    public SubscriberDTO getSubById(
            @PathVariable @ApiParam(value = "User ID", required = true, example = "123") long id) {

        return service.getSubByID(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add a New Subscriber", produces = "application/json", consumes = "application/json")
    public Subscriber addNewSubs(@RequestBody SubscriberDTO subscriberDTO) {
        return service.newSubscriber(subscriberDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update Subscriber Status", produces = "application/json", consumes = "application/json")
    public SubscriberDTO subUnsubById(@PathVariable @ApiParam(value = "User ID", required = true, example = "123") long id) {
        return service.subUnsub(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a Subscriber")
    public void updateSub(@RequestBody SubscriberDTO subscriberDTO,
                          @PathVariable @ApiParam(value = "User ID", required = true, example = "123") long id) {
        service.updateSub(subscriberDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a Subscriber")
    public void deleteSub(@PathVariable @ApiParam(value = "User ID", required = true, example = "123") long id) {
        service.deleteSub(id);
    }

}
