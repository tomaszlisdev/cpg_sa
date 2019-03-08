package com.pivovar.moviedetails.domain;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.HashMap;

@Repository
public class MovieDetailsRepository {
    private Map<String,String> storage = new HashMap<>();
    @PostConstruct
    public void init(){
        storage.put("spdrmun1","Spiderman1 details");
        storage.put("spdrmun2","Spiderman2 details");
        storage.put("incptn", "Inception details");
        storage.put("plpfct1","Spiderman1 details");
        storage.put("spdrmun2","Pulp Fiction details");
        storage.put("grnbook", "Grenbook details");
        storage.put("mtrx", "Matrix details");
        storage.put("cztrpncrn", "Szarik to fajny gość");
    }

    public String getDetails(String id){
        return storage.get(id);
    }
}
