package com.school.sms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.sms.dao.FixedFeeDao;
import com.school.sms.dao.UserDao;
import com.school.sms.model.Student;
import com.school.sms.service.UserManagementService;

@Service("userManagementService")
public class UserManagementServiceImpl implements UserManagementService{

	@Resource(name = "userDaoService")
	private UserDao userDao;

	@Override
	public Student findStudent(String enlorementNo) {
		return userDao.findStudent(enlorementNo);
	}

	@Override
	public void updateStudent(Student student) {
		userDao.updateStudent(student);
		
	}

	@Override
	public void deactivateStudent(Student student) {
		userDao.deactivateStudent(student);
		
	}
}
