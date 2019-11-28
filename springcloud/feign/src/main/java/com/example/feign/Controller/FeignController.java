package com.example.feign.Controller;

import com.example.feign.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

        @Autowired
        AdminService adminService;

        @RequestMapping(value = "/hello",method = RequestMethod.GET)
        public String sayHello(@RequestParam("name")String name){
            return adminService.sayHello(name);
        }

}
