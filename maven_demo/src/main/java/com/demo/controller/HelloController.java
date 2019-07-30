package com.demo.controller;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        PageHelper.startPage(1, 10);
        List<User> list =  userMapper.selectByExample(null);
        System.out.println("当前页数量=" + list.size());
        System.out.println("总数量=" + ((Page)list).getTotal());
        return "Hello World";
    }


}
