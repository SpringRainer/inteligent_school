package com.example.service;

import com.alibaba.fastjson.JSONArray;
import com.example.dao.shiro.shiro_check_information;
import com.example.domain.shiro_roleAndPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class Shiro_authorize {
    @Autowired
    private shiro_check_information shiro_check_information;

    private JSONArray jsonArray = new JSONArray();

    public boolean updatePassword(String password,String student_name) {
        return shiro_check_information.shiro_updatePassword(password,student_name);
    }

    public boolean updateRole(List<String> roleList,String student_name) {
        jsonArray.clear();
        jsonArray.addAll(roleList);
        return shiro_check_information.shiro_updateRole(jsonArray.toString(),student_name);
    }

    public boolean updatePermission(List<String> permissionList,String student_name) {
        jsonArray.clear();
        jsonArray.addAll(permissionList);
        return shiro_check_information.shiro_updatePermission(jsonArray.toString(),student_name);
    }

    public shiro_roleAndPermission authorizePassword(String student_name) {
        return shiro_check_information.findRoleInfoByStudentName(student_name);
    }
}
