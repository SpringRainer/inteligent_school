package com.example.dao.shiro;

import com.example.domain.shiro_roleAndPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface shiro_check_information {
    @Select("select password,role,permission from student where student_name = #{student_name}")
    shiro_roleAndPermission findRoleInfoByStudentName(String student_name);

    @Update("update student set password = #{password} where student_name = #{student_name}")
    boolean shiro_updatePassword(String password,String student_name);

    @Update("update student set role = #{roles} where student_name = #{student_name}")
    boolean shiro_updateRole(String roles,String student_name);

    @Update("update student set permission = #{permission} where student_name = #{student_name}")
    boolean shiro_updatePermission(String permission, String student_name);
}
