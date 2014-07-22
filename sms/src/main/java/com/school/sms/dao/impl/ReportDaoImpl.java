package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.ReportDao;
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

}
