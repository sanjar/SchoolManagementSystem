package com.school.sms.service;

import java.util.List;

import com.school.sms.model.Student;
import com.school.sms.model.UserAuthenticationDetails;

public interface UserManagementService {

	Student findStudent(String enlorementNo);

	void updateStudent(Student student);

	void deactivateStudent(Student student);

	Integer getMaxRollInClassAndSection(String currentClassBatch,
			String currentClassSection);

	UserAuthenticationDetails findUser(String parameter);

	void updateUser(UserAuthenticationDetails user);

	void deactivateUser(UserAuthenticationDetails user);

	void updateUserRoles(String userId, String string);

	List<Student> loadStudents();

	List<UserAuthenticationDetails> loadAdminUsers();

	

}
