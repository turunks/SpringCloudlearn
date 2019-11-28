package com.example.feign.Service;

import com.example.feign.Service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = AdminServiceHystrix.class)
public interface AdminService {

    @GetMapping(value = "hi")
    public String sayHello(@RequestParam("name")String name);

}
