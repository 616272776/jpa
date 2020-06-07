package com.demo.jpa;

import com.demo.jpa.dao.UserDao;
import com.demo.jpa.domain.User;

import com.demo.jpa.utils.PageUtils;
import com.demo.jpa.utils.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
@Transactional
@Rollback
public class SpringBootDemo8ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserDao testUserDao;
	
	@Test
	public void insert() {
		User user= new User();
		user.setUsername("zhang san");
		user.setAge(23);
		testUserDao.save(user);
	}

	@Test
	public void update() {
		User user = new User();
		user.setId(1);
		user.setAge(18);
		user.setUsername("李四");
		testUserDao.save(user);
	}
	
	@Test
	public void select() {
		// PageRequest的页数是从0开始，所以要减一
		PageRequest pageRequest = PageRequest.of(3-1, 4);
		Page<User> all = testUserDao.findAll(pageRequest);
		PageUtils pageUtils = new PageUtils(all);

		System.out.println();
	}
	
	@Test
	public void delete() {
		testUserDao.deleteById(1);
	}
}