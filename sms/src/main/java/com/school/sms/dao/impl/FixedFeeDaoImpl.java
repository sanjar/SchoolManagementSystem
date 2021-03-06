package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.FixedFeeDao;
import com.school.sms.model.DiscountsAndConcessions;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.GradeMaster;
import com.school.sms.model.OtherPayments;
import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;
import com.school.sms.model.VariableFeeBatchYearMonth;


@Service("fixedFeeDaoService")
@Transactional
public class FixedFeeDaoImpl implements FixedFeeDao {
	
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	public void addFixedFee(FixedFeeBatchYearMonth feeBatchYearMonth){
		
	}
	public void updateFixedFee(FixedFeeBatchYearMonth feeBatchYearMonth){
		entityManager.merge(feeBatchYearMonth);
		entityManager.flush();
	}
	public void deleteFixedFee(Integer fixedFeeId){
		
	}
	public FixedFeeBatchYearMonth findFixedFee(String session,Integer batchId,String month){
		if(entityManager.createQuery("FROM FixedFeeBatchYearMonth f WHERE f.session="+"'"+session+"'"+ " and f.batchId="+"'"+batchId+"'"+" and f.month="+"'"+month+"'").getResultList().size()>0){
			return (FixedFeeBatchYearMonth) entityManager.createQuery("FROM FixedFeeBatchYearMonth f WHERE f.session="+"'"+session+"'"+ " and f.batchId="+"'"+batchId+"'"+" and f.month="+"'"+month+"'").getResultList().get(0);
		}
		return null;
		
		
	}

	@Override
	public List<FixedFeeBatchYearMonth> loadFeeStructures() {
		Query query = entityManager.createQuery("FROM FixedFeeBatchYearMonth f order by f.fixedFeeId ASC");
		return query.getResultList();
	}

	@Override
	public VariableFeeBatchYearMonth findFixedFee(String session, String batch,
			String month, String studentNameClassRoll) {
		List list= entityManager.createQuery("FROM VariableFeeBatchYearMonth f WHERE f.session="+"'"+session+"'"+ " and f.batch="+"'"+batch+"'"+" and f.month="+"'"+month+"'"+" and f.studentNameClassRoll="+"'"+studentNameClassRoll+"'").getResultList();
		if(list.size()>0){
			return (VariableFeeBatchYearMonth) list.get(0);
		}
		return null;
	}

	@Override
	public void updateVariableFee(VariableFeeBatchYearMonth variableFee) {
		entityManager.merge(variableFee);
		entityManager.flush();
		
	}

	@Override
	public List<VariableFeeBatchYearMonth> loadVariableFeeStructures() {
		Query query = entityManager.createQuery("FROM VariableFeeBatchYearMonth f order by f.variableFeeId ASC");
		return query.getResultList();
	}

	@Override
	public DiscountsAndConcessions findDiscountsAndConcession(String session,
			String batch, String month, String studentNameClassRoll) {
		List list= entityManager.createQuery("FROM DiscountsAndConcessions f WHERE f.session="+"'"+session+"'"+ " and f.batch="+"'"+batch+"'"+" and f.month="+"'"+month+"'"+" and f.studentNameClassRoll="+"'"+studentNameClassRoll+"'").getResultList();
		if(list.size()>0){
			return (DiscountsAndConcessions) list.get(0);
		}
		return null;
	}

	@Override
	public void updateDiscountsAndConcession(
			DiscountsAndConcessions discountsAndConcession) {
		entityManager.merge(discountsAndConcession);
		entityManager.flush();
		
	}

	@Override
	public List<DiscountsAndConcessions> loadDiscountsAndConcession() {
		Query query = entityManager.createQuery("FROM DiscountsAndConcessions f order by f.discountsConscessionsId ASC");
		return query.getResultList();
	}

	@Override
	public void deleteVariableFee(VariableFeeBatchYearMonth variableFee) {
		VariableFeeBatchYearMonth variableFeeBatchYearMonth = entityManager.find(VariableFeeBatchYearMonth.class,variableFee.getVariableFeeId());
		entityManager.remove(variableFeeBatchYearMonth);
		entityManager.flush();
		
	}

	@Override
	public void deleteFixedFee(FixedFeeBatchYearMonth fixedFee) {
		FixedFeeBatchYearMonth fixedFeeBatchYearMonth = entityManager.find(FixedFeeBatchYearMonth.class,fixedFee.getFixedFeeId());
		entityManager.remove(fixedFeeBatchYearMonth);
		entityManager.flush();
		
	}

	@Override
	public List<Student> loadStudentsList() {
		Query query = entityManager.createQuery("FROM Student");
		return query.getResultList();
	}

	@Override
	public Student loadStudentDeatil(String enrolementNo) {
		/*Query query = entityManager.createQuery("FROM Student");
		return query.getResultList();*/
		return null;
	}

	@Override
	public List<StudentFeeDetails> loadStudentFeeDetails(String enrolementNo) {
		Query query = entityManager.createQuery("FROM StudentFeeDetails s where s.enrolementNo="+"'"+enrolementNo+"'");
		return query.getResultList();
	}

	@Override
	public FixedFeeBatchYearMonth loadStudentFeeDetails(String month,
			String session) {
		/*Query query = entityManager.createQuery("FROM FixedFeeBatchYearMonth f where s.enrolementNo="+"'"+enrolementNo+"'");
		return query.getResultList();*/
		return null;
	}

	@Override
	public StudentFeeDetails saveStudentFeeDetails(StudentFeeDetails studentFeeDeatils) {
		StudentFeeDetails details=entityManager.merge(studentFeeDeatils);
		entityManager.flush();
		return details;
	}

	@Override
	public OtherPayments findOtherPayments(String receiptNo, String mobileNo,
			String name) {
		String receiptWhereClause= "";
		String mobileNoWhereClause="";
		String nameWhereClause= "";
		if(!receiptNo.isEmpty()){
			receiptWhereClause = "o.receiptNo =" + "'"+receiptNo+"'";
		}
		if(!mobileNo.isEmpty()){
			String s = "o.mobileNo =" + "'"+mobileNo+"'";
			mobileNoWhereClause = receiptNo.isEmpty()?s:"and"+s;
		}
		if(!name.isEmpty()){
			String s = "o.mobileNo =" + "'"+mobileNo+"'";
			nameWhereClause= name.isEmpty()?s:"and"+s;
		}
		if(entityManager.createQuery("FROM OtherPayments o WHERE " +receiptWhereClause +mobileNoWhereClause+nameWhereClause).getResultList().size()>0){
			return (OtherPayments) entityManager.createQuery("FROM OtherPayments o WHERE " +receiptWhereClause +mobileNoWhereClause+nameWhereClause).getResultList().get(0);
		}
		return null;
	}

	@Override
	public OtherPayments processOtherPayment(OtherPayments otherPayments) {
		OtherPayments otherPayments2=entityManager.merge(otherPayments);
		entityManager.flush();
		return otherPayments2;
	}

	@Override
	public List<StudentFeeDetails> loadAllStudentFeeDetails() {
		Query query = entityManager.createQuery("FROM StudentFeeDetails");
		return query.getResultList();
	}

	@Override
	public List<OtherPayments> loadOtherPayments() {
		Query query = entityManager.createQuery("FROM OtherPayments");
		return query.getResultList();
	}
}
