package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class paper_subject_information implements Serializable {
    private String paper_name;
    private String paper_subject;
    private String paper_resource;

    public String getPaper_name() {
        return paper_name;
    }

    public void setPaper_name(String paper_name) {
        this.paper_name = paper_name;
    }

    public String getPaper_subject() {
        return paper_subject;
    }

    public void setPaper_subject(String paper_subject) {
        this.paper_subject = paper_subject;
    }

    public String getPaper_resource() {
        return paper_resource;
    }

    public void setPaper_resource(String paper_resource) {
        this.paper_resource = paper_resource;
    }
}
