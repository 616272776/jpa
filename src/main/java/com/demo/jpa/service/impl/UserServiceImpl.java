package com.demo.jpa.service.impl;

import com.demo.jpa.dao.UserDao;
import com.demo.jpa.domain.User;
import com.demo.jpa.service.UserService;
import com.demo.jpa.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: 苏敏
 * @date: 2020/6/7 10:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserBy(Integer userId) {
        return userDao.findById(userId).get();
    }

    @Override
    public PageUtils listUser(Map<String, String> params) {

        // 获取分页参数
        String page = params.get("page");
        String size = params.get("size");

        // PageRequest的页数是从0开始，所以要减一
        PageRequest pageRequest = PageRequest.of(Integer.parseInt(page)-1, Integer.parseInt(size));
        Page<User> all = userDao.findAll(pageRequest);
        PageUtils pageUtils = new PageUtils(all);
        return pageUtils;
    }
}
