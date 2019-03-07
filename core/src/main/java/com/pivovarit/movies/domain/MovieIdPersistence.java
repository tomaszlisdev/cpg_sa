package com.pivovarit.movies.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
class MovieIdPersistence implements Serializable {
    private String id;
    public void setId(long id){
        this.id = String.valueOf(id);
    }
    public long getId(){
        return Long.valueOf(id);
    }
}
