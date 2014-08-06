package com.school.sms.service;

import com.school.sms.model.Student;

public interface UserManagementService {

	Student findStudent(String enlorementNo);

	void updateStudent(Student student);

	void deactivateStudent(Student student);

}
