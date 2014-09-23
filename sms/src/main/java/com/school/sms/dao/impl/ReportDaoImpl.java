package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.ReportDao;
import com.school.sms.model.Customer;
import com.school.sms.model.ExtraMailRecipient;
import com.school.sms.model.SendCustomSMS;
import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;

@Service("reportDaoService")
@Transactional
public class ReportDaoImpl implements ReportDao{

private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public List<StudentFeeDetails> loadStudentFixedFeeDetailsList() {
		Query query = entityManager.createQuery("FROM StudentFeeDetails s order by s.receiptNo ASC");
		return query.getResultList();
	}

	@Override
	public Student loadStudent(String enrolementNo) {
		Query query = entityManager.createQuery("FROM Student s where s.enrolementNo="+"'"+enrolementNo+"'");
		return (query.getResultList().size()>0?(Student)query.getResultList().get(0):null);
	}

	@Override
	public void updateExtraMailRecipient(ExtraMailRecipient extraMailRecipient) {
		entityManager.merge(extraMailRecipient);
		entityManager.flush();
		
	}

	@Override
	public void deleteExtraMailRecipient(ExtraMailRecipient extraMailRecipient) {
		ExtraMailRecipient grade = entityManager.find(ExtraMailRecipient.class,extraMailRecipient.getExtraRecipientId());
		entityManager.remove(grade);
		entityManager.flush();
		
	}

	@Override
	public List<ExtraMailRecipient> loadExtraMailRecipients() {
		Query query = entityManager.createQuery("FROM ExtraMailRecipient s order by s.extraRecipientId ASC");
		return query.getResultList();
	}

	@Override
	public void sendCustomSMS(SendCustomSMS sendCustomSMS) {
		entityManager.merge(sendCustomSMS);
		entityManager.flush();
	}

	@Override
	public List<SendCustomSMS> loadSentMessages() {
		Query query = entityManager.createQuery("FROM SendCustomSMS s order by s.customSMSId ASC");
		return query.getResultList();
	}

}
