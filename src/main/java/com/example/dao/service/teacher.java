package com.example.dao.service;

import com.example.domain.grade_information;
import com.example.domain.paper_information;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface teacher {
    @Select("select paper_resource from paper where paper_name = #{student_name} and subject_name = #{subject_name}")
    byte[] getPaperByNameAndSubject(@Param("student_name") String student_name, @Param("subject_name") String subject_name);

    @Select("select * from paper_scanner where paper_subject = #{subject_name}")
    List<paper_information> getPaperBySubject(@Param("subject_name") String subject_name);

    @Insert("insert into paper(paper_student_sno,paper_subject_sno,paper_subject_grade,paper_student_name,paper_grade) values(#{grade_information.paper_student_sno},#{grade_information.paper_subject_sno},#{grade_information.paper_subject_grade},#{grade_information.paper_student_name},60)")
    Integer submitStudentGrade(@Param("grade_information") grade_information grade_information);

    @Update("update paper_scanner set paper_resource = #{paper_resource} where paper_name = #{paper_name} and paper_subject = #{paper_subject}")
    Integer updatePaperResource(@Param("paper_resource") byte[] paper_resource, @Param("paper_name") String paper_name, @Param("paper_subject") String paper_subject);

    @Select("select * from paper_scanner where paper_subject = #{paper_subject} and paper_name = #{paper_name}")
    paper_information getPaper(@Param("paper_subject") String subject_name, @Param("paper_name") String paper_name);
}