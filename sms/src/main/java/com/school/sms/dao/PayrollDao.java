package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.Department;
import com.school.sms.model.EmployeeMaster;
import com.school.sms.model.GradeMaster;
import com.school.sms.model.SalaryMaster;
import com.school.sms.model.SalaryProcessDetail;

public interface PayrollDao {

	public List<EmployeeMaster> loadEmployeeMasterList();

	public GradeMaster findGradeMaster(String gradeId);

	public void updateGradeMaster(GradeMaster gradeMaster);

	public void deleteGrade(GradeMaster gradeMaster);

	public List<GradeMaster> loadGradeMasterList();

	public List<Department> loadDepartmentList();

	public Department findDepartment(String departmentId);

	public void updateDepartmentMaster(Department department);

	public void deleteDepartment(Department department);

	public List<SalaryMaster> loadSalaryMasterList();

	public SalaryMaster findSalaryMaster(String salaryId);

	public void updateSalaryMaster(SalaryMaster salaryMaster);

	public void deleteSalary(SalaryMaster salaryMaster);

	public EmployeeMaster findEmployeeMaster(Integer employeeId);

	public void updateEmployeeMaster(EmployeeMaster employeeMaster);

	public void deleteEmployeeMaster(EmployeeMaster employeeMaster);

	public void updateSalaryProcessDetail(
			SalaryProcessDetail salaryProcessDetail);

	public List<SalaryProcessDetail> loadProcessedSalaries();

}
