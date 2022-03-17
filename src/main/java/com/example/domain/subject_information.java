package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class subject_information implements Serializable {
    private Integer subject_sno;
    private String subject_name;
    private String subject_type;
    private Integer subject_teacher_sno;

    public Integer getSubject_sno() {
        return subject_sno;
    }

    public void setSubject_sno(Integer subject_sno) {
        this.subject_sno = subject_sno;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(String subject_type) {
        this.subject_type = subject_type;
    }

    public Integer getSubject_teacher_sno() {
        return subject_teacher_sno;
    }

    public void setSubject_teacher_sno(Integer subject_teacher_sno) {
        this.subject_teacher_sno = subject_teacher_sno;
    }
}
