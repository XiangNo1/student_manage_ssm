package com.situ.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.ssm.pojo.Student;

@Controller
@RequestMapping(value="/json")
public class JsonController {
    
    //传入json、返回json
    @RequestMapping(value="/requestJson")
    public @ResponseBody Student requestJson(@RequestBody Student student) {
       System.out.println(student);
       return student;
    }
    
    //返回pojo
    @RequestMapping(value="/responseEntity")
    public @ResponseBody Student responseEntity(Student student) {
       System.out.println(student);
       return student;
    }
    
    //返回list
    @RequestMapping(value="/responseList")
    public @ResponseBody List<Student> responseList(Student student) {
       System.out.println(student);
       List<Student> list = new ArrayList<Student>();
       list.add(student);
       list.add(new Student("wangwu", 20, "男" , "123"));
       list.add(new Student("lisi", 20, "男" , "123"));
       return list;
    }
    
    //返回map
    @RequestMapping(value="/responseMap")
    public @ResponseBody Map<String, Object> responseMap(Student student) {
       System.out.println(student);
       List<Student> list = new ArrayList<Student>();
       list.add(student);
       list.add(new Student("wangwu", 20, "男" , "123"));
       list.add(new Student("lisi", 20, "男" , "123"));
       Map<String, Object> map = new HashMap<String, Object>();
       map.put("total", list.size());
       map.put("rows", list);
       return map;
    }
}

