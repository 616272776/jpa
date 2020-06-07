package com.demo.jpa.controller;

import com.demo.jpa.domain.User;
import com.demo.jpa.service.UserService;
import com.demo.jpa.utils.PageUtils;
import com.demo.jpa.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: 苏敏
 * @date: 2020/6/7 10:09
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据userId查询单个user
     * @param userId
     * @return
     */
    @GetMapping("/get/user/{userId}")
    public R selectUser(@PathVariable Integer userId){
        User user = userService.getUserBy(userId);
        return R.ok().put("data",user);
    }

    /**
     * 根据分页信息查询用户
     * @param params page 页数，size 每个个数
     * @return
     */
    @GetMapping("/list/user")
    public R selectUser(@RequestParam Map<String,String> params){
        PageUtils pageUtils = userService.listUser(params);
        return R.ok().put("page",pageUtils);
    }
}
