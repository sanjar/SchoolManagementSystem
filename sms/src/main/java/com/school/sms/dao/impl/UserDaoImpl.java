package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.UserDao;
import com.school.sms.model.Student;
import com.school.sms.model.VariableFeeBatchYearMonth;

@Service("userDaoService")
@Transactional
public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public Student findStudent(String enlorementNo) {
		List list= entityManager.createQuery("FROM Student f WHERE f.enrolementNo="+"'"+enlorementNo+"'").getResultList();
		if(list.size()>0){
			return (Student) list.get(0);
		}
		return null;
	}

	@Override
	public void updateStudent(Student student) {
		entityManager.merge(student);
		entityManager.flush();
		
	}

	@Override
	public void deactivateStudent(Student student) {
		student.setStatus(false);
		updateStudent(student);
	}
}
