package com.demo.jpa.service;

import com.demo.jpa.domain.User;
import com.demo.jpa.utils.PageUtils;

import java.util.Map;

/**
 * @author: 苏敏
 * @date: 2020/6/7 10:19
 */
public interface UserService {

    public User getUserBy(Integer userId);

    public PageUtils listUser(Map<String,String> params);
}
