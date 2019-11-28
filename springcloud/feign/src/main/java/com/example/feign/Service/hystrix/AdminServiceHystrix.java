package com.example.feign.Service.hystrix;

import com.example.feign.Service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceHystrix implements AdminService {
    @Override
    public String sayHello(String name) {
        return "调用服务失败";
    }
}
