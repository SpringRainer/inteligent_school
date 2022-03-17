package com.example.service;

import com.alibaba.fastjson.JSONArray;
import com.example.dao.service.teacher;
import com.example.domain.paper_information;
import com.example.domain.paper_subject_information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class paper_check_query {
    @Autowired
    private teacher teacher;

    public String getPaper_subject_json(String subject_name) {
        List<paper_information> papers = teacher.getPaperBySubject(subject_name);
        JSONArray jsonArray = new JSONArray();
        paper_subject_information paperSubjectInformation = null;
        System.out.println(papers.size());
        int i = 0;
        for (paper_information information : papers) {
            paperSubjectInformation = new paper_subject_information();
            paperSubjectInformation.setPaper_name(information.getPaper_name());
            paperSubjectInformation.setPaper_subject(information.getPaper_subject());
            paperSubjectInformation.setPaper_resource(Base64.getEncoder().encodeToString(information.getPaper_resource()));
            jsonArray.add(paperSubjectInformation);
        }

        return jsonArray.toString();
    }
}