package com.storagelaw;

import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class StoragelawWebController {

    private RestTemplate restTemplate = new RestTemplate();
    // public static String REST_URL = "http://localhost:8080";
    public static String REST_URL = "http://localhost:8070/rest-0.0.1-SNAPSHOT";

    @GetMapping("/testgetall")
    public String getAllLaw (Model model){
        System.out.println("Test of get all 18062022" );
        model.addAttribute("Laws",
                restTemplate.getForObject(REST_URL + "/testfind", List.class));
        return "testgetall";
    }

    @GetMapping("/testpost")
    public String addLaw (Model model){
        System.out.println("testpost page is loading");
        Law law = new Law();
        model.addAttribute("Law", law);
        return "testpost";
    }

    @PostMapping("/testpost")
    public String postLaw (Law law) throws Exception{
        System.out.println("post successfull");
        restTemplate.postForObject(REST_URL + "/testpost",law, Law.class);
        return "redirect:testgetall";
    }

    /*@DeleteMapping("/delete{id}")
    public void String deleteLaw (Law law) throws Exception{
        System.out.println("delete successfull");


    }*/

}
