package com.school.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.sms.dao.ReportDao;
import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;
import com.school.sms.service.ReportService;

@Service("reportService")
public class ReportServiceImpl implements ReportService{

	
	@Resource(name = "reportDaoService")
	private ReportDao reportDao;

	@Override
	public List<StudentFeeDetails> loadStudentFixedFeeDetailsList() {
		return reportDao.loadStudentFixedFeeDetailsList();
	}

	@Override
	public Student loadStudent(String enrolementNo) {
		// TODO Auto-generated method stub
		return reportDao.loadStudent(enrolementNo);
	}
}
