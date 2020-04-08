package com.example.demo.controller;

import com.example.demo.config.MdcUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping(path = "/")
public class Controller {

    @GetMapping(path = "home")
    public String getHome() {

        log.info("Hi Debug Level");
        log.info("MDC Value : {}", MDC.get("clientId"));

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);

        arrayList.stream().map(t -> t + 1).forEach(t -> log.info(String.valueOf(t)));
        System.out.println("Printing with Parallel Stream now");
        MdcUtil mdcUtil = new MdcUtil();
        arrayList.parallelStream().peek(mdcUtil::set).map(t -> t + 1).forEach(t-> log.info(String.valueOf(t)));

        return "Hello Home!";
    }
}
