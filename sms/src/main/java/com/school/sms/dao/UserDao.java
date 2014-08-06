package com.school.sms.dao;

import com.school.sms.model.Student;

public interface UserDao {

	Student findStudent(String enlorementNo);

	void updateStudent(Student student);

	void deactivateStudent(Student student);

}
