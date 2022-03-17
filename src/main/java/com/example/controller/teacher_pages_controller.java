package com.example.controller;

import com.example.service.paper_check_query;
import com.example.service.teacher_work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Controller
public class teacher_pages_controller {
    @Autowired
    private paper_check_query paper_check_query;

    @Autowired
    private teacher_work teacher_work;

    @PostMapping("/teacher_check_paper")
    @ResponseBody
    public String teacher_check_paper(HttpServletRequest request) {
        //        System.out.println(paper_img_data);

        return paper_check_query.getPaper_subject_json(request.getParameter("subject"));
    }

    @PostMapping("/paper_update")
    @ResponseBody
    public String paper_update(Model model, HttpServletRequest request) {
//        System.out.println(request.getParameter("paper_image"));
        Base64.Decoder decoder = Base64.getDecoder();
        teacher_work.updatePaperInformation(request.getParameter("paper_image").replaceFirst("data:image/png;base64,",""),request.getParameter("paper_name"),request.getParameter("paper_subject"));
        return "更新完成";
    }


}
