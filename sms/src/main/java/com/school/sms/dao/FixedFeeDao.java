package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.DiscountsAndConcessions;
import com.school.sms.model.FixedFeeBatchYearMonth;
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
}
