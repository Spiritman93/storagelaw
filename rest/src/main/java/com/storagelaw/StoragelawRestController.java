package com.storagelaw;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin("http://localhost:4201/")
public class StoragelawRestController {

    @Autowired
    LawRepository lawRepository;

    @GetMapping("/startpage")
    public String startPage() {
        System.out.println("it`s working");
        return "Hello, it`s startpage. It`s testing! 777";
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

    @GetMapping("/getLaw/{id}")
    public Law getLaw(@PathVariable Long id){
        Law law = lawRepository.findById(id).orElse(new Law());
        return getLaw();

    @PostMapping("/testpost")
    @ResponseStatus(HttpStatus.CREATED)
        public void testPost(@RequestBody Law law) {
        System.out.println("New law detected:" + law.toString());
        lawRepository.save(law);
        return new Law();
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
