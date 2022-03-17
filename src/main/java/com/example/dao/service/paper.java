package com.example.dao.service;

import com.example.domain.paper_information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface paper {
    @Select("select * from paper_scanner where paper_subject = #{subject}")
    List<paper_information> findBySubject (@Param("subject") String subject);

    @Insert("insert into paper_scanner values(#{paper_information.paper_name},#{paper_information.paper_subject},#{paper_information.paper_address},#{paper_information.paper_resource})")
    Integer insert_Date (@Param("paper_information") paper_information paper_information);

    @Select("select * from paper_scanner where paper_name = #{paper_name}")
    List<paper_information> findByStudentName(@Param("paper_name") String paper_name);
}