package com.storagelaw;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class StoragelawRestController {

    @Autowired
    LawRepository lawRepository;

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
    public List<Law> findAllLaw() {
        return (List<Law>) lawRepository.findAll();
    }

    @PostMapping("/testpost")
        public String testPost(@RequestBody Law newLaw) {
        System.out.println("New law detected:" + newLaw.toString());
        lawRepository.save(newLaw);
        return "post successfull";

    }

    @PutMapping
    public String updateLawData(@RequestBody Law law) {
        System.out.println("Update Law" + law.toString());
        if (lawRepository.findById(law.getLawId()).isPresent()) {
            lawRepository.save(law);
        } else {
            System.out.println("impossible update Law " + law.toString());
        }
        return "Law`s updateing" + law.toString();
    }

    //("/{lawId}")
    // (@PathVariable Long id)   // DEL -> localhost:8080/1
    // public void deleteLaw(@PathVariable Long lawId){
    // (value = "adsada")DEL -> localhost:8080?asdasd=1
    // ?lawId=

    @DeleteMapping
    public void deleteLaw(@RequestParam Long lawId){
        System.out.println("deleting Law by" + lawId);
        lawRepository.deleteById(lawId);
    }

}
