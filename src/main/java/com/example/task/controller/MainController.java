package com.example.task.controller;

import com.example.task.domain.User;
import com.example.task.repos.UserRepo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final UserRepo userRepo;

    public MainController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model)
    {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(  Map<String, Object> model){
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "main";
    }
//    @PostMapping("/main")
//    public String add(
//            @AuthenticationPrincipal User user,
//            @RequestParam String text,
//            @RequestParam String tag,
//            Map<String, Object> model
//    ) {
//        Message message = new Message(text, tag, user);
//        messageRepo.save(message);
//        Iterable<Message> messages = messageRepo.findAll();
//        model.put("users", users);
//        return "main";
//    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){

        List<User> users = new ArrayList<>();

        if(filter != null && !filter.isEmpty()){

        users.add(userRepo.findByUsername(filter));

        } else{
        users = userRepo.findAll();}

        model.put("users", users);

        return "main";
    }
}