package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.PayrollDao;
import com.school.sms.model.Department;
import com.school.sms.model.EmployeeMaster;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.GradeMaster;
import com.school.sms.model.SalaryMaster;
import com.school.sms.model.SalaryProcessDetail;
import com.school.sms.model.VariableFeeBatchYearMonth;

@Service("payrollDaoService")
@Transactional
public class PayrollDaoImpl implements PayrollDao{

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public List<EmployeeMaster> loadEmployeeMasterList() {
		Query query = entityManager.createQuery("FROM EmployeeMaster e order by e.employeeId ASC");
		return query.getResultList();
	}

	@Override
	public GradeMaster findGradeMaster(String gradeId) {
		List list= entityManager.createQuery("FROM GradeMaster g WHERE g.gradeId="+"'"+gradeId+"'").getResultList();
		if(list.size()>0){
			return (GradeMaster) list.get(0);
		}
		return null;
	}

	@Override
	public void updateGradeMaster(GradeMaster gradeMaster) {
		entityManager.merge(gradeMaster);
		entityManager.flush();
		
	}

	@Override
	public void deleteGrade(GradeMaster gradeMaster) {
		
		GradeMaster grade = entityManager.find(GradeMaster.class,gradeMaster.getGradeId());
		entityManager.remove(grade);
		entityManager.flush();
	}

	@Override
	public List<GradeMaster> loadGradeMasterList() {
		Query query = entityManager.createQuery("FROM GradeMaster g order by g.gradeId ASC");
		return query.getResultList();
	}

	@Override
	public List<Department> loadDepartmentList() {
		Query query = entityManager.createQuery("FROM Department d order by d.departmentId ASC");
		return query.getResultList();
	}

	@Override
	public Department findDepartment(String departmentId) {
		List list= entityManager.createQuery("FROM Department d WHERE d.departmentId="+"'"+departmentId+"'").getResultList();
		if(list.size()>0){
			return (Department) list.get(0);
		}
		return null;
	}

	@Override
	public void updateDepartmentMaster(Department department) {
		entityManager.merge(department);
		entityManager.flush();
		
	}

	@Override
	public void deleteDepartment(Department department) {
		Department department2 = entityManager.find(Department.class,department.getDepartmentId());
		entityManager.remove(department2);
		entityManager.flush();
		
	}

	@Override
	public List<SalaryMaster> loadSalaryMasterList() {
		Query query = entityManager.createQuery("FROM SalaryMaster s order by s.salaryId ASC");
		return query.getResultList();
	}

	@Override
	public SalaryMaster findSalaryMaster(String salaryId) {
		List list= entityManager.createQuery("FROM SalaryMaster s WHERE s.salaryId="+"'"+salaryId+"'").getResultList();
		if(list.size()>0){
			return (SalaryMaster) list.get(0);
		}
		return null;
	}

	@Override
	public void updateSalaryMaster(SalaryMaster salaryMaster) {
		entityManager.merge(salaryMaster);
		entityManager.flush();
		
	}

	@Override
	public void deleteSalary(SalaryMaster salaryMaster) {
		SalaryMaster salary = entityManager.find(SalaryMaster.class,salaryMaster.getSalaryId());
		entityManager.remove(salary);
		entityManager.flush();
		
	}

	@Override
	public EmployeeMaster findEmployeeMaster(Integer employeeId) {
		List list= entityManager.createQuery("FROM EmployeeMaster e WHERE e.employeeId="+"'"+employeeId+"'").getResultList();
		if(list.size()>0){
			return (EmployeeMaster) list.get(0);
		}
		return null;
	}

	@Override
	public void updateEmployeeMaster(EmployeeMaster employeeMaster) {
		entityManager.merge(employeeMaster);
		entityManager.flush();
		
	}

	@Override
	public void deleteEmployeeMaster(EmployeeMaster employeeMaster) {
		EmployeeMaster employeeMaster2 = entityManager.find(EmployeeMaster.class,employeeMaster.getEmployeeId());
		entityManager.remove(employeeMaster2);
		entityManager.flush();
		
	}

	@Override
	public void updateSalaryProcessDetail(
			SalaryProcessDetail salaryProcessDetail) {
		entityManager.merge(salaryProcessDetail);
		entityManager.flush();
		
	}

}
