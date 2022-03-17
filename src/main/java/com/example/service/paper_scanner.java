package com.example.service;

import com.example.dao.service.paper;
import com.example.domain.paper_information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class paper_scanner {

    @Autowired
    private paper paper;

    public Integer paper_addition (String student_name,String paper_subject,String paper_address,byte[] paper_resource) {
        paper_information paper_information = new paper_information();
        paper_information.setPaper_name(student_name);
        paper_information.setPaper_subject(paper_subject);
        paper_information.setPaper_address(paper_address);
        paper_information.setPaper_resource(paper_resource);
//        System.out.println(paper_information);
        return paper.insert_Date(paper_information);
    }

    public List<paper_information> paper_selectBySubject (String subject) {
        return paper.findBySubject(subject);
    }
}
