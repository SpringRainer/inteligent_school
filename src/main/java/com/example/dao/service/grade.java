package com.example.dao.service;

import com.example.domain.grade_information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface grade {
    @Select("select * from paper where paper_student_sno = #{student_sno}")
    List<grade_information> SearchGradeByStudentSno (@Param("student_sno") Integer student_sno);
}
