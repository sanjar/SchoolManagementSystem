package com.school.sms.service;

import java.util.List;

import com.school.sms.model.ExtraMailRecipient;
import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;

public interface ReportService {

	List<StudentFeeDetails> loadStudentFixedFeeDetailsList();

	Student loadStudent(String enrolementNo);

	void updateExtraMailRecipient(ExtraMailRecipient extraMailRecipient);

	void deleteExtraMailRecipient(ExtraMailRecipient extraMailRecipient);

	List<ExtraMailRecipient> loadExtraMailRecipients();

}
