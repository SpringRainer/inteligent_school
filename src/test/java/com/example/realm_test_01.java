package com.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.shiro.shiro_check_information;
import com.example.service.Shiro_authorize;
import com.example.service.paper_scanner;
import com.example.service.teacher_work;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = boot_8080.class)
@RunWith(SpringRunner.class)
public class realm_test_01 {

    @Autowired
    private paper_scanner paper_scanner;



    @Test
    public void domain_test_01() {
//        paper_scanner.paper_addition("喜羊羊","数学","羊村","helloWorld".getBytes());
        System.out.println(paper_scanner.paper_selectBySubject("数学"));
    }

    @Test
    public void domain_test_02() throws IOException {
        List<String> stringList = new ArrayList<>();
        stringList.add("语文");
        stringList.add("数学");
        stringList.add("英语");
        stringList.add("物理");
        stringList.add("化学");
        stringList.add("生物");
        stringList.add("地理");
        stringList.add("历史");
        stringList.add("政治");
        File file = new File("C:\\Users\\Lenovo\\Desktop\\新建文件夹 (4)");

        File[] files = file.listFiles();

        InputStream inputStream = null;

        int i = 18;

        for (String s : stringList) {
            inputStream = new FileInputStream(files[i++]);
            paper_scanner.paper_addition("光头强",
                    s, "未定",
                    inputStream.readAllBytes());
            inputStream.close();
            System.out.println(i);
        }
    }

    @Autowired
    private teacher_work teacher_work;

    @Test
    public void domain_test_03() {
//
//        RowBounds rowBounds = new RowBounds();
//        rowBounds.getLimit();
        List<Integer> list = new ArrayList<>();
        list.add(601);
        list.add(602);
        list.add(603);
        list.add(604);
        list.add(605);
        list.add(606);
        list.add(607);
        list.add(608);
        list.add(609);
        for (Integer s : list) {
            teacher_work.Insert_student_grade(1003, "光头强", s, (int)(Math.random()*20)+70);
        }
    }

    @Autowired
    private Shiro_authorize shiro_authorize;

    @Test
    public void domain_test_04() {
        JSONArray jsonArray = new JSONArray();
        String username = "光头强";
        System.out.println(JSONObject.parseArray(shiro_authorize.authorizePassword(username).getRole()));
    }
}