package com.example.dao.service;

import com.example.domain.subject_information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface subject {
    @Select("select * from subject")
    List<subject_information> SearchForSubjectInformation();

}
