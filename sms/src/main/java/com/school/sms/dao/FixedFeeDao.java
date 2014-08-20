package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.DiscountsAndConcessions;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.OtherPayments;
import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;
import com.school.sms.model.VariableFeeBatchYearMonth;

public interface FixedFeeDao {

	public void addFixedFee(FixedFeeBatchYearMonth feeBatchYearMonth);
	public void updateFixedFee(FixedFeeBatchYearMonth feeBatchYearMonth);
	public void deleteFixedFee(Integer fixedFeeId);
	public FixedFeeBatchYearMonth findFixedFee(String session,Integer batchId,String month);
	public List<FixedFeeBatchYearMonth> loadFeeStructures();
	public VariableFeeBatchYearMonth findFixedFee(String session, String batch,
			String month, String studentNameClassRoll);
	public void updateVariableFee(VariableFeeBatchYearMonth variableFee);
	public List<VariableFeeBatchYearMonth> loadVariableFeeStructures();
	public DiscountsAndConcessions findDiscountsAndConcession(String session,
			String batch, String month, String studentNameClassRoll);
	public void updateDiscountsAndConcession(
			DiscountsAndConcessions discountsAndConcession);
	public List<DiscountsAndConcessions> loadDiscountsAndConcession();
	public void deleteVariableFee(VariableFeeBatchYearMonth variableFee);
	public void deleteFixedFee(FixedFeeBatchYearMonth fixedFee);
	public List<Student> loadStudentsList();
	public Student loadStudentDeatil(String enrolementNo);
	public List<StudentFeeDetails> loadStudentFeeDetails(String enrolementNo);
	public FixedFeeBatchYearMonth loadStudentFeeDetails(String month,
			String session);
	public StudentFeeDetails saveStudentFeeDetails(StudentFeeDetails studentFeeDeatils);
	public OtherPayments findOtherPayments(String receiptNo, String mobileNo,
			String name);
	public OtherPayments processOtherPayment(OtherPayments otherPayments);
	public List<StudentFeeDetails> loadAllStudentFeeDetails();
	public List<OtherPayments> loadOtherPayments();
}
