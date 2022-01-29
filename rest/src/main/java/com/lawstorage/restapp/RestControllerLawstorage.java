package com.lawstorage.restapp;


import com.lawstorage.law.Law;
import com.lawstorage.repository.LawstorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerLawstorage {

    @Autowired
    LawstorageRepository lawstorageRepository;

    @GetMapping("/startpage")
    public String startPage() {
        System.out.println("it`s working");
        return "Hello, it`s startpage. It`s testing!";
    }

    @GetMapping("/testlawpage")
    public Law getLaw() {
        Law law = new Law("Law", "O NPA", 1);
        return law;

    }



}
