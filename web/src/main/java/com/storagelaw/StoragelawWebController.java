package com.storagelaw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class StoragelawWebController {

    private RestTemplate restTemplate = new RestTemplate();
    public static String REST_URL = "http://localhost:8080";

    @GetMapping("/testgetall")
    public String getAllLaw (Model model){
        System.out.println("Test of get all" );
        model.addAttribute("Laws",
                restTemplate.getForObject(REST_URL + "/testfind", List.class));
        return "testgetall";

    }









}
