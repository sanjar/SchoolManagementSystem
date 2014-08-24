package com.school.sms.dao;

import com.school.sms.model.Student;
import com.school.sms.model.UserAuthenticationDetails;

public interface UserDao {

	Student findStudent(String enlorementNo);

	void updateStudent(Student student);

	void deactivateStudent(Student student);

	Integer getMaxRollInClassAndSection(String currentClassBatch,
			String currentClassSection);

	UserAuthenticationDetails findUser(String userId);

	void updateUser(UserAuthenticationDetails user);

	void deactivateUser(UserAuthenticationDetails user);

	void updateUserRoles(String userId, String role);

}
