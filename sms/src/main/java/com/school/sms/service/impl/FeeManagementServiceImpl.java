package com.school.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.springframework.stereotype.Service;

import com.school.sms.dao.FixedFeeDao;
import com.school.sms.model.DiscountsAndConcessions;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.VariableFeeBatchYearMonth;
import com.school.sms.service.FeeManagementService;

@Service("feeManagementService")
public class FeeManagementServiceImpl implements FeeManagementService {

	@Resource(name = "fixedFeeDaoService")
	private FixedFeeDao fixedFeeDao;

	public void addFixedFeeStructure() {

	}

	@Override
	public List<FixedFeeBatchYearMonth> loadFeeStructures() {

		return fixedFeeDao.loadFeeStructures();
	}

	public void updateFixedFee(FixedFeeBatchYearMonth feeBatchYearMonth) {
		fixedFeeDao.updateFixedFee(feeBatchYearMonth);
	}

	@Override
	public FixedFeeBatchYearMonth findFixedFee(String session, Integer batchId,
			String month) {
		
		return fixedFeeDao.findFixedFee(session, batchId, month);
	}

	@Override
	public VariableFeeBatchYearMonth findVariableFee(String session,
			String batch, String month, String studentNameClassRoll) {
		return fixedFeeDao.findFixedFee(session, batch, month,studentNameClassRoll);
	}

	@Override
	public void updateVariableFee(VariableFeeBatchYearMonth variableFee) {
		fixedFeeDao.updateVariableFee(variableFee);
		
	}

	@Override
	public List<VariableFeeBatchYearMonth> loadVariableFeeStructures() {
		return fixedFeeDao.loadVariableFeeStructures();
	}

	@Override
	public List<DiscountsAndConcessions> loadDiscountsAndConcession() {
		return fixedFeeDao.loadDiscountsAndConcession();
	}

	@Override
	public DiscountsAndConcessions findDiscountsAndConcession(String session,
			String batch, String month, String studentNameClassRoll) {
		return fixedFeeDao.findDiscountsAndConcession(session, batch, month,studentNameClassRoll);
	}

	@Override
	public void updateDiscountsAndConcession(
			DiscountsAndConcessions discountsAndConcession) {
		fixedFeeDao.updateDiscountsAndConcession(discountsAndConcession);
		
	}

	@Override
	public void deleteVariableFee(VariableFeeBatchYearMonth variableFee) {
		fixedFeeDao.deleteVariableFee(variableFee);
		
	}

	@Override
	public void deleteFixedFee(FixedFeeBatchYearMonth fixedFee) {
		fixedFeeDao.deleteFixedFee(fixedFee);
		
	}
}
