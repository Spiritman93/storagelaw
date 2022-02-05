package com.storagelaw;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class RestControllerStorage {

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

    @PostMapping("/testallpage")
    public void testPost(@RequestBody Law newLaw) {
        lawRepository.save(newLaw);

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

    @DeleteMapping("/delete{id}")
    public void deleteLaw(@RequestParam Long  id){
        System.out.println("deleting Law by" + id);
        lawRepository.deleteById(id);
    }



}