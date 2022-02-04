package com.lawstorage.restapp;


import com.lawstorage.law.Law;
import com.lawstorage.repository.LawstorageRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class RestControllerStorage {


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

    @GetMapping("/testfind")
    public List<Law> findAllLaw (){ return (List<Law>)lawstorageRepository.findAll();
    }

    @PostMapping("/testallpage")
    public void testPost(@RequestBody Law newLaw) {
        lawstorageRepository.save(newLaw);

    }





}
