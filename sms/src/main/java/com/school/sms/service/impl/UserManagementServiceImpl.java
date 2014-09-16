package com.school.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.sms.dao.FixedFeeDao;
import com.school.sms.dao.UserDao;
import com.school.sms.model.Student;
import com.school.sms.model.UserAuthenticationDetails;
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

	@Override
	public Integer getMaxRollInClassAndSection(String currentClassBatch,
			String currentClassSection) {
		// TODO Auto-generated method stub
		return userDao.getMaxRollInClassAndSection(currentClassBatch,currentClassSection);
	}

	@Override
	public UserAuthenticationDetails findUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.findUser(userId);
	}

	@Override
	public void updateUser(UserAuthenticationDetails user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void deactivateUser(UserAuthenticationDetails user) {
		userDao.deactivateUser(user);
		
	}

	@Override
	public void updateUserRoles(String userId, String role) {
		userDao.updateUserRoles(userId,role);
		
	}

	@Override
	public List<Student> loadStudents() {
		// TODO Auto-generated method stub
		return userDao.loadStudents();
	}

	@Override
	public List<UserAuthenticationDetails> loadAdminUsers() {
		// TODO Auto-generated method stub
		return userDao.loadAdminUsers();
	}
}
