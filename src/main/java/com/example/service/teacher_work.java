package com.example.service;

import com.example.dao.service.teacher;
import com.example.domain.grade_information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
@Transactional
public class teacher_work {

    @Autowired
    private teacher teacher;

    public Integer Insert_student_grade(Integer paper_student_sno,String paper_student_name,Integer paper_subject_sno,Integer paper_subject_grade) {
        grade_information gradeInformation = new grade_information();
        gradeInformation.setPaper_student_sno(paper_student_sno);
        gradeInformation.setPaper_student_name(paper_student_name);
        gradeInformation.setPaper_subject_sno(paper_subject_sno);
        gradeInformation.setPaper_subject_grade(paper_subject_grade);
        teacher.submitStudentGrade(gradeInformation);
        return 1;
    }

    public Integer updatePaperInformation(String paper_resource, String paper_name, String paper_subject) {
        Base64.Decoder decoder = Base64.getDecoder();
        teacher.updatePaperResource(decoder.decode(paper_resource),paper_name,paper_subject);
        return 1;
    }

}