package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class student_information implements Serializable {
    private Integer student_sno;
    private String student_name;
    private String student_class;
    private String student_sex;

    public Integer getStudent_sno() {
        return student_sno;
    }

    public void setStudent_sno(Integer student_sno) {
        this.student_sno = student_sno;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }
}
