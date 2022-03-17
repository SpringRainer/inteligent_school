package com.example.controller;

import com.example.domain.grade_all_information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class page_controller {

    @Autowired
    private com.example.service.paper_scanner paper_scanner;

    @Autowired
    private com.example.service.grade_statistics grade_statistics;

    @Autowired
    private com.example.dao.service.subject subject;

    @RequestMapping("/login")
    public String login() {
        return "login/login";
    }

    @RequestMapping("/teacher_check")
    public String teacher_check() {
        return "teacher/teacher_check";
    }

    @RequestMapping("/teacher_login_grade")
    public String teacher_login_grade() {
        return "teacher/teacher_login_grade";
    }

    @RequestMapping("/teacher_check_homework")
    public String teacher_check_homework() {
        return "teacher/teacher_check_homework";
    }

    @RequestMapping("/home")
    public String home () {
        return "login/home";
    }

    @RequestMapping("/failure")
    public String failure () {
        return "exception/404";
    }

    @RequestMapping("/paper_scanner")
    public String paper_scanner () {
        return "paper/paper_scanner";
    }

    @RequestMapping("/student_grade_query")
    public String student_grade_query (Model model, HttpServletRequest request) {
        grade_all_information gradeAllInformation = grade_statistics.searchByStudentName("熊二");
        model.addAttribute("gradeAllInformation",gradeAllInformation);
        model.addAttribute("subject",subject.SearchForSubjectInformation());
        return "student/student_grade_query";
    }

}
