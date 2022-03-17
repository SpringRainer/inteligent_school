package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class teacher_information implements Serializable {
    private Integer teacher_sno;
    private String teacher_name;
    private String teacher_teach_subject;
    private Integer teacher_salary;

    public Integer getTeacher_sno() {
        return teacher_sno;
    }

    public void setTeacher_sno(Integer teacher_sno) {
        this.teacher_sno = teacher_sno;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_teach_subject() {
        return teacher_teach_subject;
    }

    public void setTeacher_teach_subject(String teacher_teach_subject) {
        this.teacher_teach_subject = teacher_teach_subject;
    }

    public Integer getTeacher_salary() {
        return teacher_salary;
    }

    public void setTeacher_salary(Integer teacher_salary) {
        this.teacher_salary = teacher_salary;
    }
}
