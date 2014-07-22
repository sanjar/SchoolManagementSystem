package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;

public interface ReportDao {

	List<StudentFeeDetails> loadStudentFixedFeeDetailsList();

	Student loadStudent(String enrolementNo);

}
