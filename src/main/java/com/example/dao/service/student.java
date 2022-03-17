package com.example.dao.service;

import com.example.domain.student_information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface student {
    @Select("select * from student where student_name = #{student_name}")
    student_information SearchSnoByStudentName(@Param("student_name") String student_name);
}
