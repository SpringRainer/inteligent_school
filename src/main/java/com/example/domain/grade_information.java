package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class grade_information  implements Serializable {
    private Integer paper_student_sno;
    private String paper_student_name;
    private Integer paper_subject_sno;
    private Integer paper_subject_grade;

    public Integer getPaper_student_sno() {
        return paper_student_sno;
    }

    public void setPaper_student_sno(Integer paper_student_sno) {
        this.paper_student_sno = paper_student_sno;
    }

    public String getPaper_student_name() {
        return paper_student_name;
    }

    public void setPaper_student_name(String paper_student_name) {
        this.paper_student_name = paper_student_name;
    }

    public Integer getPaper_subject_sno() {
        return paper_subject_sno;
    }

    public void setPaper_subject_sno(Integer paper_subject_sno) {
        this.paper_subject_sno = paper_subject_sno;
    }

    public Integer getPaper_subject_grade() {
        return paper_subject_grade;
    }

    public void setPaper_subject_grade(Integer paper_subject_grade) {
        this.paper_subject_grade = paper_subject_grade;
    }
}
