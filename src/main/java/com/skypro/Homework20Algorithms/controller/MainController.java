package com.skypro.Homework20Algorithms.controller;

import com.skypro.Homework20Algorithms.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final MainService mainService;

    public MainController(@Autowired MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/add")
    public String[] addString(@RequestParam String str) {
        return mainService.add(str);
    }
    @GetMapping("/remove")
    public String[] remove(@RequestParam Integer num) {
        return mainService.remove(num);
    }
    @GetMapping("/set")
    public String[] set(@RequestParam Integer num, @RequestParam String str) {
        return mainService.set(num, str);
    }
}
