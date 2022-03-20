package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.dao.service.subject;
import com.example.domain.grade_all_information;
import com.example.service.grade_statistics;
import com.example.service.paper_scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Controller
public class student_pages_controller {
    @Autowired
    private paper_scanner paper_scanner;

    @Autowired
    private grade_statistics grade_statistics;

    @Autowired
    private subject subject;

    @PostMapping("/paper_upload")
    @ResponseBody
    public String paper_upload(Model model, HttpServletRequest request) {
        System.out.println(request.getParameter("paper_image"));
        Base64.Decoder decoder = Base64.getDecoder();
        paper_scanner.paper_addition(request.getParameter("student_name"),request.getParameter("subject"),request.getParameter("123"), decoder.decode(request.getParameter("paper_image").replaceFirst("data:image/jpeg;base64,","")));
        return "收取成功";
    }

    @PostMapping("/student_grade_query")
    @ResponseBody
    public String student_grade_query(Model model, HttpServletRequest request) {
//        grade_all_information gradeAllInformation = grade_statistics.searchByStudentName(request.getParameter("student_name"));
        grade_all_information gradeAllInformation = grade_statistics.searchByStudentName(request.getParameter("student_name"));
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(gradeAllInformation);
        jsonArray.add(subject.SearchForSubjectInformation());
//        System.out.println(jsonArray);
        return jsonArray.toString();
    }

    @PostMapping("/test")
    @ResponseBody
    public String test(Model model, HttpServletRequest request) {
        return  "你好微信小程序";
    }

}