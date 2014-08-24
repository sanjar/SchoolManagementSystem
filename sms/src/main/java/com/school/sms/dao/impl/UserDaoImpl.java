package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.UserDao;
import com.school.sms.model.Student;
import com.school.sms.model.UserAuthenticationDetails;
import com.school.sms.model.UserRoles;
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
		Student student2 = entityManager.merge(student);
		student.setStudentId(student2.getStudentId());
		entityManager.flush();
		
	}

	@Override
	public void deactivateStudent(Student student) {
		student.setStatus(false);
		updateStudent(student);
	}

	@Override
	public Integer getMaxRollInClassAndSection(String currentClassBatch,
			String currentClassSection) {
		List list= entityManager.createQuery("SELECT max(roll) FROM Student f WHERE f.currentClassBatch="+"'"+currentClassBatch+"'" +"and f.currentClassSection="+"'"+currentClassSection+"'").getResultList();
		if(list.size()>0){
			return (Integer) list.get(0);
		}
		return 0;
	}

	@Override
	public UserAuthenticationDetails findUser(String userId) {
		List list= entityManager.createQuery("FROM UserAuthenticationDetails f WHERE f.userId="+"'"+userId+"'").getResultList();
		if(list.size()>0){
			return (UserAuthenticationDetails) list.get(0);
		}
		return null;
	}

	@Override
	public void updateUser(UserAuthenticationDetails user) {
		UserAuthenticationDetails user2 = entityManager.merge(user);
		entityManager.flush();
		
	}

	@Override
	public void deactivateUser(UserAuthenticationDetails user) {
		user.setEnabled("FALSE");
		updateUser(user);
		
	}

	@Override
	public void updateUserRoles(String userId, String role) {
	  UserRoles roles = new UserRoles();
	  roles.setRole(role);
	  roles.setUserId(userId);
	  entityManager.merge(roles);
	  entityManager.flush();
	}
}
