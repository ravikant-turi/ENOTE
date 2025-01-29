package com.ENOTE_APP.dto;

import lombok.Getter;





public class CategoryResponse {

    private Integer id;
    private String name;

    private String description;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
//java: cannot find symbol
//symbol:   method setDescription(java.lang.String)
//location: variable categoryResponse of type com.ENOTE_APP.dto.CategoryResponse