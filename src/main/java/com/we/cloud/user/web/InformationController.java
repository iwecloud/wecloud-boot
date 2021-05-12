package com.we.cloud.user.web;

import com.we.cloud.user.dto.UserInformation;
import com.we.cloud.user.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/sys/information")
public class InformationController {

    @Autowired
    private InformationService service;

    @GetMapping("/user")
    public ResponseEntity<UserInformation> queryUserInformation(){

        return new ResponseEntity(service.queryUserInformation(), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity adminTest(){

        return new ResponseEntity("ADMIN", HttpStatus.OK);
    }

}