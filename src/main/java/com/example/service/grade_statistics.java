package com.example.service;

import com.example.dao.service.grade;
import com.example.dao.service.paper;
import com.example.dao.service.student;
import com.example.domain.grade_all_information;
import com.example.domain.grade_information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class grade_statistics {

    @Autowired
    private paper paper;

    @Autowired
    private student student;

    @Autowired
    private grade grade;

    public grade_all_information searchByStudentName (String student_name) {
        Integer student_sno = student.SearchSnoByStudentName(student_name).getStudent_sno();
        List<grade_information> grade_informations =  grade.SearchGradeByStudentSno(student_sno);
        grade_all_information gradeAllInformation = new grade_all_information();
        for (grade_information gradeInformation : grade_informations) {
            if (gradeInformation.getPaper_subject_sno() == 602) gradeAllInformation.setChinese(gradeInformation.getPaper_subject_grade());
            if (gradeInformation.getPaper_subject_sno() == 603) gradeAllInformation.setMath(gradeInformation.getPaper_subject_grade());
            if (gradeInformation.getPaper_subject_sno() == 601) gradeAllInformation.setEnglish(gradeInformation.getPaper_subject_grade());
            if (gradeInformation.getPaper_subject_sno() == 604) gradeAllInformation.setPhysics(gradeInformation.getPaper_subject_grade());
            if (gradeInformation.getPaper_subject_sno() == 605) gradeAllInformation.setChemistry(gradeInformation.getPaper_subject_grade());
            if (gradeInformation.getPaper_subject_sno() == 606) gradeAllInformation.setBiology(gradeInformation.getPaper_subject_grade());
            if (gradeInformation.getPaper_subject_sno() == 607) gradeAllInformation.setGeography(gradeInformation.getPaper_subject_grade());
            if (gradeInformation.getPaper_subject_sno() == 608) gradeAllInformation.setHistory(gradeInformation.getPaper_subject_grade());
            if (gradeInformation.getPaper_subject_sno() == 609) gradeAllInformation.setPolitics(gradeInformation.getPaper_subject_grade());
        }
        return gradeAllInformation;
    }
}
