package com.school.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.sms.dao.PayrollDao;
import com.school.sms.model.Department;
import com.school.sms.model.EmployeeMaster;
import com.school.sms.model.GradeMaster;
import com.school.sms.model.SalaryMaster;
import com.school.sms.model.SalaryProcessDetail;
import com.school.sms.service.PayrollManagementService;

@Service("payrollManagementService")
public class PayrollManagementServiceImpl implements PayrollManagementService{

	@Resource(name = "payrollDaoService")
	private PayrollDao payrollDao;

	@Override
	public List<EmployeeMaster> loadEmployeeMasterList() {
		// TODO Auto-generated method stub
		return payrollDao.loadEmployeeMasterList();
	}

	@Override
	public GradeMaster findGradeMaster(String gradeId) {
		return payrollDao.findGradeMaster(gradeId);
	}

	@Override
	public void updateGradeMaster(GradeMaster gradeMaster) {
		payrollDao.updateGradeMaster(gradeMaster);
		
	}

	@Override
	public void deleteGrade(GradeMaster gradeMaster) {
		payrollDao.deleteGrade(gradeMaster);
		
	}

	@Override
	public List<GradeMaster> loadGradeMasterList() {
		return payrollDao.loadGradeMasterList();
	}

	@Override
	public List<Department> loadDepartmentList() {
		return payrollDao.loadDepartmentList();
	}

	@Override
	public Department findDepartment(String departmentId) {
		return payrollDao.findDepartment(departmentId);
	}

	@Override
	public void updateDepartmentMaster(Department department) {
		payrollDao.updateDepartmentMaster(department);
		
	}

	@Override
	public void deleteDepartment(Department department) {
		payrollDao.deleteDepartment(department);  
		
	}

	@Override
	public List<SalaryMaster> loadSalaryMasterList() {
		return payrollDao.loadSalaryMasterList();
	}

	@Override
	public SalaryMaster findSalaryMaster(String salaryId) {
		return payrollDao.findSalaryMaster(salaryId);
	}

	@Override
	public void updateSalaryMaster(SalaryMaster salaryMaster) {
		payrollDao.updateSalaryMaster(salaryMaster);
		
	}

	@Override
	public void deleteSalary(SalaryMaster salaryMaster) {
		payrollDao.deleteSalary(salaryMaster);  
		
	}

	@Override
	public EmployeeMaster findEmployeeMaster(Integer employeeId) {
		return payrollDao.findEmployeeMaster(employeeId);
	}

	@Override
	public void updateEmployeeMaster(EmployeeMaster employeeMaster) {
		payrollDao.updateEmployeeMaster(employeeMaster);
		
	}

	@Override
	public void deleteEmployeeMaster(EmployeeMaster employeeMaster) {
		payrollDao.deleteEmployeeMaster(employeeMaster);  
		
	}

	@Override
	public void updateSalaryProcessDetail(
			SalaryProcessDetail salaryProcessDetail) {
		payrollDao.updateSalaryProcessDetail(salaryProcessDetail);
		
	}

	@Override
	public List<SalaryProcessDetail> loadProcessedSalaries() {
		return payrollDao.loadProcessedSalaries();
	} 
}
