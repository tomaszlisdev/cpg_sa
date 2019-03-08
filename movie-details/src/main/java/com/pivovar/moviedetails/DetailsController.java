package com.pivovar.moviedetails;

import com.pivovar.moviedetails.domain.MovieDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailsController {

    @Autowired
    private MovieDetailsRepository repository;

    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable("id") String id){
        try {
            Thread.sleep(1200);
            return repository.getDetails(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Timeout of reading details";
        }

    }
}
